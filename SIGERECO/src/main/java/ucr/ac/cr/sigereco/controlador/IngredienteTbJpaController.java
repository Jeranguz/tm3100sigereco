/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.controlador.exceptions.IllegalOrphanException;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.IngredienteTb;

/**
 *
 * @author Drexler Guzman
 */
public class IngredienteTbJpaController implements Serializable {

    public IngredienteTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IngredienteTb ingredienteTb) {
        if (ingredienteTb.getRecetaHasIngredienteTbList() == null) {
            ingredienteTb.setRecetaHasIngredienteTbList(new ArrayList<RecetaHasIngredienteTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RecetaHasIngredienteTb> attachedRecetaHasIngredienteTbList = new ArrayList<RecetaHasIngredienteTb>();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach : ingredienteTb.getRecetaHasIngredienteTbList()) {
                recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach = em.getReference(recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach.getClass(), recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach.getRecetaHasIngredienteTbPK());
                attachedRecetaHasIngredienteTbList.add(recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach);
            }
            ingredienteTb.setRecetaHasIngredienteTbList(attachedRecetaHasIngredienteTbList);
            em.persist(ingredienteTb);
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTb : ingredienteTb.getRecetaHasIngredienteTbList()) {
                IngredienteTb oldIngredienteTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb = recetaHasIngredienteTbListRecetaHasIngredienteTb.getIngredienteTb();
                recetaHasIngredienteTbListRecetaHasIngredienteTb.setIngredienteTb(ingredienteTb);
                recetaHasIngredienteTbListRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListRecetaHasIngredienteTb);
                if (oldIngredienteTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb != null) {
                    oldIngredienteTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTbListRecetaHasIngredienteTb);
                    oldIngredienteTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb = em.merge(oldIngredienteTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IngredienteTb ingredienteTb) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IngredienteTb persistentIngredienteTb = em.find(IngredienteTb.class, ingredienteTb.getId());
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListOld = persistentIngredienteTb.getRecetaHasIngredienteTbList();
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListNew = ingredienteTb.getRecetaHasIngredienteTbList();
            List<String> illegalOrphanMessages = null;
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListOldRecetaHasIngredienteTb : recetaHasIngredienteTbListOld) {
                if (!recetaHasIngredienteTbListNew.contains(recetaHasIngredienteTbListOldRecetaHasIngredienteTb)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RecetaHasIngredienteTb " + recetaHasIngredienteTbListOldRecetaHasIngredienteTb + " since its ingredienteTb field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<RecetaHasIngredienteTb> attachedRecetaHasIngredienteTbListNew = new ArrayList<RecetaHasIngredienteTb>();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach : recetaHasIngredienteTbListNew) {
                recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach = em.getReference(recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach.getClass(), recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach.getRecetaHasIngredienteTbPK());
                attachedRecetaHasIngredienteTbListNew.add(recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach);
            }
            recetaHasIngredienteTbListNew = attachedRecetaHasIngredienteTbListNew;
            ingredienteTb.setRecetaHasIngredienteTbList(recetaHasIngredienteTbListNew);
            ingredienteTb = em.merge(ingredienteTb);
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListNewRecetaHasIngredienteTb : recetaHasIngredienteTbListNew) {
                if (!recetaHasIngredienteTbListOld.contains(recetaHasIngredienteTbListNewRecetaHasIngredienteTb)) {
                    IngredienteTb oldIngredienteTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb = recetaHasIngredienteTbListNewRecetaHasIngredienteTb.getIngredienteTb();
                    recetaHasIngredienteTbListNewRecetaHasIngredienteTb.setIngredienteTb(ingredienteTb);
                    recetaHasIngredienteTbListNewRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                    if (oldIngredienteTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb != null && !oldIngredienteTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb.equals(ingredienteTb)) {
                        oldIngredienteTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                        oldIngredienteTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb = em.merge(oldIngredienteTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ingredienteTb.getId();
                if (findIngredienteTb(id) == null) {
                    throw new NonexistentEntityException("The ingredienteTb with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IngredienteTb ingredienteTb;
            try {
                ingredienteTb = em.getReference(IngredienteTb.class, id);
                ingredienteTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ingredienteTb with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListOrphanCheck = ingredienteTb.getRecetaHasIngredienteTbList();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListOrphanCheckRecetaHasIngredienteTb : recetaHasIngredienteTbListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This IngredienteTb (" + ingredienteTb + ") cannot be destroyed since the RecetaHasIngredienteTb " + recetaHasIngredienteTbListOrphanCheckRecetaHasIngredienteTb + " in its recetaHasIngredienteTbList field has a non-nullable ingredienteTb field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ingredienteTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IngredienteTb> findIngredienteTbEntities() {
        return findIngredienteTbEntities(true, -1, -1);
    }

    public List<IngredienteTb> findIngredienteTbEntities(int maxResults, int firstResult) {
        return findIngredienteTbEntities(false, maxResults, firstResult);
    }

    private List<IngredienteTb> findIngredienteTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IngredienteTb.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public IngredienteTb findIngredienteTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IngredienteTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getIngredienteTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IngredienteTb> rt = cq.from(IngredienteTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

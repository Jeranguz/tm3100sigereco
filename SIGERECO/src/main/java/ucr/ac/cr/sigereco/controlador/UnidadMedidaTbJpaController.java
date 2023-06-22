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
import ucr.ac.cr.sigereco.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.UnidadMedidaTb;

/**
 *
 * @author Drexler Guzman
 */
public class UnidadMedidaTbJpaController implements Serializable {

    public UnidadMedidaTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadMedidaTb unidadMedidaTb) {
        if (unidadMedidaTb.getRecetaHasIngredienteTbList() == null) {
            unidadMedidaTb.setRecetaHasIngredienteTbList(new ArrayList<RecetaHasIngredienteTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RecetaHasIngredienteTb> attachedRecetaHasIngredienteTbList = new ArrayList<RecetaHasIngredienteTb>();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach : unidadMedidaTb.getRecetaHasIngredienteTbList()) {
                recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach = em.getReference(recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach.getClass(), recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach.getRecetaHasIngredienteTbPK());
                attachedRecetaHasIngredienteTbList.add(recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach);
            }
            unidadMedidaTb.setRecetaHasIngredienteTbList(attachedRecetaHasIngredienteTbList);
            em.persist(unidadMedidaTb);
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTb : unidadMedidaTb.getRecetaHasIngredienteTbList()) {
                recetaHasIngredienteTbListRecetaHasIngredienteTb.getUnidadMedidaTbList().add(unidadMedidaTb);
                recetaHasIngredienteTbListRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListRecetaHasIngredienteTb);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadMedidaTb unidadMedidaTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UnidadMedidaTb persistentUnidadMedidaTb = em.find(UnidadMedidaTb.class, unidadMedidaTb.getId());
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListOld = persistentUnidadMedidaTb.getRecetaHasIngredienteTbList();
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListNew = unidadMedidaTb.getRecetaHasIngredienteTbList();
            List<RecetaHasIngredienteTb> attachedRecetaHasIngredienteTbListNew = new ArrayList<RecetaHasIngredienteTb>();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach : recetaHasIngredienteTbListNew) {
                recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach = em.getReference(recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach.getClass(), recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach.getRecetaHasIngredienteTbPK());
                attachedRecetaHasIngredienteTbListNew.add(recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach);
            }
            recetaHasIngredienteTbListNew = attachedRecetaHasIngredienteTbListNew;
            unidadMedidaTb.setRecetaHasIngredienteTbList(recetaHasIngredienteTbListNew);
            unidadMedidaTb = em.merge(unidadMedidaTb);
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListOldRecetaHasIngredienteTb : recetaHasIngredienteTbListOld) {
                if (!recetaHasIngredienteTbListNew.contains(recetaHasIngredienteTbListOldRecetaHasIngredienteTb)) {
                    recetaHasIngredienteTbListOldRecetaHasIngredienteTb.getUnidadMedidaTbList().remove(unidadMedidaTb);
                    recetaHasIngredienteTbListOldRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListOldRecetaHasIngredienteTb);
                }
            }
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListNewRecetaHasIngredienteTb : recetaHasIngredienteTbListNew) {
                if (!recetaHasIngredienteTbListOld.contains(recetaHasIngredienteTbListNewRecetaHasIngredienteTb)) {
                    recetaHasIngredienteTbListNewRecetaHasIngredienteTb.getUnidadMedidaTbList().add(unidadMedidaTb);
                    recetaHasIngredienteTbListNewRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = unidadMedidaTb.getId();
                if (findUnidadMedidaTb(id) == null) {
                    throw new NonexistentEntityException("The unidadMedidaTb with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UnidadMedidaTb unidadMedidaTb;
            try {
                unidadMedidaTb = em.getReference(UnidadMedidaTb.class, id);
                unidadMedidaTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadMedidaTb with id " + id + " no longer exists.", enfe);
            }
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbList = unidadMedidaTb.getRecetaHasIngredienteTbList();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTb : recetaHasIngredienteTbList) {
                recetaHasIngredienteTbListRecetaHasIngredienteTb.getUnidadMedidaTbList().remove(unidadMedidaTb);
                recetaHasIngredienteTbListRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListRecetaHasIngredienteTb);
            }
            em.remove(unidadMedidaTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UnidadMedidaTb> findUnidadMedidaTbEntities() {
        return findUnidadMedidaTbEntities(true, -1, -1);
    }

    public List<UnidadMedidaTb> findUnidadMedidaTbEntities(int maxResults, int firstResult) {
        return findUnidadMedidaTbEntities(false, maxResults, firstResult);
    }

    private List<UnidadMedidaTb> findUnidadMedidaTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadMedidaTb.class));
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

    public UnidadMedidaTb findUnidadMedidaTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadMedidaTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadMedidaTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadMedidaTb> rt = cq.from(UnidadMedidaTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

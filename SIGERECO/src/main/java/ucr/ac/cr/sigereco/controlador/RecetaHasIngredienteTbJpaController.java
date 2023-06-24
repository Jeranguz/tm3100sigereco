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
import ucr.ac.cr.sigereco.modelo.IngredienteTb;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.UnidadMedidaTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.controlador.exceptions.PreexistingEntityException;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTbPK;

/**
 *
 * @author Drexler Guzman
 */
public class RecetaHasIngredienteTbJpaController implements Serializable {

    public RecetaHasIngredienteTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RecetaHasIngredienteTb recetaHasIngredienteTb) throws PreexistingEntityException, Exception {
        if (recetaHasIngredienteTb.getRecetaHasIngredienteTbPK() == null) {
            recetaHasIngredienteTb.setRecetaHasIngredienteTbPK(new RecetaHasIngredienteTbPK());
        }
        if (recetaHasIngredienteTb.getUnidadMedidaTbList() == null) {
            recetaHasIngredienteTb.setUnidadMedidaTbList(new ArrayList<UnidadMedidaTb>());
        }
        recetaHasIngredienteTb.getRecetaHasIngredienteTbPK().setIngredienteId(recetaHasIngredienteTb.getIngredienteTb().getId());
        recetaHasIngredienteTb.getRecetaHasIngredienteTbPK().setRecetaId(recetaHasIngredienteTb.getRecetaTb().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IngredienteTb ingredienteTb = recetaHasIngredienteTb.getIngredienteTb();
            if (ingredienteTb != null) {
                ingredienteTb = em.getReference(ingredienteTb.getClass(), ingredienteTb.getId());
                recetaHasIngredienteTb.setIngredienteTb(ingredienteTb);
            }
            RecetaTb recetaTb = recetaHasIngredienteTb.getRecetaTb();
            if (recetaTb != null) {
                recetaTb = em.getReference(recetaTb.getClass(), recetaTb.getId());
                recetaHasIngredienteTb.setRecetaTb(recetaTb);
            }
            List<UnidadMedidaTb> attachedUnidadMedidaTbList = new ArrayList<UnidadMedidaTb>();
            for (UnidadMedidaTb unidadMedidaTbListUnidadMedidaTbToAttach : recetaHasIngredienteTb.getUnidadMedidaTbList()) {
                unidadMedidaTbListUnidadMedidaTbToAttach = em.getReference(unidadMedidaTbListUnidadMedidaTbToAttach.getClass(), unidadMedidaTbListUnidadMedidaTbToAttach.getId());
                attachedUnidadMedidaTbList.add(unidadMedidaTbListUnidadMedidaTbToAttach);
            }
            recetaHasIngredienteTb.setUnidadMedidaTbList(attachedUnidadMedidaTbList);
            em.persist(recetaHasIngredienteTb);
            if (ingredienteTb != null) {
                ingredienteTb.getRecetaHasIngredienteTbList().add(recetaHasIngredienteTb);
                ingredienteTb = em.merge(ingredienteTb);
            }
            if (recetaTb != null) {
                recetaTb.getRecetaHasIngredienteTbList().add(recetaHasIngredienteTb);
                recetaTb = em.merge(recetaTb);
            }
            for (UnidadMedidaTb unidadMedidaTbListUnidadMedidaTb : recetaHasIngredienteTb.getUnidadMedidaTbList()) {
                unidadMedidaTbListUnidadMedidaTb.getRecetaHasIngredienteTbList().add(recetaHasIngredienteTb);
                unidadMedidaTbListUnidadMedidaTb = em.merge(unidadMedidaTbListUnidadMedidaTb);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRecetaHasIngredienteTb(recetaHasIngredienteTb.getRecetaHasIngredienteTbPK()) != null) {
                throw new PreexistingEntityException("RecetaHasIngredienteTb " + recetaHasIngredienteTb + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RecetaHasIngredienteTb recetaHasIngredienteTb) throws NonexistentEntityException, Exception {
        recetaHasIngredienteTb.getRecetaHasIngredienteTbPK().setIngredienteId(recetaHasIngredienteTb.getIngredienteTb().getId());
        recetaHasIngredienteTb.getRecetaHasIngredienteTbPK().setRecetaId(recetaHasIngredienteTb.getRecetaTb().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RecetaHasIngredienteTb persistentRecetaHasIngredienteTb = em.find(RecetaHasIngredienteTb.class, recetaHasIngredienteTb.getRecetaHasIngredienteTbPK());
            IngredienteTb ingredienteTbOld = persistentRecetaHasIngredienteTb.getIngredienteTb();
            IngredienteTb ingredienteTbNew = recetaHasIngredienteTb.getIngredienteTb();
            RecetaTb recetaTbOld = persistentRecetaHasIngredienteTb.getRecetaTb();
            RecetaTb recetaTbNew = recetaHasIngredienteTb.getRecetaTb();
            List<UnidadMedidaTb> unidadMedidaTbListOld = persistentRecetaHasIngredienteTb.getUnidadMedidaTbList();
            List<UnidadMedidaTb> unidadMedidaTbListNew = recetaHasIngredienteTb.getUnidadMedidaTbList();
            if (ingredienteTbNew != null) {
                ingredienteTbNew = em.getReference(ingredienteTbNew.getClass(), ingredienteTbNew.getId());
                recetaHasIngredienteTb.setIngredienteTb(ingredienteTbNew);
            }
            if (recetaTbNew != null) {
                recetaTbNew = em.getReference(recetaTbNew.getClass(), recetaTbNew.getId());
                recetaHasIngredienteTb.setRecetaTb(recetaTbNew);
            }
            List<UnidadMedidaTb> attachedUnidadMedidaTbListNew = new ArrayList<UnidadMedidaTb>();
            for (UnidadMedidaTb unidadMedidaTbListNewUnidadMedidaTbToAttach : unidadMedidaTbListNew) {
                unidadMedidaTbListNewUnidadMedidaTbToAttach = em.getReference(unidadMedidaTbListNewUnidadMedidaTbToAttach.getClass(), unidadMedidaTbListNewUnidadMedidaTbToAttach.getId());
                attachedUnidadMedidaTbListNew.add(unidadMedidaTbListNewUnidadMedidaTbToAttach);
            }
            unidadMedidaTbListNew = attachedUnidadMedidaTbListNew;
            recetaHasIngredienteTb.setUnidadMedidaTbList(unidadMedidaTbListNew);
            recetaHasIngredienteTb = em.merge(recetaHasIngredienteTb);
            if (ingredienteTbOld != null && !ingredienteTbOld.equals(ingredienteTbNew)) {
                ingredienteTbOld.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTb);
                ingredienteTbOld = em.merge(ingredienteTbOld);
            }
            if (ingredienteTbNew != null && !ingredienteTbNew.equals(ingredienteTbOld)) {
                ingredienteTbNew.getRecetaHasIngredienteTbList().add(recetaHasIngredienteTb);
                ingredienteTbNew = em.merge(ingredienteTbNew);
            }
            if (recetaTbOld != null && !recetaTbOld.equals(recetaTbNew)) {
                recetaTbOld.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTb);
                recetaTbOld = em.merge(recetaTbOld);
            }
            if (recetaTbNew != null && !recetaTbNew.equals(recetaTbOld)) {
                recetaTbNew.getRecetaHasIngredienteTbList().add(recetaHasIngredienteTb);
                recetaTbNew = em.merge(recetaTbNew);
            }
            for (UnidadMedidaTb unidadMedidaTbListOldUnidadMedidaTb : unidadMedidaTbListOld) {
                if (!unidadMedidaTbListNew.contains(unidadMedidaTbListOldUnidadMedidaTb)) {
                    unidadMedidaTbListOldUnidadMedidaTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTb);
                    unidadMedidaTbListOldUnidadMedidaTb = em.merge(unidadMedidaTbListOldUnidadMedidaTb);
                }
            }
            for (UnidadMedidaTb unidadMedidaTbListNewUnidadMedidaTb : unidadMedidaTbListNew) {
                if (!unidadMedidaTbListOld.contains(unidadMedidaTbListNewUnidadMedidaTb)) {
                    unidadMedidaTbListNewUnidadMedidaTb.getRecetaHasIngredienteTbList().add(recetaHasIngredienteTb);
                    unidadMedidaTbListNewUnidadMedidaTb = em.merge(unidadMedidaTbListNewUnidadMedidaTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RecetaHasIngredienteTbPK id = recetaHasIngredienteTb.getRecetaHasIngredienteTbPK();
                if (findRecetaHasIngredienteTb(id) == null) {
                    throw new NonexistentEntityException("The recetaHasIngredienteTb with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RecetaHasIngredienteTbPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RecetaHasIngredienteTb recetaHasIngredienteTb;
            try {
                recetaHasIngredienteTb = em.getReference(RecetaHasIngredienteTb.class, id);
                recetaHasIngredienteTb.getRecetaHasIngredienteTbPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recetaHasIngredienteTb with id " + id + " no longer exists.", enfe);
            }
            IngredienteTb ingredienteTb = recetaHasIngredienteTb.getIngredienteTb();
            if (ingredienteTb != null) {
                ingredienteTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTb);
                ingredienteTb = em.merge(ingredienteTb);
            }
            RecetaTb recetaTb = recetaHasIngredienteTb.getRecetaTb();
            if (recetaTb != null) {
                recetaTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTb);
                recetaTb = em.merge(recetaTb);
            }
            List<UnidadMedidaTb> unidadMedidaTbList = recetaHasIngredienteTb.getUnidadMedidaTbList();
            for (UnidadMedidaTb unidadMedidaTbListUnidadMedidaTb : unidadMedidaTbList) {
                unidadMedidaTbListUnidadMedidaTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTb);
                unidadMedidaTbListUnidadMedidaTb = em.merge(unidadMedidaTbListUnidadMedidaTb);
            }
            em.remove(recetaHasIngredienteTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RecetaHasIngredienteTb> findRecetaHasIngredienteTbEntities() {
        return findRecetaHasIngredienteTbEntities(true, -1, -1);
    }

    public List<RecetaHasIngredienteTb> findRecetaHasIngredienteTbEntities(int maxResults, int firstResult) {
        return findRecetaHasIngredienteTbEntities(false, maxResults, firstResult);
    }

    private List<RecetaHasIngredienteTb> findRecetaHasIngredienteTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RecetaHasIngredienteTb.class));
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

    public RecetaHasIngredienteTb findRecetaHasIngredienteTb(RecetaHasIngredienteTbPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RecetaHasIngredienteTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecetaHasIngredienteTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RecetaHasIngredienteTb> rt = cq.from(RecetaHasIngredienteTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

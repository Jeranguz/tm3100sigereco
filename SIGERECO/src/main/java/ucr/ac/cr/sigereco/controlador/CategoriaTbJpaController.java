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
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.CategoriaTb;

/**
 *
 * @author Drexler Guzman
 */
public class CategoriaTbJpaController implements Serializable {

    public CategoriaTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CategoriaTb categoriaTb) {
        if (categoriaTb.getRecetaTbList() == null) {
            categoriaTb.setRecetaTbList(new ArrayList<RecetaTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RecetaTb> attachedRecetaTbList = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListRecetaTbToAttach : categoriaTb.getRecetaTbList()) {
                recetaTbListRecetaTbToAttach = em.getReference(recetaTbListRecetaTbToAttach.getClass(), recetaTbListRecetaTbToAttach.getId());
                attachedRecetaTbList.add(recetaTbListRecetaTbToAttach);
            }
            categoriaTb.setRecetaTbList(attachedRecetaTbList);
            em.persist(categoriaTb);
            for (RecetaTb recetaTbListRecetaTb : categoriaTb.getRecetaTbList()) {
                //recetaTbListRecetaTb.getCategoriaTbList().add(categoriaTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CategoriaTb categoriaTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CategoriaTb persistentCategoriaTb = em.find(CategoriaTb.class, categoriaTb.getId());
            List<RecetaTb> recetaTbListOld = persistentCategoriaTb.getRecetaTbList();
            List<RecetaTb> recetaTbListNew = categoriaTb.getRecetaTbList();
            List<RecetaTb> attachedRecetaTbListNew = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListNewRecetaTbToAttach : recetaTbListNew) {
                recetaTbListNewRecetaTbToAttach = em.getReference(recetaTbListNewRecetaTbToAttach.getClass(), recetaTbListNewRecetaTbToAttach.getId());
                attachedRecetaTbListNew.add(recetaTbListNewRecetaTbToAttach);
            }
            recetaTbListNew = attachedRecetaTbListNew;
            categoriaTb.setRecetaTbList(recetaTbListNew);
            categoriaTb = em.merge(categoriaTb);
            for (RecetaTb recetaTbListOldRecetaTb : recetaTbListOld) {
                if (!recetaTbListNew.contains(recetaTbListOldRecetaTb)) {
                    //recetaTbListOldRecetaTb.getCategoriaTbList().remove(categoriaTb);
                    recetaTbListOldRecetaTb = em.merge(recetaTbListOldRecetaTb);
                }
            }
            for (RecetaTb recetaTbListNewRecetaTb : recetaTbListNew) {
                if (!recetaTbListOld.contains(recetaTbListNewRecetaTb)) {
                    //recetaTbListNewRecetaTb.getCategoriaTbList().add(categoriaTb);
                    recetaTbListNewRecetaTb = em.merge(recetaTbListNewRecetaTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = categoriaTb.getId();
                if (findCategoriaTb(id) == null) {
                    throw new NonexistentEntityException("The categoriaTb with id " + id + " no longer exists.");
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
            CategoriaTb categoriaTb;
            try {
                categoriaTb = em.getReference(CategoriaTb.class, id);
                categoriaTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoriaTb with id " + id + " no longer exists.", enfe);
            }
            List<RecetaTb> recetaTbList = categoriaTb.getRecetaTbList();
            for (RecetaTb recetaTbListRecetaTb : recetaTbList) {
                //recetaTbListRecetaTb.getCategoriaTbList().remove(categoriaTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.remove(categoriaTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CategoriaTb> findCategoriaTbEntities() {
        return findCategoriaTbEntities(true, -1, -1);
    }

    public List<CategoriaTb> findCategoriaTbEntities(int maxResults, int firstResult) {
        return findCategoriaTbEntities(false, maxResults, firstResult);
    }

    private List<CategoriaTb> findCategoriaTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CategoriaTb.class));
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

    public CategoriaTb findCategoriaTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CategoriaTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CategoriaTb> rt = cq.from(CategoriaTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

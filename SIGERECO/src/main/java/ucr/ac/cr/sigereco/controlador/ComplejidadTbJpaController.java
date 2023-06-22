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
import ucr.ac.cr.sigereco.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.exceptions.PreexistingEntityException;
import ucr.ac.cr.sigereco.modelo.ComplejidadTb;

/**
 *
 * @author Drexler Guzman
 */
public class ComplejidadTbJpaController implements Serializable {

    public ComplejidadTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComplejidadTb complejidadTb) throws PreexistingEntityException, Exception {
        if (complejidadTb.getRecetaTbList() == null) {
            complejidadTb.setRecetaTbList(new ArrayList<RecetaTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RecetaTb> attachedRecetaTbList = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListRecetaTbToAttach : complejidadTb.getRecetaTbList()) {
                recetaTbListRecetaTbToAttach = em.getReference(recetaTbListRecetaTbToAttach.getClass(), recetaTbListRecetaTbToAttach.getId());
                attachedRecetaTbList.add(recetaTbListRecetaTbToAttach);
            }
            complejidadTb.setRecetaTbList(attachedRecetaTbList);
            em.persist(complejidadTb);
            for (RecetaTb recetaTbListRecetaTb : complejidadTb.getRecetaTbList()) {
                recetaTbListRecetaTb.getComplejidadTbList().add(complejidadTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComplejidadTb(complejidadTb.getId()) != null) {
                throw new PreexistingEntityException("ComplejidadTb " + complejidadTb + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComplejidadTb complejidadTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ComplejidadTb persistentComplejidadTb = em.find(ComplejidadTb.class, complejidadTb.getId());
            List<RecetaTb> recetaTbListOld = persistentComplejidadTb.getRecetaTbList();
            List<RecetaTb> recetaTbListNew = complejidadTb.getRecetaTbList();
            List<RecetaTb> attachedRecetaTbListNew = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListNewRecetaTbToAttach : recetaTbListNew) {
                recetaTbListNewRecetaTbToAttach = em.getReference(recetaTbListNewRecetaTbToAttach.getClass(), recetaTbListNewRecetaTbToAttach.getId());
                attachedRecetaTbListNew.add(recetaTbListNewRecetaTbToAttach);
            }
            recetaTbListNew = attachedRecetaTbListNew;
            complejidadTb.setRecetaTbList(recetaTbListNew);
            complejidadTb = em.merge(complejidadTb);
            for (RecetaTb recetaTbListOldRecetaTb : recetaTbListOld) {
                if (!recetaTbListNew.contains(recetaTbListOldRecetaTb)) {
                    recetaTbListOldRecetaTb.getComplejidadTbList().remove(complejidadTb);
                    recetaTbListOldRecetaTb = em.merge(recetaTbListOldRecetaTb);
                }
            }
            for (RecetaTb recetaTbListNewRecetaTb : recetaTbListNew) {
                if (!recetaTbListOld.contains(recetaTbListNewRecetaTb)) {
                    recetaTbListNewRecetaTb.getComplejidadTbList().add(complejidadTb);
                    recetaTbListNewRecetaTb = em.merge(recetaTbListNewRecetaTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = complejidadTb.getId();
                if (findComplejidadTb(id) == null) {
                    throw new NonexistentEntityException("The complejidadTb with id " + id + " no longer exists.");
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
            ComplejidadTb complejidadTb;
            try {
                complejidadTb = em.getReference(ComplejidadTb.class, id);
                complejidadTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The complejidadTb with id " + id + " no longer exists.", enfe);
            }
            List<RecetaTb> recetaTbList = complejidadTb.getRecetaTbList();
            for (RecetaTb recetaTbListRecetaTb : recetaTbList) {
                recetaTbListRecetaTb.getComplejidadTbList().remove(complejidadTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.remove(complejidadTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComplejidadTb> findComplejidadTbEntities() {
        return findComplejidadTbEntities(true, -1, -1);
    }

    public List<ComplejidadTb> findComplejidadTbEntities(int maxResults, int firstResult) {
        return findComplejidadTbEntities(false, maxResults, firstResult);
    }

    private List<ComplejidadTb> findComplejidadTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComplejidadTb.class));
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

    public ComplejidadTb findComplejidadTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComplejidadTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getComplejidadTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComplejidadTb> rt = cq.from(ComplejidadTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

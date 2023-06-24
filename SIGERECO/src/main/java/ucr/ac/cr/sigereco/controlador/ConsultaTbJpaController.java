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
import ucr.ac.cr.sigereco.modelo.ConsultaTb;

/**
 *
 * @author Drexler Guzman
 */
public class ConsultaTbJpaController implements Serializable {

    public ConsultaTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ConsultaTb consultaTb) {
        if (consultaTb.getRecetaTbList() == null) {
            consultaTb.setRecetaTbList(new ArrayList<RecetaTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RecetaTb> attachedRecetaTbList = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListRecetaTbToAttach : consultaTb.getRecetaTbList()) {
                recetaTbListRecetaTbToAttach = em.getReference(recetaTbListRecetaTbToAttach.getClass(), recetaTbListRecetaTbToAttach.getId());
                attachedRecetaTbList.add(recetaTbListRecetaTbToAttach);
            }
            consultaTb.setRecetaTbList(attachedRecetaTbList);
            em.persist(consultaTb);
            for (RecetaTb recetaTbListRecetaTb : consultaTb.getRecetaTbList()) {
                recetaTbListRecetaTb.getConsultaTbList().add(consultaTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ConsultaTb consultaTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ConsultaTb persistentConsultaTb = em.find(ConsultaTb.class, consultaTb.getId());
            List<RecetaTb> recetaTbListOld = persistentConsultaTb.getRecetaTbList();
            List<RecetaTb> recetaTbListNew = consultaTb.getRecetaTbList();
            List<RecetaTb> attachedRecetaTbListNew = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListNewRecetaTbToAttach : recetaTbListNew) {
                recetaTbListNewRecetaTbToAttach = em.getReference(recetaTbListNewRecetaTbToAttach.getClass(), recetaTbListNewRecetaTbToAttach.getId());
                attachedRecetaTbListNew.add(recetaTbListNewRecetaTbToAttach);
            }
            recetaTbListNew = attachedRecetaTbListNew;
            consultaTb.setRecetaTbList(recetaTbListNew);
            consultaTb = em.merge(consultaTb);
            for (RecetaTb recetaTbListOldRecetaTb : recetaTbListOld) {
                if (!recetaTbListNew.contains(recetaTbListOldRecetaTb)) {
                    recetaTbListOldRecetaTb.getConsultaTbList().remove(consultaTb);
                    recetaTbListOldRecetaTb = em.merge(recetaTbListOldRecetaTb);
                }
            }
            for (RecetaTb recetaTbListNewRecetaTb : recetaTbListNew) {
                if (!recetaTbListOld.contains(recetaTbListNewRecetaTb)) {
                    recetaTbListNewRecetaTb.getConsultaTbList().add(consultaTb);
                    recetaTbListNewRecetaTb = em.merge(recetaTbListNewRecetaTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consultaTb.getId();
                if (findConsultaTb(id) == null) {
                    throw new NonexistentEntityException("The consultaTb with id " + id + " no longer exists.");
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
            ConsultaTb consultaTb;
            try {
                consultaTb = em.getReference(ConsultaTb.class, id);
                consultaTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultaTb with id " + id + " no longer exists.", enfe);
            }
            List<RecetaTb> recetaTbList = consultaTb.getRecetaTbList();
            for (RecetaTb recetaTbListRecetaTb : recetaTbList) {
                recetaTbListRecetaTb.getConsultaTbList().remove(consultaTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.remove(consultaTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ConsultaTb> findConsultaTbEntities() {
        return findConsultaTbEntities(true, -1, -1);
    }

    public List<ConsultaTb> findConsultaTbEntities(int maxResults, int firstResult) {
        return findConsultaTbEntities(false, maxResults, firstResult);
    }

    private List<ConsultaTb> findConsultaTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ConsultaTb.class));
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

    public ConsultaTb findConsultaTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ConsultaTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ConsultaTb> rt = cq.from(ConsultaTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

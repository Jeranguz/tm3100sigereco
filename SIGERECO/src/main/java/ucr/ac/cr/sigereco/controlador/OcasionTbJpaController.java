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
import ucr.ac.cr.sigereco.modelo.OcasionTb;

/**
 *
 * @author Drexler Guzman
 */
public class OcasionTbJpaController implements Serializable {

    public OcasionTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OcasionTb ocasionTb) {
        if (ocasionTb.getRecetaTbList() == null) {
            ocasionTb.setRecetaTbList(new ArrayList<RecetaTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RecetaTb> attachedRecetaTbList = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListRecetaTbToAttach : ocasionTb.getRecetaTbList()) {
                recetaTbListRecetaTbToAttach = em.getReference(recetaTbListRecetaTbToAttach.getClass(), recetaTbListRecetaTbToAttach.getId());
                attachedRecetaTbList.add(recetaTbListRecetaTbToAttach);
            }
            ocasionTb.setRecetaTbList(attachedRecetaTbList);
            em.persist(ocasionTb);
            for (RecetaTb recetaTbListRecetaTb : ocasionTb.getRecetaTbList()) {
                recetaTbListRecetaTb.getOcasionTbList().add(ocasionTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OcasionTb ocasionTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OcasionTb persistentOcasionTb = em.find(OcasionTb.class, ocasionTb.getId());
            List<RecetaTb> recetaTbListOld = persistentOcasionTb.getRecetaTbList();
            List<RecetaTb> recetaTbListNew = ocasionTb.getRecetaTbList();
            List<RecetaTb> attachedRecetaTbListNew = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListNewRecetaTbToAttach : recetaTbListNew) {
                recetaTbListNewRecetaTbToAttach = em.getReference(recetaTbListNewRecetaTbToAttach.getClass(), recetaTbListNewRecetaTbToAttach.getId());
                attachedRecetaTbListNew.add(recetaTbListNewRecetaTbToAttach);
            }
            recetaTbListNew = attachedRecetaTbListNew;
            ocasionTb.setRecetaTbList(recetaTbListNew);
            ocasionTb = em.merge(ocasionTb);
            for (RecetaTb recetaTbListOldRecetaTb : recetaTbListOld) {
                if (!recetaTbListNew.contains(recetaTbListOldRecetaTb)) {
                    recetaTbListOldRecetaTb.getOcasionTbList().remove(ocasionTb);
                    recetaTbListOldRecetaTb = em.merge(recetaTbListOldRecetaTb);
                }
            }
            for (RecetaTb recetaTbListNewRecetaTb : recetaTbListNew) {
                if (!recetaTbListOld.contains(recetaTbListNewRecetaTb)) {
                    recetaTbListNewRecetaTb.getOcasionTbList().add(ocasionTb);
                    recetaTbListNewRecetaTb = em.merge(recetaTbListNewRecetaTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ocasionTb.getId();
                if (findOcasionTb(id) == null) {
                    throw new NonexistentEntityException("The ocasionTb with id " + id + " no longer exists.");
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
            OcasionTb ocasionTb;
            try {
                ocasionTb = em.getReference(OcasionTb.class, id);
                ocasionTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ocasionTb with id " + id + " no longer exists.", enfe);
            }
            List<RecetaTb> recetaTbList = ocasionTb.getRecetaTbList();
            for (RecetaTb recetaTbListRecetaTb : recetaTbList) {
                recetaTbListRecetaTb.getOcasionTbList().remove(ocasionTb);
                recetaTbListRecetaTb = em.merge(recetaTbListRecetaTb);
            }
            em.remove(ocasionTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OcasionTb> findOcasionTbEntities() {
        return findOcasionTbEntities(true, -1, -1);
    }

    public List<OcasionTb> findOcasionTbEntities(int maxResults, int firstResult) {
        return findOcasionTbEntities(false, maxResults, firstResult);
    }

    private List<OcasionTb> findOcasionTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OcasionTb.class));
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

    public OcasionTb findOcasionTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OcasionTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getOcasionTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OcasionTb> rt = cq.from(OcasionTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

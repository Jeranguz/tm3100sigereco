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
import ucr.ac.cr.sigereco.modelo.UsuarioTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.ConsultaTb;
import ucr.ac.cr.sigereco.modelo.RecetaTb;

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
        if (consultaTb.getUsuarioTbList() == null) {
            consultaTb.setUsuarioTbList(new ArrayList<UsuarioTb>());
        }
        if (consultaTb.getRecetaTbList() == null) {
            consultaTb.setRecetaTbList(new ArrayList<RecetaTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<UsuarioTb> attachedUsuarioTbList = new ArrayList<UsuarioTb>();
            for (UsuarioTb usuarioTbListUsuarioTbToAttach : consultaTb.getUsuarioTbList()) {
                usuarioTbListUsuarioTbToAttach = em.getReference(usuarioTbListUsuarioTbToAttach.getClass(), usuarioTbListUsuarioTbToAttach.getId());
                attachedUsuarioTbList.add(usuarioTbListUsuarioTbToAttach);
            }
            consultaTb.setUsuarioTbList(attachedUsuarioTbList);
            List<RecetaTb> attachedRecetaTbList = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListRecetaTbToAttach : consultaTb.getRecetaTbList()) {
                recetaTbListRecetaTbToAttach = em.getReference(recetaTbListRecetaTbToAttach.getClass(), recetaTbListRecetaTbToAttach.getId());
                attachedRecetaTbList.add(recetaTbListRecetaTbToAttach);
            }
            consultaTb.setRecetaTbList(attachedRecetaTbList);
            em.persist(consultaTb);
            for (UsuarioTb usuarioTbListUsuarioTb : consultaTb.getUsuarioTbList()) {
                usuarioTbListUsuarioTb.getConsultaTbList().add(consultaTb);
                usuarioTbListUsuarioTb = em.merge(usuarioTbListUsuarioTb);
            }
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
            List<UsuarioTb> usuarioTbListOld = persistentConsultaTb.getUsuarioTbList();
            List<UsuarioTb> usuarioTbListNew = consultaTb.getUsuarioTbList();
            List<RecetaTb> recetaTbListOld = persistentConsultaTb.getRecetaTbList();
            List<RecetaTb> recetaTbListNew = consultaTb.getRecetaTbList();
            List<UsuarioTb> attachedUsuarioTbListNew = new ArrayList<UsuarioTb>();
            for (UsuarioTb usuarioTbListNewUsuarioTbToAttach : usuarioTbListNew) {
                usuarioTbListNewUsuarioTbToAttach = em.getReference(usuarioTbListNewUsuarioTbToAttach.getClass(), usuarioTbListNewUsuarioTbToAttach.getId());
                attachedUsuarioTbListNew.add(usuarioTbListNewUsuarioTbToAttach);
            }
            usuarioTbListNew = attachedUsuarioTbListNew;
            consultaTb.setUsuarioTbList(usuarioTbListNew);
            List<RecetaTb> attachedRecetaTbListNew = new ArrayList<RecetaTb>();
            for (RecetaTb recetaTbListNewRecetaTbToAttach : recetaTbListNew) {
                recetaTbListNewRecetaTbToAttach = em.getReference(recetaTbListNewRecetaTbToAttach.getClass(), recetaTbListNewRecetaTbToAttach.getId());
                attachedRecetaTbListNew.add(recetaTbListNewRecetaTbToAttach);
            }
            recetaTbListNew = attachedRecetaTbListNew;
            consultaTb.setRecetaTbList(recetaTbListNew);
            consultaTb = em.merge(consultaTb);
            for (UsuarioTb usuarioTbListOldUsuarioTb : usuarioTbListOld) {
                if (!usuarioTbListNew.contains(usuarioTbListOldUsuarioTb)) {
                    usuarioTbListOldUsuarioTb.getConsultaTbList().remove(consultaTb);
                    usuarioTbListOldUsuarioTb = em.merge(usuarioTbListOldUsuarioTb);
                }
            }
            for (UsuarioTb usuarioTbListNewUsuarioTb : usuarioTbListNew) {
                if (!usuarioTbListOld.contains(usuarioTbListNewUsuarioTb)) {
                    usuarioTbListNewUsuarioTb.getConsultaTbList().add(consultaTb);
                    usuarioTbListNewUsuarioTb = em.merge(usuarioTbListNewUsuarioTb);
                }
            }
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
            List<UsuarioTb> usuarioTbList = consultaTb.getUsuarioTbList();
            for (UsuarioTb usuarioTbListUsuarioTb : usuarioTbList) {
                usuarioTbListUsuarioTb.getConsultaTbList().remove(consultaTb);
                usuarioTbListUsuarioTb = em.merge(usuarioTbListUsuarioTb);
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

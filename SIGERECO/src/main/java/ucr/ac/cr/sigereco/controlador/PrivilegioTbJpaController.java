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
import ucr.ac.cr.sigereco.modelo.PerfilTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.PrivilegioTb;

/**
 *
 * @author Drexler Guzman
 */
public class PrivilegioTbJpaController implements Serializable {

    public PrivilegioTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PrivilegioTb privilegioTb) {
        if (privilegioTb.getPerfilTbList() == null) {
            privilegioTb.setPerfilTbList(new ArrayList<PerfilTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PerfilTb> attachedPerfilTbList = new ArrayList<PerfilTb>();
            for (PerfilTb perfilTbListPerfilTbToAttach : privilegioTb.getPerfilTbList()) {
                perfilTbListPerfilTbToAttach = em.getReference(perfilTbListPerfilTbToAttach.getClass(), perfilTbListPerfilTbToAttach.getId());
                attachedPerfilTbList.add(perfilTbListPerfilTbToAttach);
            }
            privilegioTb.setPerfilTbList(attachedPerfilTbList);
            em.persist(privilegioTb);
            for (PerfilTb perfilTbListPerfilTb : privilegioTb.getPerfilTbList()) {
                perfilTbListPerfilTb.getPrivilegioTbList().add(privilegioTb);
                perfilTbListPerfilTb = em.merge(perfilTbListPerfilTb);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PrivilegioTb privilegioTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PrivilegioTb persistentPrivilegioTb = em.find(PrivilegioTb.class, privilegioTb.getId());
            List<PerfilTb> perfilTbListOld = persistentPrivilegioTb.getPerfilTbList();
            List<PerfilTb> perfilTbListNew = privilegioTb.getPerfilTbList();
            List<PerfilTb> attachedPerfilTbListNew = new ArrayList<PerfilTb>();
            for (PerfilTb perfilTbListNewPerfilTbToAttach : perfilTbListNew) {
                perfilTbListNewPerfilTbToAttach = em.getReference(perfilTbListNewPerfilTbToAttach.getClass(), perfilTbListNewPerfilTbToAttach.getId());
                attachedPerfilTbListNew.add(perfilTbListNewPerfilTbToAttach);
            }
            perfilTbListNew = attachedPerfilTbListNew;
            privilegioTb.setPerfilTbList(perfilTbListNew);
            privilegioTb = em.merge(privilegioTb);
            for (PerfilTb perfilTbListOldPerfilTb : perfilTbListOld) {
                if (!perfilTbListNew.contains(perfilTbListOldPerfilTb)) {
                    perfilTbListOldPerfilTb.getPrivilegioTbList().remove(privilegioTb);
                    perfilTbListOldPerfilTb = em.merge(perfilTbListOldPerfilTb);
                }
            }
            for (PerfilTb perfilTbListNewPerfilTb : perfilTbListNew) {
                if (!perfilTbListOld.contains(perfilTbListNewPerfilTb)) {
                    perfilTbListNewPerfilTb.getPrivilegioTbList().add(privilegioTb);
                    perfilTbListNewPerfilTb = em.merge(perfilTbListNewPerfilTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = privilegioTb.getId();
                if (findPrivilegioTb(id) == null) {
                    throw new NonexistentEntityException("The privilegioTb with id " + id + " no longer exists.");
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
            PrivilegioTb privilegioTb;
            try {
                privilegioTb = em.getReference(PrivilegioTb.class, id);
                privilegioTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The privilegioTb with id " + id + " no longer exists.", enfe);
            }
            List<PerfilTb> perfilTbList = privilegioTb.getPerfilTbList();
            for (PerfilTb perfilTbListPerfilTb : perfilTbList) {
                perfilTbListPerfilTb.getPrivilegioTbList().remove(privilegioTb);
                perfilTbListPerfilTb = em.merge(perfilTbListPerfilTb);
            }
            em.remove(privilegioTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PrivilegioTb> findPrivilegioTbEntities() {
        return findPrivilegioTbEntities(true, -1, -1);
    }

    public List<PrivilegioTb> findPrivilegioTbEntities(int maxResults, int firstResult) {
        return findPrivilegioTbEntities(false, maxResults, firstResult);
    }

    private List<PrivilegioTb> findPrivilegioTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PrivilegioTb.class));
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

    public PrivilegioTb findPrivilegioTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PrivilegioTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrivilegioTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PrivilegioTb> rt = cq.from(PrivilegioTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

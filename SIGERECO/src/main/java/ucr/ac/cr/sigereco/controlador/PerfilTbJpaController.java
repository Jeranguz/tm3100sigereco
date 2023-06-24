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
import ucr.ac.cr.sigereco.modelo.PrivilegioTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.PerfilTb;

/**
 *
 * @author Drexler Guzman
 */
public class PerfilTbJpaController implements Serializable {

    public PerfilTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PerfilTb perfilTb) {
        if (perfilTb.getPrivilegioTbList() == null) {
            perfilTb.setPrivilegioTbList(new ArrayList<PrivilegioTb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PrivilegioTb> attachedPrivilegioTbList = new ArrayList<PrivilegioTb>();
            for (PrivilegioTb privilegioTbListPrivilegioTbToAttach : perfilTb.getPrivilegioTbList()) {
                privilegioTbListPrivilegioTbToAttach = em.getReference(privilegioTbListPrivilegioTbToAttach.getClass(), privilegioTbListPrivilegioTbToAttach.getId());
                attachedPrivilegioTbList.add(privilegioTbListPrivilegioTbToAttach);
            }
            perfilTb.setPrivilegioTbList(attachedPrivilegioTbList);
            em.persist(perfilTb);
            for (PrivilegioTb privilegioTbListPrivilegioTb : perfilTb.getPrivilegioTbList()) {
                privilegioTbListPrivilegioTb.getPerfilTbList().add(perfilTb);
                privilegioTbListPrivilegioTb = em.merge(privilegioTbListPrivilegioTb);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PerfilTb perfilTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PerfilTb persistentPerfilTb = em.find(PerfilTb.class, perfilTb.getId());
            List<PrivilegioTb> privilegioTbListOld = persistentPerfilTb.getPrivilegioTbList();
            List<PrivilegioTb> privilegioTbListNew = perfilTb.getPrivilegioTbList();
            List<PrivilegioTb> attachedPrivilegioTbListNew = new ArrayList<PrivilegioTb>();
            for (PrivilegioTb privilegioTbListNewPrivilegioTbToAttach : privilegioTbListNew) {
                privilegioTbListNewPrivilegioTbToAttach = em.getReference(privilegioTbListNewPrivilegioTbToAttach.getClass(), privilegioTbListNewPrivilegioTbToAttach.getId());
                attachedPrivilegioTbListNew.add(privilegioTbListNewPrivilegioTbToAttach);
            }
            privilegioTbListNew = attachedPrivilegioTbListNew;
            perfilTb.setPrivilegioTbList(privilegioTbListNew);
            perfilTb = em.merge(perfilTb);
            for (PrivilegioTb privilegioTbListOldPrivilegioTb : privilegioTbListOld) {
                if (!privilegioTbListNew.contains(privilegioTbListOldPrivilegioTb)) {
                    privilegioTbListOldPrivilegioTb.getPerfilTbList().remove(perfilTb);
                    privilegioTbListOldPrivilegioTb = em.merge(privilegioTbListOldPrivilegioTb);
                }
            }
            for (PrivilegioTb privilegioTbListNewPrivilegioTb : privilegioTbListNew) {
                if (!privilegioTbListOld.contains(privilegioTbListNewPrivilegioTb)) {
                    privilegioTbListNewPrivilegioTb.getPerfilTbList().add(perfilTb);
                    privilegioTbListNewPrivilegioTb = em.merge(privilegioTbListNewPrivilegioTb);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = perfilTb.getId();
                if (findPerfilTb(id) == null) {
                    throw new NonexistentEntityException("The perfilTb with id " + id + " no longer exists.");
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
            PerfilTb perfilTb;
            try {
                perfilTb = em.getReference(PerfilTb.class, id);
                perfilTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perfilTb with id " + id + " no longer exists.", enfe);
            }
            List<PrivilegioTb> privilegioTbList = perfilTb.getPrivilegioTbList();
            for (PrivilegioTb privilegioTbListPrivilegioTb : privilegioTbList) {
                privilegioTbListPrivilegioTb.getPerfilTbList().remove(perfilTb);
                privilegioTbListPrivilegioTb = em.merge(privilegioTbListPrivilegioTb);
            }
            em.remove(perfilTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PerfilTb> findPerfilTbEntities() {
        return findPerfilTbEntities(true, -1, -1);
    }

    public List<PerfilTb> findPerfilTbEntities(int maxResults, int firstResult) {
        return findPerfilTbEntities(false, maxResults, firstResult);
    }

    private List<PerfilTb> findPerfilTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PerfilTb.class));
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

    public PerfilTb findPerfilTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PerfilTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getPerfilTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PerfilTb> rt = cq.from(PerfilTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

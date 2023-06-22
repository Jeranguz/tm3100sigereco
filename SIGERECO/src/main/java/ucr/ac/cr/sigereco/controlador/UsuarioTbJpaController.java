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
import ucr.ac.cr.sigereco.modelo.ConsultaTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ucr.ac.cr.sigereco.exceptions.IllegalOrphanException;
import ucr.ac.cr.sigereco.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.PerfilTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1Tb;
import ucr.ac.cr.sigereco.modelo.UsuarioTb;

/**
 *
 * @author Drexler Guzman
 */
public class UsuarioTbJpaController implements Serializable {

    public UsuarioTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioTb usuarioTb) {
        if (usuarioTb.getConsultaTbList() == null) {
            usuarioTb.setConsultaTbList(new ArrayList<ConsultaTb>());
        }
        if (usuarioTb.getPerfilTbList() == null) {
            usuarioTb.setPerfilTbList(new ArrayList<PerfilTb>());
        }
        if (usuarioTb.getUsuarioHasRecetaTbList() == null) {
            usuarioTb.setUsuarioHasRecetaTbList(new ArrayList<UsuarioHasRecetaTb>());
        }
        if (usuarioTb.getUsuarioHasReceta1TbList() == null) {
            usuarioTb.setUsuarioHasReceta1TbList(new ArrayList<UsuarioHasReceta1Tb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ConsultaTb> attachedConsultaTbList = new ArrayList<ConsultaTb>();
            for (ConsultaTb consultaTbListConsultaTbToAttach : usuarioTb.getConsultaTbList()) {
                consultaTbListConsultaTbToAttach = em.getReference(consultaTbListConsultaTbToAttach.getClass(), consultaTbListConsultaTbToAttach.getId());
                attachedConsultaTbList.add(consultaTbListConsultaTbToAttach);
            }
            usuarioTb.setConsultaTbList(attachedConsultaTbList);
            List<PerfilTb> attachedPerfilTbList = new ArrayList<PerfilTb>();
            for (PerfilTb perfilTbListPerfilTbToAttach : usuarioTb.getPerfilTbList()) {
                perfilTbListPerfilTbToAttach = em.getReference(perfilTbListPerfilTbToAttach.getClass(), perfilTbListPerfilTbToAttach.getId());
                attachedPerfilTbList.add(perfilTbListPerfilTbToAttach);
            }
            usuarioTb.setPerfilTbList(attachedPerfilTbList);
            List<UsuarioHasRecetaTb> attachedUsuarioHasRecetaTbList = new ArrayList<UsuarioHasRecetaTb>();
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach : usuarioTb.getUsuarioHasRecetaTbList()) {
                usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach = em.getReference(usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach.getClass(), usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach.getUsuarioHasRecetaTbPK());
                attachedUsuarioHasRecetaTbList.add(usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach);
            }
            usuarioTb.setUsuarioHasRecetaTbList(attachedUsuarioHasRecetaTbList);
            List<UsuarioHasReceta1Tb> attachedUsuarioHasReceta1TbList = new ArrayList<UsuarioHasReceta1Tb>();
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach : usuarioTb.getUsuarioHasReceta1TbList()) {
                usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach = em.getReference(usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach.getClass(), usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach.getUsuarioHasReceta1TbPK());
                attachedUsuarioHasReceta1TbList.add(usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach);
            }
            usuarioTb.setUsuarioHasReceta1TbList(attachedUsuarioHasReceta1TbList);
            em.persist(usuarioTb);
            for (ConsultaTb consultaTbListConsultaTb : usuarioTb.getConsultaTbList()) {
                consultaTbListConsultaTb.getUsuarioTbList().add(usuarioTb);
                consultaTbListConsultaTb = em.merge(consultaTbListConsultaTb);
            }
            for (PerfilTb perfilTbListPerfilTb : usuarioTb.getPerfilTbList()) {
                perfilTbListPerfilTb.getUsuarioTbList().add(usuarioTb);
                perfilTbListPerfilTb = em.merge(perfilTbListPerfilTb);
            }
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListUsuarioHasRecetaTb : usuarioTb.getUsuarioHasRecetaTbList()) {
                UsuarioTb oldUsuarioTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb = usuarioHasRecetaTbListUsuarioHasRecetaTb.getUsuarioTb();
                usuarioHasRecetaTbListUsuarioHasRecetaTb.setUsuarioTb(usuarioTb);
                usuarioHasRecetaTbListUsuarioHasRecetaTb = em.merge(usuarioHasRecetaTbListUsuarioHasRecetaTb);
                if (oldUsuarioTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb != null) {
                    oldUsuarioTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb.getUsuarioHasRecetaTbList().remove(usuarioHasRecetaTbListUsuarioHasRecetaTb);
                    oldUsuarioTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb = em.merge(oldUsuarioTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb);
                }
            }
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListUsuarioHasReceta1Tb : usuarioTb.getUsuarioHasReceta1TbList()) {
                UsuarioTb oldUsuarioTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb = usuarioHasReceta1TbListUsuarioHasReceta1Tb.getUsuarioTb();
                usuarioHasReceta1TbListUsuarioHasReceta1Tb.setUsuarioTb(usuarioTb);
                usuarioHasReceta1TbListUsuarioHasReceta1Tb = em.merge(usuarioHasReceta1TbListUsuarioHasReceta1Tb);
                if (oldUsuarioTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb != null) {
                    oldUsuarioTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb.getUsuarioHasReceta1TbList().remove(usuarioHasReceta1TbListUsuarioHasReceta1Tb);
                    oldUsuarioTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb = em.merge(oldUsuarioTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioTb usuarioTb) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioTb persistentUsuarioTb = em.find(UsuarioTb.class, usuarioTb.getId());
            List<ConsultaTb> consultaTbListOld = persistentUsuarioTb.getConsultaTbList();
            List<ConsultaTb> consultaTbListNew = usuarioTb.getConsultaTbList();
            List<PerfilTb> perfilTbListOld = persistentUsuarioTb.getPerfilTbList();
            List<PerfilTb> perfilTbListNew = usuarioTb.getPerfilTbList();
            List<UsuarioHasRecetaTb> usuarioHasRecetaTbListOld = persistentUsuarioTb.getUsuarioHasRecetaTbList();
            List<UsuarioHasRecetaTb> usuarioHasRecetaTbListNew = usuarioTb.getUsuarioHasRecetaTbList();
            List<UsuarioHasReceta1Tb> usuarioHasReceta1TbListOld = persistentUsuarioTb.getUsuarioHasReceta1TbList();
            List<UsuarioHasReceta1Tb> usuarioHasReceta1TbListNew = usuarioTb.getUsuarioHasReceta1TbList();
            List<String> illegalOrphanMessages = null;
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListOldUsuarioHasRecetaTb : usuarioHasRecetaTbListOld) {
                if (!usuarioHasRecetaTbListNew.contains(usuarioHasRecetaTbListOldUsuarioHasRecetaTb)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain UsuarioHasRecetaTb " + usuarioHasRecetaTbListOldUsuarioHasRecetaTb + " since its usuarioTb field is not nullable.");
                }
            }
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListOldUsuarioHasReceta1Tb : usuarioHasReceta1TbListOld) {
                if (!usuarioHasReceta1TbListNew.contains(usuarioHasReceta1TbListOldUsuarioHasReceta1Tb)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain UsuarioHasReceta1Tb " + usuarioHasReceta1TbListOldUsuarioHasReceta1Tb + " since its usuarioTb field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ConsultaTb> attachedConsultaTbListNew = new ArrayList<ConsultaTb>();
            for (ConsultaTb consultaTbListNewConsultaTbToAttach : consultaTbListNew) {
                consultaTbListNewConsultaTbToAttach = em.getReference(consultaTbListNewConsultaTbToAttach.getClass(), consultaTbListNewConsultaTbToAttach.getId());
                attachedConsultaTbListNew.add(consultaTbListNewConsultaTbToAttach);
            }
            consultaTbListNew = attachedConsultaTbListNew;
            usuarioTb.setConsultaTbList(consultaTbListNew);
            List<PerfilTb> attachedPerfilTbListNew = new ArrayList<PerfilTb>();
            for (PerfilTb perfilTbListNewPerfilTbToAttach : perfilTbListNew) {
                perfilTbListNewPerfilTbToAttach = em.getReference(perfilTbListNewPerfilTbToAttach.getClass(), perfilTbListNewPerfilTbToAttach.getId());
                attachedPerfilTbListNew.add(perfilTbListNewPerfilTbToAttach);
            }
            perfilTbListNew = attachedPerfilTbListNew;
            usuarioTb.setPerfilTbList(perfilTbListNew);
            List<UsuarioHasRecetaTb> attachedUsuarioHasRecetaTbListNew = new ArrayList<UsuarioHasRecetaTb>();
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach : usuarioHasRecetaTbListNew) {
                usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach = em.getReference(usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach.getClass(), usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach.getUsuarioHasRecetaTbPK());
                attachedUsuarioHasRecetaTbListNew.add(usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach);
            }
            usuarioHasRecetaTbListNew = attachedUsuarioHasRecetaTbListNew;
            usuarioTb.setUsuarioHasRecetaTbList(usuarioHasRecetaTbListNew);
            List<UsuarioHasReceta1Tb> attachedUsuarioHasReceta1TbListNew = new ArrayList<UsuarioHasReceta1Tb>();
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach : usuarioHasReceta1TbListNew) {
                usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach = em.getReference(usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach.getClass(), usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach.getUsuarioHasReceta1TbPK());
                attachedUsuarioHasReceta1TbListNew.add(usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach);
            }
            usuarioHasReceta1TbListNew = attachedUsuarioHasReceta1TbListNew;
            usuarioTb.setUsuarioHasReceta1TbList(usuarioHasReceta1TbListNew);
            usuarioTb = em.merge(usuarioTb);
            for (ConsultaTb consultaTbListOldConsultaTb : consultaTbListOld) {
                if (!consultaTbListNew.contains(consultaTbListOldConsultaTb)) {
                    consultaTbListOldConsultaTb.getUsuarioTbList().remove(usuarioTb);
                    consultaTbListOldConsultaTb = em.merge(consultaTbListOldConsultaTb);
                }
            }
            for (ConsultaTb consultaTbListNewConsultaTb : consultaTbListNew) {
                if (!consultaTbListOld.contains(consultaTbListNewConsultaTb)) {
                    consultaTbListNewConsultaTb.getUsuarioTbList().add(usuarioTb);
                    consultaTbListNewConsultaTb = em.merge(consultaTbListNewConsultaTb);
                }
            }
            for (PerfilTb perfilTbListOldPerfilTb : perfilTbListOld) {
                if (!perfilTbListNew.contains(perfilTbListOldPerfilTb)) {
                    perfilTbListOldPerfilTb.getUsuarioTbList().remove(usuarioTb);
                    perfilTbListOldPerfilTb = em.merge(perfilTbListOldPerfilTb);
                }
            }
            for (PerfilTb perfilTbListNewPerfilTb : perfilTbListNew) {
                if (!perfilTbListOld.contains(perfilTbListNewPerfilTb)) {
                    perfilTbListNewPerfilTb.getUsuarioTbList().add(usuarioTb);
                    perfilTbListNewPerfilTb = em.merge(perfilTbListNewPerfilTb);
                }
            }
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListNewUsuarioHasRecetaTb : usuarioHasRecetaTbListNew) {
                if (!usuarioHasRecetaTbListOld.contains(usuarioHasRecetaTbListNewUsuarioHasRecetaTb)) {
                    UsuarioTb oldUsuarioTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb = usuarioHasRecetaTbListNewUsuarioHasRecetaTb.getUsuarioTb();
                    usuarioHasRecetaTbListNewUsuarioHasRecetaTb.setUsuarioTb(usuarioTb);
                    usuarioHasRecetaTbListNewUsuarioHasRecetaTb = em.merge(usuarioHasRecetaTbListNewUsuarioHasRecetaTb);
                    if (oldUsuarioTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb != null && !oldUsuarioTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb.equals(usuarioTb)) {
                        oldUsuarioTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb.getUsuarioHasRecetaTbList().remove(usuarioHasRecetaTbListNewUsuarioHasRecetaTb);
                        oldUsuarioTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb = em.merge(oldUsuarioTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb);
                    }
                }
            }
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListNewUsuarioHasReceta1Tb : usuarioHasReceta1TbListNew) {
                if (!usuarioHasReceta1TbListOld.contains(usuarioHasReceta1TbListNewUsuarioHasReceta1Tb)) {
                    UsuarioTb oldUsuarioTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb = usuarioHasReceta1TbListNewUsuarioHasReceta1Tb.getUsuarioTb();
                    usuarioHasReceta1TbListNewUsuarioHasReceta1Tb.setUsuarioTb(usuarioTb);
                    usuarioHasReceta1TbListNewUsuarioHasReceta1Tb = em.merge(usuarioHasReceta1TbListNewUsuarioHasReceta1Tb);
                    if (oldUsuarioTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb != null && !oldUsuarioTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb.equals(usuarioTb)) {
                        oldUsuarioTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb.getUsuarioHasReceta1TbList().remove(usuarioHasReceta1TbListNewUsuarioHasReceta1Tb);
                        oldUsuarioTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb = em.merge(oldUsuarioTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioTb.getId();
                if (findUsuarioTb(id) == null) {
                    throw new NonexistentEntityException("The usuarioTb with id " + id + " no longer exists.");
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
            UsuarioTb usuarioTb;
            try {
                usuarioTb = em.getReference(UsuarioTb.class, id);
                usuarioTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioTb with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<UsuarioHasRecetaTb> usuarioHasRecetaTbListOrphanCheck = usuarioTb.getUsuarioHasRecetaTbList();
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListOrphanCheckUsuarioHasRecetaTb : usuarioHasRecetaTbListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UsuarioTb (" + usuarioTb + ") cannot be destroyed since the UsuarioHasRecetaTb " + usuarioHasRecetaTbListOrphanCheckUsuarioHasRecetaTb + " in its usuarioHasRecetaTbList field has a non-nullable usuarioTb field.");
            }
            List<UsuarioHasReceta1Tb> usuarioHasReceta1TbListOrphanCheck = usuarioTb.getUsuarioHasReceta1TbList();
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListOrphanCheckUsuarioHasReceta1Tb : usuarioHasReceta1TbListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UsuarioTb (" + usuarioTb + ") cannot be destroyed since the UsuarioHasReceta1Tb " + usuarioHasReceta1TbListOrphanCheckUsuarioHasReceta1Tb + " in its usuarioHasReceta1TbList field has a non-nullable usuarioTb field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<ConsultaTb> consultaTbList = usuarioTb.getConsultaTbList();
            for (ConsultaTb consultaTbListConsultaTb : consultaTbList) {
                consultaTbListConsultaTb.getUsuarioTbList().remove(usuarioTb);
                consultaTbListConsultaTb = em.merge(consultaTbListConsultaTb);
            }
            List<PerfilTb> perfilTbList = usuarioTb.getPerfilTbList();
            for (PerfilTb perfilTbListPerfilTb : perfilTbList) {
                perfilTbListPerfilTb.getUsuarioTbList().remove(usuarioTb);
                perfilTbListPerfilTb = em.merge(perfilTbListPerfilTb);
            }
            em.remove(usuarioTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioTb> findUsuarioTbEntities() {
        return findUsuarioTbEntities(true, -1, -1);
    }

    public List<UsuarioTb> findUsuarioTbEntities(int maxResults, int firstResult) {
        return findUsuarioTbEntities(false, maxResults, firstResult);
    }

    private List<UsuarioTb> findUsuarioTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioTb.class));
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

    public UsuarioTb findUsuarioTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioTb> rt = cq.from(UsuarioTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

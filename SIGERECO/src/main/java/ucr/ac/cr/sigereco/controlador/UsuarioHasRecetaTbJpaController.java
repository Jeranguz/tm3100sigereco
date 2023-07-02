/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.controlador.exceptions.PreexistingEntityException;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTbPK;

/**
 *
 * @author Drexler Guzman
 */
public class UsuarioHasRecetaTbJpaController implements Serializable {

    public UsuarioHasRecetaTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioHasRecetaTb usuarioHasRecetaTb) throws PreexistingEntityException, Exception {
        if (usuarioHasRecetaTb.getUsuarioHasRecetaTbPK() == null) {
            usuarioHasRecetaTb.setUsuarioHasRecetaTbPK(new UsuarioHasRecetaTbPK());
        }
        usuarioHasRecetaTb.getUsuarioHasRecetaTbPK().setRecetaId(usuarioHasRecetaTb.getRecetaTb().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RecetaTb recetaTb = usuarioHasRecetaTb.getRecetaTb();
            if (recetaTb != null) {
                recetaTb = em.getReference(recetaTb.getClass(), recetaTb.getId());
                usuarioHasRecetaTb.setRecetaTb(recetaTb);
            }
            em.persist(usuarioHasRecetaTb);
            if (recetaTb != null) {
                //recetaTb.getUsuarioHasRecetaTbList().add(usuarioHasRecetaTb);
                recetaTb = em.merge(recetaTb);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioHasRecetaTb(usuarioHasRecetaTb.getUsuarioHasRecetaTbPK()) != null) {
                throw new PreexistingEntityException("UsuarioHasRecetaTb " + usuarioHasRecetaTb + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioHasRecetaTb usuarioHasRecetaTb) throws NonexistentEntityException, Exception {
        usuarioHasRecetaTb.getUsuarioHasRecetaTbPK().setRecetaId(usuarioHasRecetaTb.getRecetaTb().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioHasRecetaTb persistentUsuarioHasRecetaTb = em.find(UsuarioHasRecetaTb.class, usuarioHasRecetaTb.getUsuarioHasRecetaTbPK());
            RecetaTb recetaTbOld = persistentUsuarioHasRecetaTb.getRecetaTb();
            RecetaTb recetaTbNew = usuarioHasRecetaTb.getRecetaTb();
            if (recetaTbNew != null) {
                recetaTbNew = em.getReference(recetaTbNew.getClass(), recetaTbNew.getId());
                usuarioHasRecetaTb.setRecetaTb(recetaTbNew);
            }
            usuarioHasRecetaTb = em.merge(usuarioHasRecetaTb);
            if (recetaTbOld != null && !recetaTbOld.equals(recetaTbNew)) {
                //recetaTbOld.getUsuarioHasRecetaTbList().remove(usuarioHasRecetaTb);
                recetaTbOld = em.merge(recetaTbOld);
            }
            if (recetaTbNew != null && !recetaTbNew.equals(recetaTbOld)) {
                //recetaTbNew.getUsuarioHasRecetaTbList().add(usuarioHasRecetaTb);
                recetaTbNew = em.merge(recetaTbNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                UsuarioHasRecetaTbPK id = usuarioHasRecetaTb.getUsuarioHasRecetaTbPK();
                if (findUsuarioHasRecetaTb(id) == null) {
                    throw new NonexistentEntityException("The usuarioHasRecetaTb with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(UsuarioHasRecetaTbPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioHasRecetaTb usuarioHasRecetaTb;
            try {
                usuarioHasRecetaTb = em.getReference(UsuarioHasRecetaTb.class, id);
                usuarioHasRecetaTb.getUsuarioHasRecetaTbPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioHasRecetaTb with id " + id + " no longer exists.", enfe);
            }
            RecetaTb recetaTb = usuarioHasRecetaTb.getRecetaTb();
            if (recetaTb != null) {
                //recetaTb.getUsuarioHasRecetaTbList().remove(usuarioHasRecetaTb);
                recetaTb = em.merge(recetaTb);
            }
            em.remove(usuarioHasRecetaTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioHasRecetaTb> findUsuarioHasRecetaTbEntities() {
        return findUsuarioHasRecetaTbEntities(true, -1, -1);
    }

    public List<UsuarioHasRecetaTb> findUsuarioHasRecetaTbEntities(int maxResults, int firstResult) {
        return findUsuarioHasRecetaTbEntities(false, maxResults, firstResult);
    }

    private List<UsuarioHasRecetaTb> findUsuarioHasRecetaTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioHasRecetaTb.class));
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

    public UsuarioHasRecetaTb findUsuarioHasRecetaTb(UsuarioHasRecetaTbPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioHasRecetaTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioHasRecetaTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioHasRecetaTb> rt = cq.from(UsuarioHasRecetaTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

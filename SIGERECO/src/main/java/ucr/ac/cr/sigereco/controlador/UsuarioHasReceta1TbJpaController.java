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
import ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1Tb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1TbPK;

/**
 *
 * @author Drexler Guzman
 */
public class UsuarioHasReceta1TbJpaController implements Serializable {

    public UsuarioHasReceta1TbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioHasReceta1Tb usuarioHasReceta1Tb) throws PreexistingEntityException, Exception {
        if (usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK() == null) {
            usuarioHasReceta1Tb.setUsuarioHasReceta1TbPK(new UsuarioHasReceta1TbPK());
        }
        usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK().setRecetaId(usuarioHasReceta1Tb.getRecetaTb().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RecetaTb recetaTb = usuarioHasReceta1Tb.getRecetaTb();
            if (recetaTb != null) {
                recetaTb = em.getReference(recetaTb.getClass(), recetaTb.getId());
                usuarioHasReceta1Tb.setRecetaTb(recetaTb);
            }
            em.persist(usuarioHasReceta1Tb);
            if (recetaTb != null) {
                recetaTb.getUsuarioHasReceta1TbList().add(usuarioHasReceta1Tb);
                recetaTb = em.merge(recetaTb);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioHasReceta1Tb(usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK()) != null) {
                throw new PreexistingEntityException("UsuarioHasReceta1Tb " + usuarioHasReceta1Tb + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioHasReceta1Tb usuarioHasReceta1Tb) throws NonexistentEntityException, Exception {
        usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK().setRecetaId(usuarioHasReceta1Tb.getRecetaTb().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioHasReceta1Tb persistentUsuarioHasReceta1Tb = em.find(UsuarioHasReceta1Tb.class, usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK());
            RecetaTb recetaTbOld = persistentUsuarioHasReceta1Tb.getRecetaTb();
            RecetaTb recetaTbNew = usuarioHasReceta1Tb.getRecetaTb();
            if (recetaTbNew != null) {
                recetaTbNew = em.getReference(recetaTbNew.getClass(), recetaTbNew.getId());
                usuarioHasReceta1Tb.setRecetaTb(recetaTbNew);
            }
            usuarioHasReceta1Tb = em.merge(usuarioHasReceta1Tb);
            if (recetaTbOld != null && !recetaTbOld.equals(recetaTbNew)) {
                recetaTbOld.getUsuarioHasReceta1TbList().remove(usuarioHasReceta1Tb);
                recetaTbOld = em.merge(recetaTbOld);
            }
            if (recetaTbNew != null && !recetaTbNew.equals(recetaTbOld)) {
                recetaTbNew.getUsuarioHasReceta1TbList().add(usuarioHasReceta1Tb);
                recetaTbNew = em.merge(recetaTbNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                UsuarioHasReceta1TbPK id = usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK();
                if (findUsuarioHasReceta1Tb(id) == null) {
                    throw new NonexistentEntityException("The usuarioHasReceta1Tb with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(UsuarioHasReceta1TbPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioHasReceta1Tb usuarioHasReceta1Tb;
            try {
                usuarioHasReceta1Tb = em.getReference(UsuarioHasReceta1Tb.class, id);
                usuarioHasReceta1Tb.getUsuarioHasReceta1TbPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioHasReceta1Tb with id " + id + " no longer exists.", enfe);
            }
            RecetaTb recetaTb = usuarioHasReceta1Tb.getRecetaTb();
            if (recetaTb != null) {
                recetaTb.getUsuarioHasReceta1TbList().remove(usuarioHasReceta1Tb);
                recetaTb = em.merge(recetaTb);
            }
            em.remove(usuarioHasReceta1Tb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioHasReceta1Tb> findUsuarioHasReceta1TbEntities() {
        return findUsuarioHasReceta1TbEntities(true, -1, -1);
    }

    public List<UsuarioHasReceta1Tb> findUsuarioHasReceta1TbEntities(int maxResults, int firstResult) {
        return findUsuarioHasReceta1TbEntities(false, maxResults, firstResult);
    }

    private List<UsuarioHasReceta1Tb> findUsuarioHasReceta1TbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioHasReceta1Tb.class));
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

    public UsuarioHasReceta1Tb findUsuarioHasReceta1Tb(UsuarioHasReceta1TbPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioHasReceta1Tb.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioHasReceta1TbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioHasReceta1Tb> rt = cq.from(UsuarioHasReceta1Tb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

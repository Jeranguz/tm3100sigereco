/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioTb usuarioTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioTb = em.merge(usuarioTb);
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
    
    public List<RecetaTb> findRecetaTbEntities2(boolean all,int maxResults, int firstResult, String valorEspecifico) {
    EntityManager em = getEntityManager();
    try {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
        Root<RecetaTb> root = cq.from(RecetaTb.class);
        cq.select(root);

        if (valorEspecifico != null) {
            cq.where(cb.equal(root.get("Categoría"), valorEspecifico)); // Reemplaza "campoEspecifico" con el nombre del campo que deseas consultar
        }

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

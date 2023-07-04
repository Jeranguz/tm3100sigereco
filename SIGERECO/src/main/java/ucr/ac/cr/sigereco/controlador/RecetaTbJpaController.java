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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.RecetaTb;

/**
 *
 * @author Drexler Guzman
 */
public class RecetaTbJpaController implements Serializable {

    public RecetaTbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RecetaTb recetaTb) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(recetaTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RecetaTb recetaTb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            recetaTb = em.merge(recetaTb);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = recetaTb.getId();
                if (findRecetaTb(id) == null) {
                    throw new NonexistentEntityException("The recetaTb with id " + id + " no longer exists.");
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
            RecetaTb recetaTb;
            try {
                recetaTb = em.getReference(RecetaTb.class, id);
                recetaTb.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recetaTb with id " + id + " no longer exists.", enfe);
            }
            em.remove(recetaTb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RecetaTb> findRecetaTbEntities() {
        return findRecetaTbEntities(true, -1, -1);
    }

    public List<RecetaTb> findRecetaTbEntities(int maxResults, int firstResult) {
        return findRecetaTbEntities(false, maxResults, firstResult);
    }

    private List<RecetaTb> findRecetaTbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RecetaTb.class));
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
    
    

    public RecetaTb findRecetaTb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RecetaTb.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecetaTbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RecetaTb> rt = cq.from(RecetaTb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarCategoria(String categoria) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);
            cq.select(root).where(cb.equal(root.get("categoria"), categoria));

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarOcasion(String ocasion) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);
            cq.select(root).where(cb.equal(root.get("ocasion"), ocasion));

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarComplejidad(String complejidad) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);
            cq.select(root).where(cb.equal(root.get("dificultad"), complejidad));

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarComplejidadOcasion(String complejidad, String ocasion) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);

            cq.select(root).where(
                    cb.and(
                            cb.equal(root.get("dificultad"), complejidad),
                            cb.equal(root.get("ocasion"), ocasion)
                    )
            );

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarComplejidadCategoria(String complejidad, String categoria) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);

            cq.select(root).where(
                    cb.and(
                            cb.equal(root.get("dificultad"), complejidad),
                            cb.equal(root.get("categoria"), categoria)
                    )
            );

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarOcasionCategoria(String categoria, String ocasion) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);

            cq.select(root).where(
                    cb.and(
                            cb.equal(root.get("categoria"), categoria),
                            cb.equal(root.get("ocasion"), ocasion)
                    )
            );

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
    public List<RecetaTb> buscarOcasionCategoriaComplejidad(String categoria, String ocasion, String complejidad) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<RecetaTb> cq = cb.createQuery(RecetaTb.class);
            Root<RecetaTb> root = cq.from(RecetaTb.class);

            cq.select(root).where(
                    cb.and(
                            cb.equal(root.get("categoria"), categoria),
                            cb.equal(root.get("ocasion"), ocasion),
                            cb.equal(root.get("dificultad"), complejidad)
                    )
            );

            TypedQuery<RecetaTb> query = em.createQuery(cq);
            List<RecetaTb> resultado = query.getResultList();
            return resultado;
        } finally {
            em.close();
        }
    }
    
}

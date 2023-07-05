/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.apijsonproyectointegrado;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ucr.ac.cr.apijsonproyectointegrado.exceptions.NonexistentEntityException;
import ucr.ac.cr.apijsonproyectointegrado.exceptions.PreexistingEntityException;

/**
 *
 * @author Drexler Guzman
 */
public class ApiRecetasJpaController implements Serializable {
    
    public ApiRecetasJpaController() throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);
        server.createContext("/api", new MyHandler());
        server.setExecutor(null);
        server.start();

    }

    static class MyHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange t) throws IOException {
            if (t.getRequestMethod().equalsIgnoreCase("GET")) {
                handleGetViewIngredient(t);
            } else {
                t.sendResponseHeaders(405, -1);
                t.close();
                return;
            }

        }//

        private void handleGetViewIngredient(HttpExchange exchange) throws IOException {
            // guardar();
            Gson gson = new Gson();
            Type type = new TypeToken<List<ApiRecetas>>() {
            }.getType();

            //List<ApiRecetasVista> listView = gson.fromJson(new FileReader("recipes.json"), type);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ucr.ac.cr_APIJsonProyectoIntegrado_jar_1.0-SNAPSHOTPU");
            EntityManager em = emf.createEntityManager();
            List<ApiRecetas> listView
                    = em.createQuery("SELECT v FROM ApiRecetas v", ApiRecetas.class).
                            getResultList();

            String response = gson.toJson(listView);
            System.out.println(response);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        }

        public void guardar() {
            FileWriter writer = null;
            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("ucr.ac.cr_APIJsonProyectoIntegrado_jar_1.0-SNAPSHOTPU");
                EntityManager em = emf.createEntityManager();
                List<ApiRecetas> listView
                        = em.createQuery("SELECT v FROM ApiRecetas v", ApiRecetas.class).
                                getResultList();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                writer = new FileWriter("recipes.json");
                gson.toJson(listView, writer);
                writer.close();
            } catch (IOException ex) {
            } finally {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }

    }

    public ApiRecetasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ApiRecetas apiRecetas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(apiRecetas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findApiRecetas(apiRecetas.getId()) != null) {
                throw new PreexistingEntityException("ApiRecetas " + apiRecetas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ApiRecetas apiRecetas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            apiRecetas = em.merge(apiRecetas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = apiRecetas.getId();
                if (findApiRecetas(id) == null) {
                    throw new NonexistentEntityException("The apiRecetas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ApiRecetas apiRecetas;
            try {
                apiRecetas = em.getReference(ApiRecetas.class, id);
                apiRecetas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The apiRecetas with id " + id + " no longer exists.", enfe);
            }
            em.remove(apiRecetas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ApiRecetas> findApiRecetasEntities() {
        return findApiRecetasEntities(true, -1, -1);
    }

    public List<ApiRecetas> findApiRecetasEntities(int maxResults, int firstResult) {
        return findApiRecetasEntities(false, maxResults, firstResult);
    }

    private List<ApiRecetas> findApiRecetasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ApiRecetas.class));
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

    public ApiRecetas findApiRecetas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ApiRecetas.class, id);
        } finally {
            em.close();
        }
    }

    public int getApiRecetasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ApiRecetas> rt = cq.from(ApiRecetas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

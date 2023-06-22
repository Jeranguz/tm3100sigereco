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
import ucr.ac.cr.sigereco.modelo.OcasionTb;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ucr.ac.cr.sigereco.exceptions.IllegalOrphanException;
import ucr.ac.cr.sigereco.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.ComplejidadTb;
import ucr.ac.cr.sigereco.modelo.CategoriaTb;
import ucr.ac.cr.sigereco.modelo.ConsultaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTb;
import ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1Tb;

/**
 *
 * @author Drexler Guzman
 */
public class RecetaTbJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public RecetaTbJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SIGERECOPersistence");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RecetaTb recetaTb) {
        if (recetaTb.getOcasionTbList() == null) {
            recetaTb.setOcasionTbList(new ArrayList<OcasionTb>());
        }
        if (recetaTb.getComplejidadTbList() == null) {
            recetaTb.setComplejidadTbList(new ArrayList<ComplejidadTb>());
        }
        if (recetaTb.getCategoriaTbList() == null) {
            recetaTb.setCategoriaTbList(new ArrayList<CategoriaTb>());
        }
        if (recetaTb.getConsultaTbList() == null) {
            recetaTb.setConsultaTbList(new ArrayList<ConsultaTb>());
        }
        if (recetaTb.getUsuarioHasRecetaTbList() == null) {
            recetaTb.setUsuarioHasRecetaTbList(new ArrayList<UsuarioHasRecetaTb>());
        }
        if (recetaTb.getRecetaHasIngredienteTbList() == null) {
            recetaTb.setRecetaHasIngredienteTbList(new ArrayList<RecetaHasIngredienteTb>());
        }
        if (recetaTb.getUsuarioHasReceta1TbList() == null) {
            recetaTb.setUsuarioHasReceta1TbList(new ArrayList<UsuarioHasReceta1Tb>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<OcasionTb> attachedOcasionTbList = new ArrayList<OcasionTb>();
            for (OcasionTb ocasionTbListOcasionTbToAttach : recetaTb.getOcasionTbList()) {
                ocasionTbListOcasionTbToAttach = em.getReference(ocasionTbListOcasionTbToAttach.getClass(), ocasionTbListOcasionTbToAttach.getId());
                attachedOcasionTbList.add(ocasionTbListOcasionTbToAttach);
            }
            recetaTb.setOcasionTbList(attachedOcasionTbList);
            List<ComplejidadTb> attachedComplejidadTbList = new ArrayList<ComplejidadTb>();
            for (ComplejidadTb complejidadTbListComplejidadTbToAttach : recetaTb.getComplejidadTbList()) {
                complejidadTbListComplejidadTbToAttach = em.getReference(complejidadTbListComplejidadTbToAttach.getClass(), complejidadTbListComplejidadTbToAttach.getId());
                attachedComplejidadTbList.add(complejidadTbListComplejidadTbToAttach);
            }
            recetaTb.setComplejidadTbList(attachedComplejidadTbList);
            List<CategoriaTb> attachedCategoriaTbList = new ArrayList<CategoriaTb>();
            for (CategoriaTb categoriaTbListCategoriaTbToAttach : recetaTb.getCategoriaTbList()) {
                categoriaTbListCategoriaTbToAttach = em.getReference(categoriaTbListCategoriaTbToAttach.getClass(), categoriaTbListCategoriaTbToAttach.getId());
                attachedCategoriaTbList.add(categoriaTbListCategoriaTbToAttach);
            }
            recetaTb.setCategoriaTbList(attachedCategoriaTbList);
            List<ConsultaTb> attachedConsultaTbList = new ArrayList<ConsultaTb>();
            for (ConsultaTb consultaTbListConsultaTbToAttach : recetaTb.getConsultaTbList()) {
                consultaTbListConsultaTbToAttach = em.getReference(consultaTbListConsultaTbToAttach.getClass(), consultaTbListConsultaTbToAttach.getId());
                attachedConsultaTbList.add(consultaTbListConsultaTbToAttach);
            }
            recetaTb.setConsultaTbList(attachedConsultaTbList);
            List<UsuarioHasRecetaTb> attachedUsuarioHasRecetaTbList = new ArrayList<UsuarioHasRecetaTb>();
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach : recetaTb.getUsuarioHasRecetaTbList()) {
                usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach = em.getReference(usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach.getClass(), usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach.getUsuarioHasRecetaTbPK());
                attachedUsuarioHasRecetaTbList.add(usuarioHasRecetaTbListUsuarioHasRecetaTbToAttach);
            }
            recetaTb.setUsuarioHasRecetaTbList(attachedUsuarioHasRecetaTbList);
            List<RecetaHasIngredienteTb> attachedRecetaHasIngredienteTbList = new ArrayList<RecetaHasIngredienteTb>();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach : recetaTb.getRecetaHasIngredienteTbList()) {
                recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach = em.getReference(recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach.getClass(), recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach.getRecetaHasIngredienteTbPK());
                attachedRecetaHasIngredienteTbList.add(recetaHasIngredienteTbListRecetaHasIngredienteTbToAttach);
            }
            recetaTb.setRecetaHasIngredienteTbList(attachedRecetaHasIngredienteTbList);
            List<UsuarioHasReceta1Tb> attachedUsuarioHasReceta1TbList = new ArrayList<UsuarioHasReceta1Tb>();
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach : recetaTb.getUsuarioHasReceta1TbList()) {
                usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach = em.getReference(usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach.getClass(), usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach.getUsuarioHasReceta1TbPK());
                attachedUsuarioHasReceta1TbList.add(usuarioHasReceta1TbListUsuarioHasReceta1TbToAttach);
            }
            recetaTb.setUsuarioHasReceta1TbList(attachedUsuarioHasReceta1TbList);
            em.persist(recetaTb);
            for (OcasionTb ocasionTbListOcasionTb : recetaTb.getOcasionTbList()) {
                ocasionTbListOcasionTb.getRecetaTbList().add(recetaTb);
                ocasionTbListOcasionTb = em.merge(ocasionTbListOcasionTb);
            }
            for (ComplejidadTb complejidadTbListComplejidadTb : recetaTb.getComplejidadTbList()) {
                complejidadTbListComplejidadTb.getRecetaTbList().add(recetaTb);
                complejidadTbListComplejidadTb = em.merge(complejidadTbListComplejidadTb);
            }
            for (CategoriaTb categoriaTbListCategoriaTb : recetaTb.getCategoriaTbList()) {
                categoriaTbListCategoriaTb.getRecetaTbList().add(recetaTb);
                categoriaTbListCategoriaTb = em.merge(categoriaTbListCategoriaTb);
            }
            for (ConsultaTb consultaTbListConsultaTb : recetaTb.getConsultaTbList()) {
                consultaTbListConsultaTb.getRecetaTbList().add(recetaTb);
                consultaTbListConsultaTb = em.merge(consultaTbListConsultaTb);
            }
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListUsuarioHasRecetaTb : recetaTb.getUsuarioHasRecetaTbList()) {
                RecetaTb oldRecetaTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb = usuarioHasRecetaTbListUsuarioHasRecetaTb.getRecetaTb();
                usuarioHasRecetaTbListUsuarioHasRecetaTb.setRecetaTb(recetaTb);
                usuarioHasRecetaTbListUsuarioHasRecetaTb = em.merge(usuarioHasRecetaTbListUsuarioHasRecetaTb);
                if (oldRecetaTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb != null) {
                    oldRecetaTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb.getUsuarioHasRecetaTbList().remove(usuarioHasRecetaTbListUsuarioHasRecetaTb);
                    oldRecetaTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb = em.merge(oldRecetaTbOfUsuarioHasRecetaTbListUsuarioHasRecetaTb);
                }
            }
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListRecetaHasIngredienteTb : recetaTb.getRecetaHasIngredienteTbList()) {
                RecetaTb oldRecetaTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb = recetaHasIngredienteTbListRecetaHasIngredienteTb.getRecetaTb();
                recetaHasIngredienteTbListRecetaHasIngredienteTb.setRecetaTb(recetaTb);
                recetaHasIngredienteTbListRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListRecetaHasIngredienteTb);
                if (oldRecetaTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb != null) {
                    oldRecetaTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTbListRecetaHasIngredienteTb);
                    oldRecetaTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb = em.merge(oldRecetaTbOfRecetaHasIngredienteTbListRecetaHasIngredienteTb);
                }
            }
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListUsuarioHasReceta1Tb : recetaTb.getUsuarioHasReceta1TbList()) {
                RecetaTb oldRecetaTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb = usuarioHasReceta1TbListUsuarioHasReceta1Tb.getRecetaTb();
                usuarioHasReceta1TbListUsuarioHasReceta1Tb.setRecetaTb(recetaTb);
                usuarioHasReceta1TbListUsuarioHasReceta1Tb = em.merge(usuarioHasReceta1TbListUsuarioHasReceta1Tb);
                if (oldRecetaTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb != null) {
                    oldRecetaTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb.getUsuarioHasReceta1TbList().remove(usuarioHasReceta1TbListUsuarioHasReceta1Tb);
                    oldRecetaTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb = em.merge(oldRecetaTbOfUsuarioHasReceta1TbListUsuarioHasReceta1Tb);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RecetaTb recetaTb) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RecetaTb persistentRecetaTb = em.find(RecetaTb.class, recetaTb.getId());
            List<OcasionTb> ocasionTbListOld = persistentRecetaTb.getOcasionTbList();
            List<OcasionTb> ocasionTbListNew = recetaTb.getOcasionTbList();
            List<ComplejidadTb> complejidadTbListOld = persistentRecetaTb.getComplejidadTbList();
            List<ComplejidadTb> complejidadTbListNew = recetaTb.getComplejidadTbList();
            List<CategoriaTb> categoriaTbListOld = persistentRecetaTb.getCategoriaTbList();
            List<CategoriaTb> categoriaTbListNew = recetaTb.getCategoriaTbList();
            List<ConsultaTb> consultaTbListOld = persistentRecetaTb.getConsultaTbList();
            List<ConsultaTb> consultaTbListNew = recetaTb.getConsultaTbList();
            List<UsuarioHasRecetaTb> usuarioHasRecetaTbListOld = persistentRecetaTb.getUsuarioHasRecetaTbList();
            List<UsuarioHasRecetaTb> usuarioHasRecetaTbListNew = recetaTb.getUsuarioHasRecetaTbList();
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListOld = persistentRecetaTb.getRecetaHasIngredienteTbList();
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListNew = recetaTb.getRecetaHasIngredienteTbList();
            List<UsuarioHasReceta1Tb> usuarioHasReceta1TbListOld = persistentRecetaTb.getUsuarioHasReceta1TbList();
            List<UsuarioHasReceta1Tb> usuarioHasReceta1TbListNew = recetaTb.getUsuarioHasReceta1TbList();
            List<String> illegalOrphanMessages = null;
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListOldUsuarioHasRecetaTb : usuarioHasRecetaTbListOld) {
                if (!usuarioHasRecetaTbListNew.contains(usuarioHasRecetaTbListOldUsuarioHasRecetaTb)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain UsuarioHasRecetaTb " + usuarioHasRecetaTbListOldUsuarioHasRecetaTb + " since its recetaTb field is not nullable.");
                }
            }
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListOldRecetaHasIngredienteTb : recetaHasIngredienteTbListOld) {
                if (!recetaHasIngredienteTbListNew.contains(recetaHasIngredienteTbListOldRecetaHasIngredienteTb)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RecetaHasIngredienteTb " + recetaHasIngredienteTbListOldRecetaHasIngredienteTb + " since its recetaTb field is not nullable.");
                }
            }
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListOldUsuarioHasReceta1Tb : usuarioHasReceta1TbListOld) {
                if (!usuarioHasReceta1TbListNew.contains(usuarioHasReceta1TbListOldUsuarioHasReceta1Tb)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain UsuarioHasReceta1Tb " + usuarioHasReceta1TbListOldUsuarioHasReceta1Tb + " since its recetaTb field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<OcasionTb> attachedOcasionTbListNew = new ArrayList<OcasionTb>();
            for (OcasionTb ocasionTbListNewOcasionTbToAttach : ocasionTbListNew) {
                ocasionTbListNewOcasionTbToAttach = em.getReference(ocasionTbListNewOcasionTbToAttach.getClass(), ocasionTbListNewOcasionTbToAttach.getId());
                attachedOcasionTbListNew.add(ocasionTbListNewOcasionTbToAttach);
            }
            ocasionTbListNew = attachedOcasionTbListNew;
            recetaTb.setOcasionTbList(ocasionTbListNew);
            List<ComplejidadTb> attachedComplejidadTbListNew = new ArrayList<ComplejidadTb>();
            for (ComplejidadTb complejidadTbListNewComplejidadTbToAttach : complejidadTbListNew) {
                complejidadTbListNewComplejidadTbToAttach = em.getReference(complejidadTbListNewComplejidadTbToAttach.getClass(), complejidadTbListNewComplejidadTbToAttach.getId());
                attachedComplejidadTbListNew.add(complejidadTbListNewComplejidadTbToAttach);
            }
            complejidadTbListNew = attachedComplejidadTbListNew;
            recetaTb.setComplejidadTbList(complejidadTbListNew);
            List<CategoriaTb> attachedCategoriaTbListNew = new ArrayList<CategoriaTb>();
            for (CategoriaTb categoriaTbListNewCategoriaTbToAttach : categoriaTbListNew) {
                categoriaTbListNewCategoriaTbToAttach = em.getReference(categoriaTbListNewCategoriaTbToAttach.getClass(), categoriaTbListNewCategoriaTbToAttach.getId());
                attachedCategoriaTbListNew.add(categoriaTbListNewCategoriaTbToAttach);
            }
            categoriaTbListNew = attachedCategoriaTbListNew;
            recetaTb.setCategoriaTbList(categoriaTbListNew);
            List<ConsultaTb> attachedConsultaTbListNew = new ArrayList<ConsultaTb>();
            for (ConsultaTb consultaTbListNewConsultaTbToAttach : consultaTbListNew) {
                consultaTbListNewConsultaTbToAttach = em.getReference(consultaTbListNewConsultaTbToAttach.getClass(), consultaTbListNewConsultaTbToAttach.getId());
                attachedConsultaTbListNew.add(consultaTbListNewConsultaTbToAttach);
            }
            consultaTbListNew = attachedConsultaTbListNew;
            recetaTb.setConsultaTbList(consultaTbListNew);
            List<UsuarioHasRecetaTb> attachedUsuarioHasRecetaTbListNew = new ArrayList<UsuarioHasRecetaTb>();
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach : usuarioHasRecetaTbListNew) {
                usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach = em.getReference(usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach.getClass(), usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach.getUsuarioHasRecetaTbPK());
                attachedUsuarioHasRecetaTbListNew.add(usuarioHasRecetaTbListNewUsuarioHasRecetaTbToAttach);
            }
            usuarioHasRecetaTbListNew = attachedUsuarioHasRecetaTbListNew;
            recetaTb.setUsuarioHasRecetaTbList(usuarioHasRecetaTbListNew);
            List<RecetaHasIngredienteTb> attachedRecetaHasIngredienteTbListNew = new ArrayList<RecetaHasIngredienteTb>();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach : recetaHasIngredienteTbListNew) {
                recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach = em.getReference(recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach.getClass(), recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach.getRecetaHasIngredienteTbPK());
                attachedRecetaHasIngredienteTbListNew.add(recetaHasIngredienteTbListNewRecetaHasIngredienteTbToAttach);
            }
            recetaHasIngredienteTbListNew = attachedRecetaHasIngredienteTbListNew;
            recetaTb.setRecetaHasIngredienteTbList(recetaHasIngredienteTbListNew);
            List<UsuarioHasReceta1Tb> attachedUsuarioHasReceta1TbListNew = new ArrayList<UsuarioHasReceta1Tb>();
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach : usuarioHasReceta1TbListNew) {
                usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach = em.getReference(usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach.getClass(), usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach.getUsuarioHasReceta1TbPK());
                attachedUsuarioHasReceta1TbListNew.add(usuarioHasReceta1TbListNewUsuarioHasReceta1TbToAttach);
            }
            usuarioHasReceta1TbListNew = attachedUsuarioHasReceta1TbListNew;
            recetaTb.setUsuarioHasReceta1TbList(usuarioHasReceta1TbListNew);
            recetaTb = em.merge(recetaTb);
            for (OcasionTb ocasionTbListOldOcasionTb : ocasionTbListOld) {
                if (!ocasionTbListNew.contains(ocasionTbListOldOcasionTb)) {
                    ocasionTbListOldOcasionTb.getRecetaTbList().remove(recetaTb);
                    ocasionTbListOldOcasionTb = em.merge(ocasionTbListOldOcasionTb);
                }
            }
            for (OcasionTb ocasionTbListNewOcasionTb : ocasionTbListNew) {
                if (!ocasionTbListOld.contains(ocasionTbListNewOcasionTb)) {
                    ocasionTbListNewOcasionTb.getRecetaTbList().add(recetaTb);
                    ocasionTbListNewOcasionTb = em.merge(ocasionTbListNewOcasionTb);
                }
            }
            for (ComplejidadTb complejidadTbListOldComplejidadTb : complejidadTbListOld) {
                if (!complejidadTbListNew.contains(complejidadTbListOldComplejidadTb)) {
                    complejidadTbListOldComplejidadTb.getRecetaTbList().remove(recetaTb);
                    complejidadTbListOldComplejidadTb = em.merge(complejidadTbListOldComplejidadTb);
                }
            }
            for (ComplejidadTb complejidadTbListNewComplejidadTb : complejidadTbListNew) {
                if (!complejidadTbListOld.contains(complejidadTbListNewComplejidadTb)) {
                    complejidadTbListNewComplejidadTb.getRecetaTbList().add(recetaTb);
                    complejidadTbListNewComplejidadTb = em.merge(complejidadTbListNewComplejidadTb);
                }
            }
            for (CategoriaTb categoriaTbListOldCategoriaTb : categoriaTbListOld) {
                if (!categoriaTbListNew.contains(categoriaTbListOldCategoriaTb)) {
                    categoriaTbListOldCategoriaTb.getRecetaTbList().remove(recetaTb);
                    categoriaTbListOldCategoriaTb = em.merge(categoriaTbListOldCategoriaTb);
                }
            }
            for (CategoriaTb categoriaTbListNewCategoriaTb : categoriaTbListNew) {
                if (!categoriaTbListOld.contains(categoriaTbListNewCategoriaTb)) {
                    categoriaTbListNewCategoriaTb.getRecetaTbList().add(recetaTb);
                    categoriaTbListNewCategoriaTb = em.merge(categoriaTbListNewCategoriaTb);
                }
            }
            for (ConsultaTb consultaTbListOldConsultaTb : consultaTbListOld) {
                if (!consultaTbListNew.contains(consultaTbListOldConsultaTb)) {
                    consultaTbListOldConsultaTb.getRecetaTbList().remove(recetaTb);
                    consultaTbListOldConsultaTb = em.merge(consultaTbListOldConsultaTb);
                }
            }
            for (ConsultaTb consultaTbListNewConsultaTb : consultaTbListNew) {
                if (!consultaTbListOld.contains(consultaTbListNewConsultaTb)) {
                    consultaTbListNewConsultaTb.getRecetaTbList().add(recetaTb);
                    consultaTbListNewConsultaTb = em.merge(consultaTbListNewConsultaTb);
                }
            }
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListNewUsuarioHasRecetaTb : usuarioHasRecetaTbListNew) {
                if (!usuarioHasRecetaTbListOld.contains(usuarioHasRecetaTbListNewUsuarioHasRecetaTb)) {
                    RecetaTb oldRecetaTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb = usuarioHasRecetaTbListNewUsuarioHasRecetaTb.getRecetaTb();
                    usuarioHasRecetaTbListNewUsuarioHasRecetaTb.setRecetaTb(recetaTb);
                    usuarioHasRecetaTbListNewUsuarioHasRecetaTb = em.merge(usuarioHasRecetaTbListNewUsuarioHasRecetaTb);
                    if (oldRecetaTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb != null && !oldRecetaTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb.equals(recetaTb)) {
                        oldRecetaTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb.getUsuarioHasRecetaTbList().remove(usuarioHasRecetaTbListNewUsuarioHasRecetaTb);
                        oldRecetaTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb = em.merge(oldRecetaTbOfUsuarioHasRecetaTbListNewUsuarioHasRecetaTb);
                    }
                }
            }
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListNewRecetaHasIngredienteTb : recetaHasIngredienteTbListNew) {
                if (!recetaHasIngredienteTbListOld.contains(recetaHasIngredienteTbListNewRecetaHasIngredienteTb)) {
                    RecetaTb oldRecetaTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb = recetaHasIngredienteTbListNewRecetaHasIngredienteTb.getRecetaTb();
                    recetaHasIngredienteTbListNewRecetaHasIngredienteTb.setRecetaTb(recetaTb);
                    recetaHasIngredienteTbListNewRecetaHasIngredienteTb = em.merge(recetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                    if (oldRecetaTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb != null && !oldRecetaTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb.equals(recetaTb)) {
                        oldRecetaTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb.getRecetaHasIngredienteTbList().remove(recetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                        oldRecetaTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb = em.merge(oldRecetaTbOfRecetaHasIngredienteTbListNewRecetaHasIngredienteTb);
                    }
                }
            }
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListNewUsuarioHasReceta1Tb : usuarioHasReceta1TbListNew) {
                if (!usuarioHasReceta1TbListOld.contains(usuarioHasReceta1TbListNewUsuarioHasReceta1Tb)) {
                    RecetaTb oldRecetaTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb = usuarioHasReceta1TbListNewUsuarioHasReceta1Tb.getRecetaTb();
                    usuarioHasReceta1TbListNewUsuarioHasReceta1Tb.setRecetaTb(recetaTb);
                    usuarioHasReceta1TbListNewUsuarioHasReceta1Tb = em.merge(usuarioHasReceta1TbListNewUsuarioHasReceta1Tb);
                    if (oldRecetaTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb != null && !oldRecetaTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb.equals(recetaTb)) {
                        oldRecetaTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb.getUsuarioHasReceta1TbList().remove(usuarioHasReceta1TbListNewUsuarioHasReceta1Tb);
                        oldRecetaTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb = em.merge(oldRecetaTbOfUsuarioHasReceta1TbListNewUsuarioHasReceta1Tb);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<UsuarioHasRecetaTb> usuarioHasRecetaTbListOrphanCheck = recetaTb.getUsuarioHasRecetaTbList();
            for (UsuarioHasRecetaTb usuarioHasRecetaTbListOrphanCheckUsuarioHasRecetaTb : usuarioHasRecetaTbListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This RecetaTb (" + recetaTb + ") cannot be destroyed since the UsuarioHasRecetaTb " + usuarioHasRecetaTbListOrphanCheckUsuarioHasRecetaTb + " in its usuarioHasRecetaTbList field has a non-nullable recetaTb field.");
            }
            List<RecetaHasIngredienteTb> recetaHasIngredienteTbListOrphanCheck = recetaTb.getRecetaHasIngredienteTbList();
            for (RecetaHasIngredienteTb recetaHasIngredienteTbListOrphanCheckRecetaHasIngredienteTb : recetaHasIngredienteTbListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This RecetaTb (" + recetaTb + ") cannot be destroyed since the RecetaHasIngredienteTb " + recetaHasIngredienteTbListOrphanCheckRecetaHasIngredienteTb + " in its recetaHasIngredienteTbList field has a non-nullable recetaTb field.");
            }
            List<UsuarioHasReceta1Tb> usuarioHasReceta1TbListOrphanCheck = recetaTb.getUsuarioHasReceta1TbList();
            for (UsuarioHasReceta1Tb usuarioHasReceta1TbListOrphanCheckUsuarioHasReceta1Tb : usuarioHasReceta1TbListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This RecetaTb (" + recetaTb + ") cannot be destroyed since the UsuarioHasReceta1Tb " + usuarioHasReceta1TbListOrphanCheckUsuarioHasReceta1Tb + " in its usuarioHasReceta1TbList field has a non-nullable recetaTb field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<OcasionTb> ocasionTbList = recetaTb.getOcasionTbList();
            for (OcasionTb ocasionTbListOcasionTb : ocasionTbList) {
                ocasionTbListOcasionTb.getRecetaTbList().remove(recetaTb);
                ocasionTbListOcasionTb = em.merge(ocasionTbListOcasionTb);
            }
            List<ComplejidadTb> complejidadTbList = recetaTb.getComplejidadTbList();
            for (ComplejidadTb complejidadTbListComplejidadTb : complejidadTbList) {
                complejidadTbListComplejidadTb.getRecetaTbList().remove(recetaTb);
                complejidadTbListComplejidadTb = em.merge(complejidadTbListComplejidadTb);
            }
            List<CategoriaTb> categoriaTbList = recetaTb.getCategoriaTbList();
            for (CategoriaTb categoriaTbListCategoriaTb : categoriaTbList) {
                categoriaTbListCategoriaTb.getRecetaTbList().remove(recetaTb);
                categoriaTbListCategoriaTb = em.merge(categoriaTbListCategoriaTb);
            }
            List<ConsultaTb> consultaTbList = recetaTb.getConsultaTbList();
            for (ConsultaTb consultaTbListConsultaTb : consultaTbList) {
                consultaTbListConsultaTb.getRecetaTbList().remove(recetaTb);
                consultaTbListConsultaTb = em.merge(consultaTbListConsultaTb);
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
    
}

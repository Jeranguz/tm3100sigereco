/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "receta_has_ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecetaHasIngredienteTb.findAll", query = "SELECT r FROM RecetaHasIngredienteTb r"),
    @NamedQuery(name = "RecetaHasIngredienteTb.findByRecetaId", query = "SELECT r FROM RecetaHasIngredienteTb r WHERE r.recetaHasIngredienteTbPK.recetaId = :recetaId"),
    @NamedQuery(name = "RecetaHasIngredienteTb.findByIngredienteId", query = "SELECT r FROM RecetaHasIngredienteTb r WHERE r.recetaHasIngredienteTbPK.ingredienteId = :ingredienteId"),
    @NamedQuery(name = "RecetaHasIngredienteTb.findByCantidad", query = "SELECT r FROM RecetaHasIngredienteTb r WHERE r.cantidad = :cantidad")})
public class RecetaHasIngredienteTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecetaHasIngredienteTbPK recetaHasIngredienteTbPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinTable(name = "receta_has_ingrediente_has_unidad_medida", joinColumns = {
        @JoinColumn(name = "receta_has_ingrediente_receta_id", referencedColumnName = "receta_id"),
        @JoinColumn(name = "receta_has_ingrediente_ingrediente_id", referencedColumnName = "ingrediente_id")}, inverseJoinColumns = {
        @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id")})
    @ManyToMany
    private List<UnidadMedidaTb> unidadMedidaTbList;
    @JoinColumn(name = "ingrediente_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IngredienteTb ingredienteTb;
    @JoinColumn(name = "receta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RecetaTb recetaTb;

    public RecetaHasIngredienteTb() {
    }

    public RecetaHasIngredienteTb(RecetaHasIngredienteTbPK recetaHasIngredienteTbPK) {
        this.recetaHasIngredienteTbPK = recetaHasIngredienteTbPK;
    }

    public RecetaHasIngredienteTb(RecetaHasIngredienteTbPK recetaHasIngredienteTbPK, String cantidad) {
        this.recetaHasIngredienteTbPK = recetaHasIngredienteTbPK;
        this.cantidad = cantidad;
    }

    public RecetaHasIngredienteTb(int recetaId, int ingredienteId) {
        this.recetaHasIngredienteTbPK = new RecetaHasIngredienteTbPK(recetaId, ingredienteId);
    }

    public RecetaHasIngredienteTbPK getRecetaHasIngredienteTbPK() {
        return recetaHasIngredienteTbPK;
    }

    public void setRecetaHasIngredienteTbPK(RecetaHasIngredienteTbPK recetaHasIngredienteTbPK) {
        this.recetaHasIngredienteTbPK = recetaHasIngredienteTbPK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public List<UnidadMedidaTb> getUnidadMedidaTbList() {
        return unidadMedidaTbList;
    }

    public void setUnidadMedidaTbList(List<UnidadMedidaTb> unidadMedidaTbList) {
        this.unidadMedidaTbList = unidadMedidaTbList;
    }

    public IngredienteTb getIngredienteTb() {
        return ingredienteTb;
    }

    public void setIngredienteTb(IngredienteTb ingredienteTb) {
        this.ingredienteTb = ingredienteTb;
    }

    public RecetaTb getRecetaTb() {
        return recetaTb;
    }

    public void setRecetaTb(RecetaTb recetaTb) {
        this.recetaTb = recetaTb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recetaHasIngredienteTbPK != null ? recetaHasIngredienteTbPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetaHasIngredienteTb)) {
            return false;
        }
        RecetaHasIngredienteTb other = (RecetaHasIngredienteTb) object;
        if ((this.recetaHasIngredienteTbPK == null && other.recetaHasIngredienteTbPK != null) || (this.recetaHasIngredienteTbPK != null && !this.recetaHasIngredienteTbPK.equals(other.recetaHasIngredienteTbPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTb[ recetaHasIngredienteTbPK=" + recetaHasIngredienteTbPK + " ]";
    }
    
}

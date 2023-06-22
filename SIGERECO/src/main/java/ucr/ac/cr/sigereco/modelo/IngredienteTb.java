/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "ingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngredienteTb.findAll", query = "SELECT i FROM IngredienteTb i"),
    @NamedQuery(name = "IngredienteTb.findById", query = "SELECT i FROM IngredienteTb i WHERE i.id = :id"),
    @NamedQuery(name = "IngredienteTb.findByDescripcion", query = "SELECT i FROM IngredienteTb i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "IngredienteTb.findByNombre", query = "SELECT i FROM IngredienteTb i WHERE i.nombre = :nombre")})
public class IngredienteTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredienteTb")
    private List<RecetaHasIngredienteTb> recetaHasIngredienteTbList;

    public IngredienteTb() {
    }

    public IngredienteTb(Integer id) {
        this.id = id;
    }

    public IngredienteTb(Integer id, String descripcion, String nombre) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<RecetaHasIngredienteTb> getRecetaHasIngredienteTbList() {
        return recetaHasIngredienteTbList;
    }

    public void setRecetaHasIngredienteTbList(List<RecetaHasIngredienteTb> recetaHasIngredienteTbList) {
        this.recetaHasIngredienteTbList = recetaHasIngredienteTbList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredienteTb)) {
            return false;
        }
        IngredienteTb other = (IngredienteTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.IngredienteTb[ id=" + id + " ]";
    }
    
}

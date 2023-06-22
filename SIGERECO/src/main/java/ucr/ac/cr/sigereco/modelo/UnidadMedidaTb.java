/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedidaTb.findAll", query = "SELECT u FROM UnidadMedidaTb u"),
    @NamedQuery(name = "UnidadMedidaTb.findById", query = "SELECT u FROM UnidadMedidaTb u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadMedidaTb.findByNombre", query = "SELECT u FROM UnidadMedidaTb u WHERE u.nombre = :nombre")})
public class UnidadMedidaTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "unidadMedidaTbList")
    private List<RecetaHasIngredienteTb> recetaHasIngredienteTbList;

    public UnidadMedidaTb() {
    }

    public UnidadMedidaTb(Integer id) {
        this.id = id;
    }

    public UnidadMedidaTb(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof UnidadMedidaTb)) {
            return false;
        }
        UnidadMedidaTb other = (UnidadMedidaTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.UnidadMedidaTb[ id=" + id + " ]";
    }
    
}

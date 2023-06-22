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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaTb.findAll", query = "SELECT c FROM CategoriaTb c"),
    @NamedQuery(name = "CategoriaTb.findById", query = "SELECT c FROM CategoriaTb c WHERE c.id = :id"),
    @NamedQuery(name = "CategoriaTb.findByNombre", query = "SELECT c FROM CategoriaTb c WHERE c.nombre = :nombre")})
public class CategoriaTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "receta_has_categoria", joinColumns = {
        @JoinColumn(name = "categoria_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "receta_id", referencedColumnName = "id")})
    @ManyToMany
    private List<RecetaTb> recetaTbList;

    public CategoriaTb() {
    }

    public CategoriaTb(Integer id) {
        this.id = id;
    }

    public CategoriaTb(Integer id, String nombre) {
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
    public List<RecetaTb> getRecetaTbList() {
        return recetaTbList;
    }

    public void setRecetaTbList(List<RecetaTb> recetaTbList) {
        this.recetaTbList = recetaTbList;
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
        if (!(object instanceof CategoriaTb)) {
            return false;
        }
        CategoriaTb other = (CategoriaTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.CategoriaTb[ id=" + id + " ]";
    }
    
}

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
@Table(name = "complejidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplejidadTb.findAll", query = "SELECT c FROM ComplejidadTb c"),
    @NamedQuery(name = "ComplejidadTb.findById", query = "SELECT c FROM ComplejidadTb c WHERE c.id = :id"),
    @NamedQuery(name = "ComplejidadTb.findByNombre", query = "SELECT c FROM ComplejidadTb c WHERE c.nombre = :nombre")})
public class ComplejidadTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "receta_has_complejidad", joinColumns = {
        @JoinColumn(name = "complejidad_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "receta_id", referencedColumnName = "id")})
    @ManyToMany
    private List<RecetaTb> recetaTbList;

    public ComplejidadTb() {
    }

    public ComplejidadTb(Integer id) {
        this.id = id;
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
        if (!(object instanceof ComplejidadTb)) {
            return false;
        }
        ComplejidadTb other = (ComplejidadTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.ComplejidadTb[ id=" + id + " ]";
    }
    
}

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
@Table(name = "privilegio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrivilegioTb.findAll", query = "SELECT p FROM PrivilegioTb p"),
    @NamedQuery(name = "PrivilegioTb.findById", query = "SELECT p FROM PrivilegioTb p WHERE p.id = :id"),
    @NamedQuery(name = "PrivilegioTb.findByNombre", query = "SELECT p FROM PrivilegioTb p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PrivilegioTb.findByDescripcion", query = "SELECT p FROM PrivilegioTb p WHERE p.descripcion = :descripcion")})
public class PrivilegioTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "privilegioTbList")
    private List<PerfilTb> perfilTbList;

    public PrivilegioTb() {
    }

    public PrivilegioTb(Integer id) {
        this.id = id;
    }

    public PrivilegioTb(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PerfilTb> getPerfilTbList() {
        return perfilTbList;
    }

    public void setPerfilTbList(List<PerfilTb> perfilTbList) {
        this.perfilTbList = perfilTbList;
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
        if (!(object instanceof PrivilegioTb)) {
            return false;
        }
        PrivilegioTb other = (PrivilegioTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.PrivilegioTb[ id=" + id + " ]";
    }
    
}

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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilTb.findAll", query = "SELECT p FROM PerfilTb p"),
    @NamedQuery(name = "PerfilTb.findById", query = "SELECT p FROM PerfilTb p WHERE p.id = :id"),
    @NamedQuery(name = "PerfilTb.findByDescripcion", query = "SELECT p FROM PerfilTb p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PerfilTb.findByTipoUsuario", query = "SELECT p FROM PerfilTb p WHERE p.tipoUsuario = :tipoUsuario")})
public class PerfilTb implements Serializable {

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
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @JoinTable(name = "perfil_has_privilegio", joinColumns = {
        @JoinColumn(name = "perfil_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "privilegio_id", referencedColumnName = "id")})
    @ManyToMany
    private List<PrivilegioTb> privilegioTbList;

    public PerfilTb() {
    }

    public PerfilTb(Integer id) {
        this.id = id;
    }

    public PerfilTb(Integer id, String descripcion, String tipoUsuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoUsuario = tipoUsuario;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @XmlTransient
    public List<PrivilegioTb> getPrivilegioTbList() {
        return privilegioTbList;
    }

    public void setPrivilegioTbList(List<PrivilegioTb> privilegioTbList) {
        this.privilegioTbList = privilegioTbList;
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
        if (!(object instanceof PerfilTb)) {
            return false;
        }
        PerfilTb other = (PerfilTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.PerfilTb[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaTb.findAll", query = "SELECT c FROM ConsultaTb c"),
    @NamedQuery(name = "ConsultaTb.findById", query = "SELECT c FROM ConsultaTb c WHERE c.id = :id"),
    @NamedQuery(name = "ConsultaTb.findByFechaHora", query = "SELECT c FROM ConsultaTb c WHERE c.fechaHora = :fechaHora")})
public class ConsultaTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinTable(name = "consulta_has_usuario", joinColumns = {
        @JoinColumn(name = "consulta_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")})
    @ManyToMany
    private List<UsuarioTb> usuarioTbList;
    @JoinTable(name = "consulta_has_receta", joinColumns = {
        @JoinColumn(name = "consulta_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "receta_id", referencedColumnName = "id")})
    @ManyToMany
    private List<RecetaTb> recetaTbList;

    public ConsultaTb() {
    }

    public ConsultaTb(Integer id) {
        this.id = id;
    }

    public ConsultaTb(Integer id, Date fechaHora) {
        this.id = id;
        this.fechaHora = fechaHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @XmlTransient
    public List<UsuarioTb> getUsuarioTbList() {
        return usuarioTbList;
    }

    public void setUsuarioTbList(List<UsuarioTb> usuarioTbList) {
        this.usuarioTbList = usuarioTbList;
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
        if (!(object instanceof ConsultaTb)) {
            return false;
        }
        ConsultaTb other = (ConsultaTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.ConsultaTb[ id=" + id + " ]";
    }
    
}

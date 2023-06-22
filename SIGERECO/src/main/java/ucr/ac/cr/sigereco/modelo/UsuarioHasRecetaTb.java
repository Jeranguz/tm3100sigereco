/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "usuario_has_receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasRecetaTb.findAll", query = "SELECT u FROM UsuarioHasRecetaTb u"),
    @NamedQuery(name = "UsuarioHasRecetaTb.findByUsuarioId", query = "SELECT u FROM UsuarioHasRecetaTb u WHERE u.usuarioHasRecetaTbPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "UsuarioHasRecetaTb.findByRecetaId", query = "SELECT u FROM UsuarioHasRecetaTb u WHERE u.usuarioHasRecetaTbPK.recetaId = :recetaId"),
    @NamedQuery(name = "UsuarioHasRecetaTb.findByFecha", query = "SELECT u FROM UsuarioHasRecetaTb u WHERE u.fecha = :fecha"),
    @NamedQuery(name = "UsuarioHasRecetaTb.findByNumVotos", query = "SELECT u FROM UsuarioHasRecetaTb u WHERE u.numVotos = :numVotos")})
public class UsuarioHasRecetaTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasRecetaTbPK usuarioHasRecetaTbPK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "num_votos")
    private int numVotos;
    @JoinColumn(name = "receta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RecetaTb recetaTb;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UsuarioTb usuarioTb;

    public UsuarioHasRecetaTb() {
    }

    public UsuarioHasRecetaTb(UsuarioHasRecetaTbPK usuarioHasRecetaTbPK) {
        this.usuarioHasRecetaTbPK = usuarioHasRecetaTbPK;
    }

    public UsuarioHasRecetaTb(UsuarioHasRecetaTbPK usuarioHasRecetaTbPK, Date fecha, int numVotos) {
        this.usuarioHasRecetaTbPK = usuarioHasRecetaTbPK;
        this.fecha = fecha;
        this.numVotos = numVotos;
    }

    public UsuarioHasRecetaTb(int usuarioId, int recetaId) {
        this.usuarioHasRecetaTbPK = new UsuarioHasRecetaTbPK(usuarioId, recetaId);
    }

    public UsuarioHasRecetaTbPK getUsuarioHasRecetaTbPK() {
        return usuarioHasRecetaTbPK;
    }

    public void setUsuarioHasRecetaTbPK(UsuarioHasRecetaTbPK usuarioHasRecetaTbPK) {
        this.usuarioHasRecetaTbPK = usuarioHasRecetaTbPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public RecetaTb getRecetaTb() {
        return recetaTb;
    }

    public void setRecetaTb(RecetaTb recetaTb) {
        this.recetaTb = recetaTb;
    }

    public UsuarioTb getUsuarioTb() {
        return usuarioTb;
    }

    public void setUsuarioTb(UsuarioTb usuarioTb) {
        this.usuarioTb = usuarioTb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasRecetaTbPK != null ? usuarioHasRecetaTbPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasRecetaTb)) {
            return false;
        }
        UsuarioHasRecetaTb other = (UsuarioHasRecetaTb) object;
        if ((this.usuarioHasRecetaTbPK == null && other.usuarioHasRecetaTbPK != null) || (this.usuarioHasRecetaTbPK != null && !this.usuarioHasRecetaTbPK.equals(other.usuarioHasRecetaTbPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTb[ usuarioHasRecetaTbPK=" + usuarioHasRecetaTbPK + " ]";
    }
    
}

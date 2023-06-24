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
@Table(name = "usuario_has_receta1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasReceta1Tb.findAll", query = "SELECT u FROM UsuarioHasReceta1Tb u"),
    @NamedQuery(name = "UsuarioHasReceta1Tb.findByUsuarioId", query = "SELECT u FROM UsuarioHasReceta1Tb u WHERE u.usuarioHasReceta1TbPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "UsuarioHasReceta1Tb.findByRecetaId", query = "SELECT u FROM UsuarioHasReceta1Tb u WHERE u.usuarioHasReceta1TbPK.recetaId = :recetaId"),
    @NamedQuery(name = "UsuarioHasReceta1Tb.findByFechaFinal", query = "SELECT u FROM UsuarioHasReceta1Tb u WHERE u.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "UsuarioHasReceta1Tb.findByFechaInicio", query = "SELECT u FROM UsuarioHasReceta1Tb u WHERE u.fechaInicio = :fechaInicio")})
public class UsuarioHasReceta1Tb implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasReceta1TbPK usuarioHasReceta1TbPK;
    @Basic(optional = false)
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @JoinColumn(name = "receta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RecetaTb recetaTb;

    public UsuarioHasReceta1Tb() {
    }

    public UsuarioHasReceta1Tb(UsuarioHasReceta1TbPK usuarioHasReceta1TbPK) {
        this.usuarioHasReceta1TbPK = usuarioHasReceta1TbPK;
    }

    public UsuarioHasReceta1Tb(UsuarioHasReceta1TbPK usuarioHasReceta1TbPK, Date fechaFinal, Date fechaInicio) {
        this.usuarioHasReceta1TbPK = usuarioHasReceta1TbPK;
        this.fechaFinal = fechaFinal;
        this.fechaInicio = fechaInicio;
    }

    public UsuarioHasReceta1Tb(int usuarioId, int recetaId) {
        this.usuarioHasReceta1TbPK = new UsuarioHasReceta1TbPK(usuarioId, recetaId);
    }

    public UsuarioHasReceta1TbPK getUsuarioHasReceta1TbPK() {
        return usuarioHasReceta1TbPK;
    }

    public void setUsuarioHasReceta1TbPK(UsuarioHasReceta1TbPK usuarioHasReceta1TbPK) {
        this.usuarioHasReceta1TbPK = usuarioHasReceta1TbPK;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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
        hash += (usuarioHasReceta1TbPK != null ? usuarioHasReceta1TbPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasReceta1Tb)) {
            return false;
        }
        UsuarioHasReceta1Tb other = (UsuarioHasReceta1Tb) object;
        if ((this.usuarioHasReceta1TbPK == null && other.usuarioHasReceta1TbPK != null) || (this.usuarioHasReceta1TbPK != null && !this.usuarioHasReceta1TbPK.equals(other.usuarioHasReceta1TbPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1Tb[ usuarioHasReceta1TbPK=" + usuarioHasReceta1TbPK + " ]";
    }
    
}

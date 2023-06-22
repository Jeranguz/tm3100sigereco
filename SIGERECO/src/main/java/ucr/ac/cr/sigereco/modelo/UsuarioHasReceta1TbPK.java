/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Drexler Guzman
 */
@Embeddable
public class UsuarioHasReceta1TbPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic(optional = false)
    @Column(name = "receta_id")
    private int recetaId;

    public UsuarioHasReceta1TbPK() {
    }

    public UsuarioHasReceta1TbPK(int usuarioId, int recetaId) {
        this.usuarioId = usuarioId;
        this.recetaId = recetaId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) recetaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasReceta1TbPK)) {
            return false;
        }
        UsuarioHasReceta1TbPK other = (UsuarioHasReceta1TbPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.recetaId != other.recetaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1TbPK[ usuarioId=" + usuarioId + ", recetaId=" + recetaId + " ]";
    }
    
}

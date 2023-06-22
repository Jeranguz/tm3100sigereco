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
public class RecetaHasIngredienteTbPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "receta_id")
    private int recetaId;
    @Basic(optional = false)
    @Column(name = "ingrediente_id")
    private int ingredienteId;

    public RecetaHasIngredienteTbPK() {
    }

    public RecetaHasIngredienteTbPK(int recetaId, int ingredienteId) {
        this.recetaId = recetaId;
        this.ingredienteId = ingredienteId;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    public int getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(int ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recetaId;
        hash += (int) ingredienteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetaHasIngredienteTbPK)) {
            return false;
        }
        RecetaHasIngredienteTbPK other = (RecetaHasIngredienteTbPK) object;
        if (this.recetaId != other.recetaId) {
            return false;
        }
        if (this.ingredienteId != other.ingredienteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.RecetaHasIngredienteTbPK[ recetaId=" + recetaId + ", ingredienteId=" + ingredienteId + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecetaTb.findAll", query = "SELECT r FROM RecetaTb r"),
    @NamedQuery(name = "RecetaTb.findById", query = "SELECT r FROM RecetaTb r WHERE r.id = :id"),
    @NamedQuery(name = "RecetaTb.findByNombre", query = "SELECT r FROM RecetaTb r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RecetaTb.findByDescripcion", query = "SELECT r FROM RecetaTb r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RecetaTb.findByImagen", query = "SELECT r FROM RecetaTb r WHERE r.imagen = :imagen"),
    @NamedQuery(name = "RecetaTb.findByInstrucciones", query = "SELECT r FROM RecetaTb r WHERE r.instrucciones = :instrucciones"),
    @NamedQuery(name = "RecetaTb.findByMinutosPreparacion", query = "SELECT r FROM RecetaTb r WHERE r.minutosPreparacion = :minutosPreparacion"),
    @NamedQuery(name = "RecetaTb.findByMinutosCoccion", query = "SELECT r FROM RecetaTb r WHERE r.minutosCoccion = :minutosCoccion"),
    @NamedQuery(name = "RecetaTb.findByPorciones", query = "SELECT r FROM RecetaTb r WHERE r.porciones = :porciones")})
public class RecetaTb implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @Column(name = "instrucciones")
    private String instrucciones;
    @Basic(optional = false)
    @Column(name = "minutos_preparacion")
    private int minutosPreparacion;
    @Basic(optional = false)
    @Column(name = "minutos_coccion")
    private int minutosCoccion;
    @Basic(optional = false)
    @Column(name = "porciones")
    private int porciones;
    @ManyToMany(mappedBy = "recetaTbList")
    private List<OcasionTb> ocasionTbList;
    @ManyToMany(mappedBy = "recetaTbList")
    private List<ComplejidadTb> complejidadTbList;
    @ManyToMany(mappedBy = "recetaTbList")
    private List<CategoriaTb> categoriaTbList;
    @ManyToMany(mappedBy = "recetaTbList")
    private List<ConsultaTb> consultaTbList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recetaTb")
    private List<UsuarioHasRecetaTb> usuarioHasRecetaTbList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recetaTb")
    private List<UsuarioHasReceta1Tb> usuarioHasReceta1TbList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recetaTb")
    private List<RecetaHasIngredienteTb> recetaHasIngredienteTbList;

    public RecetaTb() {
    }

    public RecetaTb(Integer id) {
        this.id = id;
    }

    public RecetaTb(Integer id, String nombre, String descripcion, String imagen, String instrucciones, int minutosPreparacion, int minutosCoccion, int porciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.instrucciones = instrucciones;
        this.minutosPreparacion = minutosPreparacion;
        this.minutosCoccion = minutosCoccion;
        this.porciones = porciones;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getMinutosPreparacion() {
        return minutosPreparacion;
    }

    public void setMinutosPreparacion(int minutosPreparacion) {
        this.minutosPreparacion = minutosPreparacion;
    }

    public int getMinutosCoccion() {
        return minutosCoccion;
    }

    public void setMinutosCoccion(int minutosCoccion) {
        this.minutosCoccion = minutosCoccion;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    @XmlTransient
    public List<OcasionTb> getOcasionTbList() {
        return ocasionTbList;
    }

    public void setOcasionTbList(List<OcasionTb> ocasionTbList) {
        this.ocasionTbList = ocasionTbList;
    }

    @XmlTransient
    public List<ComplejidadTb> getComplejidadTbList() {
        return complejidadTbList;
    }

    public void setComplejidadTbList(List<ComplejidadTb> complejidadTbList) {
        this.complejidadTbList = complejidadTbList;
    }

    @XmlTransient
    public List<CategoriaTb> getCategoriaTbList() {
        return categoriaTbList;
    }

    public void setCategoriaTbList(List<CategoriaTb> categoriaTbList) {
        this.categoriaTbList = categoriaTbList;
    }

    @XmlTransient
    public List<ConsultaTb> getConsultaTbList() {
        return consultaTbList;
    }

    public void setConsultaTbList(List<ConsultaTb> consultaTbList) {
        this.consultaTbList = consultaTbList;
    }

    @XmlTransient
    public List<UsuarioHasRecetaTb> getUsuarioHasRecetaTbList() {
        return usuarioHasRecetaTbList;
    }

    public void setUsuarioHasRecetaTbList(List<UsuarioHasRecetaTb> usuarioHasRecetaTbList) {
        this.usuarioHasRecetaTbList = usuarioHasRecetaTbList;
    }

    @XmlTransient
    public List<UsuarioHasReceta1Tb> getUsuarioHasReceta1TbList() {
        return usuarioHasReceta1TbList;
    }

    public void setUsuarioHasReceta1TbList(List<UsuarioHasReceta1Tb> usuarioHasReceta1TbList) {
        this.usuarioHasReceta1TbList = usuarioHasReceta1TbList;
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
        if (!(object instanceof RecetaTb)) {
            return false;
        }
        RecetaTb other = (RecetaTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.RecetaTb[ id=" + id + " ]";
    }
    
}

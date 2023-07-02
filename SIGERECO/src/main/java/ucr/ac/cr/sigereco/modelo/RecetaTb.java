/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
    @NamedQuery(name = "RecetaTb.findByPorciones", query = "SELECT r FROM RecetaTb r WHERE r.porciones = :porciones"),
    @NamedQuery(name = "RecetaTb.findByIngredientes", query = "SELECT r FROM RecetaTb r WHERE r.ingredientes = :ingredientes"),
    @NamedQuery(name = "RecetaTb.findByDificultad", query = "SELECT r FROM RecetaTb r WHERE r.dificultad = :dificultad"),
    @NamedQuery(name = "RecetaTb.findByOcasion", query = "SELECT r FROM RecetaTb r WHERE r.ocasion = :ocasion"),
    @NamedQuery(name = "RecetaTb.findByCategoria", query = "SELECT r FROM RecetaTb r WHERE r.categoria = :categoria")})
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
    @Basic(optional = false)
    @Column(name = "ingredientes")
    private String ingredientes;
    @Basic(optional = false)
    @Column(name = "dificultad")
    private String dificultad;
    @Basic(optional = false)
    @Column(name = "ocasion")
    private String ocasion;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;

    public RecetaTb() {
    }

    public RecetaTb(Integer id) {
        this.id = id;
    }

    public RecetaTb(String nombre, String descripcion, String imagen, String instrucciones, int minutosPreparacion, int minutosCoccion, int porciones, String ingredientes, String dificultad, String ocasion, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.instrucciones = instrucciones;
        this.minutosPreparacion = minutosPreparacion;
        this.minutosCoccion = minutosCoccion;
        this.porciones = porciones;
        this.ingredientes = ingredientes;
        this.dificultad = dificultad;
        this.ocasion = ocasion;
        this.categoria = categoria;
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

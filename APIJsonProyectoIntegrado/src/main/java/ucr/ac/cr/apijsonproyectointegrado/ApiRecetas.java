/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.apijsonproyectointegrado;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "api_recetas")
@NamedQueries({
    @NamedQuery(name = "ApiRecetas.findAll", query = "SELECT a FROM ApiRecetas a"),
    @NamedQuery(name = "ApiRecetas.findById", query = "SELECT a FROM ApiRecetas a WHERE a.id = :id"),
    @NamedQuery(name = "ApiRecetas.findByNombre", query = "SELECT a FROM ApiRecetas a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "ApiRecetas.findByDescripcion", query = "SELECT a FROM ApiRecetas a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "ApiRecetas.findByImagen", query = "SELECT a FROM ApiRecetas a WHERE a.imagen = :imagen"),
    @NamedQuery(name = "ApiRecetas.findByInstrucciones", query = "SELECT a FROM ApiRecetas a WHERE a.instrucciones = :instrucciones"),
    @NamedQuery(name = "ApiRecetas.findByMinutosPreparacion", query = "SELECT a FROM ApiRecetas a WHERE a.minutosPreparacion = :minutosPreparacion"),
    @NamedQuery(name = "ApiRecetas.findByMinutosCoccion", query = "SELECT a FROM ApiRecetas a WHERE a.minutosCoccion = :minutosCoccion"),
    @NamedQuery(name = "ApiRecetas.findByPorciones", query = "SELECT a FROM ApiRecetas a WHERE a.porciones = :porciones"),
    @NamedQuery(name = "ApiRecetas.findByIngredientes", query = "SELECT a FROM ApiRecetas a WHERE a.ingredientes = :ingredientes"),
    @NamedQuery(name = "ApiRecetas.findByDificultad", query = "SELECT a FROM ApiRecetas a WHERE a.dificultad = :dificultad"),
    @NamedQuery(name = "ApiRecetas.findByOcasion", query = "SELECT a FROM ApiRecetas a WHERE a.ocasion = :ocasion"),
    @NamedQuery(name = "ApiRecetas.findByCategoria", query = "SELECT a FROM ApiRecetas a WHERE a.categoria = :categoria")})
public class ApiRecetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    private int id;
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

    public ApiRecetas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
}

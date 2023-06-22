/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

/**
 *
 * @author XPC
 */
public class Receta {
    
    private int id;
    private int porciones;
    private String descripcion;
    private String nombre;
    private String imagen;
    private int tiempoPreparacion;
    private int tiempoCoccion;
    private String instrucciones;
    private Categoria categoria;
    private Dificultad dificultad;
    private Ingrediente ingrediente;
    private Ocasion ocasion;
    private int meGusta;

    public Receta(int id, int porciones, String descripcion, String nombre, String imagen, int tiempoPreparacion,
            int tiempoCoccion, String instrucciones, Categoria categoria, Dificultad dificultad,
            Ingrediente ingrediente, Ocasion ocasion, int meGusta) {
        this.id = id;
        this.porciones = porciones;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tiempoCoccion = tiempoCoccion;
        this.instrucciones = instrucciones;
        this.categoria = categoria;
        this.dificultad = dificultad;
        this.ingrediente = ingrediente;
        this.ocasion = ocasion;
        this.meGusta = 0;
    }



    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Ocasion getOcasion() {
        return ocasion;
    }

    public void setOcasion(Ocasion ocasion) {
        this.ocasion = ocasion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }
    
    
    
    
    
}

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
    
    private Categoria categoria;
    private Dificultad dificultad;
    private Ingrediente ingrediente;
    private Ocasion ocasion;
    private int meGusta;

    public Receta(Categoria categoria, Dificultad dificultad, Ingrediente ingrediente, Ocasion ocasion) {
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
    
    
    
}

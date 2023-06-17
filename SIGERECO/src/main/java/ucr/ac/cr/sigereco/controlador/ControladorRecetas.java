/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ucr.ac.cr.sigereco.modelo.Categoria;
import ucr.ac.cr.sigereco.modelo.Dificultad;
import ucr.ac.cr.sigereco.modelo.Ingrediente;
import ucr.ac.cr.sigereco.modelo.Ocasion;
import ucr.ac.cr.sigereco.modelo.Receta;
import ucr.ac.cr.sigereco.modelo.UnidadMedida;


public class ControladorRecetas implements ActionListener {
    
    private Receta receta;
    private Ingrediente ingrediente;
    private Dificultad dificultad;
    private UnidadMedida unidadMedida;
    private Categoria categoria;
    private Ocasion ocasion;
    private ArrayList <Receta> listaRecetas;
    private ArrayList <Ingrediente> listaIngredientes;
    private ArrayList <Dificultad> listaDificultad;
    private ArrayList <Ocasion> listaOcasion;
    private ArrayList <UnidadMedida> listaUnidad;

    public ControladorRecetas() {
        listaRecetas = new ArrayList();
        listaIngredientes = new ArrayList();
        listaDificultad = new ArrayList();
        listaOcasion = new ArrayList();
        listaUnidad = new ArrayList();
    }
    
    //Metodos para gestionar las recetas
    public String agregarReceta(Receta receta) {

        if (listaRecetas.add(receta)) {
            return "La receta fue ingresada con exito";
        }
        return "Hubo un error al ingresar la receta";
    }
    
    public Receta buscarReceta(String nombre) {

        for (int indice = 0; indice < listaRecetas.size(); indice++) {

            if (listaRecetas.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaRecetas.get(indice);
            }
        }
        return null;

    }
    
    public String eliminarReceta(Receta receta) {
        if (listaRecetas.remove(receta)) {

            return "La receta fue eliminada con exito";

        }
        return "Hubo un problema a la hora de eliminar la receta";

    }
    
    public String modificarReceta(Receta receta) {

        if (listaRecetas != null) {

            listaRecetas.equals(receta);
            return "Valores Modificados";

        } else if (listaRecetas == null) {
            return "no hay valores";
        }
        return "no hay valores";
    }
    
    //Metodos para gestionar los ingredientes
    
    public String agregarIngrediente(Ingrediente ingrediente) {

        if (listaIngredientes.add(ingrediente)) {
            return "El ingrediente fue ingresado con exito";
        }
        return "Hubo un error al ingresar el ingrediente";
    }
    
    public Ingrediente buscarIngrediente(String nombre) {

        for (int indice = 0; indice < listaIngredientes.size(); indice++) {

            if (listaIngredientes.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaIngredientes.get(indice);
            }
        }
        return null;

    }
    
    public String eliminarIngrediente(Ingrediente ingrediente) {
        if (listaIngredientes.remove(ingrediente)) {

            return "El ingrediente fue eliminado con exito";

        }
        return "Hubo un problema a la hora de eliminar el ingrediente";

    }
    
    public String modificarIngrediente(Ingrediente ingrediente) {

        if (listaIngredientes != null) {

            listaIngredientes.equals(ingrediente);
            return "Valores Modificados";

        } else if (listaIngredientes == null) {
            return "no hay valores";
        }
        return "no hay valores";
    }
    
    //Metodos para gestionar las dificultades
    public String agregarDificultad(Dificultad dificultad) {

        if (listaDificultad.add(dificultad)) {
            return "La dificultad fue ingresada con exito";
        }
        return "Hubo un error al ingresar la dificultad";
    }
    
    public Dificultad buscarDificultad(String nombre) {

        for (int indice = 0; indice < listaDificultad.size(); indice++) {

            if (listaDificultad.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaDificultad.get(indice);
            }
        }
        return null;

    }
    
    public String eliminarDificultad(Dificultad dificultad) {
        if (listaDificultad.remove(dificultad)) {

            return "La dificultad fue eliminada con exito";

        }
        return "Hubo un problema a la hora de eliminar la dificultad";

    }
    
    public String modificarDificultad(Dificultad dificultad) {

        if (listaDificultad != null) {

            listaDificultad.equals(receta);
            return "Valores Modificados";

        } else if (listaDificultad == null) {
            return "no hay valores";
        }
        return "no hay valores";
    }
    
    //Metodos para gestionar las ocasiones
    public String agregarOcasion(Ocasion ocasion) {

        if (listaOcasion.add(ocasion)) {
            return "La ocasion fue ingresada con exito";
        }
        return "Hubo un error al ingresar la ocasion";
    }
    
    public Ocasion buscarOcasion(String nombre) {

        for (int indice = 0; indice < listaOcasion.size(); indice++) {

            if (listaOcasion.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaOcasion.get(indice);
            }
        }
        return null;

    }
    
    public String eliminarOcasion(Ocasion ocasion) {
        if (listaOcasion.remove(ocasion)) {

            return "La ocasion fue eliminada con exito";

        }
        return "Hubo un problema a la hora de eliminar la ocasion";

    }
    
    public String modificarOcasion(Ocasion ocasion) {

        if (listaOcasion != null) {

            listaOcasion.equals(ocasion);
            return "Valores Modificados";

        } else if (listaOcasion == null) {
            return "no hay valores";
        }
        return "no hay valores";
    }
    
    //Metodos para gestionar las unidades de medida
    public String agregarUnidadMedida(UnidadMedida unidadMedida) {

        if (listaUnidad.add(unidadMedida)) {
            return "La unidad de medida fue ingresada con exito";
        }
        return "Hubo un error al ingresar la unidad de medida";
    }
    
    public UnidadMedida buscarUnidadMedida(String nombre) {

        for (int indice = 0; indice < listaUnidad.size(); indice++) {

            if (listaUnidad.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaUnidad.get(indice);
            }
        }
        return null;

    }
    
    public String eliminarUnidadMedida(UnidadMedida unidadMedida) {
        if (listaUnidad.remove(unidadMedida)) {

            return "La unidad de medida fue eliminada con exito";

        }
        return "Hubo un problema a la hora de eliminar la unidad de medida";

    }
    
    public String modificarUnidadMedida(UnidadMedida unidadMedida) {

        if (listaUnidad != null) {

            listaUnidad.equals(unidadMedida);
            return "Valores Modificados";

        } else if (listaUnidad == null) {
            return "no hay valores";
        }
        return "no hay valores";
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}

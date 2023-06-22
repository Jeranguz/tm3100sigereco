/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    private ArrayList <Categoria> listaCategorias;
    private JSONObject objetoBase;
    private File archivo;

    public ControladorRecetas() {
        listaRecetas = new ArrayList();
        listaIngredientes = new ArrayList();
        listaDificultad = new ArrayList();
        listaOcasion = new ArrayList();
        listaUnidad = new ArrayList();
        listaCategorias = new ArrayList();
        archivo = new File ("Recetas.json");
        leerJson();
    }
    
    public void escribirJson (){
        JSONArray listaRecetasJson = new JSONArray();
        objetoBase = new JSONObject();
        for (int i = 0; i < listaRecetas.size(); i++) {
            JSONObject objJSONReceta = new JSONObject();
            objJSONReceta.put("id",listaRecetas.get(i).getId());
            objJSONReceta.put("porciones",listaRecetas.get(i).getPorciones());
            objJSONReceta.put("descripcion",listaRecetas.get(i).getDescripcion());
            objJSONReceta.put("nombre",listaRecetas.get(i).getNombre());
            objJSONReceta.put("imagen",listaRecetas.get(i).getImagen());
            objJSONReceta.put("tiempo de preparacion",listaRecetas.get(i).getTiempoPreparacion());
            objJSONReceta.put("tiempo de coccion",listaRecetas.get(i).getTiempoCoccion());
            objJSONReceta.put("instrucciones",listaRecetas.get(i).getInstrucciones());
            objJSONReceta.put("categoria",listaRecetas.get(i).getCategoria());
            objJSONReceta.put("dificultad",listaRecetas.get(i).getDificultad());
            objJSONReceta.put("ingredientes",listaRecetas.get(i).getIngrediente());
            objJSONReceta.put("ocasion",listaRecetas.get(i).getOcasion());
            objJSONReceta.put("imagen",listaRecetas.get(i).getImagen());
            objJSONReceta.put("me gustas",listaRecetas.get(i).getMeGusta());
            listaRecetasJson.add(objJSONReceta);
        }
        objetoBase.put("Recetas",listaRecetasJson);
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(objetoBase.toJSONString());
            escribir.flush();
            escribir.close();
        } catch (IOException ex) {
            System.err.println("Error al escribir el archivo");
        }
    }
    
    public void leerJson(){
        JSONParser parser = new JSONParser();
        try {
            FileReader leer = new FileReader(archivo);
            Object obj = parser.parse(leer);
            objetoBase = (JSONObject) obj;
            JSONArray arregloJSON = (JSONArray) objetoBase.get("Recetas");
            for (Object object : arregloJSON) {
                JSONObject objReceta = (JSONObject) object;
                receta = new Receta (Integer.parseInt(objReceta.get("id").toString()),
                        Integer.parseInt(objReceta.get("porciones").toString()),
                        objReceta.get("descripcion").toString(),
                        objReceta.get("nombre").toString(),
                        objReceta.get("imagen").toString(),
                        Integer.parseInt(objReceta.get("tiempo de preparacion").toString()),
                        Integer.parseInt(objReceta.get("tiempo de coccion").toString()),
                        objReceta.get("instrucciones").toString(),
                        (Categoria) objReceta.get("categoria"),
                        (Dificultad) objReceta.get("dificultad"),
                        (Ingrediente) objReceta.get("ingrediente"),
                        (Ocasion) objReceta.get("ocasion"),
                        Integer.parseInt(objReceta.get("me gustas").toString()));
                listaRecetas.add(receta);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorRecetas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorRecetas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodos para gestionar las recetas
    public String agregarReceta(Receta receta) {

        if (listaRecetas.add(receta)) {
            escribirJson ();
            return "La receta fue ingresada con exito"; 
        }
        return "Hubo un error al ingresar la receta";
    }
    
    public Receta buscarReceta(String nombre) {

        escribirJson ();
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
    
    //metodos para gestionar las categorias
    
    public String agregarCategoria(Categoria categoria) {

        if (listaCategorias.add(categoria)) {
            return "La categoria fue ingresada con exito";
        }
        return "Hubo un error al ingresar la categoria";
    }
    
    public Categoria buscarCategoria(String nombre) {

        for (int indice = 0; indice < listaCategorias.size(); indice++) {

            if (listaCategorias.get(indice).getNombre().equalsIgnoreCase(nombre)) {
                return listaCategorias.get(indice);
            }
        }
        return null;

    }
    
    public String eliminarCategoria(Categoria categoria) {
        if (listaCategorias.remove(categoria)) {

            return "La categoria fue eliminada con exito";

        }
        return "Hubo un problema a la hora de eliminar la categoria";

    }
    
    public String modificarCategoria(Categoria categoria) {

        if (listaCategorias != null) {

            listaCategorias.equals(categoria);
            return "Valores Modificados";

        } else if (listaCategorias == null) {
            return "no hay valores";
        }
        return "no hay valores";
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}

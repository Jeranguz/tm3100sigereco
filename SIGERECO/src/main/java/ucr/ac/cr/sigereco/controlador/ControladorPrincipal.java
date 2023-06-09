/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.bytecode.Opcode;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ucr.ac.cr.sigereco.controlador.exceptions.IllegalOrphanException;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.Consultas;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.Usuario;
import ucr.ac.cr.sigereco.vista.FrameAdmin;
import ucr.ac.cr.sigereco.vista.FrameInicioSesion;
import ucr.ac.cr.sigereco.vista.FramePrincipal;
import ucr.ac.cr.sigereco.vista.FrameRecetario;
import ucr.ac.cr.sigereco.vista.FrameRegistro;
import ucr.ac.cr.sigereco.vista.FrameReporte;
import ucr.ac.cr.sigereco.vista.FrameUsuario;
import ucr.ac.cr.sigereco.vista.PanelAdmin;
import ucr.ac.cr.sigereco.vista.PanelConsulta;
import ucr.ac.cr.sigereco.vista.PanelRecetario;
import ucr.ac.cr.sigereco.vista.PanelTop10;

/**
 *
 * @author Drexler Guzman
 */
public class ControladorPrincipal implements ActionListener {

    private ArrayList<Consultas> registroConsulta;
    private RecetaTbJpaController recetaTbControlador;
    private RecetaTb recetaTb;
    private FrameUsuario frameUsuario;
    private FramePrincipal framePrincipal;
    private PanelConsulta panelConsulta;
    private PanelTop10 panelTop10;
    private FrameRecetario frameRecetario;
    private ControladorRecetas controladorRecetas;
    private FrameAdmin frameAdmin;
    private ControladorUsuarios controladorUsuarios;
    private FrameInicioSesion frameInicioSesion;
    private FrameRegistro frameRegistro;
    private String usuarioActual = "";
    private PanelRecetario panelRecetario;
    private int posicion = 0;
    private int desicion = 0;
    private JSONObject objetoBase;
    private PanelAdmin panelAdmin;
    private File archivo;
    private FrameReporte frameReporte;

    public ControladorPrincipal() {

        //crear las instancias de los atributos
        recetaTbControlador = new RecetaTbJpaController(Persistence.createEntityManagerFactory("SIGERECOPersistence"));
        framePrincipal = new FramePrincipal();
        frameInicioSesion = new FrameInicioSesion();
        frameAdmin = new FrameAdmin();
        frameRecetario = new FrameRecetario();
        controladorUsuarios = new ControladorUsuarios();
        frameUsuario = new FrameUsuario();
        panelConsulta = new PanelConsulta();
        framePrincipal.escucharPanelConsulta(this);
        panelTop10 = new PanelTop10();
        panelAdmin = frameAdmin.getPanelAdmin();
        panelRecetario = frameRecetario.getPanelRecetario();
        archivo = new File("Recetas.json");
        frameReporte = new FrameReporte();
        frameReporte.escuchar(this);

        //frameAdmin.escuchar(this);
        frameRecetario.escuchar(this);
        frameUsuario.escuchar(this);
        frameUsuario.escucharConsulta(this);
        panelConsulta.escuchar(this);

        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.escuchar(this);
        frameInicioSesion.escuchar(this);
        frameAdmin.escuchar(this);
    }

    public String[][] getDatosTabla() {
        List lista = recetaTbControlador.findRecetaTbEntities();
        String[][] matrizDatos = new String[lista.size()][RecetaTb.ETIQUETAS_RECETAS.length];
        for (int fila = 0; fila < lista.size(); fila++) {
            for (int columna = 0; columna < matrizDatos[0].length; columna++) {
                RecetaTb obj = (RecetaTb) lista.get(fila);
                matrizDatos[fila][columna] = obj.setDatos(columna);
            }
        }
        return matrizDatos;
    }

    public void escribirJson() {
        List lista = recetaTbControlador.findRecetaTbEntities();
        JSONArray listaRecetasJson = new JSONArray();
        objetoBase = new JSONObject();
        for (int i = 0; i < lista.size(); i++) {
            RecetaTb obj = (RecetaTb) lista.get(i);
            JSONObject objJSONReceta = new JSONObject();
            objJSONReceta.put("nombre", obj.getNombre());
            objJSONReceta.put("descripcion", obj.getDescripcion());
            objJSONReceta.put("instrucciones", obj.getIngredientes());
            objJSONReceta.put("minutos de preparacion", obj.getMinutosPreparacion());
            objJSONReceta.put("minutos de coccion", obj.getMinutosCoccion());
            objJSONReceta.put("porciones", obj.getPorciones());
            objJSONReceta.put("ingredientes", obj.getIngredientes());
            objJSONReceta.put("dificultad", obj.getDificultad());
            objJSONReceta.put("ocasion", obj.getOcasion());
            objJSONReceta.put("categoria", obj.getCategoria());

            listaRecetasJson.add(objJSONReceta);
        }
        objetoBase.put("Recetas", listaRecetasJson);
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(objetoBase.toJSONString());
            escribir.flush();
            escribir.close();
        } catch (IOException ex) {
            System.err.println("Error al escribir el archivo");
        }
    }

    public void AsignarRecetario(int posicion) {
        List listaReceta = recetaTbControlador.findRecetaTbEntities();
        RecetaTb lista = (RecetaTb) listaReceta.get(posicion);
        panelRecetario.setjLabelNombre(lista.getNombre());
        panelRecetario.setjLabelPorciones(lista.getPorciones() + "");
        panelRecetario.setjLabelTiempoPrepa(lista.getMinutosPreparacion() + "");
        panelRecetario.setjLabelCoccion(lista.getMinutosCoccion() + "");
        panelRecetario.setjLabelTotal(lista.getMinutosPreparacion() + lista.getMinutosCoccion() + "");
        panelRecetario.setjLabelIngredientes(lista.getIngredientes());
        panelRecetario.setjLabelOcasion(lista.getOcasion());
        panelRecetario.setjLabelCategoria(lista.getCategoria());
        panelRecetario.setjLabelDificultad(lista.getDificultad());
        panelRecetario.setjLabelDescripcion(lista.getDescripcion());
        panelRecetario.setjLabelPreparacion(lista.getInstrucciones());
        panelRecetario.setjLabelImagen(lista.getImagen());
        panelRecetario.repaint();

    }

    public void AsignarRecetarioFiltrado(int posicion, int desicion) {

        if(frameUsuario.isActive()){
        
            switch (desicion) {
            case 1:
                //por categoria
                System.out.println(frameUsuario.getTxtCboxCategoria());
                List listaCategoria = recetaTbControlador.buscarCategoria(frameUsuario.getTxtCboxCategoria());

                if (!listaCategoria.isEmpty()) {
                    agregarListaRecetario(listaCategoria, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 2:
                //por ocasion
                System.out.println(frameUsuario.getTxtcBoxOcasion());
                List listaOcasion = recetaTbControlador.buscarOcasion(frameUsuario.getTxtcBoxOcasion());
                if (!listaOcasion.isEmpty()) {
                    agregarListaRecetario(listaOcasion, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 3:
                //por dificultad

                System.out.println(frameUsuario.getTxtcBoxDificultad());
                List listaDificultad = recetaTbControlador.buscarComplejidad(frameUsuario.getTxtcBoxDificultad());
                if (!listaDificultad.isEmpty()) {
                    agregarListaRecetario(listaDificultad, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");
                }

                break;

            case 4:
                //por dificultad y ocasion

                System.out.println(frameUsuario.getTxtcBoxDificultad());
                List listaDificultadOcasion = recetaTbControlador.buscarComplejidadOcasion(frameUsuario.getTxtcBoxDificultad(), frameUsuario.getTxtcBoxOcasion());
                if (!listaDificultadOcasion.isEmpty()) {
                    agregarListaRecetario(listaDificultadOcasion, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 5:
                //por dificultad y categoria
                
                System.out.println(frameUsuario.getTxtcBoxDificultad());
                List listaDificultadCategoria = recetaTbControlador.buscarComplejidadCategoria(frameUsuario.getTxtcBoxDificultad(), frameUsuario.getTxtCboxCategoria());
                if (!listaDificultadCategoria.isEmpty()) {
                    agregarListaRecetario(listaDificultadCategoria, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 6:
                //por categoria y ocasion

                System.out.println(frameUsuario.getTxtcBoxDificultad());
                List listaCategoriaOcasion = recetaTbControlador.buscarOcasionCategoria(frameUsuario.getTxtCboxCategoria(), frameUsuario.getTxtcBoxOcasion());
                if (!listaCategoriaOcasion.isEmpty()) {
                    agregarListaRecetario(listaCategoriaOcasion, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 7:
                //por todas

                System.out.println(frameUsuario.getTxtcBoxDificultad());
                List listaTodas = recetaTbControlador.buscarOcasionCategoriaComplejidad(frameUsuario.getTxtCboxCategoria(), frameUsuario.getTxtcBoxOcasion(), frameUsuario.getTxtcBoxDificultad());
                if (!listaTodas.isEmpty()) {
                    agregarListaRecetario(listaTodas, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;
        }
        }else{
        switch (desicion) {
            case 1:
                //por categoria
                System.out.println(framePrincipal.getTxtCboxCategoria());
                List listaCategoria = recetaTbControlador.buscarCategoria(framePrincipal.getTxtCboxCategoria());

                if (!listaCategoria.isEmpty()) {
                    agregarListaRecetario(listaCategoria, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 2:
                //por ocasion
                System.out.println(framePrincipal.getTxtcBoxOcasion());
                List listaOcasion = recetaTbControlador.buscarOcasion(framePrincipal.getTxtcBoxOcasion());
                if (!listaOcasion.isEmpty()) {
                    agregarListaRecetario(listaOcasion, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 3:
                //por dificultad

                System.out.println(framePrincipal.getTxtcBoxDificultad());
                List listaDificultad = recetaTbControlador.buscarComplejidad(framePrincipal.getTxtcBoxDificultad());
                if (!listaDificultad.isEmpty()) {
                    agregarListaRecetario(listaDificultad, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");
                }

                break;

            case 4:
                //por dificultad y ocasion

                System.out.println(framePrincipal.getTxtcBoxDificultad());
                List listaDificultadOcasion = recetaTbControlador.buscarComplejidadOcasion(framePrincipal.getTxtcBoxDificultad(), framePrincipal.getTxtcBoxOcasion());
                if (!listaDificultadOcasion.isEmpty()) {
                    agregarListaRecetario(listaDificultadOcasion, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 5:
                //por dificultad y categoria
                
                System.out.println(framePrincipal.getTxtcBoxDificultad());
                List listaDificultadCategoria = recetaTbControlador.buscarComplejidadCategoria(framePrincipal.getTxtcBoxDificultad(), framePrincipal.getTxtCboxCategoria());
                if (!listaDificultadCategoria.isEmpty()) {
                    agregarListaRecetario(listaDificultadCategoria, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 6:
                //por categoria y ocasion

                System.out.println(framePrincipal.getTxtcBoxDificultad());
                List listaCategoriaOcasion = recetaTbControlador.buscarOcasionCategoria(framePrincipal.getTxtCboxCategoria(), framePrincipal.getTxtcBoxOcasion());
                if (!listaCategoriaOcasion.isEmpty()) {
                    agregarListaRecetario(listaCategoriaOcasion, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;

            case 7:
                //por todas

                System.out.println(framePrincipal.getTxtcBoxDificultad());
                List listaTodas = recetaTbControlador.buscarOcasionCategoriaComplejidad(framePrincipal.getTxtCboxCategoria(), framePrincipal.getTxtcBoxOcasion(), framePrincipal.getTxtcBoxDificultad());
                if (!listaTodas.isEmpty()) {
                    agregarListaRecetario(listaTodas, posicion);
                } else {
                    frameRecetario.dispose();
                    JOptionPane.showMessageDialog(null, "No existe una receta con las opciones filtradas");

                }

                break;
        }
        }
    }

    public void agregarListaRecetario(List lista, int posicion) {

        RecetaTb objDificultad = (RecetaTb) lista.get(posicion);
        panelRecetario.setjLabelNombre(objDificultad.getNombre());
        panelRecetario.setjLabelPorciones(objDificultad.getPorciones() + "");
        panelRecetario.setjLabelTiempoPrepa(objDificultad.getMinutosPreparacion() + "");
        panelRecetario.setjLabelCoccion(objDificultad.getMinutosCoccion() + "");
        panelRecetario.setjLabelTotal(objDificultad.getMinutosPreparacion() + objDificultad.getMinutosCoccion() + "");
        panelRecetario.setjLabelIngredientes(objDificultad.getIngredientes());
        panelRecetario.setjLabelOcasion(objDificultad.getOcasion());
        panelRecetario.setjLabelCategoria(objDificultad.getCategoria());
        panelRecetario.setjLabelDificultad(objDificultad.getDificultad());
        panelRecetario.setjLabelDescripcion(objDificultad.getDescripcion());
        panelRecetario.setjLabelPreparacion(objDificultad.getInstrucciones());
        panelRecetario.setjLabelImagen(objDificultad.getImagen());
        panelRecetario.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

/////////////////cases para FramePrinicpal///////////////////////////
            case "Registrarse":
                System.out.println("Registrarse");

                controladorUsuarios.mostrarRegistroUsuario();

                break;

            case "Iniciar Sesion":
                System.out.println("Iniciar sesion");

                frameInicioSesion.setVisible(true);
                frameInicioSesion.setLocationRelativeTo(null);

                break;

            case "Recetario":

                frameRecetario.setVisible(true);
                frameRecetario.setLocationRelativeTo(null);
                AsignarRecetario(posicion);

                break;
            case "Anterior":
                System.out.println("se preciono");
                if (desicion == 0) {

                    if (posicion == 0) {

                    } else {
                        posicion--;
                        AsignarRecetario(posicion);
                    }
                } else {

                    if (posicion == 0) {

                    } else {
                        posicion--;
                        System.out.println("se presiono atras en filtrado");
                        AsignarRecetarioFiltrado(posicion, desicion);
                    }

                }

                break;
            case "Siguiente":
                if (desicion == 0) {

                    if (posicion < recetaTbControlador.getRecetaTbCount() - 1) {
                        
                        posicion++;
                        AsignarRecetario(posicion);
                    } else {

                    }
                } else {
                    
                    if (posicion < recetaTbControlador.getRecetaTbCount() - 1) {
                        posicion++;
                        System.out.println("se presiono adelante en filtrado");
                        AsignarRecetarioFiltrado(posicion, desicion);
                    } else {

                    }

                }

                break;

            case "Favoritas":
                System.out.println("Favoritos");

                break;

            case "Ayuda":
                JOptionPane.showMessageDialog(null, "Bienvenido a SIGERECO\n"+
                        "\nCompartir nuestras recetas de cocina, se ha convertido en una práctica muy popular. Muchas\n" +
"personas comparten sus recetas mediante video, texto o una mezcla de ambos. Sin embargo, la\n" +
"cantidad de recetas puede llegar a ser tanta que se nos hace difícil saber cual receta realmente me\n" +
"funciona. Así mismo, una vez que hemos probado una receta que nos gusta, cómo hacemos para\n" +
"guardarla e ir creando nuestro listado de recetas preferidas.\n" +
"El objetivo del proyecto es analizar, diseñar, desarrollar e implementar una aplicación que nos permita\n" +
"gestionar, de forma automatizada, recetas de cocina.");

                break;

            case "Atras":
                desicion = 0;
                frameRecetario.dispose();

                break;

            case "MostrarConsulta":
                posicion = 0;
                
                if(frameUsuario.isActive()){
                    
                    if (!frameUsuario.getTxtCboxCategoria().equals("Todas") && frameUsuario.getTxtcBoxDificultad().equals("Todas") && frameUsuario.getTxtcBoxOcasion().equals("Todas")) {
                    System.out.println(panelConsulta.getCboxCategoria());
                    System.out.println(panelConsulta.getCboxDificultad());
                    System.out.println(panelConsulta.getCboxOcasion());
                    desicion = 1;
                    frameRecetario.setVisible(true);
                    frameRecetario.setLocationRelativeTo(null);
                    AsignarRecetarioFiltrado(posicion, desicion);

                } else {

                    if (frameUsuario.getTxtCboxCategoria().equals("Todas") && frameUsuario.getTxtcBoxDificultad().equals("Todas") && !frameUsuario.getTxtcBoxOcasion().equals("Todas")) {

                        desicion = 2;
                        frameRecetario.setVisible(true);
                        frameRecetario.setLocationRelativeTo(null);
                        AsignarRecetarioFiltrado(posicion, desicion);

                    } else {

                        if (frameUsuario.getTxtCboxCategoria().equals("Todas") && !frameUsuario.getTxtcBoxDificultad().equals("Todas") && frameUsuario.getTxtcBoxOcasion().equals("Todas")) {

                            desicion = 3;
                            frameRecetario.setVisible(true);
                            frameRecetario.setLocationRelativeTo(null);
                            AsignarRecetarioFiltrado(posicion, desicion);

                        } else {

                            if (frameUsuario.getTxtCboxCategoria().equals("Todas") && !frameUsuario.getTxtcBoxDificultad().equals("Todas") && !frameUsuario.getTxtcBoxOcasion().equals("Todas")) {

                                desicion = 4;
                                frameRecetario.setVisible(true);
                                frameRecetario.setLocationRelativeTo(null);
                                AsignarRecetarioFiltrado(posicion, desicion);

                            } else {

                                if (!frameUsuario.getTxtCboxCategoria().equals("Todas") && !frameUsuario.getTxtcBoxDificultad().equals("Todas") && frameUsuario.getTxtcBoxOcasion().equals("Todas")) {

                                    desicion = 5;
                                    System.out.println("entro al 5");
                                    frameRecetario.setVisible(true);
                                    frameRecetario.setLocationRelativeTo(null);
                                    AsignarRecetarioFiltrado(posicion, desicion);

                                } else {

                                    if (!frameUsuario.getTxtCboxCategoria().equals("Todas") && frameUsuario.getTxtcBoxDificultad().equals("Todas") && !frameUsuario.getTxtcBoxOcasion().equals("Todas")) {

                                        desicion = 6;
                                        frameRecetario.setVisible(true);
                                        frameRecetario.setLocationRelativeTo(null);
                                        AsignarRecetarioFiltrado(posicion, desicion);

                                    } else {

                                        if (!frameUsuario.getTxtCboxCategoria().equals("Todas") && !frameUsuario.getTxtcBoxDificultad().equals("Todas") && !frameUsuario.getTxtcBoxOcasion().equals("Todas")) {

                                            desicion = 7;
                                            frameRecetario.setVisible(true);
                                            frameRecetario.setLocationRelativeTo(null);
                                            AsignarRecetarioFiltrado(posicion, desicion);

                                        } else {
                                            if (frameUsuario.getTxtCboxCategoria().equals("Todas") && frameUsuario.getTxtcBoxDificultad().equals("Todas") && frameUsuario.getTxtcBoxOcasion().equals("Todas")) {
                                                 System.out.println(panelConsulta.getCboxCategoria());
                                                System.out.println(panelConsulta.getCboxDificultad());
                                                System.out.println(panelConsulta.getCboxOcasion());
                                                frameRecetario.setVisible(true);
                                                frameRecetario.setLocationRelativeTo(null);
                                                AsignarRecetario(posicion);
                                            }

                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(desicion);}else{
                
                if (!framePrincipal.getTxtCboxCategoria().equals("Todas") && framePrincipal.getTxtcBoxDificultad().equals("Todas") && framePrincipal.getTxtcBoxOcasion().equals("Todas")) {
                    System.out.println(panelConsulta.getCboxCategoria());
                    System.out.println(panelConsulta.getCboxDificultad());
                    System.out.println(panelConsulta.getCboxOcasion());
                    desicion = 1;
                    frameRecetario.setVisible(true);
                    frameRecetario.setLocationRelativeTo(null);
                    AsignarRecetarioFiltrado(posicion, desicion);

                } else {

                    if (framePrincipal.getTxtCboxCategoria().equals("Todas") && framePrincipal.getTxtcBoxDificultad().equals("Todas") && !framePrincipal.getTxtcBoxOcasion().equals("Todas")) {

                        desicion = 2;
                        frameRecetario.setVisible(true);
                        frameRecetario.setLocationRelativeTo(null);
                        AsignarRecetarioFiltrado(posicion, desicion);

                    } else {

                        if (framePrincipal.getTxtCboxCategoria().equals("Todas") && !framePrincipal.getTxtcBoxDificultad().equals("Todas") && framePrincipal.getTxtcBoxOcasion().equals("Todas")) {

                            desicion = 3;
                            frameRecetario.setVisible(true);
                            frameRecetario.setLocationRelativeTo(null);
                            AsignarRecetarioFiltrado(posicion, desicion);

                        } else {

                            if (framePrincipal.getTxtCboxCategoria().equals("Todas") && !framePrincipal.getTxtcBoxDificultad().equals("Todas") && !framePrincipal.getTxtcBoxOcasion().equals("Todas")) {

                                desicion = 4;
                                frameRecetario.setVisible(true);
                                frameRecetario.setLocationRelativeTo(null);
                                AsignarRecetarioFiltrado(posicion, desicion);

                            } else {

                                if (!framePrincipal.getTxtCboxCategoria().equals("Todas") && !framePrincipal.getTxtcBoxDificultad().equals("Todas") && framePrincipal.getTxtcBoxOcasion().equals("Todas")) {

                                    desicion = 5;
                                    System.out.println("entro al 5");
                                    frameRecetario.setVisible(true);
                                    frameRecetario.setLocationRelativeTo(null);
                                    AsignarRecetarioFiltrado(posicion, desicion);

                                } else {

                                    if (!framePrincipal.getTxtCboxCategoria().equals("Todas") && framePrincipal.getTxtcBoxDificultad().equals("Todas") && !framePrincipal.getTxtcBoxOcasion().equals("Todas")) {

                                        desicion = 6;
                                        frameRecetario.setVisible(true);
                                        frameRecetario.setLocationRelativeTo(null);
                                        AsignarRecetarioFiltrado(posicion, desicion);

                                    } else {

                                        if (!framePrincipal.getTxtCboxCategoria().equals("Todas") && !framePrincipal.getTxtcBoxDificultad().equals("Todas") && !framePrincipal.getTxtcBoxOcasion().equals("Todas")) {

                                            desicion = 7;
                                            frameRecetario.setVisible(true);
                                            frameRecetario.setLocationRelativeTo(null);
                                            AsignarRecetarioFiltrado(posicion, desicion);

                                        } else {
                                            if (framePrincipal.getTxtCboxCategoria().equals("Todas") && framePrincipal.getTxtcBoxDificultad().equals("Todas") && framePrincipal.getTxtcBoxOcasion().equals("Todas")) {
                                                 System.out.println(panelConsulta.getCboxCategoria());
                                                System.out.println(panelConsulta.getCboxDificultad());
                                                System.out.println(panelConsulta.getCboxOcasion());
                                                frameRecetario.setVisible(true);
                                                frameRecetario.setLocationRelativeTo(null);
                                                AsignarRecetario(posicion);
                                            }

                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(desicion);
                }
//                ////////////////////////////////////////////////////////////////////////actulemnte funcionando
//                if (panelConsulta.getCboxCategoria().equals("Sopa")&&panelConsulta.getCboxDificultad().equals("Todas")&&panelConsulta.getCboxOcasion().equals("Todas")){
//                
//                    desicion=1;
//                    
//                    frameRecetario.setVisible(true);
//                    frameRecetario.setLocationRelativeTo(null);
//                    AsignarRecetarioFiltrado(posicion, desicion);
//                    System.out.println("ucr.ac.cr.sigereco.controlador.ControladorPrincipal.actionPerformed()");
//                    //metodo con consulta
//                }else{
//                    
//                    frameRecetario.setVisible(true);
//                    frameRecetario.setLocationRelativeTo(null);
//                    AsignarRecetario(posicion);
//
//                }
                break;

/////////////////cases para FrameInicioSesion///////////////////////////
            case "AtrasPanIS":
                System.out.println("AtrasPanIS");
                frameInicioSesion.limpiar();
                frameInicioSesion.dispose();

                break;

            case "IniciarSesionPanIS":
                System.out.println("IniciarSesionPanIS");
                switch (controladorUsuarios.validacion(frameInicioSesion.getTxtUsuario(), frameInicioSesion.getTxtContrasena())) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                        break;

                    case 1:
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                        framePrincipal.dispose();
                        usuarioActual = frameInicioSesion.getTxtUsuario();
                        frameAdmin.asignarUsuario(usuarioActual);
                        frameInicioSesion.limpiar();
                        frameInicioSesion.dispose();
                        frameAdmin.setVisible(true);
                        frameAdmin.setLocationRelativeTo(null);
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                        framePrincipal.dispose();
                        usuarioActual = frameInicioSesion.getTxtUsuario();
                        frameUsuario.asignarUsuario(usuarioActual);
                        frameInicioSesion.limpiar();
                        frameInicioSesion.dispose();
                        frameUsuario.setVisible(true);
                        frameUsuario.setLocationRelativeTo(null);
                        break;
                }

                break;
////////////////////////Cases para FrameAdmin///////////////////

            case "Consulta":
                frameUsuario.setVisible(true);

                break;

            case "Cerrar sesion":

                frameAdmin.dispose();
                frameUsuario.dispose();
                framePrincipal.setVisible(true);

                break;

            case "BuscarIngr":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "AgregarIngr":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "ModificarIngr":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "EliminarIngr":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "BuscarUni":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "AgregarUni":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "ModificarUni":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "EliminarUni":
                //Esto no se va usar
                System.out.println("Conexion Exitosa");

                break;

            case "BuscarRece":

                List lista = recetaTbControlador.findRecetaTbEntities();
                for (int i = 0; i < lista.size(); i++) {
                    RecetaTb obj = (RecetaTb) lista.get(i);
                    if (obj.getNombre().equalsIgnoreCase(panelAdmin.getTxtNombreRecet())) {
                        panelAdmin.setTxtNombre(obj.getNombre());
                        panelAdmin.setTxtImagen(obj.getImagen());
                        panelAdmin.setTxtTiempPrep(obj.getMinutosPreparacion());
                        panelAdmin.setTxtTiempcoccion(obj.getMinutosCoccion());
                        panelAdmin.setjSpinnerPorciones(obj.getPorciones());
                        panelAdmin.setAreaDescripcion(obj.getDescripcion());
                        panelAdmin.setAreaInstrucciones(obj.getInstrucciones());
                        panelAdmin.setAreaIngredientes(obj.getIngredientes());
                        panelAdmin.setjCBoxDificultad(obj.getDificultad());
                        panelAdmin.setjCBoxOcasion(obj.getOcasion());
                        panelAdmin.setjCBoxCategoria(obj.getCategoria());

                    }
                }

                System.out.println("Conexion Exitosa");

                break;

            case "AgregarLista":

                System.out.println("Conexion Exitosa");

                break;

            case "AgregarRece":

                System.out.println("Conexion Exitosa");
                if (panelAdmin.getTxtNombreRecet().equals("invalido") || panelAdmin.getTxtImagen().equals("invalido") || panelAdmin.getTxtTiempPrep() == -1 || panelAdmin.getTxtTiempcoccion() == -1 || panelAdmin.getAreaDescripcion().equals("invalido") || panelAdmin.getAreaIngredintes().equals("invalido") || panelAdmin.getAreaInstrucciones().equals("invalido") || panelAdmin.getjSpinnerPorciones() == 0) {

                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los espacios para poder registrar un usuario");
                } else {
                    recetaTb = new RecetaTb(panelAdmin.getTxtNombreRecet(),
                            panelAdmin.getAreaDescripcion(),
                            panelAdmin.getTxtImagen(),
                            panelAdmin.getAreaInstrucciones(),
                            panelAdmin.getTxtTiempPrep(),
                            panelAdmin.getTxtTiempcoccion(),
                            panelAdmin.getjSpinnerPorciones(),
                            panelAdmin.getAreaIngredintes(),
                            panelAdmin.getjCBoxDificultad(),
                            panelAdmin.getjCBoxOcasion(),
                            panelAdmin.getjCBoxCategoria());
                    recetaTbControlador.create(recetaTb);
                    escribirJson();
                    JOptionPane.showMessageDialog(null, "Receta agregada con exito :)");
                    panelAdmin.limpiar();
                }
                break;

            case "BuscarImagen":

                JFileChooser archivo = new JFileChooser();
                int resultado = archivo.showOpenDialog(null);

                if (resultado == JFileChooser.APPROVE_OPTION) {

                    File archivoSeleccionado = archivo.getSelectedFile();

                    String extension = archivoSeleccionado.getName().substring(archivoSeleccionado.getName().lastIndexOf(".") + 1).toLowerCase();
                    if (extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")) {

                        String destino = "./src/main/resources/images";

                        try {
                            File archivoDestino = new File(destino, archivoSeleccionado.getName());
                            Files.copy(archivoSeleccionado.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                            panelAdmin.setTxtImagen(destino + "/" + archivoDestino.getName());

                        } catch (IOException ex) {
                            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "Selecciona una imagen valida (JPG, JPEG o PNG", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                }

                System.out.println("Conexion Exitosa");

                break;

            case "ModificarRece":

                System.out.println("Conexion Exitosa");
                lista = recetaTbControlador.findRecetaTbEntities();

                for (int i = 0; i < lista.size(); i++) {
                    RecetaTb obj = (RecetaTb) lista.get(i);
                    if (obj.getNombre().equalsIgnoreCase(panelAdmin.getTxtNombreRecet())) {
                        RecetaTb recetaModificada = obj;
                        obj.setNombre(panelAdmin.getTxtNombreRecet());
                        obj.setDescripcion(panelAdmin.getAreaDescripcion());
                        obj.setImagen(panelAdmin.getTxtImagen());
                        obj.setInstrucciones(panelAdmin.getAreaInstrucciones());
                        obj.setMinutosPreparacion(panelAdmin.getTxtTiempPrep());
                        obj.setMinutosCoccion(panelAdmin.getTxtTiempcoccion());
                        obj.setPorciones(panelAdmin.getjSpinnerPorciones());
                        obj.setIngredientes(panelAdmin.getAreaIngredintes());
                        obj.setDificultad(panelAdmin.getjCBoxDificultad());
                        obj.setOcasion(panelAdmin.getjCBoxOcasion());
                        obj.setCategoria(panelAdmin.getjCBoxCategoria());

                        System.out.println(obj.getId());
                        try {
                            recetaTbControlador.edit(obj);
                            escribirJson();
                            JOptionPane.showMessageDialog(null, "La receta se ha modificado con exito");
                        } catch (Exception ex) {
                            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

                panelAdmin.limpiar();

                break;

            case "EliminarRece":

                lista = recetaTbControlador.findRecetaTbEntities();
                for (int i = 0; i < lista.size(); i++) {
                    RecetaTb obj = (RecetaTb) lista.get(i);
                    if (obj.getNombre().equalsIgnoreCase(panelAdmin.getTxtNombreRecet())) {
                        try {
                            String rutaImagen = obj.getImagen();
                            File archivoImagen = new File(rutaImagen);
                            if (archivoImagen.exists()) {
                                if (archivoImagen.delete()) {
                                    System.out.println("Imagen borrada");
                                } else {
                                    System.out.println("Error al borrar la imagen");
                                }
                            }

                            recetaTbControlador.destroy(obj.getId());
                            escribirJson();
                            JOptionPane.showMessageDialog(null, "Receta eliminada con exito :)");
                            panelAdmin.limpiar();
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                break;

            case "Reporte":
                frameReporte.setDatosTabla(getDatosTabla(), RecetaTb.ETIQUETAS_RECETAS);
                frameReporte.setVisible(true);
                break;
            case "Regresar":
                frameReporte.dispose();
                break;

            ////////////////////////Cases para Usuario///////////////////
        }

    }

}

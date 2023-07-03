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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
import ucr.ac.cr.sigereco.vista.FrameUsuario;
import ucr.ac.cr.sigereco.vista.PanelAdmin;
import ucr.ac.cr.sigereco.vista.PanelConsulta;
import ucr.ac.cr.sigereco.vista.PanelRecetario;
import ucr.ac.cr.sigereco.vista.PanelTop10;

/**
 *
 * @author Drexler Guzman
 */
public class ControladorPrincipal implements ActionListener{
    private ArrayList <Consultas> registroConsulta;
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
    private String usuarioActual="";
    private PanelRecetario panelRecetario;
    private int posicion = 0;
    
    private PanelAdmin panelAdmin;

    public ControladorPrincipal() {
        
        //crear las instancias de los atributos
        recetaTbControlador=new RecetaTbJpaController(Persistence.createEntityManagerFactory("SIGERECOPersistence"));
        framePrincipal=new FramePrincipal();
        frameInicioSesion=new FrameInicioSesion();
        frameAdmin=new FrameAdmin();
        frameRecetario= new FrameRecetario();
        controladorUsuarios=new ControladorUsuarios();
        frameUsuario=new FrameUsuario();
        panelConsulta = new PanelConsulta();
        panelTop10 = new PanelTop10();
        panelAdmin = frameAdmin.getPanelAdmin();
        panelRecetario = frameRecetario.getPanelRecetario();
        
        
        
        
//        frameAdmin.escuchar(this);
        frameRecetario.escuchar(this);
        frameUsuario.escuchar(this);
        panelConsulta.escuchar(this);
        
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.escuchar(this);
        frameInicioSesion.escuchar(this);
        frameAdmin.escuchar(this);
    }
    
    public void AsignarRecetario(int posicion){
         List  lista=recetaTbControlador.findRecetaTbEntities();
         RecetaTb obj = (RecetaTb) lista.get(posicion);
         panelRecetario.setjLabelNombre(obj.getNombre());
         panelRecetario.setjLabelPorciones(obj.getPorciones()+"");
         panelRecetario.setjLabelTiempoPrepa(obj.getMinutosPreparacion()+"");
         panelRecetario.setjLabelCoccion(obj.getMinutosCoccion()+"");
         panelRecetario.setjLabelTotal(obj.getMinutosPreparacion()+obj.getMinutosCoccion()+"");
         panelRecetario.setjLabelIngredientes(obj.getIngredientes());
         panelRecetario.setjLabelOcasion(obj.getOcasion());
         panelRecetario.setjLabelCategoria(obj.getCategoria());
         panelRecetario.setjLabelDificultad(obj.getDificultad());
         panelRecetario.setjLabelDescripcion(obj.getDescripcion());
         panelRecetario.setjLabelPreparacion(obj.getInstrucciones());
        
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
                        if (posicion ==0){
                            
                        }else{
                            posicion--;
                            AsignarRecetario(posicion);
                        }
                        break;
                    case "Siguiente":
                        if (posicion<recetaTbControlador.getRecetaTbCount()-1){
                            posicion++;
                            AsignarRecetario(posicion);
                    }else{
                            
                        }
                        break;
                
                
            case "Favoritas":
                System.out.println("Favoritos");
                
                break;
                
            case "Ayuda":
                System.out.println("Ayuda");
                
                break;
                
            case "Atras":
                frameRecetario.dispose();
                
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
                        usuarioActual=frameInicioSesion.getTxtUsuario();
                        frameAdmin.asignarUsuario(usuarioActual);
                        frameInicioSesion.limpiar();
                        frameInicioSesion.dispose();
                        frameAdmin.setVisible(true);
                        frameAdmin.setLocationRelativeTo(null);
                        break;
                        
                    case 2:
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                        framePrincipal.dispose();
                        usuarioActual=frameInicioSesion.getTxtUsuario();
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
                
                List  lista=recetaTbControlador.findRecetaTbEntities();
                for (int i = 0; i < lista.size(); i++) {
                    RecetaTb obj = (RecetaTb) lista.get(i);
                    if(obj.getNombre().equalsIgnoreCase(panelAdmin.getTxtNombreRecet())){
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
                        
                    }}
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "AgregarLista":
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "AgregarRece":
                
                System.out.println("Conexion Exitosa");
                if(panelAdmin.getTxtNombreRecet().equals("invalido")||panelAdmin.getTxtImagen().equals("invalido")||panelAdmin.getTxtTiempPrep()==-1||panelAdmin.getTxtTiempcoccion()==-1||panelAdmin.getAreaDescripcion().equals("invalido")||panelAdmin.getAreaIngredintes().equals("invalido")||panelAdmin.getAreaInstrucciones().equals("invalido")||panelAdmin.getjSpinnerPorciones()==0){
                
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los espacios para poder registrar un usuario");
                }else{
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
                JOptionPane.showMessageDialog(null, "Receta agregada con exito :)");
                panelAdmin.limpiar();
                }
                break;
                
            case "BuscarImagen":
                
                JFileChooser archivo=new JFileChooser();
                int resultado=archivo.showOpenDialog(null);
                
                if(resultado==JFileChooser.APPROVE_OPTION){
                
                    File archivoSeleccionado=archivo.getSelectedFile();
                    
                    String extension=archivoSeleccionado.getName().substring(archivoSeleccionado.getName().lastIndexOf(".")+1).toLowerCase();
                    if(extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png")){
                    
                        String destino="./src/main/resources/images";
                        
                        
                        try {
                            File archivoDestino=new File(destino,archivoSeleccionado.getName());
                            Files.copy(archivoSeleccionado.toPath(), archivoDestino.toPath(),StandardCopyOption.REPLACE_EXISTING);
                            
                            panelAdmin.setTxtImagen(destino+"/"+archivoDestino.getName());
                            
                        } catch (IOException ex) {
                            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    }else{
                    
                        JOptionPane.showMessageDialog(null, "Selecciona una imagen valida (JPG, JPEG o PNG","Error",JOptionPane.ERROR_MESSAGE);
                    
                    }
                
                }
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "ModificarRece":
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "EliminarRece":
                
                lista=recetaTbControlador.findRecetaTbEntities();
                for (int i = 0; i < lista.size(); i++) {
                    RecetaTb obj = (RecetaTb) lista.get(i);
                    if(obj.getNombre().equalsIgnoreCase(panelAdmin.getTxtNombreRecet())){
                        try {
                            //eliminar la imagen de la carpeta images, aun sin probar
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
                            JOptionPane.showMessageDialog(null, "Receta eliminada con exito :)");
                            panelAdmin.limpiar();
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }}
                System.out.println("Conexion Exitosa");
                
                break;
                
                ////////////////////////Cases para Usuario///////////////////
        }

    }

    
    
}

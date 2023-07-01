/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
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
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "AgregarLista":
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "AgregarRece":
                
                System.out.println("Conexion Exitosa");
                recetaTb = new RecetaTb(panelAdmin.getTxtNombreRecet(),
                        panelAdmin.getAreaDescripcion(),
                        panelAdmin.getTxtImagen(),
                        panelAdmin.getAreaInstrucciones(),
                        panelAdmin.getTxtTiempPrep(),
                        panelAdmin.getTxtTiempcoccion(),
                        panelAdmin.getjSpinnerPorciones());
                recetaTbControlador.create(recetaTb);
                JOptionPane.showMessageDialog(null, "Receta agregada con exito :)");
                panelAdmin.limpiar();
                
                break;
                
            case "BuscarImagen":
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "ModificarRece":
                
                System.out.println("Conexion Exitosa");
                
                break;
                
            case "EliminarRece":
                
                System.out.println("Conexion Exitosa");
                
                break;
                
                ////////////////////////Cases para Usuario///////////////////
        }

    }

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucr.ac.cr.sigereco.modelo.Consultas;
import ucr.ac.cr.sigereco.modelo.Usuario;
import ucr.ac.cr.sigereco.vista.FrameAdmin;
import ucr.ac.cr.sigereco.vista.FrameInicioSesion;
import ucr.ac.cr.sigereco.vista.FramePrincipal;
import ucr.ac.cr.sigereco.vista.FrameRecetario;
import ucr.ac.cr.sigereco.vista.FrameRegistro;
import ucr.ac.cr.sigereco.vista.FrameUsuario;
import ucr.ac.cr.sigereco.vista.PanelConsulta;
import ucr.ac.cr.sigereco.vista.PanelTop10;

/**
 *
 * @author Drexler Guzman
 */
public class ControladorPrincipal implements ActionListener{
    private ArrayList <Consultas> registroConsulta;
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

    public ControladorPrincipal() {
        
        //crear las instancias de los atributos
        framePrincipal=new FramePrincipal();
        frameInicioSesion=new FrameInicioSesion();
        controladorUsuarios=new ControladorUsuarios();
        
        
        
//        frameAdmin.escuchar(this);
//        frameRecetario.escuchar(this);
//        frameUsuario.escuchar(this);
//        panelConsulta.escuchar(this);
//        panelTop10.escuchar(this);
        
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.escuchar(this);
        frameInicioSesion.escuchar(this);
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
                System.out.println("Recetario");
                
                break;
                
            case "Favoritas":
                System.out.println("Favoritos");
                
                break;
                
            case "Ayuda":
                System.out.println("Ayuda");
                
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
                        frameAdmin.setVisible(true);
                        frameAdmin.setLocationRelativeTo(null);
                        break;
                        
                    case 2:
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                        framePrincipal.dispose();
                        frameUsuario.setVisible(true);
                        frameUsuario.setLocationRelativeTo(null);
                        break;
                }

                
                break;
        }

    }
    
    
}

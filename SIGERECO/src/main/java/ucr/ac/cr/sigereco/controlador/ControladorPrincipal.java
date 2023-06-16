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
import ucr.ac.cr.sigereco.vista.FrameAdmin;
import ucr.ac.cr.sigereco.vista.FramePrincipal;
import ucr.ac.cr.sigereco.vista.FrameRecetario;
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

    public ControladorPrincipal() {
        
        //crear las instancias de los atributos
        framePrincipal=new FramePrincipal();
        controladorUsuarios=new ControladorUsuarios();
        
//        frameAdmin.escuchar(this);
//        frameRecetario.escuchar(this);
//        frameUsuario.escuchar(this);
//        panelConsulta.escuchar(this);
//        panelTop10.escuchar(this);
        
        framePrincipal.setVisible(true);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.escuchar(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            
            //cases para FrameInicio Sesion o registro de usuarios
            case "Registrarse":
                System.out.println("Registrarse");
                controladorUsuarios.mostrarRegistro();
                
                break;
                
            case "Iniciar Sesion":
                System.out.println("Iniciar sesion");
                controladorUsuarios.mostrarInicioSesion();
                
                switch (controladorUsuarios.validacion()){ //corregir esto para que haga la validacion varias veces
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
                
            case "Ayuda":
                System.out.println("Ayuda");
                
                break;
        }

    }
    
    
}

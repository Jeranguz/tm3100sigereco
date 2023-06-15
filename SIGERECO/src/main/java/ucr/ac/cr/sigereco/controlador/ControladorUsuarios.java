/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ucr.ac.cr.sigereco.modelo.Usuario;
import ucr.ac.cr.sigereco.vista.FrameInicioSesion;
import ucr.ac.cr.sigereco.vista.FrameRegistro;


/**
 *
 * @author XPC
 */
public class ControladorUsuarios implements ActionListener {
    
    private FrameRegistro frameRegistro;
    private FrameInicioSesion frameInicioSesion;
    private ArrayList <Usuario> usuarios;

    public ControladorUsuarios() {
        frameRegistro = new FrameRegistro();
        frameInicioSesion=new FrameInicioSesion();
        usuarios=new ArrayList<>();
        frameRegistro.setVisible(true);
        frameRegistro.setLocationRelativeTo(null);
        frameRegistro.escuchar(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            
            case "Guardar":
                System.out.println("Se presiono el boton guardar");
                break;
                
            case "Modificar":
                System.out.println("Se presiono el boton modificar");
                break;
                
            case "Eliminar":
                System.out.println("Se presiono el boton eliminar");
                break;
                
            case "Usuarios":
                System.out.println("Se presiono el boton usuarios");
                break;
                
            case "Salir":
                frameRegistro.setVisible(false);
                break;
                
            case "Registrar":
                System.out.println("Se presiono el boton Registrar");
                break;
        }
    }
    
    public static void main(String[] args) {
        new ControladorUsuarios();
    }
    
}

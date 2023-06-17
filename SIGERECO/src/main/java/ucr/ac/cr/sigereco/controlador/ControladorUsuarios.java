/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucr.ac.cr.sigereco.modelo.Usuario;
import ucr.ac.cr.sigereco.vista.FrameInicioSesion;
import ucr.ac.cr.sigereco.vista.FrameRegistro;


/**
 *
 * @author XPC
 */
public class ControladorUsuarios implements ActionListener{
    
    private ArrayList <Usuario> usuarios;
    private FrameRegistro frameRegistro;

    public ControladorUsuarios() {

        usuarios=new ArrayList<>();
        frameRegistro=new FrameRegistro();
        frameRegistro.escuchar(this);
    }
    
    public void mostrarRegistroUsuario(){
    
        frameRegistro.setVisible(true);
        frameRegistro.setLocationRelativeTo(null);
    
    }
    
    public void agregarUsuario(Usuario usuario){
    
        usuarios.add(usuario);
    
    }

    
    public int validacion(String usuario, String contrasena){
        
      int validacion = 0;

                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuarios.get(i).getNombreUsuario().equals(usuario) && usuarios.get(i).getContrasena().equals(contrasena)) {

                        if (usuarios.get(i).getTipoUsuario().equals("Administrador")) {
                            validacion = 1;
                        } else {
                            validacion = 2;
                        }
                    }else{
                    
                    }
                }
                return validacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        
            case "BuscarPanReg":
                System.out.println("BuscarPanReg");
                
                break;
                
            case "AgregarPanReg":
                System.out.println("AgregarPanReg");
//                agregarUsuario(new Usuario(frameRegistro.getTxtNombre(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getCboxTipo(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getTxtApellido(), frameRegistro.getTxtContrasena()));
//                frameRegistro.limpiar();
                break;
                
            case "ModificarPanReg":
                System.out.println("ModificarPanReg");
                
                break;
                
            case "EliminarPanReg":
                System.out.println("EliminarPanReg");
                
                break;
                
            case "SalirPanReg":
                frameRegistro.dispose();
                frameRegistro.limpiar();
                
                break;
        
        
        }
    }

}

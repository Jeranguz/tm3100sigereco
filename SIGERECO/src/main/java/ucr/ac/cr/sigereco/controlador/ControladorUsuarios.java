/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import ucr.ac.cr.sigereco.modelo.UsuarioTb;
import ucr.ac.cr.sigereco.modelo.Usuario;
import ucr.ac.cr.sigereco.vista.FrameInicioSesion;
import ucr.ac.cr.sigereco.vista.FrameRegistro;


/**
 *
 * @author XPC
 */
public class ControladorUsuarios implements ActionListener{
    
    private ArrayList <UsuarioTb> usuarios;
    private FrameRegistro frameRegistro;
    private UsuarioTbJpaController usuarioTbControlador;
    private int id=0;

    public ControladorUsuarios() {

        usuarios=new ArrayList<>();
        frameRegistro=new FrameRegistro();
        usuarioTbControlador=new UsuarioTbJpaController(Persistence.createEntityManagerFactory("SIGERECOPersistence"));
        frameRegistro.escuchar(this);
        id=usuarioTbControlador.getUsuarioTbCount();
        //usuarios.add(new Usuario ("Adim", "admin@sigereco.com", "Costa Rica", "Administrador", "Admin", "Admin", "Admin"));
        //usuarios.add(new Usuario ("user", "user@sigereco.com", "Costa Rica", "Consultor", "user", "user", "user"));
    }
    
    public void mostrarRegistroUsuario(){
    
        frameRegistro.setVisible(true);
        frameRegistro.setLocationRelativeTo(null);
    
    }
    
    public void agregarUsuario(UsuarioTb usuario){
    
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
                UsuarioTb usuarioBuscado=usuarioTbControlador.findUsuarioTb(Integer.parseInt(frameRegistro.getTxtID()));
                frameRegistro.bloquearID();
                frameRegistro.setTxtApellido(usuarioBuscado.getApellido());
                frameRegistro.setTxtContrasena(usuarioBuscado.getContrasena());
                frameRegistro.setTxtCorreo(usuarioBuscado.getCorreo());
                frameRegistro.setTxtNombre(usuarioBuscado.getNombre());
                frameRegistro.setTxtNombreUsuario(usuarioBuscado.getNombreUsuario());
                frameRegistro.setTxtPais(usuarioBuscado.getPais());
                frameRegistro.setCboxTipo(usuarioBuscado.getTipoUsuario());
                break;
                
            case "AgregarPanReg":
                System.out.println("AgregarPanReg");
                id++;
                //agregarUsuario(new UsuarioTb(id, frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena()));
                usuarioTbControlador.create(new UsuarioTb(id, frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena()));
                JOptionPane.showMessageDialog(null, "Su ID es el:"+id+ "No lo olvides.");
                frameRegistro.limpiar();
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

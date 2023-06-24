/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
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
//        id=usuarioTbControlador.getUsuarioTbCount();
        //usuarios.add(new Usuario ("Adim", "admin@sigereco.com", "Costa Rica", "Administrador", "Admin", "Admin", "Admin"));
        //usuarios.add(new Usuario ("user", "user@sigereco.com", "Costa Rica", "Consultor", "user", "user", "user"));
    }
    
    public void mostrarRegistroUsuario(){
    
        frameRegistro.setVisible(true);
        frameRegistro.setLocationRelativeTo(null);
        id=usuarioTbControlador.getUsuarioTbCount();
        System.out.println(usuarioTbControlador.getUsuarioTbCount());
    
    }
    
    public void agregarUsuario(UsuarioTb usuario){
    
        usuarios.add(usuario);
    
    }

    
    public int validacion(String usuario, String contrasena){
        
      int validacion = 0;
      int ultimoId = usuarioTbControlador.findUsuarioTb(usuarioTbControlador.getUsuarioTbCount()).getId();

                for (int i = 1; i <= ultimoId; i++) {
                    if (usuarioTbControlador.findUsuarioTb(i).getNombreUsuario().equals(usuario) && usuarioTbControlador.findUsuarioTb(i).getContrasena().equals(contrasena)) {

                        if (usuarioTbControlador.findUsuarioTb(i).getTipoUsuario().equals("Administrador")) {
                            validacion = 1;
                        } else {
                            validacion = 2;
                        }
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
                
                if(frameRegistro.getTxtApellido().equals("invalido")||frameRegistro.getTxtContrasena().equals("invalido")||frameRegistro.getTxtCorreo().equals("invalido")||frameRegistro.getTxtNombre().equals("invalido")||frameRegistro.getTxtNombreUsuario().equals("invalido")||frameRegistro.getTxtPais().equals("invalido")){
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los espacios para poder registrar un usuario");
                }else{
                    id=usuarioTbControlador.getUsuarioTbCount();
//                    id++;
                //agregarUsuario(new UsuarioTb(id, frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena()));
                UsuarioTb usuario = new UsuarioTb(id, frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena());
                usuarioTbControlador.create(usuario);
                JOptionPane.showMessageDialog(null, "Su ID es el: "+usuario.getId()+ "No lo olvides.");
                frameRegistro.limpiar();
                }
                break;
                
            case "ModificarPanReg":
                System.out.println("ModificarPanReg");
                UsuarioTb usuarioModificar= new UsuarioTb(Integer.parseInt(frameRegistro.getTxtID()), frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena());
                
            {
                try {
                    usuarioTbControlador.edit(usuarioModificar);
                    frameRegistro.limpiar();
                    frameRegistro.habilitarID();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                JOptionPane.showMessageDialog(null, "El usuario ha sido modificado exitosamente");
                break;

                
            case "EliminarPanReg":
                System.out.println("EliminarPanReg");
            {
                try {
                    usuarioTbControlador.destroy(Integer.parseInt(frameRegistro.getTxtID()));
                    frameRegistro.limpiar();
                    frameRegistro.habilitarID();
                    id=usuarioTbControlador.getUsuarioTbCount();
                    id--;
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado exitosamente :)");
                break;

                
            case "SalirPanReg":
                frameRegistro.dispose();
                frameRegistro.limpiar();
                
                break;
        
        
        }
    }

}

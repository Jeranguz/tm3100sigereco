/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ucr.ac.cr.sigereco.controlador.exceptions.NonexistentEntityException;
import ucr.ac.cr.sigereco.modelo.UsuarioTb;
import ucr.ac.cr.sigereco.modelo.Usuario;
import ucr.ac.cr.sigereco.vista.FrameInicioSesion;
import ucr.ac.cr.sigereco.vista.FrameRegistro;
import ucr.ac.cr.sigereco.vista.FrameReporte;

/**
 *
 * @author XPC
 */
public class ControladorUsuarios implements ActionListener {

    private ArrayList<UsuarioTb> usuarios;
    private FrameRegistro frameRegistro;
    private UsuarioTbJpaController usuarioTbControlador;
    private JSONObject objetoBase;
    private File archivo;
    private FrameReporte frameReporte;

    public ControladorUsuarios() {

        usuarios = new ArrayList<>();
        frameRegistro = new FrameRegistro();
        usuarioTbControlador = new UsuarioTbJpaController(Persistence.createEntityManagerFactory("SIGERECOPersistence"));
        frameRegistro.escuchar(this);
        archivo = new File("Usuarios.json");
        frameReporte = new FrameReporte();
        frameReporte.escuchar(this);
    }

    public void escribirJson() {
        JSONArray listaUsuariosJson = new JSONArray();
        List lista = usuarioTbControlador.findUsuarioTbEntities();
        objetoBase = new JSONObject();
        for (int i = 0; i < lista.size(); i++) {
            UsuarioTb obj = (UsuarioTb) lista.get(i);
            JSONObject objJSONReceta = new JSONObject();
            objJSONReceta.put("id", obj.getId());
            objJSONReceta.put("nombre", obj.getNombre());
            objJSONReceta.put("apellido", obj.getApellido());
            objJSONReceta.put("correo", obj.getCorreo());
            objJSONReceta.put("pais", obj.getPais());
            objJSONReceta.put("nombre de usuario", obj.getNombreUsuario());
            objJSONReceta.put("tipo de usuario", obj.getTipoUsuario());
            objJSONReceta.put("contraseña", obj.getContrasena());
            listaUsuariosJson.add(objJSONReceta);
        }
        objetoBase.put("Usuarios", listaUsuariosJson);
        try {
            FileWriter escribir = new FileWriter(archivo);
            escribir.write(objetoBase.toJSONString());
            escribir.flush();
            escribir.close();
        } catch (IOException ex) {
            System.err.println("Error al escribir el archivo");
        }
    }

    public String[][] getDatosTabla() {
        List lista = usuarioTbControlador.findUsuarioTbEntities();
        String[][] matrizDatos = new String[lista.size()][UsuarioTb.ETIQUETAS_USUARIO.length];
        for (int fila = 0; fila < lista.size(); fila++) {
            for (int columna = 0; columna < matrizDatos[0].length; columna++) {
                UsuarioTb obj = (UsuarioTb) lista.get(fila);
                matrizDatos[fila][columna] = obj.setDatos(columna);
            }
        }
        return matrizDatos;
    }

    public void mostrarRegistroUsuario() {

        frameRegistro.setVisible(true);
        frameRegistro.setLocationRelativeTo(null);
        System.out.println(usuarioTbControlador.getUsuarioTbCount());

    }

    public void agregarUsuario(UsuarioTb usuario) {

        usuarios.add(usuario);

    }

    public int validacion(String usuario, String contrasena) {

        List lista = usuarioTbControlador.findUsuarioTbEntities();
        System.out.println(lista);
        System.out.println("AgregarPanReg");
        int ultimoId = 0;
        for (int i = 0; i < lista.size(); i++) {
            UsuarioTb obj = (UsuarioTb) lista.get(i);
            if (obj.getId() > ultimoId) {
                ultimoId = obj.getId();
            }
        }
        int validacion = 0;
        //int ultimoId = usuarioTbControlador.findUsuarioTb(usuarioTbControlador.getUsuarioTbCount()).getId();

        for (int i = 0; i <= ultimoId; i++) {
            if (usuarioTbControlador.findUsuarioTb(i) != null) {
                if (usuarioTbControlador.findUsuarioTb(i).getNombreUsuario().equals(usuario) && usuarioTbControlador.findUsuarioTb(i).getContrasena().equals(contrasena)) {

                    if (usuarioTbControlador.findUsuarioTb(i).getTipoUsuario().equals("Administrador")) {
                        validacion = 1;
                    } else {
                        validacion = 2;
                    }
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
                UsuarioTb usuarioBuscado = usuarioTbControlador.findUsuarioTb(Integer.parseInt(frameRegistro.getTxtID()));
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

                if (frameRegistro.getTxtApellido().equals("invalido") || frameRegistro.getTxtContrasena().equals("invalido") || frameRegistro.getTxtCorreo().equals("invalido") || frameRegistro.getTxtNombre().equals("invalido") || frameRegistro.getTxtNombreUsuario().equals("invalido") || frameRegistro.getTxtPais().equals("invalido")) {
                    JOptionPane.showMessageDialog(null, "Debe rellenar todos los espacios para poder registrar un usuario");
                } else {
                    if (frameRegistro.getCboxTipo().equals("Administrador")) {

                        if (JOptionPane.showInputDialog("Digite la contraseña de acceso que lo acredite como el Administrador más sexy").equals("root")) {
                            UsuarioTb usuario = new UsuarioTb(frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena());
                            usuarioTbControlador.create(usuario);
                            escribirJson();
                            JOptionPane.showMessageDialog(null, "Su ID es el: " + usuario.getId() + " No lo olvides.");
                            frameRegistro.limpiar();

                        } else {
                            JOptionPane.showMessageDialog(null, "No eres el administrador más sexy. Prueba otra vez o cambio de tipo de usuario");

                        }
                    } else {

                        UsuarioTb usuario = new UsuarioTb(frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena());
                        usuarioTbControlador.create(usuario);
                        escribirJson();
                        JOptionPane.showMessageDialog(null, "Su ID es el: " + usuario.getId() + " No lo olvides.");
                        frameRegistro.limpiar();

                    }
                }
                break;

            case "ModificarPanReg":
                System.out.println("ModificarPanReg");

                UsuarioTb usuarioB = usuarioTbControlador.findUsuarioTb(Integer.parseInt(frameRegistro.getTxtID()));

                usuarioB.setNombre(frameRegistro.getTxtNombre());
                usuarioB.setApellido(frameRegistro.getTxtApellido());
                usuarioB.setCorreo(frameRegistro.getTxtCorreo());
                usuarioB.setPais(frameRegistro.getTxtPais());
                usuarioB.setNombreUsuario(frameRegistro.getTxtNombreUsuario());
                usuarioB.setTipoUsuario(frameRegistro.getCboxTipo());
                usuarioB.setContrasena(frameRegistro.getTxtContrasena());

                //UsuarioTb usuarioModificar= new UsuarioTb(frameRegistro.getTxtNombre(), frameRegistro.getTxtApellido(), frameRegistro.getTxtCorreo(), frameRegistro.getTxtPais(), frameRegistro.getTxtNombreUsuario(), frameRegistro.getCboxTipo(), frameRegistro.getTxtContrasena());
                 {
                    try {
                        usuarioTbControlador.edit(usuarioB);
                        escribirJson();
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
                        escribirJson();
                        frameRegistro.limpiar();
                        frameRegistro.habilitarID();
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

            case "Reporte":
                System.out.println("entro");
                frameReporte.setDatosTabla(getDatosTabla(), UsuarioTb.ETIQUETAS_USUARIO);
                frameReporte.setVisible(true);
                break;

            case "Regresar":
                frameReporte.dispose();

        }
    }

}

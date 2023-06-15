/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

/**
 *
 * @author Drexler Guzman
 */
public class Perfil extends Caracteristicas{
    private String tipo_Usuario;

    public Perfil() {
    }

    public Perfil(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

    public Perfil(String tipo_Usuario, int id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
        this.tipo_Usuario = tipo_Usuario;
    }

    public String getTipo_Usuario() {
        return tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }
    
    
    
    
}

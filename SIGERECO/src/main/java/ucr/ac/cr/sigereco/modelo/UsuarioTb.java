/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Drexler Guzman
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioTb.findAll", query = "SELECT u FROM UsuarioTb u"),
    @NamedQuery(name = "UsuarioTb.findById", query = "SELECT u FROM UsuarioTb u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioTb.findByNombre", query = "SELECT u FROM UsuarioTb u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "UsuarioTb.findByApellido", query = "SELECT u FROM UsuarioTb u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "UsuarioTb.findByCorreo", query = "SELECT u FROM UsuarioTb u WHERE u.correo = :correo"),
    @NamedQuery(name = "UsuarioTb.findByPais", query = "SELECT u FROM UsuarioTb u WHERE u.pais = :pais"),
    @NamedQuery(name = "UsuarioTb.findByNombreUsuario", query = "SELECT u FROM UsuarioTb u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "UsuarioTb.findByTipoUsuario", query = "SELECT u FROM UsuarioTb u WHERE u.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "UsuarioTb.findByContrasena", query = "SELECT u FROM UsuarioTb u WHERE u.contrasena = :contrasena")})
public class UsuarioTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;

    public UsuarioTb() {
    }

    public UsuarioTb(Integer id) {
        this.id = id;
    }

    public UsuarioTb(String nombre, String apellido, String correo, String pais, String nombreUsuario, String tipoUsuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pais = pais;
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioTb)) {
            return false;
        }
        UsuarioTb other = (UsuarioTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ucr.ac.cr.sigereco.modelo.UsuarioTb[ id=" + id + " ]";
    }
    
}

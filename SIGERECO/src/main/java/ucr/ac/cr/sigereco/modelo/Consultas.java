/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.modelo;

import java.util.Date;

/**
 *
 * @author Drexler Guzman
 */
public class Consultas {
    
    private int id;
    private Date fechaHora;

    public Consultas() {
        
    }

    public Consultas(int id, Date fechaHora) {
        this.id = id;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.sigereco.modelo.Categoria;
import ucr.ac.cr.sigereco.modelo.Dificultad;
import ucr.ac.cr.sigereco.modelo.Ingrediente;
import ucr.ac.cr.sigereco.modelo.Ocasion;
import ucr.ac.cr.sigereco.modelo.Receta;
import ucr.ac.cr.sigereco.modelo.UnidadMedida;


public class ControladorRecetas implements ActionListener {
    
    private Receta receta;
    private Ingrediente ingrediente;
    private Dificultad dificultad;
    private UnidadMedida unidadMedida;
    private Categoria categoria;
    private Ocasion ocasion;
    

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}

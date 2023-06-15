/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucr.ac.cr.sigereco;

import ucr.ac.cr.sigereco.controlador.ControladorPrincipal;
import ucr.ac.cr.sigereco.controlador.ControladorUsuarios;

/**
 *
 * @author Drexler Guzman
 */
public class SIGERECO {

    private ControladorPrincipal controladorPrincipal;
    public SIGERECO() {
        controladorPrincipal=new ControladorPrincipal();
    }

    
    public static void main(String[] args) {
        new SIGERECO();
    }
}

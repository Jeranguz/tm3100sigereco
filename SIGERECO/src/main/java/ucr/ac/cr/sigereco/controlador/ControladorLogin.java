/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sigereco.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.sigereco.vista.FrameLogin;
import ucr.ac.cr.sigereco.vista.PanelBotones;
import ucr.ac.cr.sigereco.vista.PanelLogin;


/**
 *
 * @author XPC
 */
public class ControladorLogin implements ActionListener {
    
    private FrameLogin frameLogin;
    private PanelBotones panelBotones;
    private PanelLogin panelLogin;

    public ControladorLogin() {
        frameLogin = new FrameLogin(this);
        panelBotones= frameLogin.getPanelBotones();
        panelLogin = frameLogin.getPanelLogin();
        frameLogin.setVisible(true);
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
                frameLogin.setVisible(false);
                break;
        }
    }
    
    public static void main(String[] args) {
        new ControladorLogin();
    }
    
}

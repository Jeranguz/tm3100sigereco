/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.sigereco.vista;

import ucr.ac.cr.sigereco.controlador.ControladorPrincipal;

/**
 *
 * @author XPC
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        jMenuBar2.add(jMenuIIRegistrarse);
        jMenuBar2.add(jMenuIIniciarSesion);
        jMenuBar2.add(jMenuIAyuda);
    }
    
    public String getTxtCboxCategoria(){
    
        return panelConsulta1.getCboxCategoria();
    
    }
    
    public String getTxtcBoxOcasion(){
    
        return panelConsulta1.getCboxOcasion();
    
    }
    
    public String getTxtcBoxDificultad(){
    
        return panelConsulta1.getCboxDificultad();
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuIAyuda = new javax.swing.JMenuItem();
        jMenuIIRegistrarse = new javax.swing.JMenuItem();
        jMenuIIniciarSesion = new javax.swing.JMenuItem();
        panelConsulta1 = new ucr.ac.cr.sigereco.vista.PanelConsulta();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuIRecetario = new javax.swing.JMenuItem();
        jMenuIFavoritas = new javax.swing.JMenuItem();

        jMenuIAyuda.setText("Ayuda");
        jMenuIAyuda.setFocusable(true);
        jMenuIAyuda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuIAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuIIRegistrarse.setText("Registrarse");
        jMenuIIRegistrarse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuIIRegistrarse.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuIIniciarSesion.setText("Iniciar Sesion");
        jMenuIIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuIIniciarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelConsulta1.setOpaque(false);
        getContentPane().add(panelConsulta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 455, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Principal-02.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar2.setBackground(new java.awt.Color(112, 164, 215));

        jMenu1.setText("Explorador");

        jMenuIRecetario.setText("Recetario");
        jMenu1.add(jMenuIRecetario);

        jMenuIFavoritas.setText("Favoritas");
        jMenu1.add(jMenuIFavoritas);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuIAyuda;
    private javax.swing.JMenuItem jMenuIFavoritas;
    private javax.swing.JMenuItem jMenuIIRegistrarse;
    private javax.swing.JMenuItem jMenuIIniciarSesion;
    private javax.swing.JMenuItem jMenuIRecetario;
    private ucr.ac.cr.sigereco.vista.PanelConsulta panelConsulta1;
    // End of variables declaration//GEN-END:variables

    public void escuchar(ControladorPrincipal controladorPrincipal) {
        jMenuIAyuda.addActionListener(controladorPrincipal);
        jMenuIIRegistrarse.addActionListener(controladorPrincipal);
        jMenuIIniciarSesion.addActionListener(controladorPrincipal);
        jMenuIRecetario.addActionListener(controladorPrincipal);
        jMenuIFavoritas.addActionListener(controladorPrincipal);
        jMenuIFavoritas.setEnabled(false);
    }
    
    public void escucharPanelConsulta(ControladorPrincipal controladorPrincipal){
    
        panelConsulta1.escuchar(controladorPrincipal);
    
    }
}

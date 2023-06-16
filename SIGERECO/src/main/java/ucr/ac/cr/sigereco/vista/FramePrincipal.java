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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuIAyuda = new javax.swing.JMenuItem();
        jMenuIIRegistrarse = new javax.swing.JMenuItem();
        jMenuIIniciarSesion = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

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

        jMenu1.setText("Explorador");

        jMenuItem2.setText("Recetario");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Favoritas");
        jMenu1.add(jMenuItem3);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuIAyuda;
    private javax.swing.JMenuItem jMenuIIRegistrarse;
    private javax.swing.JMenuItem jMenuIIniciarSesion;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables

    public void escuchar(ControladorPrincipal controladorPrincipal) {
        jMenuIAyuda.addActionListener(controladorPrincipal);
        jMenuIIRegistrarse.addActionListener(controladorPrincipal);
        jMenuIIniciarSesion.addActionListener(controladorPrincipal);
        
    }
}

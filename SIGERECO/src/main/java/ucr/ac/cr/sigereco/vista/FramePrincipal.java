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
        panelConsulta1 = new ucr.ac.cr.sigereco.vista.PanelConsulta();
        panelTop101 = new ucr.ac.cr.sigereco.vista.PanelTop10();
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

        jMenu1.setText("Explorador");

        jMenuIRecetario.setText("Recetario");
        jMenu1.add(jMenuIRecetario);

        jMenuIFavoritas.setText("Favoritas");
        jMenu1.add(jMenuIFavoritas);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTop101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(panelConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTop101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuIAyuda;
    private javax.swing.JMenuItem jMenuIFavoritas;
    private javax.swing.JMenuItem jMenuIIRegistrarse;
    private javax.swing.JMenuItem jMenuIIniciarSesion;
    private javax.swing.JMenuItem jMenuIRecetario;
    private ucr.ac.cr.sigereco.vista.PanelConsulta panelConsulta1;
    private ucr.ac.cr.sigereco.vista.PanelTop10 panelTop101;
    // End of variables declaration//GEN-END:variables

    public void escuchar(ControladorPrincipal controladorPrincipal) {
        jMenuIAyuda.addActionListener(controladorPrincipal);
        jMenuIIRegistrarse.addActionListener(controladorPrincipal);
        jMenuIIniciarSesion.addActionListener(controladorPrincipal);
        jMenuIRecetario.addActionListener(controladorPrincipal);
        jMenuIFavoritas.addActionListener(controladorPrincipal);
        jMenuIFavoritas.setEnabled(false);
        
    }
}

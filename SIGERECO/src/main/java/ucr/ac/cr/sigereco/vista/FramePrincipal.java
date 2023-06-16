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
        jMenuBar1.add(jMenuIIRegistrarse);
        jMenuBar1.add(jMenuIIniciarSesion);
        jMenuBar1.add(jMenuIAyuda);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuIAyuda = new javax.swing.JMenuItem();
        jMenuIIRegistrarse = new javax.swing.JMenuItem();
        jMenuIIniciarSesion = new javax.swing.JMenuItem();
        panelConsulta1 = new ucr.ac.cr.sigereco.vista.PanelConsulta();
        panelTop101 = new ucr.ac.cr.sigereco.vista.PanelTop10();
        jMenuBar1 = new javax.swing.JMenuBar();

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
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(panelConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(panelTop101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panelTop101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(panelConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuIAyuda;
    private javax.swing.JMenuItem jMenuIIRegistrarse;
    private javax.swing.JMenuItem jMenuIIniciarSesion;
    private ucr.ac.cr.sigereco.vista.PanelConsulta panelConsulta1;
    private ucr.ac.cr.sigereco.vista.PanelTop10 panelTop101;
    // End of variables declaration//GEN-END:variables

    public void escuchar(ControladorPrincipal controladorPrincipal) {
        jMenuIAyuda.addActionListener(controladorPrincipal);
        jMenuIIRegistrarse.addActionListener(controladorPrincipal);
        jMenuIIniciarSesion.addActionListener(controladorPrincipal);
        
    }
}

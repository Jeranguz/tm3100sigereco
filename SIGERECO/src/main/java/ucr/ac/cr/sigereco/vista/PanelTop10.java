/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.sigereco.vista;

import javax.swing.JLabel;
import ucr.ac.cr.sigereco.controlador.ControladorPrincipal;

/**
 *
 * @author XPC
 */
public class PanelTop10 extends javax.swing.JPanel {

    /**
     * Creates new form PanelTop10
     */
    public PanelTop10() {
        initComponents();
    }

    public void setReceta1(String receta1) {
        jReceta1.setText(receta1);
    }

    public void setReceta10(String receta10) {
        jReceta10.setText(receta10);
    }

    public void setReceta2(String receta2) {
        jReceta2.setText(receta2);
    }

    public void setReceta3(String receta3) {
        jReceta3.setText(receta3);
    }

    public void setReceta4(String receta4) {
        jReceta4.setText(receta4);
    }

    public void setReceta5(String receta5) {
        jReceta5.setText(receta5);
    }

    public void setReceta6(String receta6) {
        jReceta6.setText(receta6);
    }

    public void setReceta7(String receta7) {
        jReceta7.setText(receta7);
    }

    public void setReceta8(String receta8) {
        jReceta8.setText(receta8);
    }

    public void setReceta9(String receta9) {
        jReceta9.setText(receta9);
    }
    
    public void escuchar(ControladorPrincipal controladorPrincipal){
        btnAtras.addActionListener(controladorPrincipal);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jReceta1 = new javax.swing.JLabel();
        jReceta2 = new javax.swing.JLabel();
        jReceta3 = new javax.swing.JLabel();
        jReceta4 = new javax.swing.JLabel();
        jReceta5 = new javax.swing.JLabel();
        jReceta6 = new javax.swing.JLabel();
        jReceta7 = new javax.swing.JLabel();
        jReceta8 = new javax.swing.JLabel();
        jReceta9 = new javax.swing.JLabel();
        jReceta10 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel1.setText("Top 10 recetas");

        jReceta1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta1.setText("jLabel2");

        jReceta2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta2.setText("jLabel3");

        jReceta3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta3.setText("jLabel4");

        jReceta4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta4.setText("jLabel5");

        jReceta5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta5.setText("jLabel6");

        jReceta6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta6.setText("jLabel7");

        jReceta7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta7.setText("jLabel8");

        jReceta8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta8.setText("jLabel9");

        jReceta9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta9.setText("jLabel10");

        jReceta10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jReceta10.setText("jLabel11");

        btnAtras.setText("Atras");
        btnAtras.setActionCommand("AtrasTop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jReceta2)
                            .addComponent(jReceta1)
                            .addComponent(jReceta3)
                            .addComponent(jReceta4)
                            .addComponent(jReceta5)
                            .addComponent(jReceta6)
                            .addComponent(jReceta7)
                            .addComponent(jReceta8)
                            .addComponent(jReceta9)
                            .addComponent(jReceta10))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnAtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jReceta1)
                .addGap(18, 18, 18)
                .addComponent(jReceta2)
                .addGap(18, 18, 18)
                .addComponent(jReceta3)
                .addGap(18, 18, 18)
                .addComponent(jReceta4)
                .addGap(18, 18, 18)
                .addComponent(jReceta5)
                .addGap(18, 18, 18)
                .addComponent(jReceta6)
                .addGap(18, 18, 18)
                .addComponent(jReceta7)
                .addGap(18, 18, 18)
                .addComponent(jReceta8)
                .addGap(18, 18, 18)
                .addComponent(jReceta9)
                .addGap(18, 18, 18)
                .addComponent(jReceta10)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jReceta1;
    private javax.swing.JLabel jReceta10;
    private javax.swing.JLabel jReceta2;
    private javax.swing.JLabel jReceta3;
    private javax.swing.JLabel jReceta4;
    private javax.swing.JLabel jReceta5;
    private javax.swing.JLabel jReceta6;
    private javax.swing.JLabel jReceta7;
    private javax.swing.JLabel jReceta8;
    private javax.swing.JLabel jReceta9;
    // End of variables declaration//GEN-END:variables

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.sigereco.vista;

import java.awt.event.ActionListener;


public class PanelLogin extends javax.swing.JPanel {

    public PanelLogin() {
        initComponents();
    }

    public String getTxtNombre() {
        if (txtNombre.getText().equals("")) {
            return "invalido";
        } else {
            return txtNombre.getText();
        }
    }

    public void setTxtNombre(String apellido) {
        this.txtNombre.setText(apellido);
    }

    public String getTxtApellido() {
        if (txtApellido.getText().equals("")) {
            return "invalido";
        } else {
            return txtApellido.getText();
        }
    }

    public void setTxtApellido(String apellido) {
        this.txtApellido.setText(apellido);
    }

    public String getTxtCorreo() {
        if (txtCorreo.getText().equals("")) {
            return "invalido";
        } else {
            return txtCorreo.getText();
        }
    }

    public void setTxtCorreo(String correo) {
        this.txtCorreo.setText(correo);
    }

    public String getTxtNombreUsuario() {
        if (txtNombreUsuario.getText().equals("")) {
            return "invalido";
        } else {
            return txtNombreUsuario.getText();
        }
    }

    public void setTxtNombreUsuario(String nombreUsuario) {
        this.txtNombreUsuario.setText(nombreUsuario);
    }

    public String getTxtPais() {
        if (txtPais.getText().equals("")) {
            return "invalido";
        } else {
            return txtPais.getText();
        }
    }

    public void setTxtPais(String pais) {
        this.txtPais.setText(pais);
    }
    
    public String getTxtContrasena() {
        if (txtContrasena.getText().equals("")) {
            return "invalido";
        } else {
            return txtContrasena.getText();
        }
    }

    public void setTxtContrasena(String contrasena) {
        this.txtContrasena.setText(contrasena);
    }
    
    public String getJComboTipo() {
        return jComboTipo.getSelectedItem().toString();
    }

    public void setCboxGenero(String jComboTipo) {
        this.jComboTipo.setSelectedItem(jComboTipo);
    }
    
    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtNombreUsuario.setText("");
        txtPais.setText("");
        txtContrasena.setText("");
    }
    
    public void escuchar (ActionListener controlador){
        txtNombre.addActionListener(controlador);
        txtApellido.addActionListener(controlador);
        txtCorreo.addActionListener(controlador);
        txtNombreUsuario.addActionListener(controlador);
        txtPais.addActionListener(controlador);
        txtContrasena.addActionListener(controlador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboTipo = new javax.swing.JComboBox<>();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo:");

        jLabel4.setText("Nombre de usuario:");

        jLabel5.setText("Pais:");

        jLabel6.setText("Contraseña:");

        jLabel7.setText("Tipo usuario:");

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Consultor" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addGap(38, 38, 38)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreUsuario)
                            .addComponent(txtPais)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}

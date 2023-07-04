/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.sigereco.vista;

import java.awt.event.ActionListener;
import ucr.ac.cr.sigereco.controlador.ControladorPrincipal;
import ucr.ac.cr.sigereco.controlador.ControladorUsuarios;


public class PanelRegistro extends javax.swing.JPanel {

    public PanelRegistro() {
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
    
    public String getCboxTipo() {
        return cBoxTipoUsuario.getSelectedItem().toString();
    }

    public void setCboxTipo(String jComboTipo) {
        this.cBoxTipoUsuario.setSelectedItem(jComboTipo);
    }
    
    public String getTxtID(){
    
        return txtID.getText();
    
    }
    
    public void setTxtID(String ID){
    
        txtID.setText(ID);
    
    }
    
    public void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtNombreUsuario.setText("");
        txtPais.setText("");
        txtContrasena.setText("");
        txtID.setText("");
    }
    
    public void escuchar (ControladorUsuarios controladorUsuarios){

          btnEliminar.addActionListener(controladorUsuarios);
          btnModificar.addActionListener(controladorUsuarios);
          btnSalir.addActionListener(controladorUsuarios);
          btnUsuarios.addActionListener(controladorUsuarios);
          btnAgregar.addActionListener(controladorUsuarios);
          btnReporte.addActionListener(controladorUsuarios);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblPais = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        lblTipoUsuario = new javax.swing.JLabel();
        cBoxTipoUsuario = new javax.swing.JComboBox<>();
        btnReporte = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        lblCod = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, 179, -1));

        lblNombre.setText("Nombre:");
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 14, -1, -1));

        lblApellido.setText("Apellido:");
        add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 14, -1, -1));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 36, 213, -1));

        lblCorreo.setText("Correo:");
        add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 76, -1, -1));
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 98, 213, -1));

        lblNombreUsuario.setText("Nombre de usuario:");
        add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 138, -1, -1));
        add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 160, 179, -1));

        lblPais.setText("Pais:");
        add(lblPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 76, -1, -1));
        add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 98, 179, -1));

        lblContrasena.setText("Contraseña:");
        add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 138, -1, -1));
        add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 160, 213, -1));

        lblTipoUsuario.setText("Tipo usuario:");
        add(lblTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 214, -1, -1));

        cBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Consultor" }));
        add(cBoxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 211, -1, -1));

        btnReporte.setBackground(new java.awt.Color(114, 192, 160));
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("Reporte");
        add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 80, -1));

        btnModificar.setBackground(new java.awt.Color(114, 192, 160));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setActionCommand("ModificarPanReg");
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 80, -1));

        btnEliminar.setBackground(new java.awt.Color(114, 192, 160));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setActionCommand("EliminarPanReg");
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 80, -1));

        btnUsuarios.setBackground(new java.awt.Color(114, 192, 160));
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("Buscar");
        btnUsuarios.setActionCommand("BuscarPanReg");
        add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 81, -1));

        btnSalir.setBackground(new java.awt.Color(114, 192, 160));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setActionCommand("SalirPanReg");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 70, -1));
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 211, 160, -1));

        lblCod.setText("ID:");
        add(lblCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(114, 192, 160));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setActionCommand("AgregarPanReg");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 70, -1));

        jLabel3.setText("*");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 10, -1));

        jLabel2.setText("(*) si deseas modificar o eliminar su informacion escriba si ID y presione buscar");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Registro.jpg.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JComboBox<String> cBoxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables

    public void bloquearID() {
        txtID.setEnabled(false);
    }
    
    public void habilitarID() {
        txtID.setEnabled(true);
    }
}

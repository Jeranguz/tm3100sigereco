/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.sigereco.vista;

import ucr.ac.cr.sigereco.controlador.ControladorPrincipal;

/**
 *
 * @author XPC
 */
public class PanelConsulta extends javax.swing.JPanel {

    /**
     * Creates new form PanelConsulta
     */
    public PanelConsulta() {
        initComponents();
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
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cBoxCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cBoxOcasion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cBoxDificultad = new javax.swing.JComboBox<>();
        btnMostrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Categoria:");

        cBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Desayuno", "Bebidas", "Entradas", "Almuerzo", "Postre", "Sopa" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Ocasion:");

        cBoxOcasion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Cumpleaños", "Día del padre", "Día de la madre", "Día del niño", "Navidad", "Semana Santa", "Verano" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Dificultad");

        cBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Fácil", "Intermedio", "Avanzado" }));

        btnMostrar.setText("Mostrar");
        btnMostrar.setActionCommand("MostrarConsulta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cBoxDificultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(cBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cBoxOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMostrar)
                        .addGap(33, 33, 33)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cBoxOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnMostrar)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void escuchar(ControladorPrincipal controladorPrincipal) {
        btnMostrar.addActionListener(controladorPrincipal);
    }
    
    public String getCboxCategoria() {
        return cBoxCategoria.getSelectedItem().toString();
    }

    public void setCBoxCategoria(String cBoxCategoria) {
        this.cBoxCategoria.setSelectedItem(cBoxCategoria);
    }
    
    public String getCboxDificultad() {
        return cBoxDificultad.getSelectedItem().toString();
    }

    public void setCBoxDificultad(String cBoxDificultad) {
        this.cBoxDificultad.setSelectedItem(cBoxDificultad);
    }
    
    public String getCboxOcasion() {
        return cBoxOcasion.getSelectedItem().toString();
    }

    public void setCBoxOcasion(String cBoxOcasion) {
        this.cBoxOcasion.setSelectedItem(cBoxOcasion);
    }
    
    public String getTxtNombre() {
        if (txtNombre.getText().equals("")) {
            return "invalido";
        } else {
            return txtNombre.getText();
        }
    }

    public void setTxtNombre(String nombre) {

        this.txtNombre.setText(nombre);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<String> cBoxCategoria;
    private javax.swing.JComboBox<String> cBoxDificultad;
    private javax.swing.JComboBox<String> cBoxOcasion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

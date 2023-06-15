/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.sigereco.vista;

/**
 *
 * @author Drexler Guzman
 */
public class PanelAdmin extends javax.swing.JPanel {

    /**
     * Creates new form PanelAdmin
     */
    public PanelAdmin() {
        initComponents();
        buttonGroup1.add(rBtnIngredientes);
        buttonGroup1.add(rBtnRecetas);
        buttonGroup1.add(rBtnUnidades);
    }
    
//    public void escuchar(ControladorPrincipal controladorPrincipal){
//    
//        btnAgregIngr.addActionListener(controladorPrincipal);
//        btnAgregUnid.addActionListener(controladorPrincipal);
//        btnAgregarIngr.addActionListener(controladorPrincipal);
//        btnAgregarRecet.addActionListener(controladorPrincipal);
//        btnBusIngr.addActionListener(controladorPrincipal);
//        btnBuscarIdRecet.addActionListener(controladorPrincipal);
//        btnBuscarImagen.addActionListener(controladorPrincipal);
//        btnBuscarUnid.addActionListener(controladorPrincipal);
//        btnElimiIngr.addActionListener(controladorPrincipal);
//        btnElimiUnid.addActionListener(controladorPrincipal);
//        btnEliminRecet.addActionListener(controladorPrincipal);
//        btnModifIngr.addActionListener(controladorPrincipal);
//        btnModifRecet.addActionListener(controladorPrincipal);
//        btnModifUnid.addActionListener(controladorPrincipal);
//    
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelAdmin = new javax.swing.JPanel();
        rBtnRecetas = new javax.swing.JRadioButton();
        rBtnIngredientes = new javax.swing.JRadioButton();
        rBtnUnidades = new javax.swing.JRadioButton();
        jPnlRecetas = new javax.swing.JPanel();
        lblNombreRecet = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTiempPrep = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTiempcoccion = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        btnBuscarImagen = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableIngredientes = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCBoxCategoria = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jCBoxOcasion = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jCBoxIngrediente = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        jCBoxUnidad = new javax.swing.JComboBox<>();
        btnAgregarIngr = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaInstrucciones = new javax.swing.JTextArea();
        btnAgregarRecet = new javax.swing.JButton();
        btnBuscarIdRecet = new javax.swing.JButton();
        lblIdRecet = new javax.swing.JLabel();
        txtIdRecet = new javax.swing.JTextField();
        btnModifRecet = new javax.swing.JButton();
        btnEliminRecet = new javax.swing.JButton();
        jSpinnerPorciones = new javax.swing.JSpinner();
        txtNombreRecet = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        jPanelIngredientes = new javax.swing.JPanel();
        lblNombreIngr = new javax.swing.JLabel();
        lblDescrIngr = new javax.swing.JLabel();
        btnBusIngr = new javax.swing.JButton();
        btnAgregIngr = new javax.swing.JButton();
        btnModifIngr = new javax.swing.JButton();
        btnElimiIngr = new javax.swing.JButton();
        txtNombreIngre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripIngre = new javax.swing.JTextArea();
        jPanelUnidades = new javax.swing.JPanel();
        lblNombreUnid = new javax.swing.JLabel();
        txtNombreUnid = new javax.swing.JTextField();
        btnBuscarUnid = new javax.swing.JButton();
        btnAgregUnid = new javax.swing.JButton();
        btnModifUnid = new javax.swing.JButton();
        btnElimiUnid = new javax.swing.JButton();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 800));

        jPanelAdmin.setName(""); // NOI18N
        jPanelAdmin.setPreferredSize(new java.awt.Dimension(1280, 800));

        rBtnRecetas.setText("Recetas");

        rBtnIngredientes.setText("Ingredientes");

        rBtnUnidades.setText("unidades");

        jPnlRecetas.setBorder(javax.swing.BorderFactory.createTitledBorder("Recetas"));
        jPnlRecetas.setToolTipText("Recetas");

        lblNombreRecet.setText("Nombre:");

        jLabel21.setText("Tiempo preparación:");

        jLabel22.setText("min");

        jLabel23.setText("Tiempo cocción:");

        jLabel24.setText("min");

        jLabel25.setText("Imagen:");

        btnBuscarImagen.setText("Buscar");
        btnBuscarImagen.setActionCommand("BuscarImagen");

        jTableIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Unidad"
            }
        ));
        jScrollPane5.setViewportView(jTableIngredientes);

        jLabel26.setText("Lista de ingredientes");

        jLabel27.setText("Porciones:");

        jLabel28.setText("Categoría:");

        jLabel29.setText("Ocasión:");

        jLabel30.setText("Ingrediente");

        jLabel31.setText("Cantidad:");

        jLabel32.setText("Unidad");

        btnAgregarIngr.setText("Agregar");
        btnAgregarIngr.setActionCommand("AgregarIngr");

        jLabel33.setText("Descripción:");

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane6.setViewportView(jTextAreaDescripcion);

        jLabel34.setText("Instrucciones:");

        jTextAreaInstrucciones.setColumns(20);
        jTextAreaInstrucciones.setRows(5);
        jScrollPane7.setViewportView(jTextAreaInstrucciones);

        btnAgregarRecet.setText("Agregar");

        btnBuscarIdRecet.setText("Buscar");

        lblIdRecet.setText("ID receta");

        btnModifRecet.setText("Modificar");

        btnEliminRecet.setText("Eliminar");

        lblImagen.setText("Imagen");

        javax.swing.GroupLayout jPnlRecetasLayout = new javax.swing.GroupLayout(jPnlRecetas);
        jPnlRecetas.setLayout(jPnlRecetasLayout);
        jPnlRecetasLayout.setHorizontalGroup(
            jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlRecetasLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreRecet)
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addComponent(lblIdRecet)
                                .addGap(29, 29, 29)
                                .addComponent(txtIdRecet, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarIdRecet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addGap(156, 156, 156))
                    .addGroup(jPnlRecetasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel33))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane7)
                                .addGap(19, 19, 19)))))
                .addContainerGap())
            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreRecet, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPnlRecetasLayout.createSequentialGroup()
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnAgregarIngr, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81))
                    .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPnlRecetasLayout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarImagen))
                        .addGroup(jPnlRecetasLayout.createSequentialGroup()
                            .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                    .addComponent(txtTiempcoccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel24))
                                .addGroup(jPnlRecetasLayout.createSequentialGroup()
                                    .addComponent(txtTiempPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel22))))
                        .addGroup(jPnlRecetasLayout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpinnerPorciones, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCBoxOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(lblImagen)
                .addGap(118, 118, 118)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnAgregarRecet)
                .addGap(174, 174, 174)
                .addComponent(btnModifRecet)
                .addGap(194, 194, 194)
                .addComponent(btnEliminRecet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlRecetasLayout.setVerticalGroup(
            jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlRecetasLayout.createSequentialGroup()
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdRecet)
                    .addComponent(btnBuscarIdRecet)
                    .addComponent(txtIdRecet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPnlRecetasLayout.createSequentialGroup()
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreRecet)
                            .addComponent(txtNombreRecet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtTiempPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtTiempcoccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarImagen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27)
                            .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSpinnerPorciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)
                                .addComponent(jCBoxOcasion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29)
                                .addComponent(lblImagen)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jCBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarIngr)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPnlRecetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarRecet)
                    .addComponent(btnModifRecet)
                    .addComponent(btnEliminRecet))
                .addContainerGap())
        );

        jPanelIngredientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingredientes"));
        jPanelIngredientes.setToolTipText("");

        lblNombreIngr.setText("Nombre:");

        lblDescrIngr.setText("Descripcion:");

        btnBusIngr.setText("Buscar");

        btnAgregIngr.setText("Agregar");

        btnModifIngr.setText("Modificar");

        btnElimiIngr.setText("Eliminar");

        txtDescripIngre.setColumns(20);
        txtDescripIngre.setRows(5);
        jScrollPane1.setViewportView(txtDescripIngre);

        javax.swing.GroupLayout jPanelIngredientesLayout = new javax.swing.GroupLayout(jPanelIngredientes);
        jPanelIngredientes.setLayout(jPanelIngredientesLayout);
        jPanelIngredientesLayout.setHorizontalGroup(
            jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngredientesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblNombreIngr)
                .addGap(38, 38, 38)
                .addComponent(txtNombreIngre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(lblDescrIngr)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, Short.MAX_VALUE))
            .addGroup(jPanelIngredientesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnBusIngr)
                .addGap(104, 104, 104)
                .addComponent(btnAgregIngr)
                .addGap(99, 99, 99)
                .addComponent(btnModifIngr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnElimiIngr)
                .addGap(65, 65, 65))
        );
        jPanelIngredientesLayout.setVerticalGroup(
            jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngredientesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombreIngr)
                        .addComponent(txtNombreIngre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDescrIngr))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifIngr)
                    .addComponent(btnAgregIngr)
                    .addComponent(btnElimiIngr)
                    .addComponent(btnBusIngr))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanelUnidades.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidades"));

        lblNombreUnid.setText("Nombre:");

        btnBuscarUnid.setText("Buscar");

        btnAgregUnid.setText("Agregar");

        btnModifUnid.setText("Modificar");

        btnElimiUnid.setText("Eliminar");

        javax.swing.GroupLayout jPanelUnidadesLayout = new javax.swing.GroupLayout(jPanelUnidades);
        jPanelUnidades.setLayout(jPanelUnidadesLayout);
        jPanelUnidadesLayout.setHorizontalGroup(
            jPanelUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUnidadesLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblNombreUnid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNombreUnid, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanelUnidadesLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnBuscarUnid)
                .addGap(18, 18, 18)
                .addComponent(btnAgregUnid)
                .addGap(18, 18, 18)
                .addComponent(btnModifUnid)
                .addGap(18, 18, 18)
                .addComponent(btnElimiUnid)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanelUnidadesLayout.setVerticalGroup(
            jPanelUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUnidadesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUnid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanelUnidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarUnid)
                    .addComponent(btnAgregUnid)
                    .addComponent(btnModifUnid)
                    .addComponent(btnElimiUnid))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addComponent(rBtnRecetas)
                        .addGap(45, 45, 45)
                        .addComponent(rBtnIngredientes)
                        .addGap(39, 39, 39)
                        .addComponent(rBtnUnidades))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPnlRecetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                                .addComponent(jPanelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtnRecetas)
                    .addComponent(rBtnIngredientes)
                    .addComponent(rBtnUnidades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPnlRecetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregIngr;
    private javax.swing.JButton btnAgregUnid;
    private javax.swing.JButton btnAgregarIngr;
    private javax.swing.JButton btnAgregarRecet;
    private javax.swing.JButton btnBusIngr;
    private javax.swing.JButton btnBuscarIdRecet;
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.JButton btnBuscarUnid;
    private javax.swing.JButton btnElimiIngr;
    private javax.swing.JButton btnElimiUnid;
    private javax.swing.JButton btnEliminRecet;
    private javax.swing.JButton btnModifIngr;
    private javax.swing.JButton btnModifRecet;
    private javax.swing.JButton btnModifUnid;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jCBoxCategoria;
    private javax.swing.JComboBox<String> jCBoxIngrediente;
    private javax.swing.JComboBox<String> jCBoxOcasion;
    private javax.swing.JComboBox<String> jCBoxUnidad;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelIngredientes;
    private javax.swing.JPanel jPanelUnidades;
    private javax.swing.JPanel jPnlRecetas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSpinner jSpinnerCantidad;
    private javax.swing.JSpinner jSpinnerPorciones;
    private javax.swing.JTable jTableIngredientes;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextArea jTextAreaInstrucciones;
    private javax.swing.JLabel lblDescrIngr;
    private javax.swing.JLabel lblIdRecet;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombreIngr;
    private javax.swing.JLabel lblNombreRecet;
    private javax.swing.JLabel lblNombreUnid;
    private javax.swing.JRadioButton rBtnIngredientes;
    private javax.swing.JRadioButton rBtnRecetas;
    private javax.swing.JRadioButton rBtnUnidades;
    private javax.swing.JTextArea txtDescripIngre;
    private javax.swing.JTextField txtIdRecet;
    private javax.swing.JTextField txtImagen;
    private javax.swing.JTextField txtNombreIngre;
    private javax.swing.JTextField txtNombreRecet;
    private javax.swing.JTextField txtNombreUnid;
    private javax.swing.JTextField txtTiempPrep;
    private javax.swing.JTextField txtTiempcoccion;
    // End of variables declaration//GEN-END:variables
}
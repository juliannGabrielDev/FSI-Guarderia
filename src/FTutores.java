
import Util.Conexion;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FTutores extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    String id;
    String nombre;

    String entradasMensualesInfantes;
    String infantes;
    String infa;

    //-----------------------------------------------------------------------------------------------------------------------------------------/
    public FTutores() {
        initComponents();
        setLocationRelativeTo(this);
        // Ordena elementos de la tabla a la columna seleccionada 
        DefaultTableModel modelo1 = (DefaultTableModel) TConsultas.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) TInfantes.getModel();
        TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<>(modelo1);
        TConsultas.setRowSorter(sorter1);
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(modelo2);
        TInfantes.setRowSorter(sorter2);

    }

    public void recibirDatos(Conexion cnx, String id, String nombre) {
        this.cnx = cnx;
        this.id = id;
        this.nombre = nombre;

        infantes = "SELECT * FROM vw_infantes_por_tutor WHERE idTutor = " + id;
        entradasMensualesInfantes = "SELECT * FROM vw_entradas_mensuales_infantes WHERE idTutor = " + id;
        
        // Esto es para poner datos en etiquetas.
        LId.setText(id);
        LNombre.setText(nombre);
        cnx.entablar(entradasMensualesInfantes, TConsultas);
        cnx.entablar(infantes, TInfantes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        LId = new javax.swing.JLabel();
        LNombre = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TInfantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TNomHi = new javax.swing.JTextField();
        LFotoTu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LFotoH = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBIdInfa = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        BAuxiliar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BPermiso = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        BInfantes = new javax.swing.JButton();
        BEntradasMes = new javax.swing.JButton();
        BReporte1 = new javax.swing.JButton();
        CBMes = new javax.swing.JComboBox<>();
        BReporte2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tutores");

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        LId.setBackground(new java.awt.Color(51, 153, 255));
        LId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LId.setOpaque(true);

        LNombre.setBackground(new java.awt.Color(51, 153, 255));
        LNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LNombre.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ID:");

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("NOMBRE:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TInfantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TInfantes);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Id INFANTE:");

        TNomHi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LFotoTu.setBackground(new java.awt.Color(255, 153, 153));
        LFotoTu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LFotoTu.setOpaque(true);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FOTO HIJO:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FOTO TUTOR:");

        LFotoH.setBackground(new java.awt.Color(255, 153, 153));
        LFotoH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LFotoH.setOpaque(true);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NOMBRE HIJO:");

        CBIdInfa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setToolTipText("");

        BAuxiliar.setBackground(new java.awt.Color(153, 255, 153));
        BAuxiliar.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        BAuxiliar.setText("AUXILIAR");
        BAuxiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAuxiliarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 204, 153));
        jLabel2.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GENERAR PERMISOS");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 102), null, null));
        jLabel2.setOpaque(true);

        BPermiso.setBackground(new java.awt.Color(153, 255, 153));
        BPermiso.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        BPermiso.setText("PERMISO");
        BPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPermisoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(BAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TConsultas.setToolTipText("");
        jScrollPane2.setViewportView(TConsultas);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INFANTES");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CONSULTAS");

        jToolBar1.setBackground(new java.awt.Color(153, 153, 255));
        jToolBar1.setRollover(true);

        BInfantes.setText("INFANTES");
        BInfantes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BInfantes.setFocusable(false);
        BInfantes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BInfantes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BInfantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInfantesActionPerformed(evt);
            }
        });
        jToolBar1.add(BInfantes);

        BEntradasMes.setText("ENTRADAS POR MES");
        BEntradasMes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BEntradasMes.setFocusable(false);
        BEntradasMes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BEntradasMes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BEntradasMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEntradasMesActionPerformed(evt);
            }
        });
        jToolBar1.add(BEntradasMes);

        BReporte1.setText("REPORTE.-1");
        BReporte1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BReporte1.setFocusable(false);
        BReporte1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BReporte1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReporte1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BReporte1);

        CBMes.setBackground(new java.awt.Color(204, 255, 255));
        CBMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Enero", "Febrero", "Marzo", "Abril ", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre" }));
        CBMes.setMaximumSize(new java.awt.Dimension(150, 50));
        CBMes.setMinimumSize(new java.awt.Dimension(150, 50));
        CBMes.setPreferredSize(new java.awt.Dimension(150, 50));
        CBMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBMesItemStateChanged(evt);
            }
        });
        jToolBar1.add(CBMes);

        BReporte2.setText("REPORTE.-2");
        BReporte2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BReporte2.setFocusable(false);
        BReporte2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BReporte2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReporte2ActionPerformed(evt);
            }
        });
        jToolBar1.add(BReporte2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TNomHi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CBIdInfa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LFotoTu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LFotoH, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(LFotoTu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(LFotoH, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBIdInfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TNomHi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)))
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAuxiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAuxiliarActionPerformed
        JDAuxiliar per = new JDAuxiliar(this, true);
        per.setVisible(true);
    }//GEN-LAST:event_BAuxiliarActionPerformed

    private void BPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPermisoActionPerformed
        JDPermiso pms = new JDPermiso(this, true);
        pms.setVisible(true);
    }//GEN-LAST:event_BPermisoActionPerformed

    private void BInfantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInfantesActionPerformed
        cnx.entablar(infantes, TConsultas);
    }//GEN-LAST:event_BInfantesActionPerformed

    private void BReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReporte1ActionPerformed
        String reporteSinParametroMes = System.getProperty("user.dir") + "/entradasTutor.jasper";
        String reporteConParametroMes = System.getProperty("user.dir") + "/entradasTutorPorMes.jasper";

        Map parametros = new HashMap();
        int mesNumero = CBMes.getSelectedIndex();

        if (CBMes.getSelectedIndex() == 0) {
            parametros.put("tutores", this.id);
            if (cnx.ejecutarReporte(reporteSinParametroMes, parametros) == 0) {
                JOptionPane.showMessageDialog(this,
                        "Error al ejecutar el reporte.\nVerifique la consola para más detalles.\nArchivo: " + reporteSinParametroMes,
                        "Error en Reporte 1",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            parametros.put("tutores", this.id);
            parametros.put("mes", mesNumero);

            System.out.println("Intentando abrir reporte: " + reporteConParametroMes);
            if (cnx.ejecutarReporte(reporteConParametroMes, parametros) == 0) {
                JOptionPane.showMessageDialog(this,
                        "Error al ejecutar el reporte.\nVerifique la consola para más detalles.\nArchivo: " + reporteConParametroMes,
                        "Error en Reporte 1",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BReporte1ActionPerformed

    private void BReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReporte2ActionPerformed
        String reporte = System.getProperty("user.dir") + "/infantes_por_tutor.jasper";
        Map parametros = new HashMap();
        parametros.put("tutor", this.id);

        System.out.println("Intentando abrir reporte: " + reporte);
        if (cnx.ejecutarReporte(reporte, parametros) == 0) {
            JOptionPane.showMessageDialog(this,
                    "Error al ejecutar el reporte.\nVerifique la consola para más detalles.\nArchivo: " + reporte,
                    "Error en Reporte 1",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BReporte2ActionPerformed

    private void BEntradasMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEntradasMesActionPerformed
        cnx.entablar(entradasMensualesInfantes, TConsultas);
    }//GEN-LAST:event_BEntradasMesActionPerformed

    private void CBMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBMesItemStateChanged
        if (CBMes.getSelectedIndex() == 0) {
            cnx.entablar(entradasMensualesInfantes, TConsultas);
            return;
        }
        int mesNumero = CBMes.getSelectedIndex();
        String sql2 = entradasMensualesInfantes + " AND mes = " + mesNumero;
        cnx.entablar(sql2, TConsultas);
    }//GEN-LAST:event_CBMesItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTutores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAuxiliar;
    private javax.swing.JButton BEntradasMes;
    private javax.swing.JButton BInfantes;
    private javax.swing.JButton BPermiso;
    private javax.swing.JButton BReporte1;
    private javax.swing.JButton BReporte2;
    private javax.swing.JComboBox<String> CBIdInfa;
    private javax.swing.JComboBox<String> CBMes;
    private javax.swing.JLabel LFotoH;
    private javax.swing.JLabel LFotoTu;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNombre;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTable TInfantes;
    private javax.swing.JTextField TNomHi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

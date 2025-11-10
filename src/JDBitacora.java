
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JDBitacora extends javax.swing.JDialog {

    Conexion cnx = new Conexion();

    // Consulta para buscar por nombre
    String nomInfante = "SELECT * FROM movimientos_infantes WHERE Nombre_Infante LIKE '%";
    // Consulta para la tabla de entradas y salidas
    String entradas_salidas = "SELECT * FROM movimientos_infantes WHERE ID_Infante ORDER BY Fecha";

    public JDBitacora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);

        if (cnx.conectar("localhost", "guarderia", "root", "") == 1) {
            cnx.entablar(entradas_salidas, TMovimientos);

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar.");
            System.exit(0);
        }
        // Ordena elementos de la tabla a la columna seleccionada 
        DefaultTableModel modelo1 = (DefaultTableModel) TMovimientos.getModel();
        TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<>(modelo1);
        TMovimientos.setRowSorter(sorter1);

        // Esto de aquí es para que automaticamente filtre la fecha + nombre 
        // sin necesidad de presionar un boton
        JDCFecha.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Solo reaccionar cuando cambia la propiedad 'date'
                if ("date".equals(evt.getPropertyName())) {
                    aplicarFiltro(); // Llama al método de filtrado 
                }
            }
        });
        
    }

    // MÉTODO: Lógica de filtrado combinado
    private void aplicarFiltro() {
        // La consulta base siempre empieza con WHERE 1=1 para añadir condiciones fácilmente
        String sql = "SELECT * FROM movimientos_infantes WHERE 1=1";

        String nombreInfante = TBuscar.getText().trim();// NOTA: .trim() es para eliminar espacios en blanco
        Date fecha = JDCFecha.getDate();// Obtiene la fecha

        // A. Aplicar filtro por Nombre del Infante (si el campo de texto no está vacío)
        if (!nombreInfante.isEmpty()) {// NOTA: .isEmpty() sirve para determinar si una cadena de texto está completamente vacía
           
            sql += " AND Nombre_Infante LIKE '%" + nombreInfante + "%'"; // Se usa LIKE para búsqueda parcial
        }

        // B. Aplicar filtro por Fecha (si se ha seleccionado una fecha en el JDateChooser)
        if (fecha != null) {
            try {
                // Formatear la fecha a 'AAAA-MM-DD' que es el formato de la columna 'Fecha' en la vista
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaSQL = sdf.format(fecha);
                sql += " AND Fecha = '" + fechaSQL + "'";
            } catch (Exception e) {
                // En caso de error de formato
                JOptionPane.showMessageDialog(this, "Error al formatear la fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // C. Ordenar el resultado
        sql += " ORDER BY Fecha DESC, Hora_Entrada ASC";

        // D. Ejecutar la consulta en la tabla
        cnx.entablar(sql, TMovimientos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TMovimientos = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        BLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TBuscar = new javax.swing.JTextField();
        JDCFecha = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bitácora");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TMovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TMovimientos);

        jToolBar1.setBackground(new java.awt.Color(51, 153, 255));
        jToolBar1.setForeground(new java.awt.Color(0, 0, 0));
        jToolBar1.setRollover(true);

        BLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        BLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        BLimpiar.setText("LIMPIAR");
        BLimpiar.setFocusable(false);
        BLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BLimpiar.setMaximumSize(new java.awt.Dimension(70, 50));
        BLimpiar.setMinimumSize(new java.awt.Dimension(70, 50));
        BLimpiar.setPreferredSize(new java.awt.Dimension(70, 50));
        BLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(BLimpiar);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("FILTRAR NOMBRE:");
        jToolBar1.add(jLabel1);

        TBuscar.setMaximumSize(new java.awt.Dimension(130, 50));
        TBuscar.setMinimumSize(new java.awt.Dimension(130, 50));
        TBuscar.setPreferredSize(new java.awt.Dimension(130, 50));
        TBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TBuscarKeyTyped(evt);
            }
        });
        jToolBar1.add(TBuscar);

        JDCFecha.setMaximumSize(new java.awt.Dimension(130, 50));
        JDCFecha.setMinimumSize(new java.awt.Dimension(130, 50));
        JDCFecha.setPreferredSize(new java.awt.Dimension(130, 50));
        jToolBar1.add(JDCFecha);

        jLabel12.setBackground(new java.awt.Color(0, 51, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("BITÁCORA DE ENTRADAS Y SALIDAS DE INFANTES");
        jLabel12.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimpiarActionPerformed
        TBuscar.setText("");
        JDCFecha.setDate(null);
        cnx.entablar(entradas_salidas, TMovimientos);
    }//GEN-LAST:event_BLimpiarActionPerformed

    private void TBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBuscarKeyTyped
        // Busca por nombre
        String nombrein = TBuscar.getText();
        String sql = nomInfante + nombrein + "%'";
        cnx.entablar(sql, TMovimientos);
    }//GEN-LAST:event_TBuscarKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Para desconectar
        if (cnx != null) {
            cnx.desconectar();
        }
    }//GEN-LAST:event_formWindowClosing

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {

        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDBitacora dialog = new JDBitacora(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLimpiar;
    private com.toedter.calendar.JDateChooser JDCFecha;
    private javax.swing.JTextField TBuscar;
    private javax.swing.JTable TMovimientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

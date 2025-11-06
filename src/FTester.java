
import javax.swing.JOptionPane;

public class FTester extends javax.swing.JFrame {

    Conexion cnx = new Conexion();

    String admin1 = "SELECT i.idInfante, nombreinf, MONTH(fechaEntrada) AS mes, COUNT(*) AS total "
            + "FROM infantes i "
            + "JOIN entradas e  ON i.idInfante = e.idInfante "
            + "GROUP BY i.idInfante, MONTH(fechaEntrada) ";

    String tutor1 = "SELECT idTutor, i.idInfante, nombreinf, MONTH(fechaEntrada) AS mes, COUNT(*) AS total "
            + "FROM infantes i "
            + "JOIN entradas e  ON i.idInfante = e.idInfante "
            + "WHERE idTutor = 1 "
            + "GROUP BY i.idInfante, MONTH(fechaEntrada) ";

    String aux1 = "SELECT idAutorizado, i.idInfante, nombreinf, MONTH(fechaSalida) AS mes, COUNT(*) AS total "
            + "FROM infantes i "
            + "JOIN salidas s  ON i.idInfante = s.idInfante "
            + "WHERE idAutorizado = 1 AND tipoAutorizado = 'Auxiliar' "
            + "GROUP BY i.idInfante, MONTH(fechaSalida) ";

    String edu1 = "SELECT idEducadora, i.idInfante, nombreinf, MONTH(fechaEntrada) AS mes, COUNT(*) AS total "
            + "FROM infantes i "
            + "JOIN entradas e  ON i.idInfante = e.idInfante ";

    public FTester() {
        initComponents();
        setLocationRelativeTo(this);

        //if para conectar ala Base de datos
        if (cnx.conectar("localhost", "guarderia", "root", "") == 1) {
            JOptionPane.showMessageDialog(this, "Conectado.");
            cnx.entablar(admin1, TConsultas);

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar.");
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BAdmin1 = new javax.swing.JButton();
        BTutor1 = new javax.swing.JButton();
        BAuxiliar1 = new javax.swing.JButton();
        BEdu1 = new javax.swing.JButton();
        CBMes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(204, 102, 255));
        jToolBar1.setRollover(true);

        BAdmin1.setText("ADMIN 1");
        BAdmin1.setFocusable(false);
        BAdmin1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BAdmin1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BAdmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAdmin1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BAdmin1);

        BTutor1.setText("TUTOR 1");
        BTutor1.setFocusable(false);
        BTutor1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTutor1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTutor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTutor1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BTutor1);

        BAuxiliar1.setText("AUXILIAR 1");
        BAuxiliar1.setFocusable(false);
        BAuxiliar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BAuxiliar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BAuxiliar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAuxiliar1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BAuxiliar1);

        BEdu1.setText("EDU 1");
        BEdu1.setFocusable(false);
        BEdu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BEdu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BEdu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEdu1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BEdu1);

        CBMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        CBMes.setMaximumSize(new java.awt.Dimension(150, 50));
        CBMes.setMinimumSize(new java.awt.Dimension(150, 50));
        CBMes.setPreferredSize(new java.awt.Dimension(150, 50));
        jToolBar1.add(CBMes);

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
        jScrollPane1.setViewportView(TConsultas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Código para que cierre la conexión
        if (cnx != null) {
            cnx.desconectar();
        }
    }//GEN-LAST:event_formWindowClosing

    private void BAdmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAdmin1ActionPerformed
        cnx.entablar(admin1, TConsultas);
    }//GEN-LAST:event_BAdmin1ActionPerformed

    private void BTutor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTutor1ActionPerformed
        cnx.entablar(tutor1, TConsultas);
    }//GEN-LAST:event_BTutor1ActionPerformed

    private void BAuxiliar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAuxiliar1ActionPerformed
        cnx.entablar(aux1, TConsultas);
    }//GEN-LAST:event_BAuxiliar1ActionPerformed

    private void BEdu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEdu1ActionPerformed
        String educadora = JOptionPane.showInputDialog(this, "ID Educadora:");
        int mes = CBMes.getSelectedIndex();

        String edu11 = edu1 + " WHERE idEducadora = " + educadora
                + " AND MONTH(fechaEntrada) = " + mes
                + " GROUP BY i.idInfante, MONTH(fechaEntrada) ";

        cnx.entablar(edu11, TConsultas);
    }//GEN-LAST:event_BEdu1ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FTester().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAdmin1;
    private javax.swing.JButton BAuxiliar1;
    private javax.swing.JButton BEdu1;
    private javax.swing.JButton BTutor1;
    private javax.swing.JComboBox<String> CBMes;
    private javax.swing.JTable TConsultas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}

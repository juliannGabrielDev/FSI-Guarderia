
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Util.Conexion;

public class FAcceso extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    int veces = 0;// Contador para el acceso

    public FAcceso() {
        initComponents();
        setLocationRelativeTo(this);

        //if para conectar ala Base de datos
        if (cnx.conectar("localhost", "guarderias", "root", "") == 0) {
            JOptionPane.showMessageDialog(this, "Error en la conexión");
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LNombre = new javax.swing.JLabel();
        LNombre1 = new javax.swing.JLabel();
        TCorreo = new javax.swing.JTextField();
        BAcceder = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        TContra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión");

        LNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LNombre.setText("CORREO:");

        LNombre1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LNombre1.setText("CONTRASEÑA:");

        BAcceder.setBackground(new java.awt.Color(0, 153, 255));
        BAcceder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BAcceder.setText("ACCEDER");
        BAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAccederActionPerformed(evt);
            }
        });

        BCancelar.setBackground(new java.awt.Color(255, 102, 102));
        BCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BCancelar.setText("CANCELAR");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TContra)
                    .addComponent(LNombre1)
                    .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(BAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(LNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAccederActionPerformed
        String correo = TCorreo.getText();
        String pass = new String(TContra.getPassword());

        String sql = "SELECT idUsuario, nombreUsuario, tipoUsuario "
                + "FROM usuarios "
                + "WHERE nombreUsuario = '" + correo + "' "
                + "AND contraseña = '" + pass + "' "
                + "AND activo = 1;";

        ArrayList<ArrayList<String>> resultado = cnx.consultar(sql);
        if (resultado.size() > 0) {
            String id = resultado.get(0).get(0);
            String nombre = resultado.get(0).get(1);
            String rol = resultado.get(0).get(2);

            switch (rol) {
                case "Tutor":
                    FTutores ftu = new FTutores();
                    ftu.recibirDatos(cnx, id, nombre);
                    ftu.setVisible(true);
                    break;
                case "Auxiliar":
                    FAuxiliares fau = new FAuxiliares();
                    fau.recibirDatos(cnx, id, nombre);
                    fau.setVisible(true);
                    break;
                case "Administrador":
                    FAdmin fad = new FAdmin();
                    fad.recibirDatos(cnx, id, nombre);
                    fad.setVisible(true);
                    break;
                case "Educadora":
                    String idEdu = cnx.buscarDato("educadoras", "idEducadora", "idUsuario", id);
                    
                    FPersonal fper = new FPersonal();
                    fper.recibirDatos(cnx, idEdu, nombre);
                    fper.setVisible(true);
                    break;
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Los datos son incorrectos.");
            veces++;
            if (veces >= 3) {
                JOptionPane.showMessageDialog(this, "Demasiados intentos.");
                this.dispose();
            }
        }
    }//GEN-LAST:event_BAccederActionPerformed

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
            java.util.logging.Logger.getLogger(FAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAcceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAcceder;
    private javax.swing.JButton BCancelar;
    private javax.swing.JLabel LNombre;
    private javax.swing.JLabel LNombre1;
    private javax.swing.JPasswordField TContra;
    private javax.swing.JTextField TCorreo;
    // End of variables declaration//GEN-END:variables
}


import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FPersonal extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    String id;
    String nombre;

    // Se muestra al iniciar la ventana
    String infantesdata = "SELECT * FROM infantesdatos ORDER BY idInfante";
    // Para filtrar 
    String grupcb = "SELECT * FROM infoinfantes WHERE grupo_asignado = '";// Por grupos
    // Para mostrar items en el ComboBox
    String grupos = "SELECT nombreGrupo FROM grupos ORDER BY nombreGrupo";// CBGrupos
    // Para buscar infante por su nombre
    String infoInfa = "SELECT * FROM infantesdatos WHERE nombre_Infante LIKE '%";
    // Segunda consulta: muestra nombre del infante, grupo y tutor
    String edu2 = "SELECT * FROM infoinfantes ORDER BY grupo_asignado";

    public FPersonal() {
        initComponents();
        setLocationRelativeTo(this);
        TTutor.setEnabled(false);
        TAuxiliar.setEnabled(false);
        TIdTu.setEnabled(false);
        TIdAux.setEnabled(false);
        TInfante.setEnabled(false);

        if (cnx.conectar("localhost", "guarderia", "root", "") == 1) {
            cnx.seleccionar(grupos, CBGrupos);
            cnx.entablar(infantesdata, TConsultas);

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo conectar.");
            System.exit(0);
        }
        // Ordena elementos de la tabla a la columna seleccionada 
        DefaultTableModel modelo = (DefaultTableModel) TConsultas.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        TConsultas.setRowSorter(sorter);

    }

    public void recibirDatos(Conexion cnx, String id, String nombre) {// , String infa, String idTu, String tutor, String idAux, String aux
        // Hacer esto permite utilizar las variables en toda la ventana.
        this.cnx = cnx;
        this.id = id;
        this.nombre = nombre;
        // Esto es para poner datos en etiquetas.
        LId.setText("ID: " + id);
        LNombre.setText("NOMBRE: " + nombre);
        cnx.entablar(infantesdata, TConsultas);
        cnx.seleccionar(grupos, CBGrupos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LId = new javax.swing.JLabel();
        LNombre = new javax.swing.JLabel();
        CBEntSal = new javax.swing.JComboBox<>();
        BAceptar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        SFecha = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        TBuscarInfa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TInfante = new javax.swing.JTextField();
        TAuxiliar = new javax.swing.JTextField();
        TTutor = new javax.swing.JTextField();
        TIdTu = new javax.swing.JTextField();
        TIdAux = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TPermiso = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        BTodos = new javax.swing.JButton();
        BEducador1 = new javax.swing.JButton();
        CBMes = new javax.swing.JComboBox<>();
        BReporte1 = new javax.swing.JButton();
        BEducador2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        CBGrupos = new javax.swing.JComboBox<>();
        BReporte2 = new javax.swing.JButton();
        TBuscar = new javax.swing.JTextField();
        BBitacora = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        LId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LId.setForeground(new java.awt.Color(255, 255, 255));

        LNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LNombre.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(LId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        CBEntSal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Salida" }));

        BAceptar.setBackground(new java.awt.Color(0, 153, 255));
        BAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BAceptar.setForeground(new java.awt.Color(255, 255, 255));
        BAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        BAceptar.setText("AGREGAR");

        BCancelar.setBackground(new java.awt.Color(255, 102, 102));
        BCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete1.png"))); // NOI18N
        BCancelar.setText("CANCELAR");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        SFecha.setModel(new javax.swing.SpinnerDateModel());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("ID Tutor:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID Auxiliar:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tutor:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Auxiliar:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGISTRO DE ENTRADAS Y SALIDAS");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Consultas:");

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
        jScrollPane2.setViewportView(TConsultas);

        TBuscarInfa.setBackground(new java.awt.Color(255, 255, 255));
        TBuscarInfa.setForeground(new java.awt.Color(0, 0, 0));
        TBuscarInfa.setMaximumSize(new java.awt.Dimension(68, 26));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Infante:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Infante:");

        TInfante.setBackground(new java.awt.Color(255, 255, 255));
        TInfante.setForeground(new java.awt.Color(0, 0, 0));
        TInfante.setMaximumSize(new java.awt.Dimension(68, 26));

        TAuxiliar.setBackground(new java.awt.Color(255, 255, 255));
        TAuxiliar.setForeground(new java.awt.Color(0, 0, 0));
        TAuxiliar.setMaximumSize(new java.awt.Dimension(68, 26));

        TTutor.setBackground(new java.awt.Color(255, 255, 255));
        TTutor.setForeground(new java.awt.Color(0, 0, 0));
        TTutor.setMaximumSize(new java.awt.Dimension(68, 26));

        TIdTu.setBackground(new java.awt.Color(255, 255, 255));
        TIdTu.setForeground(new java.awt.Color(0, 0, 0));
        TIdTu.setMaximumSize(new java.awt.Dimension(68, 26));

        TIdAux.setBackground(new java.awt.Color(255, 255, 255));
        TIdAux.setForeground(new java.awt.Color(0, 0, 0));
        TIdAux.setMaximumSize(new java.awt.Dimension(68, 26));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("ID Permiso:");

        TPermiso.setBackground(new java.awt.Color(255, 255, 255));
        TPermiso.setForeground(new java.awt.Color(0, 0, 0));
        TPermiso.setMaximumSize(new java.awt.Dimension(68, 26));

        jToolBar1.setBackground(new java.awt.Color(51, 153, 255));
        jToolBar1.setForeground(new java.awt.Color(0, 0, 0));
        jToolBar1.setRollover(true);

        BTodos.setBackground(new java.awt.Color(255, 255, 255));
        BTodos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTodos.setForeground(new java.awt.Color(0, 0, 0));
        BTodos.setText("TODOS");
        BTodos.setFocusable(false);
        BTodos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTodos.setMaximumSize(new java.awt.Dimension(70, 50));
        BTodos.setMinimumSize(new java.awt.Dimension(70, 50));
        BTodos.setPreferredSize(new java.awt.Dimension(70, 50));
        BTodos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTodosActionPerformed(evt);
            }
        });
        jToolBar1.add(BTodos);

        BEducador1.setBackground(new java.awt.Color(255, 255, 255));
        BEducador1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BEducador1.setForeground(new java.awt.Color(0, 0, 0));
        BEducador1.setText("ENTRADAS");
        BEducador1.setFocusable(false);
        BEducador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BEducador1.setMaximumSize(new java.awt.Dimension(85, 50));
        BEducador1.setMinimumSize(new java.awt.Dimension(85, 50));
        BEducador1.setPreferredSize(new java.awt.Dimension(85, 50));
        BEducador1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BEducador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEducador1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BEducador1);

        CBMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        CBMes.setMaximumSize(new java.awt.Dimension(100, 70));
        CBMes.setMinimumSize(new java.awt.Dimension(100, 70));
        CBMes.setPreferredSize(new java.awt.Dimension(100, 50));
        jToolBar1.add(CBMes);

        BReporte1.setBackground(new java.awt.Color(255, 255, 255));
        BReporte1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BReporte1.setForeground(new java.awt.Color(0, 0, 0));
        BReporte1.setText("REPORTE 1");
        BReporte1.setFocusable(false);
        BReporte1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BReporte1.setMaximumSize(new java.awt.Dimension(85, 50));
        BReporte1.setMinimumSize(new java.awt.Dimension(85, 50));
        BReporte1.setPreferredSize(new java.awt.Dimension(85, 50));
        BReporte1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReporte1ActionPerformed(evt);
            }
        });
        jToolBar1.add(BReporte1);

        BEducador2.setBackground(new java.awt.Color(255, 255, 255));
        BEducador2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BEducador2.setForeground(new java.awt.Color(0, 0, 0));
        BEducador2.setText("GRUPOS");
        BEducador2.setFocusable(false);
        BEducador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BEducador2.setMaximumSize(new java.awt.Dimension(70, 50));
        BEducador2.setMinimumSize(new java.awt.Dimension(70, 50));
        BEducador2.setPreferredSize(new java.awt.Dimension(70, 50));
        BEducador2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BEducador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEducador2ActionPerformed(evt);
            }
        });
        jToolBar1.add(BEducador2);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("GRUPO:");
        jToolBar1.add(jLabel11);

        CBGrupos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3" }));
        CBGrupos.setMaximumSize(new java.awt.Dimension(85, 70));
        CBGrupos.setMinimumSize(new java.awt.Dimension(85, 70));
        CBGrupos.setPreferredSize(new java.awt.Dimension(85, 50));
        CBGrupos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBGruposItemStateChanged(evt);
            }
        });
        jToolBar1.add(CBGrupos);

        BReporte2.setBackground(new java.awt.Color(255, 255, 255));
        BReporte2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BReporte2.setForeground(new java.awt.Color(0, 0, 0));
        BReporte2.setText("REPORTE 2");
        BReporte2.setFocusable(false);
        BReporte2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BReporte2.setMaximumSize(new java.awt.Dimension(85, 50));
        BReporte2.setMinimumSize(new java.awt.Dimension(85, 50));
        BReporte2.setPreferredSize(new java.awt.Dimension(85, 50));
        BReporte2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReporte2ActionPerformed(evt);
            }
        });
        jToolBar1.add(BReporte2);

        TBuscar.setToolTipText("");
        TBuscar.setMaximumSize(new java.awt.Dimension(130, 50));
        TBuscar.setMinimumSize(new java.awt.Dimension(130, 50));
        TBuscar.setPreferredSize(new java.awt.Dimension(130, 50));
        TBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TBuscarKeyTyped(evt);
            }
        });
        jToolBar1.add(TBuscar);

        BBitacora.setBackground(new java.awt.Color(255, 255, 255));
        BBitacora.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BBitacora.setForeground(new java.awt.Color(0, 0, 0));
        BBitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/registro.png"))); // NOI18N
        BBitacora.setText("BITÁCORA");
        BBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBitacoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(3, 3, 3)
                                        .addComponent(TIdAux, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TTutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(CBEntSal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(SFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(TIdTu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(TBuscarInfa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TInfante, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TInfante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TBuscarInfa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TIdTu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TIdAux, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBEntSal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BEducador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEducador1ActionPerformed
        // Consulta 1: Muestra las asistencias que tuvo un infante durante un mes en especifico
        String educadora = JOptionPane.showInputDialog(this, "ID Educadora:");
        int mes = CBMes.getSelectedIndex();
        String sql = "SELECT * FROM entradas_edu WHERE ideducadora = " + educadora + " AND mes = " + mes;
        cnx.entablar(sql, TConsultas);
    }//GEN-LAST:event_BEducador1ActionPerformed

    private void BEducador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEducador2ActionPerformed
        cnx.entablar(edu2, TConsultas);// Muestra la consulta 2 en la tabla
    }//GEN-LAST:event_BEducador2ActionPerformed

    private void BReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReporte1ActionPerformed
        // Genera el reporte 1 de las asistencias de los infantes
        int mes = CBMes.getSelectedIndex();
        String reporte = System.getProperty("user.dir") + "/edu1.jasper";
        Map parametros = new HashMap();
        parametros.put("educadora", this.id);
        parametros.put("mes", String.valueOf(mes));

        if (cnx.ejecutarReporte(reporte, parametros) == 0) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar el reporte");
        }
    }//GEN-LAST:event_BReporte1ActionPerformed

    private void BReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReporte2ActionPerformed
        // Genera el reporte 2 de todos los infantes en X grupo
        String reporte = System.getProperty("user.dir") + "/edu2.jasper";
        Map parametros = new HashMap();
        parametros.put("educa2", CBGrupos.getSelectedItem().toString());

        if (cnx.ejecutarReporte(reporte, parametros) == 0) {
            JOptionPane.showMessageDialog(this, "Error al ejecutar el reporte");
        }
    }//GEN-LAST:event_BReporte2ActionPerformed

    private void CBGruposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBGruposItemStateChanged
        // Filtra por grupo completando la consulta de "grupcb" y entabla
        String filtrar = CBGrupos.getSelectedItem().toString();
        String sql = grupcb + filtrar + "'";
        cnx.entablar(sql, TConsultas);
    }//GEN-LAST:event_CBGruposItemStateChanged

    private void TBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBuscarKeyTyped
        // Aquí busca a un infante en especifico por su nombre
        String nombrein = TBuscar.getText();
        String sql = infoInfa + nombrein + "%'";// Completa la cosulta infoInfa
        cnx.entablar(sql, TConsultas);
    }//GEN-LAST:event_TBuscarKeyTyped

    private void BTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTodosActionPerformed
        // Entabla la consulta infantesdata (datos generales de infantes)
        cnx.entablar(infantesdata, TConsultas);
    }//GEN-LAST:event_BTodosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Para desconectar
        if (cnx != null) {
            cnx.desconectar();
        }
    }//GEN-LAST:event_formWindowClosing

    private void BBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBitacoraActionPerformed
        // Abre el JDialog de los registros de entrada y salida de cada infante 
        JDBitacora mov = new JDBitacora(this, rootPaneCheckingEnabled);
        mov.setVisible(true);
    }//GEN-LAST:event_BBitacoraActionPerformed

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
            java.util.logging.Logger.getLogger(FPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BBitacora;
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BEducador1;
    private javax.swing.JButton BEducador2;
    private javax.swing.JButton BReporte1;
    private javax.swing.JButton BReporte2;
    private javax.swing.JButton BTodos;
    private javax.swing.JComboBox<String> CBEntSal;
    private javax.swing.JComboBox<String> CBGrupos;
    private javax.swing.JComboBox<String> CBMes;
    private javax.swing.JLabel LId;
    private javax.swing.JLabel LNombre;
    private javax.swing.JSpinner SFecha;
    private javax.swing.JTextField TAuxiliar;
    private javax.swing.JTextField TBuscar;
    private javax.swing.JTextField TBuscarInfa;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TIdAux;
    private javax.swing.JTextField TIdTu;
    private javax.swing.JTextField TInfante;
    private javax.swing.JTextField TPermiso;
    private javax.swing.JTextField TTutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        TAuxiliar.setText("");
        TBuscarInfa.setText("");
        TIdAux.setText("");
        TIdTu.setText("");
        TInfante.setText("");
        TPermiso.setText("");
        TTutor.setText("");
    }

}

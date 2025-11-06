
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.io.File;
import java.util.Calendar;

import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class Conexion {

    Connection con;

    //-------------------------------------------------------------------------------
//    public int conectar(String servidor, String base, String usuario, String clave) {
//        try {
//            String url = "jdbc:mysql://" + servidor + ":3306/" + base;
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            con = DriverManager.getConnection(url, usuario, clave);
//            return 1;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return 0;
//        }
//    }
    public int conectar(String servidor, String base, String usuario, String clave) {
        try {
            // URL final con todos los parámetros
            String url = "jdbc:mysql://" + servidor + ":3307/" + base + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            // com.mysql.cj.jdbc.Driver para version 9 del driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection(url, usuario, clave);
            return 1;
        } catch (Exception e) {
            // Imprime el error completo para tener más detalles si vuelve a fallar
            e.printStackTrace();
            return 0;
        }
    }
    //-------------------------------------------------------------------------------

    public int desconectar() {
        try {
            con.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int ejecutar(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeUpdate(sql); // Devuelve el número de filas afectadas
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0; // Devuelve 0 si hay un error
        }
    }

    //--------------------------------------------------------------------------
    //-------- Muestra el resultado de una consulta en una JTable 
    //--------------------------------------------------------------------------
    public int entablar(String consulta, JTable malla) {

        int correcta = 0;

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsm = rs.getMetaData();
            DefaultTableModel modelo = (DefaultTableModel) malla.getModel();
            //limpiar tabla
            modelo.setColumnCount(0);
            modelo.setRowCount(0);

            //agregar las columnas del resultado con su nombre
            for (int k = 1; k <= rsm.getColumnCount(); k++) {
                modelo.addColumn(rsm.getColumnName(k).toUpperCase());
            }

            //agregar renglones con los datos
            int renglon = 0;
            while (rs.next()) {
                modelo.insertRow(renglon, new String[rsm.getColumnCount()]);
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
//                    if (rsm.getColumnType(k) == -4) { //tipo blob de imagen
//                        int w = malla.getColumnModel().getColumn(k - 1).getWidth();
//                        int h = malla.getRowHeight();
//                        malla.getColumnModel().getColumn(k - 1).setCellRenderer(new ImageRenderer(w, h));
//                        modelo.setValueAt(new ImageIcon(rs.getBytes(k)), renglon, k - 1);
//                    } else { //cualquier otro tipo que se puede manejar como cadena
//                        modelo.setValueAt(rs.getString(k), renglon, k - 1);
//                    }
                    if (rsm.getColumnType(k) == -4) { //tipo blob de imagen
                        // --- INICIO DE LA CORRECCIÓN ---
                        byte[] blob = rs.getBytes(k);
                        if (blob != null) {
                            int w = malla.getColumnModel().getColumn(k - 1).getWidth();
                            int h = malla.getRowHeight();
                            malla.getColumnModel().getColumn(k - 1).setCellRenderer(new ImageRenderer(w, h));
                            modelo.setValueAt(new ImageIcon(blob), renglon, k - 1);
                        } else {
                            // Si no hay imagen, puedes poner un texto o dejarlo en blanco
                            modelo.setValueAt("Sin imagen", renglon, k - 1);
                        }
                        // --- FIN DE LA CORRECCIÓN ---
                    } else { //cualquier otro tipo que se puede manejar como cadena
                        modelo.setValueAt(rs.getString(k), renglon, k - 1);
                    }
                }
                renglon++;
            }
        } catch (SQLException ex) {
            correcta = 0;
            System.out.println(ex.getMessage());
        }

        return correcta;

    }

    //--------------------------------------------------------------------------
    //-------- Muestra el resultado de una consulta en una JTable 
    //-------- adaptando el ancho de las columnas
    //--------------------------------------------------------------------------
    public int entablar(String consulta, JTable malla, double... porcentajes) {

        int correcta = 0;

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsm = rs.getMetaData();
            DefaultTableModel modelo = (DefaultTableModel) malla.getModel();
            //limpiar tabla
            modelo.setColumnCount(0);
            modelo.setRowCount(0);

            //agregar las columnas del resultado con su nombre
            for (int k = 1; k <= rsm.getColumnCount(); k++) {
                modelo.addColumn(rsm.getColumnName(k).toUpperCase());
            }

            //agregar renglones con los datos
            int renglon = 0;
            while (rs.next()) {
                modelo.insertRow(renglon, new String[rsm.getColumnCount()]);
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
                    if (rsm.getColumnType(k) == -4) { //tipo blob de imagen
                        int w = malla.getColumnModel().getColumn(k - 1).getWidth();
                        int h = malla.getRowHeight();
                        malla.getColumnModel().getColumn(k - 1).setCellRenderer(new ImageRenderer(w, h));
                        modelo.setValueAt(new ImageIcon(rs.getBytes(k)), renglon, k - 1);
                    } else { //cualquier otro tipo que se puede manejar como cadena
                        modelo.setValueAt(rs.getString(k), renglon, k - 1);
                    }
                }
                renglon++;
            }

            //Adaptar el ancho de las columnas
            setAnchoColumnas(malla, porcentajes);

        } catch (SQLException ex) {
            correcta = 0;
            System.out.println(ex.getMessage());
        }

        return correcta;

    }

    //--------------------------------------------------------------------------
    //-------- cambia el ancho de las columnas de una tabla en porcentajes
    //--------------------------------------------------------------------------
    public static void setAnchoColumnas(JTable tabla, double... porcentajes) {
        double total = 0;
        int anchoTabla = tabla.getWidth();

        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            total += porcentajes[i];
        }

        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tabla.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (anchoTabla * (porcentajes[i] / total)));
        }
    }
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    //-------- regresa el valor de una consulta de un solo dato
    //-------- si el resultado es la cadena vacia, significa que la consulta ha
    //-------- regresado una tabla vacia o el código SQL es incorrecto
    //--------------------------------------------------------------------------
    public String obtenerDato(String consulta) {

        String resultado = "";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getString(1);
            }
            return resultado;
        } catch (Exception e) {
            return resultado;
        }
    }

    //--------------------------------------------------------------------------
    //-------- regresa el valor de un campo que coincida con un dato dado
    //-------- supone que el campo regresado por la consulta es único
    //--------------------------------------------------------------------------
    public String buscarDato(String tabla, String columnaDeseada, String campoBuscado, String valorBuscado) {
        String consulta = "SELECT " + columnaDeseada + " FROM " + tabla
                + " WHERE " + campoBuscado + " = '" + valorBuscado + "'";

        String resultado = "";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getString(columnaDeseada);
            }
            return resultado;
        } catch (Exception e) {
            return resultado;
        }
    }

    //--------------------------------------------------------------------------
    //-------- Función para un Textfield de busqueda
    //--------------------------------------------------------------------------
    public void buscar(String tabla, String[] columnas, String textoBusqueda, JTable malla) {
        StringBuilder sql = new StringBuilder("SELECT * FROM " + tabla + " WHERE ");
        // Itera sobre cada columna especificada en el array
        for (int i = 0; i < columnas.length; i++) {
            // Agrega la condición LIKE para buscar el texto en la columna actual
            // El patrón '%texto%' permite encontrar el texto en cualquier posición
            sql.append(columnas[i]).append(" LIKE '%").append(textoBusqueda).append("%'");
            if (i < columnas.length - 1) {
                sql.append(" OR ");
            }
        }
        entablar(sql.toString(), malla);
    }

    /**
     * Ejecuta una consulta de actualización (INSERT, UPDATE, DELETE) usando
     * PreparedStatement para prevenir inyección SQL.
     *
     * @param sql La plantilla de la consulta SQL, ej: "UPDATE tabla SET nombre
     * = ? WHERE id = ?"
     * @param parametros Una lista variable de los valores que reemplazarán los
     * '?' en la consulta.
     * @return El número de filas afectadas, o 0 si ocurre un error.
     */
    public int actualizarBD(String sql, Object... parametros) {
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                if (parametros[i] instanceof FileInputStream) {
                    pst.setBinaryStream(i + 1, (FileInputStream) parametros[i]);
                } else if (parametros[i] == null) {
                    pst.setNull(i + 1, java.sql.Types.NULL);
                } else {
                    pst.setObject(i + 1, parametros[i]);
                }
            }
            return pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al ejecutar actualización: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    //--------------------------------------------------------------------------
    //-------- muestra los datos de un campo en un combobox
    //--------------------------------------------------------------------------
    public void seleccionar(String consulta, JComboBox box) {
        ArrayList<String> datos = new ArrayList();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(consulta);
            while (rs.next()) {
                datos.add(rs.getString(1));
            }
            if (datos.size() > 0) {
                datos.add(0, "Todos");
                DefaultComboBoxModel cbm = new DefaultComboBoxModel(datos.toArray());
                box.setModel(cbm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //--------------------------------------------------------------------------
    //-------- muestra id y descripción en un combobox
    //--------------------------------------------------------------------------
//    public void seleccionarConDescripcion(String consulta, JComboBox box) {
//        ArrayList<Pelicula> datos = new ArrayList();
//        try {
//            Statement ps = con.createStatement();
//            ResultSet rs = ps.executeQuery(consulta);
//
//            while (rs.next()) {
//                String id = rs.getString(1);      // Primera columna: ID
//                String titulo = rs.getString(2);  // Segunda columna: Título
//                datos.add(new Pelicula(id, titulo, null, null, null));
//            }
//
//            DefaultComboBoxModel cbm = new DefaultComboBoxModel(datos.toArray());
//            box.setModel(cbm);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    //--------------------------------------------------------------------------
    //-------- regresa una lista con los registros del resultado de la consulta
    //---------cada registro de la lista es otra lista
    //--------------------------------------------------------------------------
    public ArrayList<ArrayList<String>> consultar(String consulta) {
        ArrayList<ArrayList<String>> datos = new ArrayList();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(consulta);
            ResultSetMetaData rsm = rs.getMetaData();
            while (rs.next()) {
                ArrayList<String> renglon = new ArrayList();
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
                    renglon.add(rs.getString(k));
                }
                datos.add(renglon);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datos;
    }

    //--------------------------------------------------------------------------
    //-------- regresa un arreglo con los registros del resultado de la consulta
    //---------cada registro es un arreglo
    //--------------------------------------------------------------------------
    public String[][] consultar2Array(String consulta) {
        ArrayList<ArrayList<String>> datos = consultar(consulta);
        String[][] resultado = null;
        if (!datos.isEmpty()) {
            resultado = new String[datos.size()][];
            for (int r = 0; r < datos.size(); r++) {
                ArrayList<String> ren = datos.get(r);
                resultado[r] = (String[]) ren.toArray();
            }
        }
        return resultado;
    }

    // <editor-fold defaultstate="collapsed" desc="Funciones para el manejo de fechas">  
    //--------------------------------------------------------------------------
    //-------- obtener la fechay hora del sistema
    //--------------------------------------------------------------------------
    public String ObtenerFechaHora() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        int mSecond = c.get(Calendar.SECOND);
        int mMili = c.get(Calendar.MILLISECOND);

        return year + "-" + month + "-" + day + " " + mHour + ":" + mMinute + ":" + mSecond + "." + mMili;
    }

    //--------------------------------------------------------------------------
    //-------- obtener la fecha del sistema
    //--------------------------------------------------------------------------
    public String ObtenerFecha() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return year + "-" + month + "-" + day;
    }

    //--------------------------------------------------------------------------
    //-------- obtener la hora del sistema
    //--------------------------------------------------------------------------
    public String ObtenerHora() {
        Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        int mSecond = c.get(Calendar.SECOND);
        int mMili = c.get(Calendar.MILLISECOND);

        return mHour + ":" + mMinute + ":" + mSecond + "." + mMili;
    }

    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Codigo para manejo de reportes">  
    //--------------------------------------------------------------------------
    //-------- ejecuta un reporte jasper
    //--------------------------------------------------------------------------
    public int ejecutarReporte(String archivo, Map parametro) {
        try {
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(new File(archivo));
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, con);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setVisible(true);
            return 1;
        } catch (Exception j) {
            System.out.println("ERROR: "+j.getMessage());
           return 0;
        }
    } 
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Codigo para manejo de imágenes">  
    //--------------------------------------------------------------------------
    //-------- obtiene los bytes de un ImageIcon
    //--------------------------------------------------------------------------
//    public FileInputStream ImagenBytes(ImageIcon imagen) {
//        FileInputStream res = null;
//        javax.swing.JFrame f = new javax.swing.JFrame();
//        BufferedImage buff = null;
//
//        try {
//            Image img = imagen.getImage();
//            buff = new BufferedImage(imagen.getIconWidth(), imagen.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
//
//            Graphics2D ig2 = buff.createGraphics();
//            ig2.drawImage(img, 0, 0, f);
//
//            File directorio = new File("c:\\tempo");
//            directorio.mkdirs();
//            String nombre = "c:\\tempo\\auxiliar.jpg";
//            ImageIO.write(buff, "JPEG", new File(nombre));
//            res = new FileInputStream(new File(nombre));
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//        }
//        return res;
//    }
    public FileInputStream ImagenBytes(ImageIcon imagen) {
        FileInputStream res = null;
        try {
            Image img = imagen.getImage();
            BufferedImage buff = new BufferedImage(imagen.getIconWidth(), imagen.getIconHeight(), BufferedImage.TYPE_INT_RGB);

            // Dibuja la imagen en el BufferedImage (importante para evitar fondos negros)
            Graphics2D ig2 = buff.createGraphics();
            ig2.drawImage(img, 0, 0, null);
            ig2.dispose();

            // Crea un archivo temporal en la carpeta correcta del sistema
            File tempFile = File.createTempFile("img_temp_", ".jpg");
            tempFile.deleteOnExit(); // Asegura que el archivo se borre al cerrar la app

            // Escribe la imagen en el archivo temporal
            ImageIO.write(buff, "JPEG", tempFile);

            // Prepara el archivo para ser enviado a la base de datos
            res = new FileInputStream(tempFile);
        } catch (IOException ex) {
            System.out.println("Error al procesar la imagen: " + ex.toString());
        }
        return res;
    }

    //--------------------------------------------------------------------------
    //-------- cambia el tamaño de una imagen
    //--------------------------------------------------------------------------
    public static Image escalarImagen(Image srcImg, int ancho, int alto) {
        BufferedImage imagenEscalada = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagenEscalada.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, ancho, alto, null);
        g2.dispose();

        return imagenEscalada;
    }

}

//------------------------------------------------------------------------------
//---- Clase para manejar imagenes en las celdas de una JTable
//------------------------------------------------------------------------------
class ImageRenderer extends DefaultTableCellRenderer {

    JLabel lbl = new JLabel();
    ImageIcon icon;
    int ancho, alto;

    public ImageRenderer(int ancho, int alto) {
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.ancho = ancho;
        this.alto = alto;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
//        if (value instanceof String) {
//            lbl.setText((String) value);
//        } else if (value instanceof ImageIcon) {
//            ImageIcon nueva = new ImageIcon(Conexion.escalarImagen(((ImageIcon) value).getImage(), ancho, alto));
//            lbl.setIcon(nueva);
//        }
        if (value instanceof String) {
            lbl.setIcon(null); // Limpia el icono anterior
            lbl.setText((String) value);
        } else if (value instanceof ImageIcon) {
            ImageIcon nueva = new ImageIcon(Conexion.escalarImagen(((ImageIcon) value).getImage(), ancho, alto));
            lbl.setText(""); // Limpia el texto anterior
            lbl.setIcon(nueva);
        } else {
            // Asegura que la celda esté vacía si no es ni texto ni imagen
            lbl.setIcon(null);
            lbl.setText("");
        }
        return lbl;
    }

}// </editor-fold>



//-----------------------------------------------------------------------------------------------

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import atencionresto.Conexion;
import atencionresto.MesaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import atencionresto.*;
import atencionresto.Mesa;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class VistaMesa extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private DefaultTableModel m;
    private Conexion conexion;
    private ArrayList<Mesa> listaMesa;
    private ArrayList<Mesa> listaMesaData;
    private ArrayList<Pedido> listaPedidoMesa;
    private ArrayList <Mesa> obtenerMesa;
    private MesaData mesadata;
    private Mesa mesa;
    public int idMesa;

    public VistaMesa() {
        initComponents();
        try {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");

            modelo = new DefaultTableModel();
            
            m = new DefaultTableModel();

            mesadata = new MesaData(conexion);
            listaMesa = (ArrayList) mesadata.obtenerMesas();
            

            // cargaMesas();
            armaCabeceraTabla();
            armaCabeceraTablaDos();
            cargarDatos();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel1.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaMesas = new javax.swing.JTable();
        jButtonModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaPedidoMesa = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jNombreMesa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFechaUno = new javax.swing.JTextField();
        jHoraUno = new javax.swing.JTextField();
        jBotonBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jHoraDos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(251, 250, 219));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mesas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 0, 295, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Mesas:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 37, 106, 26));

        jTablaMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablaMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaMesas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 69, 227, 240));

        jButtonModificar.setText("Modificar Estado");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel2.setText("Seleccione una mesa libre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 330, -1, -1));

        jLabel4.setText("para que pueda ser atendida por un mesero.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel5.setText("Pedidos que ha hecho una mesa en una fecha entre horas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 46, -1, -1));

        jTablaPedidoMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTablaPedidoMesa);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 71, 259, 238));

        jLabel6.setText("Numero mesa");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 330, 86, -1));
        jPanel1.add(jNombreMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 327, 124, -1));

        jLabel7.setText("Fecha");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 75, 20));

        jLabel8.setText("Hora inicial");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 75, 20));
        jPanel1.add(jFechaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 124, -1));
        jPanel1.add(jHoraUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 120, -1));

        jBotonBuscar.setText("Buscar");
        jBotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jBotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 124, -1));

        jLabel9.setText("luego modifique su estado");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 353, 215, -1));
        jPanel1.add(jHoraDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 120, -1));

        jLabel10.setText("Hora final");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//METODO PARA TOMAR VALOR DEL ESTADO DE MESA
    private void jTablaMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMesasMouseClicked
       
    }//GEN-LAST:event_jTablaMesasMouseClicked

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        
        int filaSeleccionada = jTablaMesas.getSelectedRow();
        
        try {
            String idMesa;
            
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione una mesa");
            } else {
                
                idMesa = jTablaMesas.getValueAt(filaSeleccionada, 0).toString();
                System.out.println(idMesa);
                
                MesaData md = new MesaData(conexion);
                md.actualizarMesaOcupada(parseInt(idMesa));
                
                JOptionPane.showMessageDialog(null, "Usted actualizó el estado de la mesa a ocupada");
            }
            
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jBotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonBuscarActionPerformed
        // TODO add your handling code here:
        String nombre = jNombreMesa.getText();

        MesaData me = new MesaData(conexion);
        obtenerMesa = (ArrayList) me.obtenerMesa(parseInt(nombre));

        for (Mesa mesa : obtenerMesa) {
            idMesa = mesa.getIdMesa();
         
        }
        System.out.println(idMesa);
        
        String dia = jFechaUno.getText();
        
        LocalDate ld = LocalDate.parse(dia);
        
        String horaUno = jHoraUno.getText();
        
        LocalTime lt = LocalTime.parse(horaUno);
        
        String horaDos = jHoraDos.getText();
        
        LocalTime ltDos = LocalTime.parse(horaDos);
        
        LocalDateTime fechaHoraUno = LocalDateTime.of(ld, lt);
        
        LocalDateTime fechaHoraDos = LocalDateTime.of(ld, ltDos);
        
        PedidoData pd = new PedidoData(conexion);
        listaPedidoMesa = (ArrayList) pd.obtenerPedidosPorMesa(fechaHoraUno, fechaHoraDos, idMesa);
        
        for (Pedido p : listaPedidoMesa) {
            m.addRow(new Object[] {p.getId_pedido(),p.getFechaHora_pedido()});
        }
    }//GEN-LAST:event_jBotonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JTextField jFechaUno;
    private javax.swing.JTextField jHoraDos;
    private javax.swing.JTextField jHoraUno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNombreMesa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaMesas;
    private javax.swing.JTable jTablaPedidoMesa;
    // End of variables declaration//GEN-END:variables
int filas;//variable global

    public void cargarDatos() {

        borraFilasTabla();
        //Llenar filas

        MesaData pd = new MesaData(conexion);
        listaMesa = (ArrayList) pd.obtenerMesas();
        for (Mesa p : listaMesa) {
            modelo.addRow(new Object[]{p.getNumMesa(), p.getCapacidad(), p.getEstado()});
        }
    }

    public void armaCabeceraTabla() {

        //Titulos de Columnas
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Numero");
        columnas.add("Capacidad");
        columnas.add("estado");
        for (Object it : columnas) {

            modelo.addColumn(it);
        }
        jTablaMesas.setModel(modelo);
    }
    
    public void armaCabeceraTablaDos() {

        //Titulos de Columnas
        ArrayList<Object> c = new ArrayList<Object>();
        c.add("id de reserva");
        c.add("fecha y hora");
        for (Object it : c) {

            m.addColumn(it);
        }
        jTablaPedidoMesa.setModel(m);
    }

    public void borraFilasTabla() {

        int a = modelo.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {

            modelo.removeRow(i);
        }
    }

    public void cargaAlumnos() {
        //Carga numero de mesas al ComboBox
        for (Mesa item : listaMesa) {
            //jComboBox1.addItem(item.toString());
        }

    }

}

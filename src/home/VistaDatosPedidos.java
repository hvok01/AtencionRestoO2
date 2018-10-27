package home;

import atencionresto.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaDatosPedidos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ArrayList<Pedido> listaPedidosPendientes;
    private PedidoData pedidoData;
    private MesaData mesaData;
    private Conexion conexion;

    public VistaDatosPedidos() {
        initComponents();

        try {

            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");

            modelo = new DefaultTableModel();

            PedidoData pedidoData = new PedidoData(conexion);
            listaPedidosPendientes = (ArrayList) pedidoData.obtenerPedidosPendientes();
            
            MesaData mesaData = new MesaData(conexion);

            cargarCabeceraPedidos();
            obtenerPedidosPendientes();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarCabeceraPedidos() {
        ArrayList<Object> co = new ArrayList<Object>();
        co.add("id_pedido");
        co.add("cobrar");
        co.add("Numero de mesa");

        for (Object it : co) {
            modelo.addColumn(it);
        }

        jListaPedidos.setModel(modelo);
    }

    public void obtenerPedidosPendientes() {

        PedidoData pd = new PedidoData(conexion);
        listaPedidosPendientes = (ArrayList) pd.obtenerPedidosPendientes();

        for (Pedido p : listaPedidosPendientes) {
            modelo.addRow(new Object[]{p.getId_pedido(), p.getDinero_cobrado(), p.getId_mesa()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaPedidos = new javax.swing.JTable();
        jBotonCobrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(251, 250, 219));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vista para gestionar datos de pedidos");

        jListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jListaPedidos);

        jBotonCobrar.setText("Cobrar pedido");
        jBotonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCobrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista de pedidos pendientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBotonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBotonCobrar)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCobrarActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada = jListaPedidos.getSelectedRow();

        try {
            String idMesa;

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Por favor seleccione un pedido");
            } else {
                idMesa = jListaPedidos.getValueAt(filaSeleccionada, 2).toString();

                PedidoData pd = new PedidoData(conexion);
                pd.actualizarPedido(parseInt(idMesa));
                
                mesaData = new MesaData(conexion);
                mesaData.actualizarMesa(parseInt(idMesa));
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jBotonCobrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonCobrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jListaPedidos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

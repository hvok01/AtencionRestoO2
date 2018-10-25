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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VistaMesa extends javax.swing.JInternalFrame {
DefaultTableModel modelo;
private MesaData mesaData;
private Conexion conexion;
  
 
    public VistaMesa(){
        initComponents();
        mostrardatos();
    try {
        conexion = new Conexion("jdbc:mysql://localhost/universidad", "root", "");
        mesaData = new MesaData(conexion);
        Connection cc=conexion();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(VistaMesa.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }
    //METODO PARA MOSTRAR DATOS DE BBDD EN TABLA
 void mostrardatos(){
     modelo.addColumn("id_mesa");
     modelo.addColumn("Numero mesa");
     modelo.addColumn("Capacidad");
     modelo.addColumn("Estado");
     jTable1.setModel(modelo);//imprime en la tabla
     String []datos=new String [4];
    try{
            Statement st= cc.createStatement(); //enviar consultas sql al servidor
            ResultSet rs = st.executeQuery("SELECT * FROM mesa"); //recuperar estructura de la consulta
          while(rs.netx()){
             datos[0]=rs.getString(0); //capturamos datos de la columna 0
             datos[1]=rs.getString(1); 
             datos[2]=rs.getString(2); 
             datos[3]=rs.getString(3); 
             modelo.addRow(datos);//agregar la fila
          }  
          jTable1.setModel(modelo);//mostramos en tabla jtable1
       }catch (SQLException e){
             Logger.getLogger(VistaMesa.class.getName()).log(Level.SEVERE, null,e);           
      }
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        BotonConsulta = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jtxtEstado = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(251, 250, 219));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mesas");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Numero de mesa:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        BotonConsulta.setText("Consulta");
        BotonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConsultaActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar Estado");

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");

        jButton2.setText("Atender Mesa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonActualizar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonConsulta)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonModificar)
                                .addGap(43, 43, 43)
                                .addComponent(jtxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(260, 260, 260))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonConsulta))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonModificar))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonActualizar)
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)))
                .addGap(62, 62, 62)
                .addComponent(jButton1)
                .addContainerGap(153, Short.MAX_VALUE))
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

    private void BotonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConsultaActionPerformed
     mostrardatos();
        /*  try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:msql://localhost/resto", "root", "");
             //conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            Statement stm = conexion.createStatement(); //enviar consultas sql al servidor
            ResultSet rst = stm.executeQuery("SELECT * FROM mesa"); //recuperar estructura de la consulta
            ResultSetMetaData rsMd=rst.getMetaData(); 
            int numeroColumnas=rsMd.getColumnCount();// numero de columnas de nuestra consulta
            DefaultTableModel modelo =new DefaultTableModel();//crear objeto de la tabla modelo
            this.jTable1.setModel(modelo);//asignar este objeto llamado modelo a nuestra tabla jtable1
             for (int x=1; x<numeroColumnas; x++){   //añadir nuestros objetos de la consulta a nuestra tabla
                 modelo.addColumn(rsMd.getColumnLabel(x));
             }
             while (rst.next()){ //añadir nuestros registros
                 Object[] fila = new Object [numeroColumnas]; 
                 for (int y=0; y<numeroColumnas; y ++){ //anadir el contenido de nuestra bbdd
                     fila[y]=rst.getObject(y+1);
                 }
                 modelo.addRow(fila);
             }
            
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
             System.out.println("no se pudo conectar");
        }*/
    }//GEN-LAST:event_BotonConsultaActionPerformed
//METODO PARA TOMAR VALOR DEL ESTADO DE MESA
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int filasele=jTable1.getSelectedRow();
    jtxtEstado.setText(jTable1.getValueAt(filasele,3).toString());//toma el valor de fila seleccionada y columna 3 
    filas=filasele;
    }//GEN-LAST:event_jTable1MouseClicked
//METODO PARA ACTUALIZAR EL ESTADO DE MESA
    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
      String []datos=new String[4];
      datos[3]=jtxtEstado.getText();//captura el estado
      for(int i=0;i<jTable1.getColumnCount();i++){
          modelo.setValueAt(datos[3],filas,3);
          
      }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxtEstado;
    // End of variables declaration//GEN-END:variables
int filas;//variable global

}

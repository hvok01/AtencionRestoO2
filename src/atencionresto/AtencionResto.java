
package atencionresto;

import javax.swing.JOptionPane;


public class AtencionResto {

    
   public static void main(String[] args) {
        Conexion conexion;
        
        try {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            
           // JOptionPane.showMessageDialog(null, "conectado");
            MeseroData mesero = new MeseroData(conexion);
            Mesero nm;
            nm = new Mesero("nombre", 22111333, true);
          
            // metodos que se pueden hacer
            
            //guardar mesero, agrega a la base de datos un mesero, atributos, nombre, dni y estado
           // mesero.guardarMesero(nm);
            
            //borrar mesero elimina un mesero por el nombre
           // mesero.borrarMesero(nm);
            
            //actualizar mesero, actualiza los siguientes datos de un mesero: nombre, dni y estado
            //mesero.actualizarMesero("Pablo", 55666777, false, -2);
            
            //buscar mesero busca un mesero por el id(se puede cambiar para filtrar por otra cosa)
            // 3 es igual al id del mesero que busca
            mesero.buscarMesero(-2);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error al instanciar la clase conexion: " + e.getMessage());
        }
    }
    
}

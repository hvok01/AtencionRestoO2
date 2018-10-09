
package atencionresto;


public class AtencionResto {

    
    public static void main(String[] args) {
        Conexion conexion;
        
        try {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            MeseroData mesero = new MeseroData(conexion);
            Mesero nm = new Mesero();
            
            // metodos que se pueden hacer
            
            //guardar mesero, agrega a la base de datos un mesero, atributos, nombre, dni y estado
            // mesero.guardarMesero("nombre", 22111333, true);
            
            //borrar mesero elimina un mesero por el nombre
            //mesero.borrarMesero("nombre");
            
            //actualizar mesero, actualiza los siguientes datos de un mesero: nombre, dni y estado
            //mesero.actualizarMesero("nombre", 22333444, false,4);
            
            //buscar mesero busca un mesero por el id(se puede cambiar para filtrar por otra cosa)
            // 3 es igual al id del mesero que busca
            //mesero.buscarMesero(3);
            
        } catch (Exception e) {
            System.out.println("Error al instanciar la clase conexion: " + e.getMessage());
        }
    }
    
}

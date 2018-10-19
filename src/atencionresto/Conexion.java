
package atencionresto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private String url;
    private String usuario;
    private String password;

    private Connection conexion;

    public Conexion() {
    }
    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
      
    }
    
   
    public Connection getConexion() throws ClassNotFoundException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return conexion = DriverManager.getConnection(url,usuario,password);
           
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

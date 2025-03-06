/*package cap_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CConexion {

    private Connection conectar = null;
    private static CConexion instancia = null;

    private final String usuario = "root";
    private final String contraseña = "";
    private final String bd = "dbpos";
    private final String ip = "localhost";
    private final String puerto = "3306";
    private final String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd + "?serverTimezone=UTC";

    private CConexion() {
        estableceConexion();
    }

    public static CConexion getInstancia() {
        if (instancia == null) {
            instancia = new CConexion();
        }
        return instancia;
    }

    public Connection getConectar() {
        if (conectar == null) {
            estableceConexion();
        }
        return conectar;
    }

    private void estableceConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Nueva versión del driver
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            System.out.println("Conexión correcta a BD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE CONECTÓ A LA BD: " + e.toString());
        }
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("La conexión fue cerrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.toString());
        }
    }
}
*/

package cap_bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    //library 
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    // database credentials
    private static final String URL = "jdbc:mysql://localhost/dbpos";
    private static final String USER ="root";
    private static final String PASSWORD = "123456";
    
    private static Connection con = null;

    private static ConexionDB instancia  = null;

    //THIS CLASS USES THE SINGLETON PATTERN  TO MANIPULATE DATA IN A MYSQL DATABASE  
    public static ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }
    
    public Connection getConnection() {
        return con;
    }
    

    public ConexionDB() {
        try {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.out.println("conexion fallida");
        }
    }
    
     public static void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión cerrada");
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
     
}

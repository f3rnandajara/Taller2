package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author blasc
 */
public class ConexionBD {

    public static Connection iniciarConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String serv = "jdbc:mysql://localhost:3306/inventario";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(serv, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Error DB");
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } catch (Exception e) {
            System.out.println("Error de capa 8");
        }
        return con;
    }
}
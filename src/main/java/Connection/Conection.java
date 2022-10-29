package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    private static final String Driver="com.mysql.cj.jdbc.Driver";
    private static final String Url="jdbc:mysql://localhost/api_nyt";
    private static final String Usuario="root";
    private static final String Pass="";

    public static Connection conexion;

    static {
        try {

            Class.forName(Driver);
            conexion = DriverManager.getConnection(Url, Usuario, Pass);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
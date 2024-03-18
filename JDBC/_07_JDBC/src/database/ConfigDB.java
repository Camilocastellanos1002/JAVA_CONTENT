package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable que va a contener el estado de la conexión

    static Connection objConnection = null;

    //Metodo para abrir la conexion entre Java y la base de datos

    public  static Connection openConnection(){
        try {
            //Class forname permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //copiar el nombre de la base de datos creada en MySQL Workbrench

            String url = "jdbc:mysql://localhost:3306/_1_jdbc";
            String user = "root";
            String password="";

            //Establecemos la conexión
            objConnection = (Connection) DriverManager.getConnection(url, user,password);
            System.out.println("Me conecte perfectamente!!");

        }catch (ClassNotFoundException e){
            System.out.println("Error >> Driver no Instalado");
        }catch (SQLException e){
            System.out.println("Error >> No se puede establecer una conexion con la base de datos ");
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null) {
                objConnection.close();
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}

/**
* Conexion
* Es una clase que permite establecer una conexión a la base de datos Test de SQL-Server 2019
* @author Armando J. López L. / UCA
* @version 0.1, 2021/10/13
*/

package domain;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion
{
       public static Connection cn=null; 
    
        // A continuación los atributos de la conexión
        private String driver;
        private String url;
        private String database;
        private String user;
        private String password;
    
    //Constructor: observe que es privado, esto permite no crear instancias desde fuera de la clase
    private Conexion(){
           
           try {
               driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
               url="jdbc:sqlserver://localhost:1434;databasename=Registro;";
               user="user=sa;";
               password="password=Mrs2003;";
               
               Class.forName(driver);
               cn = DriverManager.getConnection(url+user+password);
               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
               
           }
            
                
            
    }
                                
    // El método que permite obtener una única instancia. Oberve que la conección se crea solo la primera vez
    public static Connection getConexion()
    {
        if(cn==null){
            new Conexion();              
        }
        
        return cn;
    }
    
    // Cierra la conexión si está abierta
    public void cerrar() throws SQLException
    {
        if(cn!=null){
            cn.close();
        }            
    }
}

package domain;

//Importar paquetes para la conexion SQL

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.logging.Level;
import java.util.logging.Logger;




public class TCita {
    
     // A continuación los atributos de la conexión a clinica
    
    Connection cn;
    Statement stm;
    ResultSet rs;
    
    public TCita(){
        cn = Conexion.getConexion();
    }
    
    
    //Metodos necesarios para cargar cita en la base de datos
    
    
    public void cargarDatos(){
        try {
            stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=stm.executeQuery("SELECT * FROM Citas");
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   public void agregar(Cita e){
        try {
            rs.moveToInsertRow();
            
            rs.updateString("paciente", e.getPaciente());
            rs.updateString("fechaCita", e.getFecha());
            
            rs.insertRow();
        } catch (SQLException ex) {
            Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
   public void modificar(Cita e){
        try {
            
            rs.updateString("paciente", e.getPaciente());
            rs.updateString("fechaCita", e.getFecha());
            rs.updateRow();
        } catch (SQLException ex) {
            Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cita leerRegistro(int i){
         try {
            Cita c = new Cita();
            this.rs.absolute(i);
            c.setPaciente(rs.getString("paciente"));
            c.setFecha(rs.getString("fechaCita"));
            
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
         
    }
    public Cita leerRegistroActual(){
        try {
            Cita c = new Cita();

            c.setPaciente(rs.getString("paciente"));
            c.setFecha(rs.getString("fechaCita"));
            
            return c;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
   public boolean siguiente(){
        try {
        if(rs.next()!=false){
            return true;
        }
        else{
            rs.previous();
            return false;
        }
        } catch (SQLException ex) {
                Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
        
    }
    public boolean anterior(){
        try {
        if(rs.previous()!=false){
            return true;
        }
        else{
            rs.next();
            return false;
        }
        } catch (SQLException ex) {
                Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    public void eliminar(){
        try {
            rs.deleteRow();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

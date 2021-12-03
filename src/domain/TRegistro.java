package domain;

//Importar paquetes para la conexion SQL

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TRegistro {
    
    //atributos de la conexion
    
    Connection cn;
    Statement stm;
    ResultSet rs;
    
    //Conexion de TRegistro a sql
    
    public TRegistro(){
        cn=Conexion.getConexion();
    }
    
    public void cargarDatos(){
        try {
            stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=stm.executeQuery("SELECT * FROM Registro");
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregar(Registro e){
        try {
            rs.moveToInsertRow();
            
            rs.updateString("paciente", e.getPac());
            rs.updateString("diagnostico", e.getDiagnostico());
            rs.updateString("tratamiento", e.getTratamiento());
            
            
            rs.insertRow();
        } catch (SQLException ex) {
            Logger.getLogger(TRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(Registro e){
        try {
            
            rs.updateString("paciente", e.getPac());
            rs.updateString("diagnostico", e.getDiagnostico());
            rs.updateString("tratamiento", e.getTratamiento());
            rs.updateRow();
        } catch (SQLException ex) {
            Logger.getLogger(TRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Registro leerRegistro(int i){
         try {
            Registro reg = new Registro();
            this.rs.absolute(i);
            reg.setPac(rs.getString("paciente"));
            reg.setDiagnostico(rs.getString("diagnostico"));
            reg.setTratamiento(rs.getString("tratamiento"));
            
            return reg;
        } catch (SQLException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Registro leerRegistroActual(){
        try {
            Registro reg = new Registro();
            
            reg.setPac(rs.getString("paciente"));
            reg.setDiagnostico(rs.getString("diagnostico"));
            reg.setTratamiento(rs.getString("tratamiento"));
            
            return reg;
        } catch (SQLException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //Metodos del boton siguiente, anterior y eliminar 
    
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
                Logger.getLogger(TRegistro.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TRegistro.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    public void eliminar(){
        try {
            rs.deleteRow();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

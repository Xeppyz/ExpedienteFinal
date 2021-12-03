package domain;

//importar paquetes para la conectividad del SQL

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class TPaciente {
    
    //Atributos de la conexion 
    
    Connection cn;
    Statement stn;
    ResultSet rs;
    
    
    //Cargar datos pacientes a la base sql
    
    public TPaciente(){
        cn = Conexion.getConexion();
    }
    
    public void cargarDatos(){
        try {
            stn=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs=stn.executeQuery("SELECT * FROM Paciente");
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void agregar(Paciente e){
        try {
            rs.afterLast();
            rs.moveToInsertRow();
            rs.updateString("nombre", e.getNombre());
            rs.updateInt("edad", e.getEdad());
            rs.updateInt("id", e.getId());
            rs.updateInt("numTelef", e.getNumTelef());
            rs.insertRow();
            
            JOptionPane.showMessageDialog(null, "Paciente Creado", "Crear Paciente", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Paciente leerRegistro(int i){
         try {
            Paciente pac = new Paciente();
            this.rs.absolute(i);
            pac.setNombre(rs.getString("nombre"));
            pac.setId(rs.getInt("id"));
            pac.setEdad(rs.getInt("edad"));
            pac.setId(rs.getInt("numTelef"));
            return pac;
        } catch (SQLException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Paciente leerRegistroActual(){
        try {
            Paciente e = new Paciente();
            e.setNombre(rs.getString("nombre"));
            e.setEdad(rs.getInt("edad"));
            e.setId(rs.getInt("id"));
            e.setNumTelef(rs.getInt("numTelef"));
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        //Metodos para lograr la función del boton siguiente y anterior
        //Utilización de for 
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
                Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
}

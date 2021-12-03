package domain; //Paquete donde se almacena las clases domain


import java.sql.Date; //Importar tipo de datos de fecha más simple, permite registrar únicamente el día (año, mes, día) sin horas



/**
 * @author Marcelo
 * @version 1.0
 * @created 26-Nov-2021 6:27:26 PM
 */
public class Cita { 

        private String paciente; //Declaración de una variable  tipo String paciente
	private String fecha; //Declaración de una variable tipo String fecha

	public Cita(){

	} 
	public void finalize() throws Throwable {

	}
        
    //Creación de metodos y atributos
    //Encapsular 

    public String getPaciente() { //Obetner paciente
        return paciente;
    }

    public void setPaciente(String paciente) { //setear paciente
        this.paciente = paciente;
    }

    public String getFecha() { //Obtener fecha
        return fecha;
    }

    public void setFecha(String fecha) { //Setear fecha
        this.fecha = fecha;
    }
        
}//end Cita
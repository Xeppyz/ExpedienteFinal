    package domain; //Paquete donde se almacena las clases domain



/**
 * @author Marcelo
 * @version 1.0
 * @created 26-Nov-2021 6:27:26 PM
 */
public class Paciente {

    //Declaración de variables/atributos
    
	private int edad;
	private int id;
	private String nombre;
	private int numTelef;

	public Paciente(){

	}

	public void finalize() throws Throwable {

	}

        //Encapsulamiento de la clase paciente
        
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumTelef() {
        return numTelef;
    }

    public void setNumTelef(int numTelef) {
        this.numTelef = numTelef;
    }
        
}//end Paciente
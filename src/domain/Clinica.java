package domain; //Paquete donde se almacena las clases domain

import java.sql.*; //Importar la conectivadad del SQL
import java.util.logging.Level; // interfaz de programación de registro de Java.
import java.util.logging.Logger; //Archivo de tecto en el que cronológicamente consta de acontecimientos que han afectado al sistema

/**
 * @author Marcelo
 * @version 1.0
 * @created 26-Nov-2021 6:27:26 PM
 */
public class Clinica {

	private Registro m_Registro = new Registro(); //Creación de objeto m_Registro
	
        private Paciente p = new Paciente(); // Creación de objeto p
        
        

	public Clinica(){
            
	}
        //Metodos y atributos 

	public void finalize() throws Throwable {

	}
	public void agregarPaciente(Paciente p){ //Metodo agregar paciente
            m_Registro.crearPaciente(p);
	}
        public void agregarCita(Cita m){ //Metodo agregar cita
            this.m_Registro.cargarCita();
            this.m_Registro.crearCita(m);
        }
        public void cargarCita() {  //Metodo cargar cita 
            this.m_Registro.cargarCita();
        }
        public Cita leerCita(){ //Metodo leerCita
            Cita n;
            this.cargarCita();
            return n = this.m_Registro.leerCita(1);
        }
        public Cita leerCitaActual(){ //Metodo leerCitaActual
            Cita n;
            return n = this.m_Registro.leerCitaAct();
        }

         public boolean sigCita(){ //Metodo siguiente cita
            boolean sig = this.m_Registro.siguienteCita();
            return sig;
        }
        public boolean antCtia(){ //Metodo anterior cita
            boolean ant = this.m_Registro.anteriorCita();
            return ant;
        }
        
        public void modificarCita(Cita m){ //Metodo modificar una cita
            
            this.m_Registro.modificarCita(m);
        }
        
        public void eliminarCita(){ //Metodo eliminar una cita
            this.m_Registro.eliminarCita();
        }

        
        public void crearRegistro(Registro m){ //Metodo cargar el registro
            this.m_Registro.cargarRegistro();
            this.m_Registro.crearRegistro(m);
        }
        
        public Registro leerRegistroAct(){ //Metodo leer el registro actualizado
            Registro n;
            return n = this.m_Registro.leerRegistroAct();
        }
        public Registro leerRegistro(){ //Metodo leer un registro
            Registro n;
            this.cargarRegistro();
            n=this.m_Registro.leerRegistro(1);
            return n;
        }
        public boolean sigRegistro(){ //Metodo siguiente registro
            boolean sig = this.m_Registro.siguienteReg();
            return sig;
        }
        public boolean antRegistro(){ //Metodo anterior registro
            boolean ant = this.m_Registro.anteriorReg();
            return ant;
        }
        
        public void modificarRegistro(Registro m){ //Metodo modificar el registro
            
            this.m_Registro.modificarReg(m);
        }
        
        public void eliminarRegistro(){ //Metodo eliminar un registro
            this.m_Registro.eliminarReg();
        }

	
        public void cargarRegistro(){ //Metodo cargar el registro
            this.m_Registro.cargarRegistro();
        }
        public void cargarPacientes(){ //Metodo cargar el paciente
            this.m_Registro.cargarPaciente();
        }
       
        public Paciente leerPaciente(){ //Metodo leer paciente
            
            this.p=this.m_Registro.leerPaciente(1);
            
            return p;
        }
        public Paciente leerPacienteAct(){ //Metodo leer paciente actual
            return this.p = this.m_Registro.leerPacienteAct();
        }
        public boolean sigPaciente(){ //Metodo siguiente paciente
            boolean sig = this.m_Registro.siguientePac();
            return sig;
        }
        public boolean antPaciente(){ //Metodo anterior paciente
            boolean ant = this.m_Registro.anteriorPac();
            return ant;
        }
        
////        public boolean buscarUsuario(Usuario e) {
//////            int l = 1;
//////          Usuario n = this.leerUsuario(1);
//////          boolean f = false;
//////          
//////          do{
//////          if(n.getUsuario().compareTo(e.getUsuario())==0&&n.getClave().compareTo(e.getClave())==0){
//////              f = true;
//////          }else if(this.sigUsuario()){
//////              l++;
//////              n = this.leerUsuario(l);
//////          }else{
//////              break;
//////          }
//////          }while(f==false);
//////          return f;
////        }
        

    

        
        
}//end Clinica
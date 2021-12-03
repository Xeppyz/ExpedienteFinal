package domain;

import javax.swing.JOptionPane; //Parte de la libreria Swing para el manejo de interfaces gráficas



/**
 * @author Marcelo
 * @version 1.0
 * @created 26-Nov-2021 6:27:26 PM
 */
public class Registro {

    //Declaración de varibales/atributos
    
	private String diagnostico;
	private String tratamiento;
        private String pac;
        private Cita m_Cita;
        private TPaciente mn = new TPaciente();
        private TCita n_cita = new TCita();
        private TRegistro m_Registro = new TRegistro();

        public Registro(){
            
	}

	public void finalize() throws Throwable {

            //Metodos y atributos de la clase Registro
	}
	/**
	 * 
	 * @param fecha
	 */
	public void cargarCita(){
            this.n_cita.cargarDatos();
        }
        public void crearCita(Cita m){
            this.n_cita.agregar(m);
            JOptionPane.showMessageDialog(null, "Cita Guardada", "Nueva Cita", JOptionPane.INFORMATION_MESSAGE);
	}
        
        public Cita leerCita(int i){
            Cita n;
            n = this.n_cita.leerRegistro(1);
            return n;
        }
        
        public Cita leerCitaAct(){
            Cita n;
            return n = this.n_cita.leerRegistroActual();
        }
        
        public boolean siguienteCita(){
            boolean sig = this.n_cita.siguiente();
            return sig;
        }
        public boolean anteriorCita(){
            boolean ant = this.n_cita.anterior();
            return ant;
        }
        
        public void modificarCita(Cita m){
            this.n_cita.modificar(m);
            JOptionPane.showMessageDialog(null, "Registro modificado", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        
        public void eliminarCita(){
            this.n_cita.eliminar();
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        public void crearRegistro(Registro m){
            this.m_Registro.agregar(m);
            JOptionPane.showMessageDialog(null, "Registro Guardado", "Nuevo Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        
        public void cargarRegistro(){
            this.m_Registro.cargarDatos();
        }
        public Registro leerRegistro(int i){
            Registro n;
            n = this.m_Registro.leerRegistro(1);
            return n;
        }
        public Registro leerRegistroAct(){
            Registro n;
            return n =this.m_Registro.leerRegistroActual();
        }
        
        public boolean siguienteReg(){
            boolean sig = this.m_Registro.siguiente();
            return sig;
        }
        public boolean anteriorReg(){
            boolean ant = this.m_Registro.anterior();
            return ant;
        }
        
        public void modificarReg(Registro m){
            this.m_Registro.modificar(m);
            JOptionPane.showMessageDialog(null, "Registro modificado", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        
        public void eliminarReg(){
            this.m_Registro.eliminar();
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }
        
            
	public void crearPaciente(Paciente p){
            this.mn.agregar(p);
	}
        public Paciente leerPaciente(int i){
            Paciente n;
           n= this.mn.leerRegistro(i);
           return n;
        }
        public Paciente leerPacienteAct(){
            Paciente n;
            return n = this.mn.leerRegistroActual();
        }
        public void cargarPaciente(){
            this.mn.cargarDatos();
        }
        public boolean siguientePac(){
            boolean sig = this.mn.siguiente();
            return sig;
        }

        public boolean anteriorPac(){
            boolean sig = this.mn.anterior();
            return sig;
        }
	

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }
    
        
}//end Registro
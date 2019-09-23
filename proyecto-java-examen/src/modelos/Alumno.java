package modelos;

/**
 * Clase que representa un alumno
 * @author Dev
 *
 */
public class Alumno {
	
	/**
	 * instancia de la clase {@link Persona Persona} en la que están los datos básicos del alumno
	 */
	private Persona persona;
	
	/**
	 * legajo del alumno
	 */
	private int legajo;
	
	/**
	 * Constructor de la clase que instancia un objeto con sus varialbes de instancia
	 * @param pPersona objeto de la clase {@link Persona Persona}
	 * @param pLegajo entero que representa el legajo del alumno
	 */
	public Alumno(Persona pPersona, int pLegajo) {
		this.persona = pPersona;
		this.legajo = pLegajo;
	}
	
	/**
	 * Constructor de la clase que instancia un Alumno sin inicializar sus variables de instancia
	 */
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * devuelve la instancia de la clase {@link Persona Persona} en la que se encuentra los datos
	 * básicos del alumno
	 * @return instancia de la calse {@link Persona Persona}
	 */
	public Persona getPersona() {
		return this.persona;
	}
	
	/**
	 * setea la variable de instancia persona
	 * @param persona instancia de la calse {@link Persona Persona}
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	/**
	 * devuelve el legajo del alumno
	 * @return legajo del alumno
	 */
	public int getLegajo() {
		return this.legajo;
	}
	
	/**
	 * setea el valor del legajo del alumno
	 * @param legajo entero que representa el legajo del alumno
	 */
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	
}

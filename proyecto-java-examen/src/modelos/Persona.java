package modelos;

import java.util.Date;

import tipos.enumTiposDocumentos;

/**
 * Clase que representa una persona
 * @author Dev
 *
 */
public class Persona {
	
	/**
	 * tipo de documento de la persona
	 */
	private enumTiposDocumentos TipoDocumento ;
	/**
	 * Número de documento de la persona
	 */
	private long NroDocumento;
	
	/**
	 * nombre de la persona
	 */
	private String Nombre;
	
	/**
	 * Apellido de la persona
	 */
	private String Apellido;
	
	/**
	 * Fecha de Nacimiento de la persona
	 */
	private Date FechaNacimiento;
	
	/**
	 * Constructor de la clase que instancia una persona inicializando todos sus datos
	 * @param pTipoDocumento tipo de documento de la persona del tipo {@link tipos.enumTiposDocumentos enumTiposDocumentos }
	 * @param pNroDocumento número de documento
	 * @param pNombre nombre de la persona
	 * @param pApellido apellido de la persona
	 * @param pFechaNacimiento fecha de nacimiento de la persona
	 */
	public Persona(enumTiposDocumentos pTipoDocumento, int pNroDocumento, String pNombre, String pApellido, Date pFechaNacimiento) {
		this.TipoDocumento = pTipoDocumento;
		this.NroDocumento = pNroDocumento;
		this.Nombre = pNombre;
		this.Apellido = pApellido;
		this.FechaNacimiento = pFechaNacimiento;
	}
	
	/**
	 * Constructor de la clase que instancia una persona sin inicializar sus variables de instancia
	 */
	public Persona() {
		
	}
	/**
	 * devuelve el tipo de documento de la persona
	 * @return tipo de documento de la persona. Devuelve un enum del tipo {@link tipos.enumTiposDocumentos enumTiposDocumentos}
	 */
	public enumTiposDocumentos getTipoDocumento() {
		return this.TipoDocumento;
	}
	
	/**
	 * devuelve el tipo de documento en formato string
	 * @return tipo de documento en formato string
	 */
	public String getTipoDocumentoString() {
		return this.TipoDocumento.toString();
	}
	
	/**
	 * setea el tipo de documento de la persona. 
	 * @param tipoDocumento tipo de documento a setear del tipo {@link tipos.enumTiposDocumentos enumTiposDocumentos}
	 */
	public void setTipoDocumento(enumTiposDocumentos tipoDocumento) {
		this.TipoDocumento = tipoDocumento;
	}
	
	/**
	 * devuelve el número de documento de la persona
	 * @return número de documento de la persona
	 */
	public long getNroDocumento() {
		return this.NroDocumento;
	}
	
	/**
	 * setea el número de documento de la persona
	 * @param nroDocumento valor entero que representa el número de documento de la persona
	 */
	public void setNroDocumento(int nroDocumento) {
		this.NroDocumento = nroDocumento;
	}
	
	/**
	 * devuelve el nombre de la p ersona
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return this.Nombre;
	}
	
	/**
	 * setea el nombre de la persona
	 * @param nombre nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	
	/**
	 * devuelve el apellido de la persona
	 * @return apellido de la persona
	 */
	public String getApellido() {
		return this.Apellido;
	}
	
	/**
	 * setea el apellido de la persona
	 * @param apellido apellido de la persona a setear
	 */
	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}
	
	/**
	 *  devuelve la fecha de nacimiento de la persona
	 * @return fecha de nacimiento de la persona
	 */
	public Date getFechaNacimiento() {
		return this.FechaNacimiento;
	}
	
	/**
	 * setea la fecha de nacimiento de la persona
	 * @param fechaNacimiento fecha de nacimiento de la persona a setear
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.FechaNacimiento = fechaNacimiento;
	}
	

}

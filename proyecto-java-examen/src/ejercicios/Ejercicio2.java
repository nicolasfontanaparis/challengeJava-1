package ejercicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelos.Persona;
import tipos.enumTiposDocumentos;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica) 
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 * B. En el m√©todo main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * 
 * 
 * C. En el m√©todo main de la clase "Ejercicio 2" imprimir los valores en 
 * consola 
 * (crear m√©todo main e imprimir valores) 
 *  
 * @author examen
 *
 */
public class Ejercicio2{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona objPersona;
		objPersona = new Persona(enumTiposDocumentos.dni, 32296321, "Nicol·s", "Fontana", (new GregorianCalendar(1986, Calendar.JUNE, 30)).getTime());
		ImprimirValores(objPersona);

	}
	
	private static void ImprimirValores(Persona pPersona) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("Tipo y n˙mero de documento: %s - %d\n", pPersona.getTipoDocumentoString(), pPersona.getNroDocumento());
		System.out.printf("Apellido y Nombre: %s\n", pPersona.getApellido() + ", " +pPersona.getNombre());
		System.out.printf("Fecha de Nacimiento: %s\n", sdf.format(pPersona.getFechaNacimiento()));
	}

}
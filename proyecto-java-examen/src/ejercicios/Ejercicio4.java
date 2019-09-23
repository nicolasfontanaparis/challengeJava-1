package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido,
	static Integer[] valoresLista1 = { 1, 2, 5, 8, 10, 30, 20, 8, 9, 10 };
	static Integer[] valoresLista2 = { 1, 2, 4, 20, 5, 10, 7, 8, 10, 9 };

	/**
	 * Para ejecutar el mÃ©todo main se debe hacer boton derecho sobre la clase "Run
	 * As --> Java Application"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("**** inicializando datos ****");

		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));

		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		// informacion(lista1, 10);

		// EJERCICIO 4.2: corregir el metodo
		// List<Integer> union = unionListas(lista1, lista2);
		// System.out.println("union: " + union.toString());

		// EJERCICIO 4.3: implementar
		// List<Integer> interseccion = interseccionListas(lista1, lista2);
		// System.out.println("interseccion: " + interseccion.toString());

		// EJERCICIO 4.4: implementar
		// List<Integer> orden1 = ordenaListaAscendente(lista1);
		// System.out.println("orden asc: " + orden1);

		// EJERCICIO 4.5: implementar
		// List<Integer> orden2 = ordenaListaDescendente(lista2);
		// System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		 boolean b = tienenMismoContenido(lista1, lista2);
		 System.out.println("mismo contenido: " + b);

	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la
		// implementacion

		int pares = 0;
		for (Integer n : lista1) {
			if (n % 2 == 0) {
				pares = pares + 1;
			}
		}

		// se muestra la cantidad de números pares encontrados en el loop anterior
		System.out.println("... " + pares);

		List<Integer> impares = new ArrayList<Integer>();
		for (Integer n : lista1) {
			if (n % 2 != 0) {
				impares.add(n);
			}
		}

		// Se muestra los números impares separados por coma en único string.
		// Los números impares se fueron buscando en el loop anterior y se fueron
		// agregando a un arraylist
		System.out.println("... " + impares.toString());

		int p = lista1.size() / 2;

		// se muestra la posición en la que se encuentra el valor de p. En este caso
		// p tiene la longitud de la lista dividido 2 (división entera)
		// En este caso 10/2 = 5, la posición de 5 es la tercera (2 contando desde cero)
		System.out.println("..." + lista1.indexOf(p));

		// se cuenta la cantidad de números que son mayores a el parámetro numero, en
		// este caso 10
		int c = 0;
		for (Integer n : lista1) {
			if (n > numero) {
				c = c + 1;
			}
		}

		// se evalúa si la cantidad de números mayores a 10 es mayor a la mitad del
		// tamaño de la lista
		// por lo tanto para este caso 2 >5
		if (c > lista1.size() / 2) {
			// se muestra este caso
			System.out.println("...");
		} else if (c > 0) {
			System.out.println("...");
		} else {
			System.out.println("...");
		}
		/**
		 * POSIBLES MEJORAS usar un único loop para contar los números pares, agregar
		 * impares a la lista y para contar la cantidad de números mayores a 10
		 */
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 *               retornar una lista que contenga los elementos de ambas listas,
	 *               sin elementos repetidos
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente

		// List<Integer> union = null;
		List<Integer> union = new ArrayList<Integer>();
		union.addAll(lista1);
		union.addAll(lista2);
		
		Set<Integer> listaSinRepetidos = new HashSet<Integer>(union);
		/*for (Integer m : lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}*/
		union.clear();
		union.addAll(listaSinRepetidos);
		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 *               retornar una lista que contenga los elementos que estan
	 *               presentes en ambas listas, sin elementos repetidos
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		int nroActual;
		ArrayList<Integer> interseccion = new ArrayList<Integer>();
		Iterator<Integer> it = lista1.iterator();
		
		while(it.hasNext()) {
			nroActual = (Integer)it.next();
			if (lista2.indexOf(nroActual) != -1 && interseccion.indexOf(nroActual) == -1 ) {
				interseccion.add(nroActual);
			}
		}
		return interseccion;
	}

	/***
	 * @param lista1
	 * 
	 *               retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		//Implementación con ordenamiento burbuja
		ArrayList<Integer> listaOrdenadaAsc = new ArrayList<Integer>();
		listaOrdenadaAsc.addAll(lista1);
		int nroTemporal;
		for (int i = 0; i < listaOrdenadaAsc.size(); i++) {
			for (int j = 0; j < listaOrdenadaAsc.size()-1; j++) {
				if (listaOrdenadaAsc.get(j) > listaOrdenadaAsc.get(j + 1)) {
                    
					nroTemporal = listaOrdenadaAsc.get(j+1);
                    listaOrdenadaAsc.set(j+1, listaOrdenadaAsc.get(j));
                    listaOrdenadaAsc.set(j, nroTemporal);
                }
			}
		}
				
		//Implementación usando librerías de java
		//Collections.sort(listaOrdenadaAsc);
		return listaOrdenadaAsc;
	}

	/***
	 * @param lista2
	 * 
	 *               retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		//Implementación con ordenamiento burbuja
		ArrayList<Integer> listaOrdenadaDesc = new ArrayList<Integer>();
		listaOrdenadaDesc.addAll(lista2);
		int nroTemporal;
		for (int i = 0; i < listaOrdenadaDesc.size(); i++) {
			for (int j = 0; j < listaOrdenadaDesc.size()-1; j++) {
				if (listaOrdenadaDesc.get(j) < listaOrdenadaDesc.get(j + 1)) {
                    
					nroTemporal = listaOrdenadaDesc.get(j+1);
					listaOrdenadaDesc.set(j+1, listaOrdenadaDesc.get(j));
					listaOrdenadaDesc.set(j, nroTemporal);
                }
			}
		}
		//Implementación usando librerías de java
		//Collections.sort(listaOrdenadaDesc);
		//Collections.reverse(listaOrdenadaDesc);
		return listaOrdenadaDesc;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 *               devuelve true si contienen los mismos elementos NO se considera
	 *               valido que esten en diferente orden NO se considera valido que
	 *               la cantidad de repeticiones de los elementos sea diferente
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		// TODO:
		if(lista1.size() != lista2.size()) {
			return false;
		} else {
			for (int i = 0; i < lista1.size(); i++) {
				if(lista1.get(i) != lista2.get(i)) {
					return false;
				}
			}
		}
		return true;
	}

}

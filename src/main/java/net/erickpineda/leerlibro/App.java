package net.erickpineda.leerlibro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *
 */
public class App {
	public static void main(String[] args) {
		entrada("/SAGeology.txt");
	}

	private static BufferedReader br;

	private static HashMap<String, ContarPalabras> mapa;

	public static void entrada(String fichero) {

		br = null;
		InputStream entrada = App.class.getResourceAsStream(fichero);

		Pattern eliminoCaracteres = Pattern.compile("([A-Za-zÑñáéíóúÁÉÍÓÚ]+)");
		String[] carac = { ",", ":", "-", "#", "." };

		if (entrada != null) {
			Reader leer = new InputStreamReader(entrada);
			br = new BufferedReader(leer);
			String lineaFichero = null;
			clausulasLL(lineaFichero);

		} else {
			System.out.println("***NO SE HA PODIDO LEER EL FICHERO***");
		}
	}

	public static void clausulasLL(String linea) {
		try {
			linea = br.readLine();

			leerLibro(linea);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void cuentaPalabras(final String palabra) {

		if (mapa.containsKey(palabra)) {
			mapa.get(palabra).incrementarPalabra();

		} else {
			mapa.put(palabra, new ContarPalabras(palabra));

		}
	}

	public static void leerLibro(String linea) throws IOException {

		mapa = new HashMap<String, ContarPalabras>();

		while (linea != null) {

			if (!linea.trim().equals("")) {
				// System.out.println();

				noQuieroCaracteresRaros(linea);
				//System.out.println(linea);

			}
			linea = br.readLine();
		}
	}

	public static String noQuieroCaracteresRaros(String linea) {
		String minusculas = linea.toLowerCase();
		String retorna = null;
		String[] array = minusculas.split(" ");
		
		Pattern exre = Pattern.compile("([A-Za-zÑñáéíóúÁÉÍÓÚ]+)");
		Matcher mat = exre.matcher(minusculas);

		if (mat.matches()) {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
				retorna = retorna + minusculas.charAt(i);
			}
		}
		return retorna;
	}
}

package net.erickpineda.leerlibro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		leoLibro("/SAGeology.txt");
	}

	public static void leoLibro(String fichero) {

		BufferedReader br = null;
		InputStream entrada = App.class.getResourceAsStream(fichero);

		if (entrada != null) {
			Reader leer = new InputStreamReader(entrada);
			br = new BufferedReader(leer);

			String lineaFichero;
			try {
				lineaFichero = br.readLine();
				
				while (lineaFichero != null) {
					System.out.println(lineaFichero);
					lineaFichero = br.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}

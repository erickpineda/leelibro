package net.erickpineda.leerlibro;

public class ContarPalabras {
	private String palabra;
	private int contarVeces;
	
	public ContarPalabras(){
		
	}
	
	public ContarPalabras(final String laPalabra){
		palabra = laPalabra;
		contarVeces = 1;
	}
	
	public String getPalabra(){
		return palabra;
	}
	
	public int getContarVeces(){
		return contarVeces;
	}
	
	public int incrementarPalabra(){
		return contarVeces++;
	}
	
	public String toString(){
		return ">> La palabra " + palabra + " veces repetida " + contarVeces;
	}
}

package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	// Variable para almacenar el porcentaje de descuento
	private double porcDescuento;
	
	// Variable para almacenar los autores en oferta
	private String[] autoresOferta;
	
	/**
	 * Constructor para crear instancias de la clase LibreriaOferta.
	 * @param desc	Porcentaje de descuento
	 * @param autores	Array con autores en descuento
	 */
	public LibreriaOferta(double desc, String[] autores) {
		if (desc < 0) 
			throw new RuntimeException("El porcentaje de descuento no puede ser negativo");
		porcDescuento = desc;
		autoresOferta = autores;
	}
	
	/**
	 * Devuelve el array con los autores que están en oferta.
	 * @return	Array de autores en oferta
	 */
	public String[] getOferta() {
		return autoresOferta;
	}
	
	/**
	 * Devuelve el porcentaje de descuento.
	 * @return	Porcentaje de descuento
	 */
	public double getDescuento() {
		return porcDescuento;
	}
	
	/**
	 * Redefinición de addLibro que agrega un objeto LibroOferta en la lista de libros de la librería, 
	 * si el autor está en oferta, y un objeto Libro si no lo está.  
	 */
	@Override
	public void addLibro(String aut, String tit, double precio) {
		Libro libro = null;
		if (buscarAutorOferta(aut) >= 0) // El autor está en oferta
			libro = new LibroOferta(aut,tit,precio,porcDescuento);
		else // El autor no está en oferta
			libro = new Libro(aut,tit,precio);
		anyadirLibro(libro);
	}
	
	/**
	 * Método protegido para determinar si un determinado autor está en oferta. 
	 * Devuelve la posición del array de autores en oferta si está, y -1 si no se encuentra.
	 * @param autor	Autor que se quiere localizar
	 * @return Posición del array o -1 si no se localiza
	 */
	protected int buscarAutorOferta(String autor) {
		boolean encontrado = false;
		int i=0;
		while(i < autoresOferta.length && ! encontrado) {
			encontrado = autoresOferta[i].equalsIgnoreCase(autor);
			i++;
		}
		return encontrado ? i-1 : -1;
	}
	
	/**
	 * Representación textual de la librería con ofertas.
	 */
	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta) + super.toString();
	}
}

package libreria;

import java.util.Arrays;

/**
 * Implementación de la interfaz OfertaFlex que determina como criterio de descuento
 * el que el autor esté en un determinado array de autores en oferta. 
 */
public class OfertaAutor implements OfertaFlex {
	// Porcentaje de descuento a aplicar
	private double porcDescuento;
	
	// Array de autores que están en oferta
	private String[] autoresOferta;
	
	/**
	 * Constructor que crea objetos de la clase a partir de un porcentaje 
	 * de descuento y un array de autores en oferta.
	 * @param porcDesc	Porcentaje de descuento
	 * @param autores	Array de autores en oferta
	 */
	public OfertaAutor(double porcDesc, String[] autores) {
		porcDescuento = porcDesc;
		autoresOferta = autores;
	}
	
	/**
	 * Si el autor del libro que se pasa como argumento está en oferta
	 * devuelve el descuento correspondiente, si no lo está, devuelve 0.
	 */
	public double getDescuento(Libro l) {
		return buscarAutorOferta(l.getAutor()) >= 0 ? porcDescuento : 0;
	}
	
	/**
	 * Método protegido que devuelve la posición de un autor en el array de 
	 * autores en oferta, y -1 si no está. 
	 * @param autor	Autor a buscar
	 * @return	Posición del autor en el array de autores en oferta o -1
	 */
	protected int buscarAutorOferta(String autor) {
		int i=0;
		while(i < autoresOferta.length && ! autoresOferta[i].equalsIgnoreCase(autor))
			i++;
		return i == autoresOferta.length ? -1 : i;
	}
	
	/**
	 * Representación textual:
	 * 		Porcentaje de descuento%[Elementos del array]
	 */
	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta);
	}
}

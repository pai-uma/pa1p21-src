package libreria;

/**
 * La clase LibreriaOfertaFlex (del paquete libreria) hereda de la clase Libreria, 
 * pero permite crear y almacenar libros en oferta. Para ello, contiene
 * una referencia a un objeto que implemente la intefaz OfertaFlex
 */
public class LibreriaOfertaFlex extends Libreria {
	// Variable que representa el tipo de oferta que se quiere aplicar
	private OfertaFlex oferta;
	
	/**
	 * Constructor que crea una librería, asignándole el tipo de oferta que se va aplicar 
	 * @param of OfertaFlex
	 */
	public LibreriaOfertaFlex(OfertaFlex of) {
		oferta = of;
	}
	
	/**
	 * Modifica la oferta a aplicar
	 * @param ofNueva	OfertaFlex
	 */
	public void setOferta(OfertaFlex ofNueva) {
		oferta = ofNueva;
	}
	
	/**
	 * Obtiene la oferta que se está aplicando
	 * @return	OfertaFlex
	 */
	public OfertaFlex getOferta() {
		return oferta;
	}
	
	/**
	 * Redefine la forma de agregar un libro a la librería. 
	 * Si el libro que se va a añadir tiene algún descuento, se añade a la librería como LibroOferta.
	 */
	@Override
	public void addLibro(String a, String t, double precio) {
		Libro l = new Libro(a,t,precio);
		double porcDescuento = oferta.getDescuento(l);
		if (porcDescuento > 0)
			l = new LibroOferta(a,t,precio,porcDescuento);
		anyadirLibro(l);
	}

	/**
	 * Representación textual de una libreria con oferta flexible.
	 */
	@Override
	public String toString() {
		return oferta.toString() + super.toString();
	}
}

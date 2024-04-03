package libreria;

/**
 * Interfaz que incluye un método para obtener el porcentaje de descuento aplicado a un libro.
 * El descuento podrá ser aplicado según diferentes criterios que deberán establecer las 
 * clases que implementen la interfaz.
 */
public interface OfertaFlex {
	double getDescuento(Libro libro);
}

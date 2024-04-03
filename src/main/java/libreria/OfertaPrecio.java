package libreria;

/**
 * Implementación de la interfaz OfertaFlex que determina como criterio de descuento
 * el que el precio esté por encima de un determinado umbral. 
 */
public class OfertaPrecio implements OfertaFlex {
	// Porcentaje de descuento a aplicar
	private double porcDescuento;
	
	// Precio mínimo a partir del cuarl se aplica descuento
	private double umbral;
	
	/**
	 * Constructor para crear objetos de OfertaPrecio a partir
	 * de un descuento y un umbral sobre el precio.
	 * @param porcDesc	Porcentaje de descuento
	 * @param umb		Umbral del precio
	 */
	public OfertaPrecio(double porcDesc, double umb) {
		porcDescuento = porcDesc;
		umbral = umb;
	}
	
	/**
	 * Devuelve el descuento que le corresponde a un libro. Este dependerá de si el precio
	 * es mayor o igual que el umbral. 
	 */
	@Override
	public double getDescuento(Libro libro) {
		return libro.getBaseImponible() >= umbral ? porcDescuento : 0;
	}
	
	/**
	 * Representación textual:
	 * 	Porcentaje de Descuento&(umbral del precio)
	 */
	@Override
	public String toString() {
		return porcDescuento + "%(" + umbral + ")";
	}

}

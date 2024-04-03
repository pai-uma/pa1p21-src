package libreria;

/**
 * La clase LibroOferta (del paquete prLibreria) deriva de la clase Libro, 
 * por lo que contiene información sobre un determinado libro, pero además, 
 * permite especificar un determinado porcentaje de descuento, que será 
 * aplicado al precio base al calcular el precio final del libro.
 */
public class LibroOferta extends Libro {
	/**
	 * Porcentaje para aplicar como descuento
	 */
	private double porcDescuento;
	
	/**
	 * Constructor para crear objetos de la clase con un autor,
	 * título, precio base y porcentaje de descuento dados
	 * como argumentos.
	 * @param aut	Nombre del autor
	 * @param tit	   Título del libro
	 * @param pr	Precio base del libro
	 * @param desc	Porcentaje de descuento a aplicar
	 */
	public LibroOferta(String aut, String tit, double pr, double desc) {
		super(aut,tit,pr);	
		if (desc < 0)
			throw new RuntimeException("El porcentaje de descuento no puede ser negativo");
		porcDescuento = desc;
	}
	
	/**
	 * Método para obtener el porcentaje de descuento.
	 * @return Porcentaje de descuento
	 */
	public double getDescuento() {
		return porcDescuento;
	}
	
	/**
	 * Método para obtener la base imponible.
	 */
	@Override
	protected double getBaseImponible() {
		return super.getBaseImponible()-super.getBaseImponible()*porcDescuento/100;
	}
	
	/** 
	 * Representación textual de un libro en oferta:
	 * 		(autor; título; precio base; descuento%; base imponible; IVA%; precio final)
	 */
	@Override
	public String toString() {
		// return super.toString() + ": " + porcDescuento;
		return "(" + getAutor() + "; " + getTitulo() + "; " + getPrecioBase() + 
				"; " + getDescuento() + "%; " + getBaseImponible() + 
				"; " + getIVA() + "%; " + getPrecioFinal() + ")";
	}
	
}

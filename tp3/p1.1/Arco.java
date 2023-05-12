/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
    }

    @SuppressWarnings("unchecked") //Ignore el warning de la linea 34 -> Type safety: Unchecked cast from Object to Arco<T>
    @Override
    public boolean equals(Object o) {
        try {
            Arco<T> otro_arco = (Arco<T>) o;
            return this.getVerticeOrigen() == otro_arco.getVerticeOrigen() && this.getVerticeDestino() == otro_arco.getVerticeDestino();
        }
        catch (Exception e) {
            return false;
        }
    }
}
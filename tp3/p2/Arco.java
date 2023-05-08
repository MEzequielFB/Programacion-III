/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */

public class Arco {
    private int verticeOrigen;
	private int verticeDestino;
	private String etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, String etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return this.verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return this.verticeDestino;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	@Override
	public String toString() {
		return "\nArco [verticeOrigen=" + verticeOrigen + ", verticeDestino=" + verticeDestino + ", etiqueta=" + etiqueta
				+ "]";
	}
}
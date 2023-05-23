public class Arco<T> {

	private String verticeOrigen;
	private String verticeDestino;
	private T etiqueta;

	public Arco(String verticeOrigen, String verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public String getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public String getVerticeDestino() {
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
            return this.getVerticeOrigen().equals(otro_arco.getVerticeOrigen()) && this.getVerticeDestino().equals(otro_arco.getVerticeDestino());
        }
        catch (Exception e) {
            return false;
        }
    }

	@Override
	public String toString() {
		return "Arco [verticeOrigen=" + verticeOrigen + ", verticeDestino=" + verticeDestino + ", etiqueta=" + etiqueta
				+ "]";
	}
}
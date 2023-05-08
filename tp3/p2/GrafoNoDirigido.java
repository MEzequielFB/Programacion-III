public class GrafoNoDirigido extends GrafoDirigido {
    @Override
	public void agregarArco(int verticeId1, int verticeId2, String etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}
	
	@Override
	public int cantidadArcos() {
		//Redondea para arriba
		return (int) Math.ceil((double) super.cantidadArcos() / 2.0);
	}
}
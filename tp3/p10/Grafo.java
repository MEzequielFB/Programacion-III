import java.util.Iterator;

public interface Grafo<T> {
	
	// Agrega un vertice 
	public void agregarVertice(String nombre_tarea, String descripcion, int duracion);

	// Borra un vertice
	public void borrarVertice(String nombre_tarea);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(String nombre_tarea1, String nombre_tarea2, T etiqueta);

	public int obtenerDuracionVertice(String nombre_tarea);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	public void borrarArco(String nombre_tarea1, String nombre_tarea2);

	// Verifica si existe un vertice
	public boolean contieneVertice(String nombre_tarea);

	// Verifica si existe un arco entre dos vertices
	public boolean existeArco(String nombre_tarea1, String nombre_tarea2);
	
	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Arco<T> obtenerArco(String nombre_tarea1, String nombre_tarea2);

	// Devuelve la cantidad total de vertices en el grafo
	public int cantidadVertices();

	// Devuelve la cantidad total de arcos en el grafo
	public int cantidadArcos();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
	public Iterator<Tarea> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
	public Iterator<Tarea> obtenerAdyacentes(String nombre_tarea);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arco<T>> obtenerArcos();
		
	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
	public Iterator<Arco<T>> obtenerArcos(String nombre_tarea);
}
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioCaminoLargo {
    private Grafo<?> grafo;
    private int vertice_origen;
    private int vertice_destino;

    public ServicioCaminoLargo(Grafo<?> grafo, int vertice_origen, int vertice_destino) {
        this.grafo = grafo;
        this.vertice_origen = vertice_origen;
        this.vertice_destino = vertice_destino;
    }

    public List<Integer> camino() {
        //Verifica que el grafo tenga ambos vertices, sino, devuelve null
        if (grafo.contieneVertice(this.vertice_origen) && grafo.contieneVertice(vertice_destino)) {

            //En la lista camino se guardan todos los caminos encontrados
            //La lista camino_mas_largo es la que se le va a devolver al usuario
            LinkedList<LinkedList<Integer>> caminos = new LinkedList<>();
            LinkedList<Integer> camino_mas_largo = new LinkedList<>();

            //Se obtienen los caminos y se guardan en la lista
            this.obtenerCaminos(caminos);

            //Una vez obtenidos todos los caminos se comparan y se queda con el mas grande (mayor size)
            for (LinkedList<Integer> camino : caminos) {
                if (camino_mas_largo.isEmpty() || camino.size() > camino_mas_largo.size()) {
                    camino_mas_largo = camino;
                }
            }
            //Devuelve el camino mas largo
            return camino_mas_largo;
        }
        return null;
    }

    private void obtenerCaminos(LinkedList<LinkedList<Integer>> caminos) {
        //La lista vertices_visitados se usa para no repetir arcos
        LinkedList<Integer> vertices_visitados = new LinkedList<>();

        //Se agrega la vertice origen como primer elemento
        vertices_visitados.add(this.vertice_origen);

        //Se inicializa una variable de tipo entro en 0
        int contador = 0;

        //Se recorren los adyacentes de la vertice origen
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(this.vertice_origen);
        while (adyacentes.hasNext()) {
            //Por cada adyacente se incrementa el contador
            contador++;

            //Si el vertice origen tiene mas de un adyacente, el contador va a ser mayor a 1 en un momento dado
            //Si es asi, se borra el ultimo elemento de la lista (el adyacente anterior) para obtener los caminos del adyacente actual
            if (contador > 1) {
                vertices_visitados.removeLast();
            }

            //Se guarda en una variable al adyacente actual
            //Si no fue visitado se crea una lista con los elementos de vertices_visitados (backup_visitados) y se agrega el adyacente actual
            //Esto se hace porque se va a pasar por parametro a vertices_visitados en el metodo agregarCamino y su contenido sera modificado
            //Una vez que finaliza ese metodo la lista de vertices visitados vuelve al estado antes de llamar a ese metodo
            int adyacente = adyacentes.next();
            if (!vertices_visitados.contains(adyacente)) {
                LinkedList<Integer> backup_visitados = new LinkedList<>(vertices_visitados);
                backup_visitados.add(adyacente);

                this.agregarCamino(adyacente, caminos, vertices_visitados);

                vertices_visitados = backup_visitados;
            }
        }
    }
    
    private void agregarCamino(int vertice, LinkedList<LinkedList<Integer>> caminos, LinkedList<Integer> vertices_visitados) {
        //Se agrega el vertice pasada por parametro a los vertices visitados
        vertices_visitados.add(vertice);

        //Si el vertice es igual al vertice destino se agrega el camino conseguido hasta el momento a la lista de caminos y se retorna el metodo
        if (vertice == this.vertice_destino) {
            caminos.add(vertices_visitados);
            return;
        }

        //Se recorre los adyacentes del vertice
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            //Se guarda el estado actual de la lista de vertices visitados
            LinkedList<Integer> backup_visitados = new LinkedList<>(vertices_visitados);

            //Si el adyacente del vertice no fue visitado
            //Se pregunta si el adyacente es el vertice destino, si lo es se agrega a la lista de visitados y se agrega la lista de visitados como un camino. Finalmente retorna
            //De lo contrario llama recursivamente a agregarCamino pasando al adyacente como parametro para seguir el camino y ver si llega a destino
            //Cuando finaliza el agregarCamino recursivo, la lista de visitados vuelve al estado anterior ya que se buscara un camino a partir de otro adyacente si es que existe
            int adyacente = adyacentes.next();
            if (!vertices_visitados.contains(adyacente)) {
                if (adyacente == this.vertice_destino) {
                    vertices_visitados.add(adyacente);
                    caminos.add(vertices_visitados);
                    return;
                }
                this.agregarCamino(adyacente, caminos, vertices_visitados);
                vertices_visitados = backup_visitados;
            }
        }
    }
}
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioVerticesCamino {
    private Grafo<?> grafo;
    private int vertice_destino;

    public ServicioVerticesCamino(Grafo<?> grafo, int vertice_destino) {
        this.grafo = grafo;
        this.vertice_destino = vertice_destino;
    }

    public List<Integer> vertices() {
        //Crea una lista donde se agregan los vertices que tienen un camino hacia el vertice destino
        LinkedList<Integer> vertices_que_cumplen = new LinkedList<>();

        //Se le pregunta a cada vertice del grafo si tiene un camino hacia el vertice destino
        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            boolean resultado = existeCamino(vertice);

            //Si existe un camino o el vertice actual es igual al vertice destino se agrega a la lista
            if (resultado || vertice == this.vertice_destino) {
                vertices_que_cumplen.add(vertice);
            }
        }
        //Se devuelve la lista de los vertices con un camino hacia el vertice destino
        return vertices_que_cumplen;
    }

    //se realiza un recorrido BFS
    private boolean existeCamino(int vertice) {
        LinkedList<Integer> vertices_visitados = new LinkedList<>();
        LinkedList<Integer> cola = new LinkedList<>();
        vertices_visitados.add(vertice);
        cola.add(vertice);
        
        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!vertices_visitados.contains(adyacente)) {
                    vertices_visitados.add(adyacente);
                    cola.add(adyacente);

                    //Si el adyacente es igual al vertice destino existe un camino y se retorna true
                    if (adyacente == this.vertice_destino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
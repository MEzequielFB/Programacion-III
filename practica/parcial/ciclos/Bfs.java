import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bfs {
    private List<Integer> vertices_visitados;
    private List<Integer> cola;

    public Bfs() {
        this.vertices_visitados = new ArrayList<>();
        this.cola = new ArrayList<>();
    }

    public List<Integer> bfs(Grafo<?> grafo) {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!this.vertices_visitados.contains(vertice)) {
                this.bfsVisit(grafo, vertice);
            }
        }
        return this.vertices_visitados;
    }

    private void bfsVisit(Grafo<?> grafo, int vertice) {
        this.vertices_visitados.add(vertice);
        this.cola.add(vertice);

        while (!cola.isEmpty()) {
            int primer_elemento = this.cola.remove(0);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!this.vertices_visitados.contains(adyacente)) {
                    this.vertices_visitados.add(adyacente);
                    this.cola.add(adyacente);
                }
            }
        }
    }
}
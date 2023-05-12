import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioBfs {
    private Grafo<?> grafo;

    public ServicioBfs(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> bfs() {
        ArrayList<Integer> vertices_visitados = new ArrayList<>();

        Iterator<Integer> vertices = this.grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (!vertices_visitados.contains(vertice)) {
                this.bfs_visit(vertice, vertices_visitados);
            }
        }

        return vertices_visitados;
    }

    private void bfs_visit(Integer vertice, List<Integer> vertices_visitados) {
        ArrayList<Integer> cola = new ArrayList<>();
        cola.add(vertice);
        vertices_visitados.add(vertice);

        while (!cola.isEmpty()) {
            Integer primer_elemento_cola = cola.get(0);
            cola.remove(0);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(primer_elemento_cola);

            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                if (!vertices_visitados.contains(adyacente)) {
                    vertices_visitados.add(adyacente);
                    cola.add(adyacente);
                }
            }
        }
    }
}
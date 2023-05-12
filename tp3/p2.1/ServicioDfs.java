import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioDfs {
    private Grafo<?> grafo;

    public ServicioDfs(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> dfs() {
        ArrayList<Integer> vertices_visitados = new ArrayList<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (!vertices_visitados.contains(vertice)) {
                this.dfs_visit(vertice, vertices_visitados);
            }
        }

        return vertices_visitados;
    }

    private void dfs_visit(Integer vertice, ArrayList<Integer> vertices_visitados) {
        vertices_visitados.add(vertice);
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (!vertices_visitados.contains(adyacente)) {
                this.dfs_visit(adyacente, vertices_visitados);
            }
        }
    }
}
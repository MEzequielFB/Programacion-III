import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dfs {
    private List<Integer> vertices_visitados;

    public Dfs() {
        this.vertices_visitados = new ArrayList<>();
    }

    public List<Integer> dfs(Grafo<?> grafo) {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!this.vertices_visitados.contains(vertice)) {
                this.dfsVisit(grafo, vertice);
            }
        }
        return this.vertices_visitados;
    }

    private void dfsVisit(Grafo<?> grafo, int vertice) {
        this.vertices_visitados.add(vertice);
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!this.vertices_visitados.contains(adyacente)) {
                this.dfsVisit(grafo, adyacente);
            }
        }
    }
}
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioBfs {
    private List<Integer> vertices_visitados;

    public ServicioBfs() {
        this.vertices_visitados = new ArrayList<>();
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
        ArrayList<Integer> fila = new ArrayList<>();
        fila.add(vertice);
        this.vertices_visitados.add(vertice);

        while (!fila.isEmpty()) {
            int vertice_fila = fila.remove(fila.size()-1);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice_fila);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!this.vertices_visitados.contains(adyacente)) {
                    this.vertices_visitados.add(adyacente);
                    fila.add(adyacente);
                }
            }
        }
    }
}
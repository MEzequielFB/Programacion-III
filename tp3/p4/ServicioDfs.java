import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioDfs {
    private Grafo<?> grafo;

    public ServicioDfs(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> encontrarCaminoMasLargo(int verticeId1, int verticeId2) {
        ArrayList<Integer> vertices_visitados = new ArrayList<>();
        ArrayList<Integer> camino = new ArrayList<>();

        if (grafo.contieneVertice(verticeId1) && grafo.contieneVertice(verticeId2)) {
            this.dfs_visit(verticeId1, verticeId2, vertices_visitados, camino);
            /* vertices_visitados.add(verticeId1);
            camino.add(verticeId1);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeId1);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!vertices_visitados.contains(adyacente)) {
                    vertices_visitados.add(adyacente);
                }
            } */
        }
        
        return null;
    }

    private void dfs_visit(Integer vertice, Integer verticeId2, ArrayList<Integer> vertices_visitados, ArrayList<Integer> camino) {
        vertices_visitados.add(vertice);

        if (vertice != verticeId2) {
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
    
                if (!vertices_visitados.contains(adyacente)) {
                    this.dfs_visit(adyacente, verticeId2, vertices_visitados, camino);
                }
            }
        } else {
            if (vertices_visitados.size() > camino.size()) {
                camino = vertices_visitados;
            }
        }
    }

    /* public List<Integer> encontrarCaminoMasLargo(int verticeId1, int verticeId2) {
        ArrayList<Integer> vertices_visitados = new ArrayList<>();

        if (grafo.contieneVertice(verticeId1) && grafo.contieneVertice(verticeId2)) {
            Iterator<Integer> vertices = grafo.obtenerVertices();
            while (vertices.hasNext()) {
                Integer vertice = vertices.next();
    
                if (vertice == verticeId1) {
                    this.dfs_visit(vertice, verticeId2, vertices_visitados);
                }
            }
        }
        if (vertices_visitados.contains(verticeId2)) {
            return vertices_visitados;
        }
        return null;
    } */

    /* public List<Integer> encontrarCaminoMasLargo(int verticeId1, int verticeId2) {
        ArrayList<Integer> vertices_visitados = new ArrayList<>();

        if (grafo.contieneVertice(verticeId1) && grafo.contieneVertice(verticeId2)) {
            Iterator<Integer> vertices = grafo.obtenerVertices();
            while (vertices.hasNext()) {
                Integer vertice = vertices.next();
    
                if (!vertices_visitados.contains(vertice)) {
                    this.dfs_visit(vertice, vertices_visitados);
                }
            }
        }
        return vertices_visitados;
    } */
}
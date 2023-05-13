import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioBfs {
    private Grafo<?> grafo;

    public ServicioBfs(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> obtenerCaminoMasLargo(int verticeId1, int verticeId2) {
        ArrayList<Integer> vertices_visitados = new ArrayList<>();
        ArrayList<Integer> camino = new ArrayList<>();

        if (grafo.contieneVertice(verticeId1) && grafo.contieneVertice(verticeId2)) {
            if (verticeId1 == verticeId2) {
                camino.add(verticeId2);
                return camino;
            }
            this.bfs_visit(verticeId1, verticeId2, vertices_visitados, camino);
        }
        
        return camino;
    }

    private void bfs_visit(int vertice, int verticeId2, ArrayList<Integer> vertices_visitados, ArrayList<Integer> camino) {
        ArrayList<Integer> cola = new ArrayList<>();
        cola.add(vertice);
        vertices_visitados.add(vertice);
        camino.add(vertice);

        while (!cola.isEmpty()) {
            /* for (Integer vertice_cola : cola) {
                if (vertice == verticeId2) {
                    camino.add(vertice_cola);
                }
            } */

            int primer_elemento = cola.get(0);
            cola.remove(0);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(primer_elemento);
            /* while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (adyacente == verticeId2 && !camino.contains(adyacente)) {
                    camino.add(verticeId2);
                }
            } */

            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!vertices_visitados.contains(adyacente)) {
                    /* if (adyacente != verticeId2) {
                        vertices_visitados.add(adyacente);
                    } */
                    vertices_visitados.add(adyacente);
                    cola.add(adyacente);
                    
                }
            }
        }
    }
}
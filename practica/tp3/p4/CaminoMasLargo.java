import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CaminoMasLargo {
    private List<Integer> solucion;
    private List<Integer> vertices_visitados;
    private List<Arco<?>> arcos_visitados;

    public CaminoMasLargo() {
        this.solucion = new LinkedList<>();
        this.vertices_visitados = new LinkedList<>();
        this.arcos_visitados = new LinkedList<>();
    }

    public List<Integer> obtenerCaminoMasLargo(Grafo<?> grafo, int origen, int destino) {
        if (grafo.contieneVertice(origen) && grafo.contieneVertice(destino)) {
            this.vertices_visitados.add(origen);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();

                Arco<?> arco = new Arco<>(origen, adyacente, null);
                if (!this.arcos_visitados.contains(arco)) {
                    this.arcos_visitados.add(arco);
                    this.buscarCamino(grafo, adyacente, destino);
                    
                    this.arcos_visitados.remove(arcos_visitados.size()-1);
                    this.vertices_visitados.remove(vertices_visitados.size()-1);
                }
            }
        }
        return this.solucion;
    }

    private void buscarCamino(Grafo<?> grafo, int vertice_actual, int destino) {
        this.vertices_visitados.add(vertice_actual);

        if (this.esSolucion(vertice_actual, destino)) {
            this.solucion.clear();
            this.solucion.addAll(this.vertices_visitados);
        }

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice_actual);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();

            Arco<?> arco = new Arco<>(vertice_actual, adyacente, null);

            if (!this.arcos_visitados.contains(arco)) {
                this.arcos_visitados.add(arco);
                this.buscarCamino(grafo, adyacente, destino);

                this.vertices_visitados.remove(vertices_visitados.size()-1);
                this.arcos_visitados.remove(arcos_visitados.size()-1);
            }
        }
    }

    private boolean esSolucion(int vertice1, int vertice2) {
        return vertice1 == vertice2 && (this.solucion.isEmpty() || this.vertices_visitados.size() > this.solucion.size());
    }
}
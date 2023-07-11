import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CicloMasLargo<T> {
    private List<Integer> solucion;
    private List<Integer> vertices_visitados;
    private List<Integer> vertices_terminados;
    private List<Arco<T>> arcos_pasados;

    public CicloMasLargo() {
        this.solucion = new ArrayList<>();
        this.vertices_visitados = new ArrayList<>();
        this.vertices_terminados = new ArrayList<>();
        this.arcos_pasados = new ArrayList<>();
    }

    public List<Integer> cicloMasLargo(Grafo<?> grafo) {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!this.vertices_visitados.contains(vertice)) {
                this.dfsVisit(grafo, vertice);
                this.vertices_visitados.remove(this.vertices_visitados.size()-1);
                this.vertices_terminados.clear();
            }
        }
        return this.solucion;
    }

    private void dfsVisit(Grafo<?> grafo, int vertice) {
        this.vertices_visitados.add(vertice);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            Arco<T> arco = new Arco<>(vertice, adyacente, null);

            if (!this.arcos_pasados.contains(arco)) {
                this.arcos_pasados.add(arco);

                if (this.vertices_visitados.contains(adyacente) && !this.vertices_terminados.contains(adyacente) && this.vertices_visitados.size()+1 > this.solucion.size()) {
                    this.solucion.clear();
                    this.solucion.addAll(this.vertices_visitados);
                    this.solucion.add(adyacente);
                }
                this.dfsVisit(grafo, adyacente);

                this.arcos_pasados.remove(this.arcos_pasados.size()-1);

                int vertice_eliminado = this.vertices_visitados.remove(this.vertices_visitados.size()-1);
                if (!this.vertices_terminados.isEmpty() && vertice_eliminado == this.vertices_terminados.get(this.vertices_terminados.size()-1)) {
                    this.vertices_terminados.remove(this.vertices_terminados.size()-1);
                }
            }
        }

        this.vertices_terminados.add(vertice);
    }
}
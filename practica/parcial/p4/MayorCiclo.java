import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MayorCiclo {
    private List<Integer> solucion;
    private List<Integer> solucion_parcial;
    private List<Integer> vertices_terminados;
    private List<Arco<?>> arcos_pasados;

    public MayorCiclo() {
        this.solucion = new ArrayList<>();
        this.solucion_parcial = new ArrayList<>();
        this.vertices_terminados = new ArrayList<>();
        this.arcos_pasados = new ArrayList<>();
    }

    public List<Integer> mayorCiclo(Grafo<?> grafo) {
        this.solucion.clear();
        this.vertices_terminados.clear();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!solucion_parcial.contains(vertice)) {
                this.dfsVisit(grafo, vertice);
                this.solucion_parcial.remove(this.solucion_parcial.size()-1);
            }
        }
        return this.solucion;
    }

    private void dfsVisit(Grafo<?> grafo, int vertice) {
        this.solucion_parcial.add(vertice);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            Arco<?> arco = new Arco<>(vertice, adyacente, null);
            Arco<?> arco_invertido = new Arco<>(adyacente, vertice, null);

            if (!this.solucion_parcial.contains(adyacente)) {
                this.arcos_pasados.add(arco);
                this.dfsVisit(grafo, adyacente);

                this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                this.arcos_pasados.remove(this.arcos_pasados.size()-1);
                this.vertices_terminados.remove(adyacente);

            } else if (!this.vertices_terminados.contains(adyacente) && !this.arcos_pasados.contains(arco) && !this.arcos_pasados.contains(arco_invertido)) {
                if (this.solucion.size() < this.solucion_parcial.size()) {
                    this.solucion.clear();
                    this.solucion.addAll(this.solucion_parcial);
                    this.solucion.add(adyacente);
                }
            }
        }

        this.vertices_terminados.add(vertice);
    }
}
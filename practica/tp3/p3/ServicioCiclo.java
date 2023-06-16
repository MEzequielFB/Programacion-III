import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCiclo {
    private List<Integer> vertices_visitados;
    private List<Integer> vertices_terminados;

    public ServicioCiclo() {
        this.vertices_visitados = new LinkedList<>();
        this.vertices_terminados = new ArrayList<>();
    }

    public boolean tieneCiclo(Grafo<?> grafo) {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!this.vertices_visitados.contains(vertice)) {
                boolean tiene_ciclo = this.visit(grafo, vertice);

                if (tiene_ciclo) {
                    return tiene_ciclo;
                }
            }
        }

        return false;
    }

    private boolean visit(Grafo<?> grafo, int vertice) {
        this.vertices_visitados.add(vertice);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!this.vertices_visitados.contains(adyacente)) {
                boolean tiene_ciclo = this.visit(grafo, adyacente);

                if (tiene_ciclo) {
                    return tiene_ciclo;
                }
            } else {
                return !this.vertices_terminados.contains(adyacente);
                /* boolean adyacentes_visitados = this.tieneTodosAdyacentesVisitados(grafo, adyacente);

                if (!adyacentes_visitados) {
                    return true;
                } */
            }
        }
        if (!this.vertices_terminados.contains(vertice)) {
            this.vertices_terminados.add(vertice);
        }
        return false;
    }

    /* private boolean tieneTodosAdyacentesVisitados(Grafo<?> grafo, int vertice) {
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!this.vertices_visitados.contains(adyacente)) {
                return false;
            }
        }
        return true;
    } */
}
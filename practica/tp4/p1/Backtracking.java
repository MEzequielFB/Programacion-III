import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backtracking {
    private List<Integer> solucion;
    private List<Integer> solucion_parcial;
    private List<Arco<?>> arcos_pasados;

    public Backtracking() {
        this.solucion = new ArrayList<>();
        this.solucion_parcial = new ArrayList<>();
        this.arcos_pasados = new ArrayList<>();
    }

    public List<Integer> caminoMasLargo(Grafo<?> grafo, int entrada, int salida) {
        if (grafo.contieneVertice(entrada) && grafo.contieneVertice(salida)) {
            this.backtracking(grafo, entrada, salida);
        }
        return this.solucion;
    }

    private void backtracking(Grafo<?> grafo, int vertice_actual, int salida) {
        this.solucion_parcial.add(vertice_actual);
        
        if (this.esSolucion(vertice_actual, salida)) {
            this.solucion.clear();
            this.solucion.addAll(this.solucion_parcial);
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice_actual);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();

                Arco<?> arco_actual = new Arco<>(vertice_actual, adyacente, null);

                if (!this.arcos_pasados.contains(arco_actual)) {
                    this.arcos_pasados.add(arco_actual);
                    this.backtracking(grafo, adyacente, salida);
                    
                    this.arcos_pasados.remove(arcos_pasados.size()-1);
                    this.solucion_parcial.remove(solucion_parcial.size()-1);
                }
            }
        }
    }

    private boolean esSolucion(int vertice_actual, int salida) {
        return vertice_actual == salida && ( this.solucion.isEmpty() || this.solucion_parcial.size() > this.solucion.size() );
    }
}
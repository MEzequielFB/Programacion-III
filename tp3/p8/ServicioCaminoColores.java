import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCaminoColores<T> {
    private Grafo<?> grafo;
    private int vertice_origen;
    private int vertice_destino;
    private T color_restriccion;

    public ServicioCaminoColores(Grafo<?> grafo, int vertice_origen, int vertice_destino, T color_restriccion) {
        this.grafo = grafo;
        this.vertice_origen = vertice_origen;
        this.vertice_destino = vertice_destino;
        this.color_restriccion = color_restriccion;
    }

    public List<Integer> camino() {
        if (this.grafo.contieneVertice(vertice_origen) && this.grafo.contieneVertice(vertice_destino)) {
            LinkedList<Integer> camino = new LinkedList<>();
            LinkedList<Arco<?>> arcos_pasados = new LinkedList<>();
            return buscarCamino(this.vertice_origen, camino, arcos_pasados);
        }
        return null;
    }

    private LinkedList<Integer> buscarCamino(int vertice, LinkedList<Integer> camino, LinkedList<Arco<?>> arcos_pasados) {
        camino.add(vertice);
        if (vertice == this.vertice_destino) {
            return camino;
        }

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            Arco<?> arco_actual = this.grafo.obtenerArco(vertice, adyacente);
            if (!arcos_pasados.contains(arco_actual) && !arco_actual.getEtiqueta().equals(this.color_restriccion)) {
                arcos_pasados.add(arco_actual);
                LinkedList<Integer> posible_camino = this.buscarCamino(adyacente, camino, arcos_pasados);
                if (posible_camino != null) {
                    return posible_camino;
                }

                arcos_pasados.removeLast();
                camino.removeLast();
            }
        }
        return null;
    }

    /* private List<Integer> buscarCamino() {
        LinkedList<Integer> camino = new LinkedList<>();
        //LinkedList<Integer> arcos_pasados = new LinkedList<>();
        LinkedList<Integer> cola = new LinkedList<>();
        camino.add(this.vertice_origen);
        cola.add(this.vertice_origen);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeLast();

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                Arco<?> arco_actual = this.grafo.obtenerArco(primer_elemento, adyacente);
                if (!camino.contains(adyacente)) {
                    cola.add(adyacente);
                    if (!arco_actual.getEtiqueta().equals(this.color_restriccion)) {
                        camino.add(adyacente);
                        if (adyacente == this.vertice_destino) {
                            return camino;
                        }
                    }
                }
            }
        }
        return null;
    } */
}
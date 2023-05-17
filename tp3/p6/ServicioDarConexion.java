import java.util.Iterator;
import java.util.LinkedList;

public class ServicioDarConexion {
    private Grafo<?> grafo;
    private int computadora_origen;
    private int computadora_destino;
    private int computadora_fuera_de_servicio;

    public ServicioDarConexion(Grafo<?> grafo, int computadora_origen, int computadora_destino, int computadora_fuera_de_servicio) {
        this.grafo = grafo;
        this.computadora_origen = computadora_origen;
        this.computadora_destino = computadora_destino;
        this.computadora_fuera_de_servicio = computadora_fuera_de_servicio;
    }

    public LinkedList<Integer> darConexion() {
        if (this.grafo.contieneVertice(this.computadora_origen) && this.grafo.contieneVertice(computadora_destino) && this.grafo.contieneVertice(computadora_fuera_de_servicio)) {
            return this.obtenerCamino();
        }
        return null;
    }

    private LinkedList<Integer> obtenerCamino() {
        LinkedList<Integer> computadoras_visitadas = new LinkedList<>();
        LinkedList<Integer> cola = new LinkedList<>();

        computadoras_visitadas.add(this.computadora_origen);
        cola.add(this.computadora_origen);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();

                if (!computadoras_visitadas.contains(adyacente) && adyacente != this.computadora_fuera_de_servicio) {
                    LinkedList<Integer> backup_visitadas = new LinkedList<>(computadoras_visitadas);
                    backup_visitadas.add(adyacente);

                    LinkedList<Integer> posible_camino = this.buscarCamino(adyacente, computadoras_visitadas);
                    if (posible_camino != null) {
                        return posible_camino;
                    }

                    computadoras_visitadas = backup_visitadas;
                    cola.add(adyacente);
                }
            }
        }

        return null;
    }

    private LinkedList<Integer> buscarCamino(int computadora, LinkedList<Integer> computadoras_visitadas) {
        computadoras_visitadas.add(computadora);

        if (computadora == this.computadora_destino) {
            return computadoras_visitadas;
        }

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(computadora);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!computadoras_visitadas.contains(adyacente)) {
                return this.buscarCamino(adyacente, computadoras_visitadas);
            }
        }
        return null;
    }
}
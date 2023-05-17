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

    //Se busca un camino a partir de cada adyacente de la computadora origen
    //No se toma en cuenta la computadora fuera de servicio para la busqueda
    private LinkedList<Integer> obtenerCamino() {
        LinkedList<Integer> computadoras_visitadas = new LinkedList<>();
        computadoras_visitadas.add(this.computadora_origen);

        int contador = 0;

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(this.computadora_origen);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();

            //Solo incrementa si el adyacente no es la computadora fuera de servicio
            if (adyacente != this.computadora_fuera_de_servicio) {
                contador++;
            }
            if (contador > 1) {
                computadoras_visitadas.removeLast();
            }

            if (!computadoras_visitadas.contains(adyacente) && adyacente != this.computadora_fuera_de_servicio) {
                LinkedList<Integer> backup_visitadas = new LinkedList<>(computadoras_visitadas);
                backup_visitadas.add(adyacente);

                LinkedList<Integer> posible_camino = this.buscarCamino(adyacente, computadoras_visitadas);
                if (posible_camino != null) {
                    return posible_camino;
                }

                computadoras_visitadas = backup_visitadas;
            }
        }
        return null;
    }

    //Se buscan todos los caminos posibles a partir de computadora
    //Devuelve el primer camino en el que encuentra a la computadora destino
    private LinkedList<Integer> buscarCamino(int computadora, LinkedList<Integer> computadoras_visitadas) {
        computadoras_visitadas.add(computadora);

        if (computadora == this.computadora_destino) {
            return computadoras_visitadas;
        }

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(computadora);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!computadoras_visitadas.contains(adyacente) && adyacente != this.computadora_fuera_de_servicio) {
                LinkedList<Integer> backup_visitados = new LinkedList<>(computadoras_visitadas);
                backup_visitados.add(adyacente);

                LinkedList<Integer> posible_camino = this.buscarCamino(adyacente, computadoras_visitadas);
                if (posible_camino != null) {
                    return posible_camino;
                } else {
                    computadoras_visitadas = backup_visitados;
                }
            }
        }
        return null;
    }
}
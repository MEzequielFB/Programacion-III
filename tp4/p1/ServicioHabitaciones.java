import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioHabitaciones {
    private Grafo<?> grafo;
    private int entrada;
    private int salida;

    public ServicioHabitaciones(Grafo<?> grafo, int entrada, int salida) {
        this.grafo = grafo;
        this.entrada = entrada;
        this.salida = salida;
    }

    public List<Integer> camino() {
        LinkedList<Integer> camino = new LinkedList<>();
        if (this.grafo.contieneVertice(this.entrada) && this.grafo.contieneVertice(this.salida)) {
            this.obtenerCamino(camino);
        }
        return camino;
    }

    private void obtenerCamino(LinkedList<Integer> camino) {
        LinkedList<Integer> camino_parcial = new LinkedList<>();
        LinkedList<Arco<String>> arcos_pasados = new LinkedList<>();

        camino_parcial.add(this.entrada);

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(this.entrada);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();

            Arco<String> arco_actual = new Arco<>(this.entrada, adyacente, "");

            if (!arcos_pasados.contains(arco_actual)) {
                arcos_pasados.add(arco_actual);
                this.agregarCaminos(adyacente, camino, camino_parcial, arcos_pasados);
                camino_parcial.removeLast();
                arcos_pasados.removeLast();
            }
        }
    }

    private void agregarCaminos(int habitacion, LinkedList<Integer> camino, LinkedList<Integer> camino_parcial, LinkedList<Arco<String>> arcos_pasados) {
        camino_parcial.add(habitacion);
        if (habitacion == this.salida) {
            if (this.esMejorSolucion(camino, camino_parcial)) {
                this.reemplazarSolucion(camino, camino_parcial);
            }
        } else {
            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(habitacion);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
    
                Arco<String> arco_actual = new Arco<>(habitacion, adyacente, "");
                if (!arcos_pasados.contains(arco_actual)) {
                    arcos_pasados.add(arco_actual);
                    this.agregarCaminos(adyacente, camino, camino_parcial, arcos_pasados);
                    arcos_pasados.removeLast();
                    camino_parcial.removeLast();
                }
            }
        }
    }

    private boolean esMejorSolucion(LinkedList<Integer> camino, LinkedList<Integer> camino_parcial) {
        return camino.isEmpty() || camino.size() < camino_parcial.size();
    }

    private void reemplazarSolucion(LinkedList<Integer> camino, LinkedList<Integer> camino_parcial) {
        camino.clear();
        camino.addAll(camino_parcial);
    }
}
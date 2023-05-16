import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioCaminoCorto {
    private Grafo<?> grafo;
    private int esquina_origen;
    private int esquina_destino;

    public ServicioCaminoCorto(Grafo<?> grafo, int esquina_origen, int esquina_destino) {
        this.grafo = grafo;
        this.esquina_origen = esquina_origen;
        this.esquina_destino = esquina_destino;
    }

    public List<Integer> camino() {
        //Verifica que el grafo tenga ambas esquinas, sino, devuelve null
        if (grafo.contieneVertice(this.esquina_origen) && grafo.contieneVertice(esquina_destino)) {
            //Llama al obtenerCaminoMasCorto y retorna el resultado
            return this.obtenerCaminoMasCorto();
        }
        return null;
    }

    //Recorrido bfs
    private LinkedList<Integer> obtenerCaminoMasCorto() {
        LinkedList<Integer> esquinas_visitadas = new LinkedList<>();
        LinkedList<Integer> cola = new LinkedList<>();

        //El primer elemento aagregado es la esquina origen
        esquinas_visitadas.add(this.esquina_origen);
        cola.add(this.esquina_origen);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

            int contador = 0;

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                contador++;

                //Por cada adyacente del elemento actual se incrementa el contador
                //Si tiene mas de un adyacente se borra el ultimo elemento de los visitados (adyacente anterior) para interferir en el camino del adyacente actual
                if (contador > 1) {
                    esquinas_visitadas.removeLast();
                }

                //Si el adyacente no fue visitado se agrega a la cola y a los visitados
                //Si el adyacente es la esquina destino se retorna la lista de visitados como el camino mas corto
                int adyacente = adyacentes.next();
                if (!esquinas_visitadas.contains(adyacente)) {
                    esquinas_visitadas.add(adyacente);
                    cola.add(adyacente);

                    if (adyacente == this.esquina_destino) {
                        return esquinas_visitadas;
                    }
                }
            }
        }
        //Retorna una lista vacia si es que no encuentra una camino de origen a destino
        return new LinkedList<>();
    }
}
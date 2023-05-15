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

    //Recorrido BFS
    public List<Integer> camino() {
        //Verifica que el grafo tenga ambas esquinas, sino, devuelve null
        if (grafo.contieneVertice(this.esquina_origen) && grafo.contieneVertice(esquina_destino)) {
            LinkedList<Integer> esquinas_visitadas = new LinkedList<>();
            LinkedList<Integer> cola = new LinkedList<>();

            esquinas_visitadas.add(this.esquina_origen);
            cola.add(this.esquina_origen);

            while (!cola.isEmpty()) {
                int primer_elemento = cola.removeFirst();

                //Recorre todos los adyacentes para ver si alguno matchea con la esquina destino
                //Si matchea alguna, se agrega a las esquinas visitadas y se devuelve la lista de esquinas visitadas
                Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(primer_elemento);
                while (adyacentes.hasNext()) {
                    int adyacente = adyacentes.next();
                    if (adyacente == this.esquina_destino) {
                        esquinas_visitadas.add(adyacente);
                        return esquinas_visitadas;
                    }
                }

                //Si ningun adyacente matcheo con la esquina destino, se sigue con el recorrido normalmente
                Iterator<Integer> adyacentes2 = grafo.obtenerAdyacentes(primer_elemento);
                while (adyacentes2.hasNext()) {
                    int adyacente = adyacentes2.next();
                    if (!esquinas_visitadas.contains(adyacente)) {
                        esquinas_visitadas.add(adyacente);
                        cola.add(adyacente);
                        /* if (adyacente == this.esquina_destino) {
                            return esquinas_visitadas;
                        } */
                    }
                }
            }
        }
        return null;
    }
}
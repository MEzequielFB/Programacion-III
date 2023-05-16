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
            LinkedList<LinkedList<Integer>> caminos = new LinkedList<>();
            LinkedList<Integer> camino_mas_corto = new LinkedList<>();

            this.obtenerCaminos2(caminos);

            for (LinkedList<Integer> camino : caminos) {
                if (camino_mas_corto.isEmpty() || camino.size() < camino_mas_corto.size()) {
                    camino_mas_corto = camino;
                }
            }
            return camino_mas_corto;
        }
        return null;
    }

    private void obtenerCaminos2(LinkedList<LinkedList<Integer>> caminos) {
        LinkedList<Integer> esquinas_visitadas = new LinkedList<>();
        LinkedList<Integer> cola = new LinkedList<>();

        /* boolean esquina_destino_encontrada = false; */

        esquinas_visitadas.add(this.esquina_origen);
        cola.add(this.esquina_origen);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

            /* if (esquina_destino_encontrada) {
                esquinas_visitadas.removeLast();
                esquina_destino_encontrada = false;

                esquinas_visitadas.add(primer_elemento);
            } */

            int contador = 0;

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                contador++;

                if (contador > 1) {
                    esquinas_visitadas.removeLast();
                }

                int adyacente = adyacentes.next();
                if (!esquinas_visitadas.contains(adyacente)) {
                    /* esquinas_visitadas.add(adyacente); */
                    cola.add(adyacente);

                    LinkedList<Integer> backup_visitadas = new LinkedList<>(esquinas_visitadas);
                    backup_visitadas.add(adyacente);

                    /* this.agregarCamino(adyacente, caminos, esquinas_visitadas); */
                    if (adyacente == this.esquina_destino) {
                        caminos.add(new LinkedList<>(backup_visitadas));
                        /* esquina_destino_encontrada = true; */
                    }

                    esquinas_visitadas = backup_visitadas;
                }
            }
        }
    }
    
    private void agregarCamino(int esquina, LinkedList<LinkedList<Integer>> caminos, LinkedList<Integer> esquinas_visitadas) {
        esquinas_visitadas.add(esquina);

        if (esquina == this.esquina_destino) {
            caminos.add(esquinas_visitadas);
            return;
        }

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(esquina);
        while (adyacentes.hasNext()) {
            LinkedList<Integer> backup_visitadas = new LinkedList<>(esquinas_visitadas);

            int adyacente = adyacentes.next();
            if (!esquinas_visitadas.contains(adyacente)) {
                if (adyacente == this.esquina_destino) {
                    esquinas_visitadas.add(adyacente);
                    caminos.add(esquinas_visitadas);
                    return;
                }
                this.agregarCamino(adyacente, caminos, esquinas_visitadas);
                esquinas_visitadas = backup_visitadas;
            }
        }
    }
}
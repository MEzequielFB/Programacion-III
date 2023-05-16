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

        esquinas_visitadas.add(esquina_origen);
        cola.add(this.esquina_origen);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

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

                    this.agregarCamino(adyacente, caminos, esquinas_visitadas);

                    esquinas_visitadas = backup_visitadas;
                }
            }
        }
    }
    
    private void agregarCamino(int esquina, LinkedList<LinkedList<Integer>> caminos, LinkedList<Integer> esquinas_visitadas) {
        esquinas_visitadas.add(esquina);

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(esquina);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (!esquinas_visitadas.contains(adyacente)) {
                if (adyacente == this.esquina_destino) {
                    esquinas_visitadas.add(adyacente);
                    caminos.add(esquinas_visitadas);
                    return;
                }
                this.agregarCamino(adyacente, caminos, esquinas_visitadas);
            }
        }
    }

    private void obtenerCaminos(LinkedList<LinkedList<Integer>> caminos) {
        LinkedList<Integer> esquinas_visitadas = new LinkedList<>();
        LinkedList<Integer> cola = new LinkedList<>();

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(this.esquina_origen);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            esquinas_visitadas.add(adyacente);
            /* LinkedList<Integer> posible_camino = this.obtenerCamino(adyacente, esquinas_visitadas); */
            //this.obtenerCaminosAdyacente(adyacente, esquinas_visitadas, caminos);

            /* if (posible_camino.contains(this.esquina_destino)) {
                caminos.add(posible_camino);
            } */
        }

        /* esquinas_visitadas.add(this.esquina_origen);
        cola.add(this.esquina_origen);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

            //Si ningun adyacente matcheo con la esquina destino, se sigue con el recorrido normalmente
            Iterator<Integer> adyacentes2 = grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes2.hasNext()) {
                int adyacente = adyacentes2.next();
                if (!esquinas_visitadas.contains(adyacente)) {
                    esquinas_visitadas.add(adyacente);
                    cola.add(adyacente);
                    
                    LinkedList<Integer> posible_camino = this.obtenerCamino(adyacente);
                    if (posible_camino.contains(this.esquina_destino)) {
                        caminos.add(posible_camino);
                    }
                }
            }
        } */
    }

    /* private void obtenerCaminosAdyacente(int esquina, LinkedList<Integer> esquinas_visitadas, LinkedList<LinkedList<Integer>> caminos) {
        LinkedList<Integer> esquinas_visitadas2 = esquinas_visitadas;
        LinkedList<Integer> camino = esquinas_visitadas;
        LinkedList<Integer> cola = new LinkedList<>();

        cola.add(esquina);

        while (!cola.isEmpty()) {
            int primer_elemento = cola.removeFirst();

            Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(primer_elemento);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                esquinas_visitadas2.add(adyacente);
                cola.add(adyacente);
                camino.add(adyacente);
                
                if (adyacente == this.esquina_destino) {
                    caminos.add(camino);
                    camino = esquinas_visitadas;
                }
            }
        }

        //return esquinas_visitadas;
    } */
}
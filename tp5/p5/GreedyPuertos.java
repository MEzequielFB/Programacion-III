import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GreedyPuertos {
    private static int _infinito;

    private Integer origen;
    private List<List<List<Integer>>> soluciones;
    private List<Integer> distancias;
    private List<Integer> padres;

    public GreedyPuertos() {
        _infinito = 999999999;

        this.origen = null;
        this.soluciones = new ArrayList<>();
        this.distancias = new ArrayList<>();
        this.padres = new ArrayList<>();
    }

    //Algoritmo de Dijkstra
    public List<List<List<Integer>>> greedy(Grafo<Integer> grafo, List<Integer> puertos) {

        //Realiza el algoritmo de Dijktra tomando como origen a cada vertice del grafo
        //Mientras el grafo tenga un siguiente vertice y la lista de puertos no sea vacia...
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext() && !puertos.isEmpty()) {
            this.origen = vertices.next();

            ArrayList<Integer> solucion_parcial = new ArrayList<>();

            for (int i = 0 ; i < grafo.cantidadVertices(); i++) {
                this.distancias.add(_infinito);
                this.padres.add(null);
            }

            int posicion_origen = grafo.obtenerPosicionVertice(this.origen);
            this.distancias.set(posicion_origen, 0);

            int iteracion = 0;
            while (iteracion < grafo.cantidadVertices()) {
                int candidato = this.seleccionar(grafo, solucion_parcial, puertos);
                solucion_parcial.add(candidato);

                Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(candidato);
                while (adyacentes.hasNext()) {
                    int adyacente = adyacentes.next();
                    int posicion_adyacente = grafo.obtenerPosicionVertice(adyacente);
                    int posicion_candidato = grafo.obtenerPosicionVertice(candidato);

                    int suma = this.distancias.get(posicion_candidato) + grafo.obtenerArco(candidato, adyacente).getEtiqueta();
                    if (suma < this.distancias.get(posicion_adyacente)) {
                        this.distancias.set(posicion_adyacente, suma);
                        this.padres.set(posicion_adyacente, candidato);
                    }
                }
                
                iteracion++;
            }

            //Obtiene el puerto mas cercano
            /* int puerto_mas_cercano = this.obtenerPuertoMasCercano(grafo, puertos);
            int posicion_puerto_mas_cercano = grafo.obtenerPosicionVertice(puerto_mas_cercano); */
            
            int puerto_mas_cercano = -1;
            int posicion_puerto_mas_cercano = -1;
            for (Integer puerto : puertos) {
                int posicion_puerto = grafo.obtenerPosicionVertice(puerto);
                if (puerto_mas_cercano == -1 || this.distancias.get(posicion_puerto) < this.distancias.get(posicion_puerto_mas_cercano)) {
                    puerto_mas_cercano = puerto;
                    posicion_puerto_mas_cercano = posicion_puerto;
                }
            }

            List<Integer> camino = new ArrayList<>();
            this.obtenerCamino(grafo, camino, puerto_mas_cercano, posicion_puerto_mas_cercano);
            /* List<Integer> camino = this.obtenerCamino(grafo, puerto_mas_cercano, posicion_puerto_mas_cercano); */

            List<List<Integer>> solucion_actual = new ArrayList<>();
            solucion_actual.add(camino);
            solucion_actual.add(new ArrayList<>(this.distancias));
            solucion_actual.add(new ArrayList<>(this.padres));

            this.soluciones.add(solucion_actual);

            solucion_parcial.clear();
            this.distancias.clear();
            this.padres.clear();
        }

        return this.soluciones;
    }

    /* private List<Integer> obtenerCamino(Grafo<Integer> grafo, int vertice, int posicion_vertice) {
        int posicion_actual = posicion_vertice;
        ArrayList<Integer> camino = new ArrayList<>();
        camino.add(0, vertice);
        while (!camino.contains(this.origen)) {
            camino.add(0, this.padres.get(posicion_actual));
            posicion_actual = grafo.obtenerPosicionVertice(this.padres.get(posicion_actual));
        }
        return camino;
    } */

    /* private int obtenerPuertoMasCercano(Grafo<Integer> grafo, List<Integer> puertos) {
        int puerto_mas_cercano = -1;
        int posicion_puerto_mas_cercano = -1;
        for (Integer puerto : puertos) {
            int posicion_puerto = grafo.obtenerPosicionVertice(puerto);
            if (puerto_mas_cercano == -1 || this.distancias.get(posicion_puerto) < this.distancias.get(posicion_puerto_mas_cercano)) {
                puerto_mas_cercano = puerto;
                posicion_puerto_mas_cercano = posicion_puerto;
            }
        }
        return puerto_mas_cercano;
    } */

    //Obtiene un camino a partir de:
    //Un vertice
    //Su posicion
    //Y su padre y la posicion de su padre
    private void obtenerCamino(Grafo<Integer> grafo, List<Integer> camino, int vertice, int posicion_vertice) {
        camino.add(0, vertice);
        if (!camino.contains(this.origen)) {
            int padre_vertice = this.padres.get(posicion_vertice);
            int posicion_padre_vertice = grafo.obtenerPosicionVertice(padre_vertice);

            this.obtenerCamino(grafo, camino, padre_vertice, posicion_padre_vertice);
        }
    }

    //El mejor candidato es aquel con menor distancia y que no sea parte de la solucion parcial
    private int seleccionar(Grafo<Integer> grafo, List<Integer> solucion_parcial, List<Integer> puertos) {
        int mejor_candidato = -1;

        for (int i = 0; i < grafo.cantidadVertices(); i++) {
            if (mejor_candidato == -1 || this.distancias.get(i) < this.distancias.get(grafo.obtenerPosicionVertice(mejor_candidato))) {

                int vertice_actual = grafo.obtenerVertice(i);
                if (!solucion_parcial.contains(vertice_actual)) {
                    mejor_candidato = vertice_actual;
                }
            }
        }
        return mejor_candidato;
    }
}
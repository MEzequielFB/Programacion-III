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

    public List<List<List<Integer>>> greedy(Grafo<Integer> grafo, List<Integer> puertos) {
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

            int puerto_mas_cercano = -1;
            int posicion_puerto_mas_cercano = -1;
            for (Integer puerto : puertos) {
                int posicion_puerto = grafo.obtenerPosicionVertice(puerto);
                if (puerto_mas_cercano == -1 || this.distancias.get(posicion_puerto) < this.distancias.get(posicion_puerto_mas_cercano)) {
                    puerto_mas_cercano = puerto;
                    posicion_puerto_mas_cercano = posicion_puerto;
                }
            }
            List<Integer> camino = this.armarCamino(grafo, puerto_mas_cercano, posicion_puerto_mas_cercano);

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

    private List<Integer> armarCamino(Grafo<Integer> grafo, int vertice, int posicion_vertice) {
        int posicion_actual = posicion_vertice;
        ArrayList<Integer> camino = new ArrayList<>();
        camino.add(0, vertice);
        while (!camino.contains(this.origen)) {
            camino.add(0, this.padres.get(posicion_actual));
            posicion_actual = grafo.obtenerPosicionVertice(this.padres.get(posicion_actual));
        }
        return camino;
    }

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
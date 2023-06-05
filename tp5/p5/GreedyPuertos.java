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

    public List<List<List<Integer>>> greedy(Grafo<Integer> grafo, int puerto1, int puerto2, int puerto3) {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            this.origen = vertices.next();

            ArrayList<Integer> solucion_parcial = new ArrayList<>();

            for (int i = 0 ; i < grafo.cantidadVertices(); i++) {
                this.distancias.add(_infinito);
                this.padres.add(null);
            }

            int posicion_origen = grafo.obtenerPosicionVertice(this.origen);
            this.distancias.set(posicion_origen, 0);

            while (solucion_parcial.isEmpty() || !this.esSolucion(solucion_parcial, puerto1, puerto2, puerto3)) {
                int candidato = this.seleccionar(grafo, solucion_parcial);
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
            }
            List<List<Integer>> solucion_actual = new ArrayList<>();
            solucion_actual.add(new ArrayList<>(this.distancias));
            solucion_actual.add(new ArrayList<>(this.padres));

            this.soluciones.add(solucion_actual);

            solucion_parcial.clear();
            this.distancias.clear();
            this.padres.clear();
        }

        return this.soluciones;
    }

    private int seleccionar(Grafo<Integer> grafo, List<Integer> solucion_parcial) {
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

    private boolean esSolucion(List<Integer> solucion_parcial, int puerto1, int puerto2, int puerto3) {
        int ultimo_elemento = solucion_parcial.get(solucion_parcial.size()-1);
        return ultimo_elemento == puerto1 || ultimo_elemento == puerto2 || ultimo_elemento == puerto3;
    }
}
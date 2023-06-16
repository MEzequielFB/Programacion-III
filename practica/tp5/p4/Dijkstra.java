import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dijkstra {
    private static int _infinito;

    private List<List<Integer>> solucion;
    private List<Integer> vertices_seleccionados;
    private List<Integer> distancias;
    private List<Integer> padres;

    public Dijkstra() {
        _infinito = 999999999;

        this.solucion = new ArrayList<>();
        this.vertices_seleccionados = new ArrayList<>();
        this.distancias = new ArrayList<>();
        this.padres = new ArrayList<>();
    }

    public List<List<Integer>> caminoMasCorto(Grafo<Integer> grafo, int origen) {
        if (grafo.contieneVertice(origen)) {
            for (int i = 0; i < grafo.cantidadVertices(); i++) {
                this.distancias.add(_infinito);
                this.padres.add(null);
            }

            int posicion_origen = this.getPosicionVertice(grafo, origen);
            this.distancias.set(posicion_origen, 0);

            while (this.vertices_seleccionados.size() < grafo.cantidadVertices()) {
                int candidato = this.seleccionar(grafo);
                int posicion_candidato = this.getPosicionVertice(grafo, candidato);

                this.vertices_seleccionados.add(candidato);

                Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(candidato);
                while (adyacentes.hasNext()) {
                    int adyacente = adyacentes.next();
                    int posicion_adyacente = this.getPosicionVertice(grafo, adyacente);

                    int suma_distancias = this.distancias.get(posicion_candidato) + grafo.obtenerArco(candidato, adyacente).getEtiqueta();

                    if (suma_distancias < this.distancias.get(posicion_adyacente)) {
                        this.distancias.set(posicion_adyacente, suma_distancias);
                        this.padres.set(posicion_adyacente, candidato);
                    }
                }
            }
        }
        this.solucion.add(this.distancias);
        this.solucion.add(this.padres);
        return this.solucion;
    }

    private int seleccionar(Grafo<Integer> grafo) {
        Integer mejor_candidato = null;
        Integer posicion_mejor_candidato = null;
        int posicion = 0;

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!this.vertices_seleccionados.contains(vertice)) {
                if (mejor_candidato == null || this.distancias.get(posicion) < this.distancias.get(posicion_mejor_candidato)) {
                    mejor_candidato = vertice;
                    posicion_mejor_candidato = posicion;
                }
            }
            
            posicion++;
        }
        return mejor_candidato;
    }

    private int getPosicionVertice(Grafo<Integer> grafo, int vertice_buscado) {
        int posicion = 0;

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (vertice == vertice_buscado) {
                return posicion;
            }
            posicion++;
        }
        return -1;
    }
}
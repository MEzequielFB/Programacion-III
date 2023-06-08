import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GreedyViajero {
    private static int _infinito;

    private List<Integer> solucion;
    private List<Integer> distancias;
    private List<Integer> padres;

    public GreedyViajero() {
        _infinito = 999999999;

        this.solucion = new ArrayList<>();
        this.distancias = new ArrayList<>();
        this.padres = new ArrayList<>();
    }

    public List<Integer> greedy(Grafo<Integer> grafo, int origen) {
        this.solucion.clear();
        this.distancias.clear();
        this.padres.clear();
        
        if (grafo.contieneVertice(origen)) {
            for (int i = 0; i < grafo.cantidadVertices(); i++) {
                this.distancias.add(_infinito);
                this.padres.add(null);
            }

            int posicion_origen = this.getPosicionVertice(grafo, origen);
            this.distancias.set(posicion_origen, 0);

            int iteracion = 0;
            while (iteracion < grafo.cantidadVertices()) {
                int candidato = this.seleccionar(grafo);
                int posicion_candidato = this.getPosicionVertice(grafo, candidato);

                this.solucion.add(candidato);

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

                iteracion++;
            }
        }
        return this.solucion;
    }

    public int sumaDistancias() {
        int suma = 0;
        for (int distancia : this.distancias) {
            suma += distancia;
        }
        return suma;
    }

    private int seleccionar(Grafo<Integer> grafo) {
        int mejor_candidato = -1;
        int posicion_mejor_candidato = -1;

        Iterator<Integer> candidatos = grafo.obtenerVertices();
        while (candidatos.hasNext()) {
            int candidato = candidatos.next();
            int posicion_candidato = this.getPosicionVertice(grafo, candidato);

            if (mejor_candidato == -1 || this.distancias.get(posicion_candidato) < this.distancias.get(posicion_mejor_candidato)) {
                if (!this.solucion.contains(candidato)) {
                    mejor_candidato = candidato;
                    posicion_mejor_candidato = posicion_candidato;
                }
            }
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
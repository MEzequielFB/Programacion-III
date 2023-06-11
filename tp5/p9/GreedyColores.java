import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GreedyColores {
    private List<String> solucion;
    private List<String> colores;

    public GreedyColores(List<String> colores) {
        this.solucion = new ArrayList<>();
        this.colores = colores;
    }

    public List<String> greedy(Grafo<?> grafo) {
        ArrayList<Integer> vertices_pintados = new ArrayList<>();

        for (int i = 0; i < grafo.cantidadVertices(); i++) {
            this.solucion.add(null);
        }

        while (vertices_pintados.size() < grafo.cantidadVertices()) {
            int posicion_candidato = this.seleccionar(grafo, vertices_pintados);
            int candidato = this.obtenerVerticePorPosicion(grafo, posicion_candidato);

            this.colorear(grafo, vertices_pintados, candidato, posicion_candidato);
            vertices_pintados.add(candidato);
        }
        return this.solucion;
    }

    private int seleccionar(Grafo<?> grafo, ArrayList<Integer> vertices_pintados) {
        int mejor_candidato = -1;
        int posicion_mejor_candidato = -1;
        int posicion = 0;

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!vertices_pintados.contains(vertice)) {
                if (posicion_mejor_candidato == -1 || this.obtenerCantidadAdyacentes(grafo, vertice) < this.obtenerCantidadAdyacentes(grafo, mejor_candidato)) {
                    mejor_candidato = vertice;
                    posicion_mejor_candidato = posicion;
                }
            }
            posicion++;
        }
        return posicion_mejor_candidato;
    }

    private void colorear(Grafo<?> grafo, List<Integer> vertices_pintados, int candidato, int posicion_candidato) {
        int cantidad_adyacentes_pintados = 0;

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(candidato);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (vertices_pintados.contains(adyacente)) {
                cantidad_adyacentes_pintados++;
            }
        }

        this.solucion.set(posicion_candidato, this.colores.get(cantidad_adyacentes_pintados));
    }

    private int obtenerVerticePorPosicion(Grafo<?> grafo, int posicion_buscada) {
        int posicion = 0;
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (posicion == posicion_buscada) {
                return vertice;
            }
            posicion++;
        }
        return -1;
    }

    private int obtenerCantidadAdyacentes(Grafo<?> grafo, int vertice) {
        int cantidad_adyacentes = 0;
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            adyacentes.next();
            cantidad_adyacentes++;
        }
        return cantidad_adyacentes;
    }

    public void addColor(String color) {
        if (!this.colores.contains(color)) {
            this.colores.add(color);
        }
    }
}
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

        //Agrega nulos a la solucion en relacion a la cantidad de vertices del grafo
        for (int i = 0; i < grafo.cantidadVertices(); i++) {
            this.solucion.add(null);
        }

        //Mientras la cantidad de vertices pintados sea menor a la cantidad de vertices del grafo...
        while (vertices_pintados.size() < grafo.cantidadVertices()) {
            int posicion_candidato = this.seleccionar(grafo, vertices_pintados);
            int candidato = this.obtenerVerticePorPosicion(grafo, posicion_candidato);

            //Colorea al candidato y lo agrega a la lista de vertices pintados
            this.colorear(grafo, vertices_pintados, candidato, posicion_candidato);
            vertices_pintados.add(candidato);
        }
        return this.solucion;
    }

    //Selecciona a los candidatos con mayor cantidad de adyacentes y que no hayan sido pintados
    private int seleccionar(Grafo<?> grafo, ArrayList<Integer> vertices_pintados) {
        int mejor_candidato = -1;
        int posicion_mejor_candidato = -1;
        int posicion = 0;

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (!vertices_pintados.contains(vertice)) {
                if (posicion_mejor_candidato == -1 || this.obtenerCantidadAdyacentes(grafo, vertice) > this.obtenerCantidadAdyacentes(grafo, mejor_candidato)) {
                    mejor_candidato = vertice;
                    posicion_mejor_candidato = posicion;
                }
            }
            posicion++;
        }
        return posicion_mejor_candidato;
    }

    //Colorea al candidato sin repetir los colores de sus adyacentes
    private void colorear(Grafo<?> grafo, List<Integer> vertices_pintados, int candidato, int posicion_candidato) {
        ArrayList<String> colores_usados = new ArrayList<>();

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(candidato);
        while (adyacentes.hasNext()) {
            int adyacente = adyacentes.next();
            if (vertices_pintados.contains(adyacente)) {
                colores_usados.add(this.colores.get(this.obtenerPosicionVertice(grafo, adyacente)));
            }
        }

        this.solucion.set(posicion_candidato, this.elegirColor(colores_usados));
    }

    //Elige un color que no haya sido utilizado, dando prioridad a los primeros colores de la lista de colores
    private String elegirColor(List<String> colores_usados) {
        for (String color : this.colores) {
            if (!colores_usados.contains(color)) {
                return color;
            }
        }
        return null;
    }

    private int obtenerPosicionVertice(Grafo<?> grafo, int vertice_buscada) {
        int posicion = 0;
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            int vertice = vertices.next();
            if (vertice == vertice_buscada) {
                return posicion;
            }
            posicion++;
        }
        return -1;
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
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
    private int cantidad_vertices;
    private int cantidad_arcos;
    private LinkedList<Integer> vertices;
    private LinkedList<Arco<T>> arcos;

    public GrafoDirigido(int cantidad_vertices, int cantidad_arcos) {
        this.cantidad_vertices = 0;
        this.cantidad_arcos = 0;
        this.vertices = new LinkedList<>();
        this.arcos = new LinkedList<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.vertices.contains(verticeId)) {
            this.vertices.add(verticeId);
            this.cantidad_vertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        for (Integer vertice : this.vertices) {
            if (vertice.equals(verticeId)) {
                this.vertices.remove(vertice);
                this.cantidad_vertices--;

                this.borrarArcos(verticeId);
                return;
            }
        }
    }

    private void borrarArcos(int verticeId) {
        Iterator<Arco<T>> arcos_iterator = this.obtenerArcos(verticeId);
        while (arcos_iterator.hasNext()) {
            arcos_iterator.next();
            arcos_iterator.remove();
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!this.existeArco(verticeId1, verticeId2)) {
            this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Arco<String> arco_a_borrar = new Arco<>(verticeId1, verticeId2, "");
        this.arcos.remove(arco_a_borrar);
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.contains(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Arco<String> arco_buscado = new Arco<>(verticeId1, verticeId1, "");
        return this.arcos.contains(arco_buscado);
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        Arco<String> arco_a_obtener = new Arco<>(verticeId1, verticeId2, "");
        for (Arco<T> arco : this.arcos) {
            if (arco.equals(arco_a_obtener)) {
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return this.cantidad_vertices;
    }

    @Override
    public int cantidadArcos() {
        return this.cantidad_arcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return this.vertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        LinkedList<Integer> adyacentes = new LinkedList<>();
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId) {
                adyacentes.add(arco.getVerticeDestino());
            }
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return this.arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        LinkedList<Arco<T>> arcos_vertice = new LinkedList<>();
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                arcos_vertice.add(arco);
            }
        }
        return arcos_vertice.iterator();
    }
}
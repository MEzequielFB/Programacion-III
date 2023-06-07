import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

    private int cantidad_vertices;
    private int cantidad_arcos;
    private LinkedList<Integer> vertices;
    private LinkedList<Arco<T>> arcos;

    public GrafoDirigido() {
        this.cantidad_vertices = 0;
        this.cantidad_arcos = 0;
        this.vertices = new LinkedList<>();
        this.arcos = new LinkedList<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId)) {
            this.vertices.add(verticeId);
            this.cantidad_vertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        for (Integer vertice : this.vertices) {
            if (vertice == verticeId) {
                this.vertices.remove(vertice);
                this.cantidad_vertices--;

                this.borrarArcos(verticeId);
            }
        }
    }

    /* @Override
    public int obtenerPosicionVertice(int verticeId) {
        for (int i = 0; i < this.cantidadVertices(); i++) {
            if (this.vertices.get(i) == verticeId) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int obtenerVertice(int posicion) {
        if (posicion >= 0 && posicion < this.cantidadVertices()) {
            return this.vertices.get(posicion);
        }
        return -1;
    } */

    private void borrarArcos(int verticeId) {
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                this.arcos.remove(arco);
                this.cantidad_arcos--;
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!this.existeArco(verticeId1, verticeId2)) {
            this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
            this.cantidad_arcos++;
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Arco<T> arco_a_borrar = new Arco<T>(verticeId1, verticeId2, null);
        this.arcos.remove(arco_a_borrar);
        this.cantidad_arcos--;
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.contains(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
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
        return arcos.iterator();
    }
}
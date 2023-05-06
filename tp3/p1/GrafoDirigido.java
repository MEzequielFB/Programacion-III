import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido implements Grafo {

    private int cantidad_vertices;
    /* private int cantidad_arcos; */
    private LinkedList<Vertice> vertices;
    /* private LinkedList<Arco> arcos; */

    public GrafoDirigido() {
        this.cantidad_vertices = 0;
        /* this.cantidad_arcos = 0; */
        this.vertices = new LinkedList<>();
        /* this.arcos = new LinkedList<>(); */
    }

    @Override
    public void agregarVertice(int verticeId) {
        //Verifica que no exista el vertice en la lista
        if (!this.contieneVertice(verticeId)) {
            this.vertices.add(new Vertice(verticeId));
            this.cantidad_vertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        for (Vertice vertice : this.vertices) {
            if (vertice.getId() == verticeId) {
                this.vertices.remove(vertice);
                this.cantidad_vertices--;
                return; //Retorna para que no siga iterando innecesariamente al encontrar y borrar el vertice
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, String etiqueta) {
        //Si no existen los vertices se agregan al grafo
        if (!this.contieneVertice(verticeId1)) {
            this.agregarVertice(verticeId1);
        }
        if (!this.contieneVertice(verticeId2)) {
            this.agregarVertice(verticeId2);
        }

        //Se agrega un arco y se incrementa la cantidad de arcos
        /* this.arcos.add(new Arco(verticeId1, verticeId2, etiqueta));
        this.cantidad_arcos++; */

        //Se agrega a la lista de adyacentes del vertice1 al vertice2
        Vertice vertice1 = this.getVertice(verticeId1);
        Vertice vertice2 = this.getVertice(verticeId2);
        vertice1.addVerticeAdyacente(vertice2);
    }

    private Vertice getVertice(int verticeId) {
        for (Vertice vertice : this.vertices) { //Las LinkedList implementan Iterable
            if (vertice.getId() == verticeId) {
                return vertice;
            }
        }
        return null;
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarArco'");
    }

    @Override
    public boolean contieneVertice(int verticeId) { //No se puede hacer una busqueda que recorra la menor cantidad de vertices??
        for (Vertice vertice : this.vertices) { //Las LinkedList implementan Iterable
            if (vertice.getId() == verticeId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeArco'");
    }

    @Override
    public Arco obtenerArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerArco'");
    }

    @Override
    public int cantidadVertices() {
        return this.cantidad_vertices;
    }

    @Override
    public int cantidadArcos() {
        /* return this.cantidad_arcos; */
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadArcos'");
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerVertices'");
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerAdyacentes'");
    }

    @Override
    public Iterator<Arco> obtenerArcos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerArcos'");
    }

    @Override
    public Iterator<Arco> obtenerArcos(int verticeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerArcos'");
    }
}
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido implements Grafo {

    private int cantidad_vertices;
    private int cantidad_arcos;
    private LinkedList<Vertice> vertices;
    private LinkedList<Arco> arcos;

    public GrafoDirigido() {
        this.cantidad_vertices = 0;
        this.cantidad_arcos = 0;
        this.vertices = new LinkedList<>();
        this.arcos = new LinkedList<>();
    }

    public String getArcos() {
        return arcos + "";
    }

    public String getVertices() {
        return vertices + "";
    }

    @Override
    public void dfs() {
        String color_sin_visitar = "blanco";
        int tiempo = 0;
        //Setea el color y los tiempos al valor predeterminado de cada vertice
        for (Vertice vertice : this.vertices) {
            vertice.setColor(color_sin_visitar);
            vertice.setTiempoDescubrimiento(tiempo);
            vertice.setTiempoFinalizacion(tiempo);
        }
        //Se recorre cada vertice y sus adyacentes dependiendo de su color
        for (Vertice vertice : this.vertices) {
            if (vertice.getColor().equals(color_sin_visitar)) {
                tiempo = this.dfs_visit(vertice, tiempo, color_sin_visitar);
            }
        }
    }

    private int dfs_visit(Vertice vertice, int tiempo, String color_sin_visitar) {
        String color_visitado = "amarillo";
        String color_completado = "negro";
        //Setea al vertice como visitado
        vertice.setColor(color_visitado);
        //Incrementa el tiempo y setea el tiempo de descubrimiento del vertice
        tiempo++;
        vertice.setTiempoDescubrimiento(tiempo);
        //Recorre los adyacentes del vertice (el vertice es iterable)
        for (Vertice adyacente : vertice) {
            //Si el adyacente no fue visitado se llama recursivamente a este metodo pasando al adyacente como parametro
            if (adyacente.getColor().equals(color_sin_visitar)) {
                tiempo = this.dfs_visit(adyacente, tiempo, color_sin_visitar);
            }
        }
        //Se setea al vertice como completado (todos sus adyacentes ya fueron descubiertos)
        vertice.setColor(color_completado);
        //Incrementa el tiempo y setea el tiempo de descubrimiento del vertice
        tiempo++;
        vertice.setTiempoFinalizacion(tiempo);
        //Imprime los valores del vertice
        System.out.println(vertice);
        //Devuelve el tiempo para no perder el valor actual
        return tiempo;
    }

    @Override
    public void agregarVertice(int verticeId) {
        //Verifica que no exista el vertice en la lista
        if (!this.contieneVertice(verticeId)) {
            this.vertices.add(new Vertice(verticeId));
            this.cantidad_vertices++;
        }
    }

    //Borra los arcos que contienen un vertice con el id pasado por parametro
    private void borrarArcosContienenVertice(int verticeId) {
        //USO EL ITERATOR PARA QUE NO ME TIRE CurrentModificationException
        Iterator<Arco> iterator_arcos = this.arcos.iterator();

        while (iterator_arcos.hasNext()) {
            Arco arco = iterator_arcos.next();

            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                iterator_arcos.remove();
                this.cantidad_arcos--;
            }
        }

        //Borra al vertice con el id pasado por parametro de las listas de adyacentes de todos los vertices del grafo
        for (Vertice vertice : this.vertices) {
            vertice.removeVerticeAdyacente(verticeId);
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        this.borrarArcosContienenVertice(verticeId);

        //ACA NO ME HACE FALTA USAR EL REMOVE DEL ITERATOR PORQUE UNA VEZ QUE ENCUENTA EL VERTICE A BORRAR NO VUELVE A ITERAR
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
        if (!this.existeArco(verticeId1, verticeId2)) {
            this.arcos.add(new Arco(verticeId1, verticeId2, etiqueta));
            this.cantidad_arcos++;

            //Se agrega a la lista de adyacentes del vertice1 al vertice2
            Vertice vertice1 = this.getVertice(verticeId1);
            Vertice vertice2 = this.getVertice(verticeId2);
            vertice1.addVerticeAdyacente(vertice2);
        }
    }

    private Vertice getVertice(int verticeId) {
        for (Vertice vertice : this.vertices) { //Las LinkedList implementan Iterable
            if (vertice.getId() == verticeId) {
                return vertice;
            }
        }
        return null;
    }

    //Borra el arco con el origen y destino pasados por parametro. Despues borra de la lista de adyacentes del primer vertice al segundo vertice
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        //USO EL ITERATOR PARA QUE NO ME TIRE CurrentModificationException
        Iterator<Arco> iterator_arco = this.arcos.iterator();

        //Recorre la lista de arcos
        while (iterator_arco.hasNext()) {
            Arco arco = iterator_arco.next();

            //Verifica que exista un arco con el origen y destino pasados por parametro
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                //Elimina el arco de la lista y reduce la cantidad de arcos
                iterator_arco.remove();
                this.cantidad_arcos--;

                //Obtiene los vertices con los valores pasados por parametro
                Vertice vertice1 = this.getVertice(verticeId1);
                /* Vertice vertice2 = this.getVertice(verticeId2); */
                //El primer vertice elimina de su lista de adyacentes al segundo vertice
                vertice1.removeVerticeAdyacente(verticeId2);

                //retorna para no seguir iterando
                return;
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) { //¿NO SE PUEDE HACER UNA BUSQUEDA QUE RECORRA LA MENOR CANTIDAD DE VERTICES??
        for (Vertice vertice : this.vertices) { //Las LinkedList implementan Iterable
            if (vertice.getId() == verticeId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (Arco arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco obtenerArco(int verticeId1, int verticeId2) {
        for (Arco arco : this.arcos) {
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
        return this.arcos.iterator();
    }

    @Override
    public Iterator<Arco> obtenerArcos(int verticeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerArcos'");
    }
}
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MayorCiclo {
    private List<Integer> solucion;
    private List<Integer> solucion_parcial;
    private List<Integer> vertices_terminados;
    private List<Arco<?>> arcos_pasados;

    //DFS
    public MayorCiclo() {
        this.solucion = new ArrayList<>();
        this.solucion_parcial = new ArrayList<>();
        this.vertices_terminados = new ArrayList<>();
        this.arcos_pasados = new ArrayList<>();
    }

    //Hace un dfs y al volver de la recursion elimina al ultimo vertice agregado de la solucion parcial y de vertices terminados si es que lo estaba
    public List<Integer> mayorCiclo(Grafo<?> grafo) {
        this.solucion.clear();
        this.vertices_terminados.clear();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (!solucion_parcial.contains(vertice)) {
                this.dfsVisit(grafo, vertice);
                this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                this.vertices_terminados.remove(vertice);
            }
        }
        return this.solucion;
    }

    private void dfsVisit(Grafo<?> grafo, int vertice) {
        //Si el vertice ya fue visitado y no esta terminado se obtiene el ciclo de la solucion parcial y se compara su tamanio
        //con el de la solucion para ver si reemplazarlo
        if (solucion_parcial.contains(vertice) && !this.vertices_terminados.contains(vertice)) {
            List<Integer> ciclo = this.obtenerCiclo(vertice);

            if (this.solucion.size() < ciclo.size()) {
                this.solucion.clear();
                this.solucion.addAll(ciclo);
            }
        }

        //Se agrega el vertice
        this.solucion_parcial.add(vertice);

        //Se obtienen los adyacentes y se verifica que no se hayan pasado por los arcos
        //Si no se paso por los arcos se agrega el arco a los visitados y se llama
        //recursivamente al visit
        //Al volver de la recursion se eliminan elementos de las listas
        //Al salir de la iteracion se agrega al vertice a los terminados
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            Arco<?> arco = new Arco<>(vertice, adyacente, null);
            Arco<?> arco_invertido = new Arco<>(adyacente, vertice, null);

            if (!this.arcos_pasados.contains(arco) && !this.arcos_pasados.contains(arco_invertido)) {
                this.arcos_pasados.add(arco);
                this.dfsVisit(grafo, adyacente);

                this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                this.arcos_pasados.remove(this.arcos_pasados.size()-1);
                this.vertices_terminados.remove(adyacente);

            }
        }

        this.vertices_terminados.add(vertice);
    }

    //Obtiene el ciclo de la solucion parcial desde una posicion especifica hacia el final de la lista
    private List<Integer> obtenerCiclo(int ultimo_vertice) {
        List<Integer> ciclo = new ArrayList<>();
        int posicion = 0;

        for (Integer vertice : this.solucion_parcial) {
            if (vertice == ultimo_vertice) {
                ciclo.addAll(this.solucion_parcial.subList(posicion, this.solucion_parcial.size()));
                ciclo.add(ultimo_vertice);
                return ciclo;
            }

            posicion++;
        }
        return null;
    }
}
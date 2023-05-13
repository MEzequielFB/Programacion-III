import java.util.ArrayList;
import java.util.Iterator;

public class ServicioDfs {
    private Grafo<?> grafo;

    public ServicioDfs(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public boolean tieneCicloDfs() {
        //Crea un arraylist de visitados y un boolean inicializado en false
        ArrayList<Integer> vertices_visitados = new ArrayList<>();
        boolean tiene_ciclo = false;

        //Obtiene todos los vertices del grafo y los recorre
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()) {
            Integer vertice = vertices.next();

            //Si el vertice no fue visitado se llama al dfs_visit y se guarda el resultado en el boolean
            if (!vertices_visitados.contains(vertice)) {
                tiene_ciclo = this.dfs_visit(vertice, vertices_visitados);

                //Si el boolean es true lo devuelve y corta el metodo
                if (tiene_ciclo) {
                    return tiene_ciclo;
                }
            }
        }
        //Si no se encuentra un ciclo devuelve tiene_ciclo como false
        return tiene_ciclo;
    }

    private boolean dfs_visit(Integer vertice, ArrayList<Integer> vertices_visitados) {
        //Crea boolean seteado en false y Agrega el vertice a los visitados
        boolean tiene_ciclo = false;
        vertices_visitados.add(vertice);

        //Obtiene los adyacentes del vertice actual y los recorre
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();

            //Si el adyacente no se visitó se llama al dfs_visit y guarda el resultado en el boolean
            //Si el adyacente ya fue visitado se devuelve true
            if (!vertices_visitados.contains(adyacente)) {
                tiene_ciclo = this.dfs_visit(adyacente, vertices_visitados);
            } else {
                return true;
            }

            //Si el resultado del dsf_visit fue true, lo devuelve
            if (tiene_ciclo) {
                return tiene_ciclo;
            }
        }
        //Devuelve false si no encuentra ciclo
        return tiene_ciclo;
    }

    /* private boolean dfs_visit(Integer vertice, ArrayList<Integer> vertices_visitados) {
        //Agrega el vertice a los visitados
        vertices_visitados.add(vertice);

        //Obtiene los adyacentes del vertice actual y los recorre
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();

            //Se obtienen los adyacentes del vertice adyacente del vertice actual
            Iterator<Integer> adyacentes_de_adyacente = grafo.obtenerAdyacentes(adyacente);
            while (adyacentes_de_adyacente.hasNext()) {
                Integer adyacente_de_adyacente = adyacentes_de_adyacente.next();

                //Si el vertice adyacente del vertice actual tiene como adyacente al vertice actual, HAY CICLO
                if (adyacente_de_adyacente.equals(vertice)) {
                    return true;
                }
            }

            if (!vertices_visitados.contains(adyacente)) {
                this.dfs_visit(adyacente, vertices_visitados);
            }
        }
        //Devuelve false si no encuentra ciclo
        return false;
    } */
}
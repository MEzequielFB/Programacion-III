import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

    private int cantidad_vertices;
    private int cantidad_arcos;
    private HashMap<Integer, Integer> vertices;
    private HashMap<Integer, List<Arco<T>>> arcos;

    public GrafoDirigido() {
        this.cantidad_vertices = 0;
        this.cantidad_arcos = 0;
        this.vertices = new HashMap<>();
        this.arcos = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        Integer vertice = this.vertices.put(verticeId, verticeId);
        if (vertice == null) {
            this.cantidad_vertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        Integer resultado = this.vertices.remove(verticeId);
        if (resultado != null) {
            this.cantidad_vertices--;
            this.borrarArcos(verticeId);
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        List<Arco<T>> arcos = this.arcos.get(verticeId1);
        if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
            Arco<T> arco_a_agregar = new Arco<>(verticeId1, verticeId2, etiqueta);

            if (arcos != null) {
                if (!arcos.contains(arco_a_agregar)) {
                    arcos.add(arco_a_agregar);
                    this.cantidad_arcos++;
                }
            } else {
                List<Arco<T>> lista_nueva = new ArrayList<>();
                lista_nueva.add(arco_a_agregar);
                this.arcos.put(verticeId1, lista_nueva);
                this.cantidad_arcos++;
            }
        }
    }

    private void borrarArcos(int verticeId) {
        List<Arco<T>> arcos = this.arcos.remove(verticeId);
        if (arcos != null) {
            this.cantidad_arcos = this.cantidad_arcos - arcos.size();
        }

        Collection<List<Arco<T>>> listas_arcos = this.arcos.values();
        for (List<Arco<T>> lista : listas_arcos) {
            Iterator<Arco<T>> lista_iterator = lista.iterator();
            while (lista_iterator.hasNext()) {
                Arco<T> arco = lista_iterator.next();
                if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                    lista_iterator.remove();
                    this.cantidad_arcos--;
                }
            }
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        List<Arco<T>> arcos = this.arcos.get(verticeId1);
        if (arcos != null) {
            Arco<String> arco_a_eliminar = new Arco<>(verticeId1, verticeId2, null);
            boolean resultado = arcos.remove(arco_a_eliminar);
            if (resultado) {
                this.cantidad_arcos--;
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return this.vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        List<Arco<T>> arcos = this.arcos.get(verticeId1);
        if (arcos != null) {
            Arco<String> arco_buscado = new Arco<>(verticeId1, verticeId2, null);
            return arcos.contains(arco_buscado);
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        List<Arco<T>> arcos = this.arcos.get(verticeId1);
        if (arcos != null) {
            Arco<String> arco_buscado = new Arco<>(verticeId1, verticeId2, null);
            for (Arco<T> arco : arcos) {
                if (arco.equals(arco_buscado)) {
                    return arco;
                }
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
        return this.vertices.values().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        List<Integer> adyacentes = new ArrayList<>();

        List<Arco<T>> arcos = this.arcos.get(verticeId);
        if (arcos != null) {
            for (Arco<T> arco : arcos) {
                adyacentes.add(arco.getVerticeDestino());
            }
        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> arcos_totales = new ArrayList<>();

        Collection<List<Arco<T>>> listas_arcos = this.arcos.values();
        for (List<Arco<T>> lista : listas_arcos) {
            arcos_totales.addAll(lista);
        }
        return arcos_totales.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        List<Arco<T>> arcos = this.arcos.get(verticeId);
        if (arcos != null) {
            return arcos.iterator();
        }
        return new ArrayList<Arco<T>>().iterator();
    }
}
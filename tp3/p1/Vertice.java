import java.util.Iterator;
import java.util.LinkedList;

public class Vertice implements Iterable<Vertice> {
    private int id;
    private LinkedList<Vertice> vertices_adyacentes;

    public Vertice(int id) {
        this.id = id;
        this.vertices_adyacentes = new LinkedList<>();
    }

    @Override
    public Iterator<Vertice> iterator() {
        return this.vertices_adyacentes.iterator();
    }

    public void removeVerticeAdyacente(int verticeId) {
        Iterator<Vertice> iterator_adyacentes = this.vertices_adyacentes.iterator();
        while (iterator_adyacentes.hasNext()) {
            Vertice adyacente = iterator_adyacentes.next();
            if (adyacente.getId() == verticeId) {
                iterator_adyacentes.remove();
            }
        }
    }

    public void addVerticeAdyacente(Vertice vertice_adyacente) {
        if (!this.vertices_adyacentes.contains(vertice_adyacente)) {
            this.vertices_adyacentes.add(vertice_adyacente);
        }
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Vertice otro_vertice = (Vertice) o;
            return this.getId() == otro_vertice.getId();
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nVertice [id=" + id + "]";
    }
}
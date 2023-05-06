import java.util.LinkedList;

public class Vertice {
    private int id;
    private LinkedList<Vertice> vertices_adyacentes;

    public Vertice(int id) {
        this.id = id;
        this.vertices_adyacentes = new LinkedList<>();
    }

    public void removeVerticeAdyacente(Vertice vertice_adyacente) {
        this.vertices_adyacentes.remove(vertice_adyacente);
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
}
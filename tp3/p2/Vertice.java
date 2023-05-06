import java.util.Iterator;
import java.util.LinkedList;

public class Vertice implements Iterable<Vertice> {
    private int id;
    private String color;
    private int tiempo_descubrimiento;
    private int tiempo_finalizacion;
    private LinkedList<Vertice> vertices_adyacentes;

    public Vertice(int id) {
        this.id = id;
        this.color = "blanco";
        this.tiempo_descubrimiento = 0;
        this.tiempo_finalizacion = 0;
        this.vertices_adyacentes = new LinkedList<>();
    }

    @Override
    public Iterator<Vertice> iterator() {
        return this.vertices_adyacentes.iterator();
    }

    /* public Iterator<Vertice> getAdyacentes() {
        return this.vertices_adyacentes.iterator();
    } */

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

    public String getColor() {
        return this.color;
    }

    public int getTiempoDescubrimiento() {
        return this.tiempo_descubrimiento;
    }

    public int getTiempoFinalizacion() {
        return this.tiempo_finalizacion;
    }

    public void setTiempoDescubrimiento(int tiempo_descubrimiento) {
        this.tiempo_descubrimiento = tiempo_descubrimiento;
    }

    public void setTiempoFinalizacion(int tiempo_finalizacion) {
        this.tiempo_finalizacion = tiempo_finalizacion;
    }

    public void setColor(String color) {
        this.color = color;
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
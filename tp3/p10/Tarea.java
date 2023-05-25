public class Tarea {
    private String nombre;
    private String descripcion;
    private int duracion;

    public Tarea(String nombre, String descripcion, int duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getDuracion() {
        return this.duracion;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Tarea otra_tarea = (Tarea) o;
            return this.getNombre().equals(otra_tarea.getNombre());
        }
        catch(Exception exc) {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
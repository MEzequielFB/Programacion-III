public class Tarea {
    private String nombre;
    private double tiempo_ejecucion;

    public Tarea(String nombre, double tiempo_ejecucion) {
        this.nombre = nombre;
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getTiempoEjecucion() {
        return this.tiempo_ejecucion;
    }

    @Override
    public String toString() {
        return this.getNombre() + "(" + this.getTiempoEjecucion() + ")";
    }
}
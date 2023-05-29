public class Tarea {
    private String titulo;
    private int tiempo_ejecucion;

    public Tarea(String titulo, int tiempo_ejecucion) {
        this.titulo = titulo;
        this.tiempo_ejecucion = tiempo_ejecucion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getTiempoEjecucion() {
        return this.tiempo_ejecucion;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
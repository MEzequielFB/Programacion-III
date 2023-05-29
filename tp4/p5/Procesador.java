import java.util.ArrayList;

public class Procesador {
    private ArrayList<Tarea> tareas_pendientes;

    public Procesador() {
        this.tareas_pendientes = new ArrayList<>();
    }

    public ArrayList<Tarea> getTareasPendientes() {
        return new ArrayList<>(this.tareas_pendientes);
    }

    public void addTarea(Tarea tarea) {
        if (!this.tareas_pendientes.contains(tarea)) {
            this.tareas_pendientes.add(tarea);
        }
    }

    public Tarea removeTareaIndex(int i) {
        return this.tareas_pendientes.remove(i);
    }

    public int getCantTareas() {
        return this.tareas_pendientes.size();
    }

    public int getTiempoEjecucionTotal() {
        int tiempo_ejecucion_total = 0;

        for (Tarea tarea : this.tareas_pendientes) {
            tiempo_ejecucion_total += tarea.getTiempoEjecucion();
        }

        return tiempo_ejecucion_total;
    }

    @Override
    public String toString() {
        return "Proc: " + this.tareas_pendientes + "";
    }
}

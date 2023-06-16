import java.util.ArrayList;
import java.util.List;

public class Procesador {
    private List<Tarea> tareas;
    
    public Procesador() {
        this.tareas = new ArrayList<>();
    }

    public int cantidadTareas() {
        return this.tareas.size();
    }

    public Tarea removeTarea(int index) {
        if (index >= 0 && index < this.tareas.size()) {
            return this.tareas.remove(index);
        }
        return null;
    }

    public void agregarTarea(Tarea tarea) {
        if (!this.tareas.contains(tarea)) {
            this.tareas.add(tarea);
        }
    }

    public double getTiempoTotal() {
        double tiempo_total = 0;
        for (Tarea tarea : this.tareas) {
            tiempo_total += tarea.getTiempoEjecucion();
        }
        return tiempo_total;
    }

    public List<Tarea> getTareas() {
        return new ArrayList<>(this.tareas);
    }

    @Override
    public String toString() {
        return this.tareas + "";
    }
}
import java.util.ArrayList;
import java.util.List;

public class ServicioAsignacion {
    private List<Procesador> solucion;
    private Integer solucion_tiempo_ejecucion;
    private List<Procesador> procesadores;
    private List<Tarea> tareas;

    public ServicioAsignacion(List<Procesador> procesadores, List<Tarea> tareas) {
        this.solucion = new ArrayList<>();
        this.solucion_tiempo_ejecucion = null;
        this.procesadores = procesadores;
        this.tareas = tareas;
    }

    public List<Procesador> asignarTareas() {
        if (!this.tareas.isEmpty()) {
            for (Procesador procesador : this.procesadores) {
                this.backtracking(procesador);
                this.tareas.add(0, procesador.removeTareaIndex(procesador.getCantTareas() - 1));
            }
        }
        return this.solucion;
    }

    private void backtracking(Procesador procesador_actual) {
        Tarea tarea = this.tareas.remove(0);
        procesador_actual.addTarea(tarea);
        
        if (this.esSolucion()) {
            this.armarSolucion();
            this.solucion_tiempo_ejecucion = this.calcularTiempoEjecucion();
        } else {
            if (!this.tareas.isEmpty()) {
                for (Procesador procesador : this.procesadores) {
                    this.backtracking(procesador);
                    this.tareas.add(0, procesador.removeTareaIndex(procesador.getCantTareas() - 1));
                }
            }
        }
    }

    private void armarSolucion() {
        this.solucion.clear();

        for (Procesador procesador : this.procesadores) {
            Procesador procesador_nuevo = new Procesador();
            ArrayList<Tarea> tareas_procesador = procesador.getTareasPendientes();

            for (Tarea tarea : tareas_procesador) {
                procesador_nuevo.addTarea(tarea);
            }

            this.solucion.add(procesador_nuevo);
        }
    }

    private boolean esSolucion() {
        return this.tareas.isEmpty() && (this.solucion_tiempo_ejecucion == null || this.calcularTiempoEjecucion() < this.solucion_tiempo_ejecucion);
    }

    private int calcularTiempoEjecucion() {
        int tiempo_ejecucion_total = -1;

        for (Procesador procesador : this.procesadores) {
            int tiempo_ejecucion_procesador = procesador.getTiempoEjecucionTotal();

            if (tiempo_ejecucion_procesador > tiempo_ejecucion_total) {
                tiempo_ejecucion_total = tiempo_ejecucion_procesador;
            }
        }

        return tiempo_ejecucion_total;
    }

    public Integer getSolucionTiempoEjecucion() {
        return this.solucion_tiempo_ejecucion;
    }
}
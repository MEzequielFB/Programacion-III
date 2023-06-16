import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private List<Procesador> solucion;
    private Double tiempo_solucion;

    public Backtracking() {
        this.solucion = new ArrayList<>();
        this.tiempo_solucion = null;
    }

    public List<Procesador> getMejorAsignacion(List<Procesador> procesadores, List<Tarea> tareas) {
        if (!procesadores.isEmpty() && !tareas.isEmpty()) {
            for (Procesador procesador : procesadores) {
                this.backtracking(procesadores, tareas, procesador);

                Tarea tarea_borrada = procesador.removeTarea(procesador.cantidadTareas()-1);
                tareas.add(0, tarea_borrada);
            }
        }
        return this.solucion;
    }

    private void backtracking(List<Procesador> procesadores, List<Tarea> tareas, Procesador procesador) {
        Tarea tarea = tareas.remove(0);
        procesador.agregarTarea(tarea);

        if (this.esSolucion(procesadores, tareas)) {
            this.armarSolucion(procesadores);
        } else {
            if (!tareas.isEmpty()) {
                for (Procesador procesador2 : procesadores) {
                    this.backtracking(procesadores, tareas, procesador2);

                    Tarea tarea_borrada = procesador2.removeTarea(procesador2.cantidadTareas()-1);
                    tareas.add(0, tarea_borrada);
                }
            }
        }
    }

    private void armarSolucion(List<Procesador> procesadores) {
        this.solucion.clear();

        for (Procesador procesador : procesadores) {
            Procesador procesador_nuevo = new Procesador();
            List<Tarea> tareas_procesador = procesador.getTareas();

            for (Tarea tarea : tareas_procesador) {
                procesador_nuevo.agregarTarea(tarea);
            }

            this.solucion.add(procesador_nuevo);
        }

        this.tiempo_solucion = this.calcularTiempoEjecucion(procesadores);
    }

    private boolean esSolucion(List<Procesador> procesadores, List<Tarea> tareas) {
        return tareas.isEmpty() && ( this.tiempo_solucion == null || this.calcularTiempoEjecucion(procesadores) < this.tiempo_solucion );
    }

    private double calcularTiempoEjecucion(List<Procesador> procesadores) {
        Double tiempo_total = null;

        for (Procesador procesador : procesadores) {
            double tiempo_procesador = procesador.getTiempoTotal();

            if (tiempo_total == null || tiempo_procesador > tiempo_total) {
                tiempo_total = tiempo_procesador;
            }
        }
        return tiempo_total;
    }
}

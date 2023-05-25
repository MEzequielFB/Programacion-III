import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SecuenciaEjecucionCritica {
    private Grafo<Integer> grafo;
    private String origen;
    private LinkedList<Tarea> solucion;
    private int duracion_solucion;

    public SecuenciaEjecucionCritica(Grafo<Integer> grafo, String origen) {
        this.grafo = grafo;
        this.origen = origen;
        this.solucion = new LinkedList<>();
        this.duracion_solucion = 0;
    }

    public List<Tarea> obtenerSecuenciaEjecucionCritica() {
        LinkedList<Tarea> solucion_parcial = new LinkedList<>();
        LinkedList<Arco<Integer>> arcos_pasados = new LinkedList<>();

        solucion_parcial.add(new Tarea(this.origen, "", this.grafo.obtenerDuracionVertice(this.origen)));

        Iterator<Tarea> adyacentes = this.grafo.obtenerAdyacentes(this.origen);
        while (adyacentes.hasNext()) {
            Tarea adyacente = adyacentes.next();

            Arco<Integer> arco_actual = this.grafo.obtenerArco(this.origen, adyacente.getNombre());
            if (!solucion_parcial.contains(adyacente)) {
                arcos_pasados.add(arco_actual);

                this.buscarSolucion(adyacente, solucion_parcial, arcos_pasados);

                arcos_pasados.removeLast();
                solucion_parcial.removeLast();
            }
        }
        return new LinkedList<>(this.solucion);
    }

    private void buscarSolucion(Tarea tarea, LinkedList<Tarea> solucion_parcial, LinkedList<Arco<Integer>> arcos_pasados) {
        solucion_parcial.add(tarea);
        int suma_solucion_parcial = this.calcularDuracion(solucion_parcial);
        if (suma_solucion_parcial > this.duracion_solucion) {
            this.solucion = new LinkedList<>(solucion_parcial);
            /* this.solucion.addAll(solucion_parcial); */
            this.duracion_solucion = suma_solucion_parcial;
        }
        
        Iterator<Tarea> adyacentes = this.grafo.obtenerAdyacentes(tarea.getNombre());
        while (adyacentes.hasNext()) {
            Tarea adyacente = adyacentes.next();

            Arco<Integer> arco_actual = this.grafo.obtenerArco(tarea.getNombre(), adyacente.getNombre());
            if (!solucion_parcial.contains(adyacente)) {
                arcos_pasados.add(arco_actual);

                this.buscarSolucion(adyacente, solucion_parcial, arcos_pasados);

                int suma_solucion_parcial2 = this.calcularDuracion(solucion_parcial);
                if (suma_solucion_parcial2 > this.duracion_solucion) {
                    this.solucion = new LinkedList<>(solucion_parcial);
                    //this.solucion.addAll(solucion_parcial);
                    this.duracion_solucion = suma_solucion_parcial2;
                }

                arcos_pasados.removeLast();
                solucion_parcial.removeLast();
            }
        }
    }

    private int calcularDuracion(LinkedList<Tarea> tareas) {
        int sumatoria = 0;
        for (int i = 0; i < tareas.size()-1; i++) {
            sumatoria += tareas.get(i).getDuracion();
            sumatoria += this.grafo.obtenerArco(tareas.get(i).getNombre(), tareas.get(i+1).getNombre()).getEtiqueta();
        }
        sumatoria += tareas.get(tareas.size()-1).getDuracion();
        return sumatoria;
    }

    /* private int sumarSolucionParcial(LinkedList<Tarea> solucion_parcial, LinkedList<Arco<Integer>> arcos_pasados) {
        int sumatoria = 0;
        for (Tarea tarea : solucion_parcial) {
            sumatoria += tarea.getDuracion();
        }
        return sumatoria;
    } */

    @Override
    public String toString() {
        return "Tareas: " + this.solucion + ", duracion total: " + this.duracion_solucion;
    }
}
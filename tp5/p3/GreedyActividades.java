import java.util.ArrayList;
import java.util.List;

public class GreedyActividades {
    private static int _factible;
    private static int _no_factible;

    private List<Integer> solucion;
    private List<String> actividades;
    private List<Integer> tiempos_comienzo;
    private List<Integer> tiempos_fin;

    public GreedyActividades(List<String> actividades, List<Integer> tiempos_comienzo, List<Integer> tiempos_fin) {
        _factible = 1;
        _no_factible = -1;

        this.solucion = new ArrayList<>();
        this.actividades = new ArrayList<>(actividades);
        this.tiempos_comienzo = new ArrayList<>(tiempos_comienzo);
        this.tiempos_fin = new ArrayList<>(tiempos_fin);
    }

    public List<String> greedy() {
        //Si los horarios no son validos se retorna una solucion vacia
        if (!this.sonHorariosValidos()) {
            return new ArrayList<>();
        }

        //Agrega ceros a la solucion en base a la cantidad de actividades
        for (int i = 0; i < this.actividades.size(); i++) {
            this.solucion.add(0);
        }

        //Mientras la iteracion sea menor a la cantidad de actividades...
        //Elige un candidato y verifica que sea factible agregarlo a la solucion
        //Dependiendo del resultado setea un valor a la solucion en la posicion del candidato
        int iteracion = 0;
        while (iteracion < this.actividades.size()) {
            int posicion_candidato = this.seleccion();
            if (this.esFactible(posicion_candidato)) {
                this.solucion.set(posicion_candidato, _factible);
            } else {
                this.solucion.set(posicion_candidato, _no_factible);
            }

            //Incrementa iteracion
            iteracion++;
        }

        //Genera una solucion en base a los valores de la lista solucion
        //Lo devuelve
        return this.generarSolucion();
    }

    //Recorre los horarios de todas las actividades
    //Si al menos una actividad no tiene horarios validos retorna false
    //Una actividad no tiene horarios validos cuando su tiempo fin es menor al comienzo o ambos tiempos son iguales
    private boolean sonHorariosValidos() {
        for (int i = 0; i < this.tiempos_comienzo.size(); i++) {
            int tiempo_comienzo = this.tiempos_comienzo.get(i);
            int tiempo_fin = this.tiempos_fin.get(i);
            if (tiempo_comienzo > tiempo_fin || tiempo_comienzo == tiempo_fin) {
                return false;
            }
        }
        return true;
    }

    //Genera una lista con los nombres de las actividades
    //Si el valor en la lista de solucion es _factible se agrega el nombre de la actividad a la nueva lista
    private List<String> generarSolucion() {
        ArrayList<String> solucion = new ArrayList<>();

        for (int i = 0; i < this.solucion.size(); i++) {
            if (this.solucion.get(i) == _factible) {
                solucion.add(this.actividades.get(i));
            }
        }
        return solucion;
    }

    //Es factible si no se solapa con los horarios de las actividades que son parte de la solucion
    private boolean esFactible(int posicion) {
        for (int i = 0; i < this.actividades.size(); i++) {
            if (this.estaEnSolucion(i)) {
                if (!this.noSeSolapan(i, posicion)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean noSeSolapan(int posicion1, int posicion2) {
        return this.tiempos_comienzo.get(posicion1) > this.tiempos_fin.get(posicion2) || this.tiempos_comienzo.get(posicion2) > this.tiempos_fin.get(posicion1);
    }

    //Selecciona un candidato con el menor tiempo fin y que no haya sido seleccionado aun
    private int seleccion() {
        int posicion_mejor_candidato = -1;
        for (int i = 0; i < this.actividades.size(); i++) {
            if (( posicion_mejor_candidato == -1 || this.tiempos_fin.get(i) < this.tiempos_fin.get(posicion_mejor_candidato )) && !this.fueSeleccionado(i)) {
                posicion_mejor_candidato = i;
            }
        }
        return posicion_mejor_candidato;
    }

    private boolean estaEnSolucion(int posicion) {
        return this.solucion.get(posicion) == 1;
    }

    private boolean fueSeleccionado(int posicion) {
        return this.solucion.get(posicion) == _factible || this.solucion.get(posicion) == _no_factible;
    }
}
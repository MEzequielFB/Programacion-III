import java.util.ArrayList;
import java.util.List;

public class BacktrackingCombinacion {
    private int suma_objetivo;
    private List<Integer> numeros;
    private List<List<Integer>> solucion;

    public BacktrackingCombinacion(int suma_objetivo, ArrayList<Integer> numeros) {
        this.suma_objetivo = suma_objetivo;
        this.numeros = numeros;
        this.solucion = new ArrayList<>();
    }

    public List<List<Integer>> combinaciones() {
        ArrayList<Integer> solucion_parcial = new ArrayList<>();

        if (!this.numeros.isEmpty()) {
            this.buscarCaminos(1, 0, solucion_parcial);
            solucion_parcial.remove(solucion_parcial.size()-1);

            this.buscarCaminos(0, 0, solucion_parcial);
            solucion_parcial.remove(solucion_parcial.size()-1);
        }
        return this.solucion;
    }

    private void buscarCaminos(int numero, int numero_iteracion, ArrayList<Integer> solucion_parcial) {
        solucion_parcial.add(numero);
        int suma_actual = this.calcularSuma(solucion_parcial);

        if (suma_actual == this.suma_objetivo && solucion_parcial.size() == this.numeros.size()) {
            this.solucion.add(this.obtenerSolucion(solucion_parcial));
        } else {
            numero_iteracion++;
            if (numero_iteracion < this.numeros.size()) {
                if (suma_actual < this.suma_objetivo) {
                    this.buscarCaminos(1, numero_iteracion, solucion_parcial);
                    solucion_parcial.remove(solucion_parcial.size() - 1);

                }
                if (suma_actual <= this.suma_objetivo) {
                    this.buscarCaminos(0, numero_iteracion, solucion_parcial);
                    solucion_parcial.remove(solucion_parcial.size() - 1);
                }
            }
        }
    }

    private List<Integer> obtenerSolucion(ArrayList<Integer> solucion_parcial) {
        ArrayList<Integer> subconjunto = new ArrayList<>();
        for (int i = 0; i < this.numeros.size(); i++) {
            int resultado = this.numeros.get(i) * solucion_parcial.get(i);
            if (resultado != 0) {
                subconjunto.add(resultado);
            }
        }
        return subconjunto;
    }

    private int calcularSuma(ArrayList<Integer> solucion_parcial) {
        int sumatoria = 0;
        for (int i = 0; i < solucion_parcial.size(); i++) {
            sumatoria += this.numeros.get(i) * solucion_parcial.get(i);
        }
        return sumatoria;
    }
}
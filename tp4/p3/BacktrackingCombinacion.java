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
        //La solucion parcial esta compuesta por 0 y 1
        //1 si agrega el elemento de la lista de numeros a la solucion
        //0 si no lo agrega
        ArrayList<Integer> solucion_parcial = new ArrayList<>();

        //Si la lista ingresada no esta vacia
        //Busca las soluciones posibles empezando con el primero elemento agregado
        //Y despues busca las soluciones posibles empezando con el primero elemento sin pertenecer a la solucion
        if (!this.numeros.isEmpty()) {
            this.buscarCaminos(1, 0, solucion_parcial);
            solucion_parcial.remove(solucion_parcial.size()-1);

            this.buscarCaminos(0, 0, solucion_parcial);
            solucion_parcial.remove(solucion_parcial.size()-1);
        }
        return this.solucion;
    }

    private void buscarCaminos(int numero, int numero_iteracion, ArrayList<Integer> solucion_parcial) {
        //Agrega el numero a la solucion parcial (1 o 0)
        solucion_parcial.add(numero);
        int suma_actual = this.calcularSuma(solucion_parcial);

        //Si la suma actual es igual a la suma buscada
        //Y la solucion parcial es del mismo tamanio que la lista de numero
        //Agrega la solucion parcial como solucion valida
        if (suma_actual == this.suma_objetivo && solucion_parcial.size() == this.numeros.size()) {
            this.solucion.add(this.obtenerSolucion(solucion_parcial));
        } else {
            //Si la solucion parcial no es una solucion valida...
            //Aumenta el numero de iteracion y verifica que no se pase de la cantidad de elementos de numeros

            //Podas:
            //Si la suma actual es menor a la suma objetivo llama recursivamente agregando el proximo elemento de la lista
            //Si la suma es menor igual a la suma objetivo llama recursivamente sin agregar el proximo elemento de la lista
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
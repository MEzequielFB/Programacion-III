import java.util.ArrayList;
import java.util.List;

public class BackSubconjuntos {
    private static int _resultado_esperado;

    private List<List<Integer>> soluciones;

    public BackSubconjuntos() {
        _resultado_esperado = 0;
        this.soluciones = new ArrayList<>();
    }

    public List<List<Integer>> obtenerSoluciones(List<Integer> estado, int tamanio_subconjunto) {
        //Verifica que el tamanio del subconjunto sea menor al tamanio del estado
        if (!estado.isEmpty() && estado.size() > tamanio_subconjunto) {
            //Crea la la lista solucion parcial
            List<Integer> solucion_parcial = new ArrayList<>();
            
            //Llama al backtracking agregando el primer elemento del estado
            this.backtracking(1, estado, solucion_parcial, tamanio_subconjunto);
            solucion_parcial.remove(solucion_parcial.size()-1);

            //Llama al backtracking sin agregar al primer elemento del estado
            this.backtracking(0, estado, solucion_parcial, tamanio_subconjunto);
            solucion_parcial.remove(solucion_parcial.size()-1);
        }

        return this.soluciones;
    }

    private void backtracking(int numero, List<Integer> estado, List<Integer> solucion_parcial, int tamanio_subconjunto) {
        //Agrega el numero (0 o 1) a la solucion parcial
        solucion_parcial.add(numero);

        //Si es solucion se agrega a la lista de soluciones
        if (this.esSolucion(estado, solucion_parcial, tamanio_subconjunto)) {
            this.soluciones.add(this.obtenerSolucion(estado, solucion_parcial));
        } else {
            //Si el tamanio de la solucion parcial es menor a la del estado entra al if (condicion de corte)
            //Si la cantidad de numeros de la solucion parcial es menor al tamanio pasado por parametro entra al if (poda)
            //Despues llama al backtracking sin agregar el proximo elemento
            if (solucion_parcial.size() < estado.size()) {

                if (this.getCantidadNumeros(solucion_parcial) < tamanio_subconjunto) {
                    this.backtracking(1, estado, solucion_parcial, tamanio_subconjunto);
                    solucion_parcial.remove(solucion_parcial.size()-1);
                }
    
                this.backtracking(0, estado, solucion_parcial, tamanio_subconjunto);
                solucion_parcial.remove(solucion_parcial.size()-1);
            }
        }
    }

    private int getCantidadNumeros(List<Integer> solucion_parcial) {
        int numero = 1;
        int cantidad_numeros = 0;
        for (int elemento : solucion_parcial) {
            if (elemento == numero) {
                cantidad_numeros++;
            }
        }
        return cantidad_numeros;
    }

    private List<Integer> obtenerSolucion(List<Integer> estado, List<Integer> solucion_parcial) {
        List<Integer> solucion = new ArrayList<>();
        for (int i = 0; i < solucion_parcial.size(); i++) {
            int numero = estado.get(i) * solucion_parcial.get(i);
            if (numero != _resultado_esperado) {
                solucion.add(numero);
            }
        }
        return solucion;
    }

    private boolean esSolucion(List<Integer> estado, List<Integer> solucion_parcial, int tamanio_subconjunto) {
        return this.getCantidadNumeros(solucion_parcial) == tamanio_subconjunto && this.getSuma(estado, solucion_parcial) == _resultado_esperado;
    }

    public int getSuma(List<Integer> estado, List<Integer> solucion_parcial) {
        int suma = 0;
        int cantidad_ceros = 0;
        for (int i = 0; i < solucion_parcial.size(); i++) {
            suma += estado.get(i) * solucion_parcial.get(i);
            if (solucion_parcial.get(i) == _resultado_esperado) {
                cantidad_ceros++;
            }
        }
        if (cantidad_ceros == solucion_parcial.size()) {
            return -1;
        }
        return suma;
    }
}
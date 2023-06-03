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
        if (!estado.isEmpty() && estado.size() > tamanio_subconjunto) {
            List<Integer> solucion_parcial = new ArrayList<>();
            
            this.backtracking(1, estado, solucion_parcial, tamanio_subconjunto);
            solucion_parcial.remove(solucion_parcial.size()-1);

            this.backtracking(0, estado, solucion_parcial, tamanio_subconjunto);
            solucion_parcial.remove(solucion_parcial.size()-1);
        }

        return this.soluciones;
    }

    private void backtracking(int numero, List<Integer> estado, List<Integer> solucion_parcial, int tamanio_subconjunto) {
        solucion_parcial.add(numero);

        if (this.esSolucion(estado, solucion_parcial, tamanio_subconjunto)) {
            this.soluciones.add(this.obtenerSolucion(estado, solucion_parcial));
        } else {
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
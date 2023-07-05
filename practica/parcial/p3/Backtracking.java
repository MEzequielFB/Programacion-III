import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private List<List<Integer>> subconjuntos;

    public Backtracking() {
        this.subconjuntos = new ArrayList<>();
    }

    public List<List<Integer>> subconjuntos(List<Integer> conjunto, int suma_buscada, int cantidad_subconjuntos) {
        if (conjunto.size() >= cantidad_subconjuntos) {
            this.inicializarSubconjuntos(cantidad_subconjuntos);
            int contador = 0;

            while (contador < cantidad_subconjuntos) {
                boolean resultado = this.backtracking(conjunto, suma_buscada, contador);
                if (resultado) {
                    return this.subconjuntos;
                }

                List<Integer> subconjunto = this.subconjuntos.get(contador);
                int valor = subconjunto.remove(subconjunto.size()-1);
                conjunto.add(0, valor);

                contador++;
            }
        }
        return null;
    }

    private boolean backtracking(List<Integer> conjunto, int suma_buscada, int posicion_subconjunto) {
        int valor_actual = conjunto.remove(0);
        this.subconjuntos.get(posicion_subconjunto).add(valor_actual);

        if (this.esSolucion(conjunto, suma_buscada)) {
            return true;
        } else {
            if (!conjunto.isEmpty()) {
                int contador = 0;

                while (contador < this.subconjuntos.size()) {
                    boolean resultado = this.backtracking(conjunto, suma_buscada, contador);
                    if (resultado) {
                        return resultado;
                    }

                    List<Integer> subconjunto = this.subconjuntos.get(contador);
                    int valor = subconjunto.remove(subconjunto.size()-1);
                    conjunto.add(0, valor);

                    contador++;
                }
            }
        }

        return false;
    }

    private boolean esSolucion(List<Integer> conjunto, int suma_buscada) {
        return conjunto.isEmpty() && this.cumpleSuma(suma_buscada);
    }

    //Verifica que la suma de todos los subconjuntos sea la suma buscada
    private boolean cumpleSuma(int suma_buscada) {
        int suma_subconjunto = 0;
        for (List<Integer> subconjunto : this.subconjuntos) {
            for (Integer valor : subconjunto) {
                suma_subconjunto += valor;
            }

            if (suma_subconjunto != suma_buscada) {
                return false;
            }
            suma_subconjunto = 0;
        }
        return true;
    }

    //Agrega N cantidad de subconjuntos
    private void inicializarSubconjuntos(int cantidad_subconjuntos) {
        int i = 0;
        while (i < cantidad_subconjuntos) {
            this.subconjuntos.add(new ArrayList<>());
            i++;
        }
    }
}
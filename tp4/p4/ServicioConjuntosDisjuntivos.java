import java.util.ArrayList;
import java.util.List;

public class ServicioConjuntosDisjuntivos {
    private List<Integer> numeros;
    private List<Integer> solucion1;
    private List<Integer> solucion2;

    public ServicioConjuntosDisjuntivos(List<Integer> numeros) {
        this.numeros = numeros;
        this.solucion1 = new ArrayList<>();
        this.solucion2 = new ArrayList<>();
    }

    public List<List<Integer>> conjuntos_disjuntivos() {
        //En esta lista se guardan los dos subconjuntos si es que existen
        List<List<Integer>> subconjuntos = new ArrayList<>();

        //Se llama al backtracking empezando por el primero subconjunto
        this.backtracking(subconjuntos, this.solucion1);
        this.numeros.add(0, this.solucion1.remove(this.solucion1.size() - 1));

        //Se llama al backtracking empezando por el segundo subconjunto
        this.backtracking(subconjuntos, this.solucion2);
        this.numeros.add(0, this.solucion2.remove(this.solucion2.size() - 1));

        return subconjuntos;
    }

    private boolean backtracking(List<List<Integer>> subconjuntos, List<Integer> solucion) {
        //Elimina el primer elemento de numero y lo agrega al subconjunto pasado por parametro
        int numero = this.numeros.remove(0);
        solucion.add(numero);

        //Si es solucion se agregan los subconjuntos a la lista de listas y se retorna true
        if (this.esSolucion()) {
            subconjuntos.add(new ArrayList<>(this.solucion1));
            subconjuntos.add(new ArrayList<>(this.solucion2));
            return true;
        } else {
            //Si no es solucion...
            //Se verifica que la lista numeros no sea vacia
            //Si no lo es se llama recursivamente al backtracking y se guarda el retorno
            //Si se encontro una solucion se retorna true, de lo contrario se elimina el ultimo elemento del primer subconjunto y se agrega a numeros

            //Se hace lo mismo que arriba pero con el subconjunto2
            if (!this.numeros.isEmpty()) {
                boolean hay_solucion = this.backtracking(subconjuntos, this.solucion1);
                if (hay_solucion) {
                    return hay_solucion;
                }
                this.numeros.add(0, this.solucion1.remove(this.solucion1.size() - 1));

                hay_solucion = this.backtracking(subconjuntos, this.solucion2);
                if (hay_solucion) {
                    return hay_solucion;
                }
                this.numeros.add(0, this.solucion2.remove(this.solucion2.size() - 1));
            }
        }
        //Si no se encuentra solucion devuelve false
        return false;
    }

    //Es solucion si:
    //Ambos subconjuntos suman los mismo
    //Son disjuntos
    //La lista de numeros esta vacia
    private boolean esSolucion() {
        if (this.tienenMismaSuma() && this.numeros.isEmpty()) {
            for (int elemento : this.solucion1) {
                if (this.solucion2.contains(elemento)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean tienenMismaSuma() {
        int sumatoria1 = 0;
        int sumatoria2 = 0;
        for (int numero : this.solucion1) {
            sumatoria1 += numero;
        }

        for (int numero : this.solucion2) {
            sumatoria2 += numero;
        }
        return sumatoria1 == sumatoria2;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        lista1.add(2);
        lista1.add(5);
        lista1.add(6);
        lista1.add(7);
        

        lista2.add(2);
        lista2.add(10);
        lista2.add(7);
        lista2.add(42);
        lista2.add(5);
        lista2.add(53);
        lista2.add(6);
        lista2.add(11);

        List<Integer> resultado = combinarListas(lista1, lista2);
        System.out.println(resultado);
    }

    public static List<Integer> combinarListas(List<Integer> lista1, List<Integer> lista2) {
        ArrayList<Integer> lista_resultante = new ArrayList<>();

        int iteraciones = 0;
        while (iteraciones < lista1.size()) {
            int elemento_lista1 = lista1.get(iteraciones);

            if (lista2.contains(elemento_lista1) && !lista_resultante.contains(elemento_lista1)) {
                addOrdenado(elemento_lista1, lista_resultante);
            }
            iteraciones++;
        }
        return lista_resultante;
    }

    public static void addOrdenado(int valor, List<Integer> lista) {
        int i = 0;
        if (lista.isEmpty()) {
            lista.add(valor);
        }

        while (i < lista.size()) {
            int valor_actual = lista.get(i);

            if (valor_actual < valor) {
                lista.add(valor);
                return;
            }
            if (valor_actual > valor) {
                lista.add(i, valor);
                return;
            }
            i++;
        }
    }
}
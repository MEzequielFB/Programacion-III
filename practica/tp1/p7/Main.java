import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        lista1.add(23);
        lista1.add(2);
        lista1.add(8);
        lista1.add(14);

        lista2.add(14);
        lista2.add(5);
        lista2.add(8);
        lista2.add(9);

        List<Integer> resultado = crearLista(lista1, lista2);
        System.out.println(resultado);
    }

    public static List<Integer> crearLista(List<Integer> lista1, List<Integer> lista2) {
        ArrayList<Integer> lista_resultante = new ArrayList<>();
        int i = 0;

        while (i < lista1.size()) {
            int valor = lista1.get(i);
            if (!lista2.contains(valor) && !lista_resultante.contains(valor)) {
                lista_resultante.add(valor);
            }
            i++;
        }
        return lista_resultante;
    }
}
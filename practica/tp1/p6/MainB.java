import java.util.ArrayList;
import java.util.List;

public class MainB {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        lista1.add(1);
        lista1.add(2);
        lista1.add(5);
        lista1.add(6);
        lista1.add(7);
        lista1.add(30);
        

        lista2.add(2);
        lista2.add(5);
        lista2.add(7);
        lista2.add(10);
        lista2.add(11);
        lista2.add(24);
        lista2.add(25);
        lista2.add(30);

        List<Integer> resultado = combinarListas(lista1, lista2);
        System.out.println(resultado);
    }

    public static List<Integer> combinarListas(List<Integer> lista1, List<Integer> lista2) {
        ArrayList<Integer> lista_resultante = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < lista1.size() && j < lista2.size()) {
            int valor1 = lista1.get(i);
            int valor2 = lista2.get(j);
            if (valor1 == valor2) {
                lista_resultante.add(valor1);
                i++;
                j++;
            } else if (valor1 < valor2) {
                i++;
            } else if (valor1 > valor2) {
                j++;
            }
        }
        return lista_resultante;
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(-5);
        numeros.add(5);
        numeros.add(9);
        numeros.add(-2);
        numeros.add(-3);
        numeros.add(12);
        numeros.add(7);
        numeros.add(4);
        numeros.add(-1);

        BackSubconjuntos back_subconjuntos = new BackSubconjuntos();
        System.out.println("Soluciones: " + back_subconjuntos.obtenerSoluciones(numeros, 3));
    }
}
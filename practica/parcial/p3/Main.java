import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(19);
        numeros.add(3);
        numeros.add(7);
        numeros.add(9);
        numeros.add(2);
        numeros.add(1);
        numeros.add(-10);

        Backtracking backtracking = new Backtracking();
        System.out.println("Solucion: " + backtracking.subconjuntos(numeros, 9, 4));
    }
}
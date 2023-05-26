import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(5);
        numeros.add(3);
        numeros.add(4);
        numeros.add(1);

        BacktrackingCombinacion backtracking = new BacktrackingCombinacion(5, numeros);
        System.out.println("Soluciones: " + backtracking.combinaciones());

        ArrayList<Integer> numeros2 = new ArrayList<>();
        numeros2.add(1);
        numeros2.add(2);
        numeros2.add(1);

        BacktrackingCombinacion backtracking2 = new BacktrackingCombinacion(2, numeros2);
        System.out.println("\nSoluciones: " + backtracking2.combinaciones());
    }
}
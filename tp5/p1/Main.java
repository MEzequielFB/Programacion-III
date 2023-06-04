import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> billetes = new ArrayList<>();
        billetes.add(1000);
        billetes.add(500);
        billetes.add(100);
        billetes.add(25);
        billetes.add(10);
        /* billetes.add(5); */
        /* billetes.add(1); */

        GreedyCambio greedy_cambio = new GreedyCambio(289);
        System.out.println("Solucion: " + greedy_cambio.greedy(billetes));

        GreedyCambio greedy_cambio2 = new GreedyCambio(1170);
        System.out.println("Solucion2: " + greedy_cambio2.greedy(billetes));
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> billetes = new ArrayList<>();
        billetes.add(100);
        billetes.add(25);
        billetes.add(10);
        billetes.add(5);
        billetes.add(1);

        GreedyBilletes greedy = new GreedyBilletes();
        System.out.println("Solucion: " + greedy.getBilletes(billetes, 289));
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> personajes = new ArrayList<>();
        personajes.add(1);
        personajes.add(0);
        personajes.add(0);
        personajes.add(1);
        personajes.add(0);
        personajes.add(0);
        personajes.add(0);
        personajes.add(1);

        GreedyJuego greedy = new GreedyJuego();
        System.out.println("Solucion: " + greedy.greedy(personajes, 2));
    }
}
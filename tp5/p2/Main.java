import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Objeto obj1 = new Objeto(25, 10);
        Objeto obj2 = new Objeto(30, 40);
        Objeto obj3 = new Objeto(21, 38);
        Objeto obj4 = new Objeto(14, 10);

        ArrayList<Objeto> objetos = new ArrayList<>();
        objetos.add(obj1);
        objetos.add(obj2);
        objetos.add(obj3);
        objetos.add(obj4);

        GreedyMochila greedy_mochila = new GreedyMochila(80);
        System.out.println("Solucion: " + greedy_mochila.greedy(objetos));
    }
}
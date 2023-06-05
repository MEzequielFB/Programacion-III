import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);

        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 35);
        grafo.agregarArco(1, 5, 30);
        grafo.agregarArco(1, 6, 20);
        grafo.agregarArco(2, 3, 10);
        grafo.agregarArco(2, 4, 20);
        grafo.agregarArco(2, 5, 25);
        grafo.agregarArco(3, 8, 100);
        grafo.agregarArco(4, 5, 15);
        grafo.agregarArco(4, 8, 30);
        grafo.agregarArco(5, 7, 15);

        ArrayList<Integer> puertos = new ArrayList<>();
        puertos.add(6);
        puertos.add(7);
        puertos.add(8);

        GreedyPuertos greedy = new GreedyPuertos();
        System.out.println("Solucion: " + greedy.greedy(grafo, puertos));
    }
}
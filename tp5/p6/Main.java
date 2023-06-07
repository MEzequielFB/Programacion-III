public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 3);
        grafo.agregarArco(1, 5, 4);
        grafo.agregarArco(1, 6, 6);
        grafo.agregarArco(2, 4, 5);
        grafo.agregarArco(3, 5, 5);
        grafo.agregarArco(3, 4, 20);
        grafo.agregarArco(3, 6, 7);
        grafo.agregarArco(4, 5, 2);

        GreedyViajero greedy = new GreedyViajero();
        System.out.println("Solucion: " + greedy.greedy(grafo, 1) + "\nDistancia: " + greedy.sumaDistancias());
    }
}
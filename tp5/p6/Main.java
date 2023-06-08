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
        grafo.agregarArco(1, 3, 13);
        grafo.agregarArco(1, 4, 7);
        grafo.agregarArco(1, 5, 4);
        grafo.agregarArco(1, 6, 6);
        grafo.agregarArco(2, 3, 5);
        grafo.agregarArco(2, 4, 11);
        grafo.agregarArco(2, 5, 13);
        grafo.agregarArco(2, 6, 3);
        grafo.agregarArco(3, 4, 16);
        grafo.agregarArco(3, 5, 8);
        grafo.agregarArco(3, 6, 21);
        grafo.agregarArco(4, 5, 2);
        grafo.agregarArco(4, 6, 10);
        grafo.agregarArco(5, 6, 27);

        GreedyViajero greedy = new GreedyViajero();
        System.out.println("Solucion: " + greedy.greedy(grafo, 4) + "\nDistancia: " + greedy.sumaDistancias());
        
        System.out.println("\nSolucion: " + greedy.greedy(grafo, 8) + "\nDistancia: " + greedy.sumaDistancias());
    }
}
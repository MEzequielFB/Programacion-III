public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 3, 15);
        grafo.agregarArco(1, 4, 25);
        grafo.agregarArco(2, 4, 6);
        grafo.agregarArco(3, 2, 8);

        Dijkstra dijsktra = new Dijkstra();
        System.out.println("Solucion (distancias : padres): " + dijsktra.caminoMasCorto(grafo, 1));
    }
}
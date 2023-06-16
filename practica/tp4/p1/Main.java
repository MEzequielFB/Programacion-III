public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArco(1, 4, null);
        grafo.agregarArco(2, 1, null);
        grafo.agregarArco(2, 3, null);
        grafo.agregarArco(3, 6, null);
        grafo.agregarArco(4, 5, null);
        grafo.agregarArco(5, 2, null);
        grafo.agregarArco(5, 6, null);
        grafo.agregarArco(5, 3, null);
        grafo.agregarArco(6, 3, null);
        grafo.agregarArco(6, 2, null);

        Backtracking back = new Backtracking();
        System.out.println("Solucion: " + back.caminoMasLargo(grafo, 1, 2));
    }
}
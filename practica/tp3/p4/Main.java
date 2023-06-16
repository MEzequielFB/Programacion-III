public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1, 1, null);
        grafo.agregarArco(1, 2, null);
        grafo.agregarArco(1, 3, null);
        grafo.agregarArco(2, 3, null);
        grafo.agregarArco(2, 4, null);
        grafo.agregarArco(3, 1, null);
        grafo.agregarArco(4, 3, null);

        CaminoMasLargo servicio = new CaminoMasLargo();
        System.out.println("Solucion: " + servicio.obtenerCaminoMasLargo(grafo, 1, 4));
    }
}
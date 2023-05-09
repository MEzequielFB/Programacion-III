public class MainBfs {
    public static void main(String[] args) {
        //PROBAR EL BFS CON UN NUEVO GRAFO DIRIGIDO Y MAS GRANDE

        System.out.println("Grafo dirigido:\n");
        GrafoDirigido grafo1 = new GrafoDirigido();
        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);
        grafo1.agregarVertice(4);
        grafo1.agregarVertice(5);
        grafo1.agregarVertice(6);
        grafo1.agregarVertice(7);

        grafo1.agregarArco(1, 2, "se conecta con");
        grafo1.agregarArco(2, 1, "se conecta con");
        grafo1.agregarArco(2, 3, "se conecta con");
        grafo1.agregarArco(2, 4, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(5, 7, "se conecta con");
        grafo1.agregarArco(6, 5, "se conecta con");
        grafo1.agregarArco(7, 1, "se conecta con");

        System.out.println("Cantidad vertices: " + grafo1.cantidadVertices());
        System.out.println("Cantidad arcos: " + grafo1.cantidadArcos());

        grafo1.bfs();

        System.out.println("\nGrafo no dirigido:\n");

        GrafoNoDirigido grafo2 = new GrafoNoDirigido();
        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(6);
        grafo2.agregarVertice(7);

        grafo2.agregarArco(1, 2, "se conecta con");
        grafo2.agregarArco(2, 3, "se conecta con");
        grafo2.agregarArco(2, 4, "se conecta con");
        grafo2.agregarArco(3, 4, "se conecta con");
        grafo2.agregarArco(5, 7, "se conecta con");
        grafo2.agregarArco(6, 5, "se conecta con");
        grafo2.agregarArco(7, 1, "se conecta con");

        System.out.println("Cantidad vertices: " + grafo2.cantidadVertices());
        System.out.println("Cantidad arcos: " + grafo2.cantidadArcos());

        grafo2.bfs();
    }
}
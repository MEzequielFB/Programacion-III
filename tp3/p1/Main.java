public class Main {
    public static void main(String[] args) {
        System.out.println("\nGrafo dirigido:");
        GrafoDirigido grafo1 = new GrafoDirigido();

        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);

        grafo1.agregarArco(1, 2, "se conecta con");
        grafo1.agregarArco(1, 1, "se conecta con");
        grafo1.agregarArco(1, 3, "se conecta con");
        /* grafo1.agregarArco(2, 1, "se conecta con"); */

        /* grafo1.borrarArco(1, 3); */
        grafo1.borrarVertice(2);

        System.out.println("\nArcos del grafo: " + grafo1.getArcos());
        System.out.println("\nVertices del grafo: " + grafo1.getVertices());
        System.out.println("\nCantidad de vertices: " + grafo1.cantidadVertices());
        System.out.println("\nCantidad de arcos: " + grafo1.cantidadArcos());

        //GRAFO NO DIRIGIDO
        System.out.println("\nGrafo No dirigido:");
        GrafoNoDirigido grafo2 = new GrafoNoDirigido();

        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);

        grafo2.agregarArco(1, 2, "se conecta con");
        grafo2.agregarArco(1, 1, "se conecta con");
        grafo2.agregarArco(1, 3, "se conecta con");
        /* grafo2.agregarArco(2, 1, "se conecta con"); */

        /* grafo1.borrarArco(1, 3); */
        grafo2.borrarVertice(2);

        System.out.println("\nArcos del grafo: " + grafo2.getArcos());
        System.out.println("\nVertices del grafo: " + grafo2.getVertices());
        System.out.println("\nCantidad de vertices: " + grafo2.cantidadVertices());
        System.out.println("\nCantidad de arcos: " + grafo2.cantidadArcos());
    }
}
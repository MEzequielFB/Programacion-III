public class Main {
    public static void main(String[] args) {
        GrafoDirigido grafo1 = new GrafoDirigido();

        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);

        grafo1.agregarArco(1, 2, "se conecta con");
        grafo1.agregarArco(1, 1, "se conecta con");
        grafo1.agregarArco(1, 3, "se conecta con");
        grafo1.agregarArco(2, 1, "se conecta con");

        System.out.println("Primer dfs:");
        grafo1.dfs();

        /* grafo1.borrarArco(1, 3); */
        grafo1.borrarVertice(1);

        System.out.println("\nSegundo dfs:");
        grafo1.dfs();

        System.out.println("\nArcos del grafo: " + grafo1.getArcos());
        System.out.println("\nVertices del grafo: " + grafo1.getVertices());
        System.out.println("\nCantidad de vertices: " + grafo1.cantidadVertices());
        System.out.println("\nCantidad de arcos: " + grafo1.cantidadArcos());
    }
}
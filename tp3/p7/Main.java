public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo1 = new GrafoDirigido<>();
        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);
        grafo1.agregarVertice(4);
        grafo1.agregarVertice(5);
        grafo1.agregarVertice(6);

        grafo1.agregarArco(1, 3, "se conecta con");
        grafo1.agregarArco(1, 5, "se conecta con");
        grafo1.agregarArco(1, 6, "se conecta con");
        grafo1.agregarArco(2, 1, "se conecta con");
        grafo1.agregarArco(3, 5, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(4, 5, "se conecta con");
        grafo1.agregarArco(5, 6, "se conecta con");
        grafo1.agregarArco(6, 4, "se conecta con");

        System.out.println("Cantidad vertices: " + grafo1.cantidadVertices());
        System.out.println("Cantidad arcos: " + grafo1.cantidadArcos());

        ServicioCaminoCorto servicio_camino_corto1 = new ServicioCaminoCorto(grafo1, 2, 6);
        System.out.println("\nCamino mas corto de 2 a 6: " + servicio_camino_corto1.camino());

        /* ServicioCaminoCorto servicio_camino_corto2 = new ServicioCaminoCorto(grafo1, 1, 4);
        System.out.println("\nCamino mas corto de 1 a 4: " + servicio_camino_corto2.camino()); */
    }
}
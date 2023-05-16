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
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(3, 5, "se conecta con");
        grafo1.agregarArco(4, 5, "se conecta con");
        grafo1.agregarArco(5, 6, "se conecta con");
        grafo1.agregarArco(6, 4, "se conecta con");

        System.out.println("Cantidad vertices: " + grafo1.cantidadVertices());
        System.out.println("Cantidad arcos: " + grafo1.cantidadArcos());
        System.out.println("Contiene vertice: " + grafo1.contieneVertice(10));
        System.out.println("Contiene vertice: " + grafo1.contieneVertice(7));
        System.out.println("Existe arco: " + grafo1.existeArco(3, 4));
        System.out.println("Existe arco: " + grafo1.existeArco(1, 4)+"\n");

        ServicioCaminoLargo servicioCaminoLargo1 = new ServicioCaminoLargo(grafo1, 2, 6);
        System.out.println("Camino mas largo de 2 a 6: " + servicioCaminoLargo1.camino());

        ServicioCaminoLargo servicioCaminoLargo2 = new ServicioCaminoLargo(grafo1, 1, 5);
        System.out.println("Camino mas largo de 1 a 5: " + servicioCaminoLargo2.camino());

        ServicioCaminoLargo servicioCaminoLargo3 = new ServicioCaminoLargo(grafo1, 3, 4);
        System.out.println("Camino mas largo de 3 a 4: " + servicioCaminoLargo3.camino());

        ServicioCaminoLargo servicioCaminoLargo4 = new ServicioCaminoLargo(grafo1, 4, 1);
        System.out.println("Camino mas largo de 4 a 1: " + servicioCaminoLargo4.camino());

        ServicioCaminoLargo servicioCaminoLargo5 = new ServicioCaminoLargo(grafo1, 5, 10);
        System.out.println("Camino mas largo de 4 a 1: " + servicioCaminoLargo5.camino());
    }
}
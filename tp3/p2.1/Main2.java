public class Main2 {
    public static void main(String[] args) {
        GrafoNoDirigido<String> grafo1 = new GrafoNoDirigido<>();

        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);
        grafo1.agregarVertice(4);
        grafo1.agregarVertice(5);
        grafo1.agregarVertice(6);
        grafo1.agregarVertice(7);

        grafo1.agregarArco(1, 2, "se conecta con");
        grafo1.agregarArco(1, 3, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(3, 7, "se conecta con");
        grafo1.agregarArco(7, 2, "se conecta con");
        grafo1.agregarArco(5, 3, "se conecta con");
        grafo1.agregarArco(6, 7, "se conecta con");
        grafo1.agregarArco(6, 4, "se conecta con");

        grafo1.borrarVertice(1);

        System.out.println("Cantidad de vertices: " + grafo1.cantidadVertices());
        System.out.println("Cantidad de arcos: " + grafo1.cantidadArcos());

        System.out.println("\nDFS");
        ServicioDfs servicio_dfs = new ServicioDfs(grafo1);
        System.out.println(servicio_dfs.dfs());

        System.out.println("\nBFS");
        ServicioBfs servicio_bfs = new ServicioBfs(grafo1);
        System.out.println(servicio_bfs.bfs());
    }
}
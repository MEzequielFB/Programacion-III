public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo1 = new GrafoDirigido<>();
        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);
        grafo1.agregarVertice(4);
        grafo1.agregarVertice(5);
        grafo1.agregarVertice(6);
        grafo1.agregarVertice(7);

        grafo1.agregarArco(1, 4, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(1, 3, "se conecta con");
        grafo1.agregarArco(1, 7, "se conecta con");
        grafo1.agregarArco(6, 5, "se conecta con");
        grafo1.agregarArco(6, 1, "se conecta con");
        grafo1.agregarArco(3, 6, "se conecta con");

        ServicioDfs dfs = new ServicioDfs();
        System.out.println("Dfs: " + dfs.dfs(grafo1));

        ServicioBfs bfs = new ServicioBfs();
        System.out.println("Bfs: " + bfs.bfs(grafo1));
    }
}
public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(1, 5, 15);
        grafo.agregarArco(2, 2, 4);
        grafo.agregarArco(3, 4, 103);
        grafo.agregarArco(3, 6, 25);
        grafo.agregarArco(4, 1, 103);
        grafo.agregarArco(4, 2, 103);
        grafo.agregarArco(6, 5, 103);

        System.out.println("DFS:");
        Dfs dsf = new Dfs();
        System.out.println("Recorrido dfs: " + dsf.dfs(grafo));

        System.out.println("\nBFS:");
        Bfs bsf = new Bfs();
        System.out.println("Recorrido bfs: " + bsf.bfs(grafo));

        System.out.println("\nCiclo mas largo:");
        CicloMasLargo<Integer> ciclos = new CicloMasLargo<>();
        System.out.println("Solucion: " + ciclos.cicloMasLargo(grafo));
    }
}
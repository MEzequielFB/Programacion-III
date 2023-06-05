public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafoDirigido = new GrafoDirigido<>();
        grafoDirigido.agregarVertice(1);
        grafoDirigido.agregarVertice(2);
        grafoDirigido.agregarVertice(3);
        grafoDirigido.agregarVertice(4);
        grafoDirigido.agregarVertice(5);

        grafoDirigido.agregarArco(1, 2, 10);
        grafoDirigido.agregarArco(1, 4, 30);
        grafoDirigido.agregarArco(1, 5, 100);
        grafoDirigido.agregarArco(2, 3, 50);
        grafoDirigido.agregarArco(3, 5, 10);
        grafoDirigido.agregarArco(4, 3, 20);
        grafoDirigido.agregarArco(4, 5, 60);

        GreedyCaminoCorto greedy = new GreedyCaminoCorto();
        System.out.println("Solucion: " + greedy.greedy(grafoDirigido, 1));
    }
}
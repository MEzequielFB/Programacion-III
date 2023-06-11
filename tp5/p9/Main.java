import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("violeta");
        colores.add("amarillo");
        colores.add("marron");
        colores.add("celeste");
        colores.add("azul");
        colores.add("rosa");

        GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArco(1, 2, null);
        grafo.agregarArco(1, 3, null);
        grafo.agregarArco(2, 3, null);
        grafo.agregarArco(4, 1, null);
        grafo.agregarArco(5, 4, null);
        grafo.agregarArco(6, 2, null);

        GreedyColores greedy = new GreedyColores(colores);
        System.out.println("Solucion: " + greedy.greedy(grafo));
    }
}
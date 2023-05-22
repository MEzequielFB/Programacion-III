import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo_dirigido = new GrafoDirigido<>();

        grafo_dirigido.agregarVertice(1);
        grafo_dirigido.agregarVertice(2);
        grafo_dirigido.agregarVertice(3);
        grafo_dirigido.agregarVertice(4);

        grafo_dirigido.agregarArco(1, 3, "verde");
        grafo_dirigido.agregarArco(1, 4, "rojo");
        grafo_dirigido.agregarArco(2, 1, "verde");
        grafo_dirigido.agregarArco(2, 2, "verde");
        grafo_dirigido.agregarArco(2, 4, "verde");
        grafo_dirigido.agregarArco(3, 2, "amarillo");
        grafo_dirigido.agregarArco(4, 1, "rojo");
        grafo_dirigido.agregarArco(4, 4, "rojo");

        ServicioCaminoColores<String> servicio = new ServicioCaminoColores<String>(grafo_dirigido, 1, 3, "rojo");
        System.out.println("Camino 1 a 3: " + servicio.camino());

        ServicioCaminoColores<String> servicio2 = new ServicioCaminoColores<String>(grafo_dirigido, 1, 4, "rojo");
        System.out.println("Camino 1 a 4: " + servicio2.camino());

        System.out.println("\nVertices:");
        Iterator<Integer> vertices = grafo_dirigido.obtenerVertices();
        while (vertices.hasNext()) {
            System.out.println(vertices.next());
        }

        System.out.println("\nArcos:");
        Iterator<Arco<String>> arcos = grafo_dirigido.obtenerArcos();
        while (arcos.hasNext()) {
            System.out.println(arcos.next());
        }
    }
}
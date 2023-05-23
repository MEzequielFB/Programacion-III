import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArco(1, 4, "se conecta con");
        grafo.agregarArco(2, 1, "se conecta con");
        grafo.agregarArco(2, 3, "se conecta con");
        grafo.agregarArco(3, 6, "se conecta con");
        grafo.agregarArco(4, 5, "se conecta con");
        grafo.agregarArco(5, 2, "se conecta con");
        grafo.agregarArco(5, 6, "se conecta con");
        grafo.agregarArco(6, 2, "se conecta con");
        grafo.agregarArco(6, 3, "se conecta con");

        ServicioHabitaciones servicio = new ServicioHabitaciones(grafo, 1, 2);
        System.out.println("Solucion servicio: " + servicio.camino());

        System.out.println("\nArcos:");
        Iterator<Arco<String>> arcos = grafo.obtenerArcos();
        while (arcos.hasNext()) {
            System.out.println(arcos.next());
        }
    }
}
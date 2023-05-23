public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();

        grafo.agregarVertice("buenos aires");
        grafo.agregarVertice("flores");
        grafo.agregarVertice("azul");
        grafo.agregarVertice("rauch");
        grafo.agregarVertice("tandil");
        grafo.agregarVertice("ayacucho");
        grafo.agregarVertice("gral belgrano");

        grafo.agregarArco("buenos aires", "flores", "ruta");
        grafo.agregarArco("buenos aires", "gral belgrano", "ruta");
        grafo.agregarArco("flores", "azul", "ruta");
        grafo.agregarArco("flores", "rauch", "ruta");
        grafo.agregarArco("azul", "rauch", "ruta");
        grafo.agregarArco("azul", "tandil", "ruta");
        grafo.agregarArco("rauch", "tandil", "ruta");
        grafo.agregarArco("rauch", "ayacucho", "ruta");
        grafo.agregarArco("tandil", "ayacucho", "ruta");
        grafo.agregarArco("ayacucho", "gral belgrano", "ruta");

        ServicioCaminos<String> servicio = new ServicioCaminos<>(grafo, "buenos aires", "tandil", grafo.obtenerArco("flores", "rauch"));
        System.out.println("Servicio caminos: " + servicio.caminos());
    }
}
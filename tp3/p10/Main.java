public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        grafo.agregarVertice("tarea0", "hace algo", 7);
        grafo.agregarVertice("tarea1", "hace algo", 2);
        grafo.agregarVertice("tarea2", "hace algo", 4);
        grafo.agregarVertice("tarea3", "hace algo", 1);
        grafo.agregarVertice("tarea4", "hace algo", 2);
        grafo.agregarVertice("tarea5", "hace algo", 9);
        grafo.agregarVertice("tarea6", "hace algo", 1);
        grafo.agregarVertice("tarea7", "hace algo", 16);


        grafo.agregarArco("tarea0", "tarea1", 7);
        grafo.agregarArco("tarea0", "tarea2", 5);
        grafo.agregarArco("tarea1", "tarea3", 5);
        grafo.agregarArco("tarea1", "tarea6", 15);
        grafo.agregarArco("tarea2", "tarea3", 4);
        grafo.agregarArco("tarea2", "tarea4", 5);
        grafo.agregarArco("tarea2", "tarea5", 2);
        grafo.agregarArco("tarea3", "tarea5", 10);
        grafo.agregarArco("tarea3", "tarea7", 3);
        grafo.agregarArco("tarea4", "tarea7", 7);
        grafo.agregarArco("tarea5", "tarea7", 7);
        grafo.agregarArco("tarea6", "tarea7", 2);

        SecuenciaEjecucionCritica secuencia = new SecuenciaEjecucionCritica(grafo, "tarea0");
        System.out.println(secuencia.obtenerSecuenciaEjecucionCritica());
        System.out.println(secuencia);
    }
}
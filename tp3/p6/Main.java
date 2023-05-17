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
        grafo1.agregarArco(3, 5, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(4, 5, "se conecta con");
        grafo1.agregarArco(5, 6, "se conecta con");
        grafo1.agregarArco(6, 4, "se conecta con");

        /* grafo1.agregarArco(1, 5, "se conecta con");
        grafo1.agregarArco(1, 2, "se conecta con");
        grafo1.agregarArco(2, 6, "se conecta con");
        grafo1.agregarArco(3, 1, "se conecta con");
        grafo1.agregarArco(3, 5, "se conecta con");
        grafo1.agregarArco(4, 5, "se conecta con");
        grafo1.agregarArco(4, 3, "se conecta con");
        grafo1.agregarArco(5, 4, "se conecta con");
        grafo1.agregarArco(6, 1, "se conecta con");
        grafo1.agregarArco(6, 3, "se conecta con"); */

        System.out.println("Cantidad vertices: " + grafo1.cantidadVertices());
        System.out.println("Cantidad arcos: " + grafo1.cantidadArcos());

        ServicioDarConexion servicio_dar_conexion1 = new ServicioDarConexion(grafo1, 2, 6, 1);
        System.out.println("\nConexion entre 2 a 6 (fuera de servicio: 1): " + servicio_dar_conexion1.darConexion());

        ServicioDarConexion servicio_dar_conexion2 = new ServicioDarConexion(grafo1, 1, 4, 3);
        System.out.println("Conexion entre 1 a 4 (fuera de servicio: 3): " + servicio_dar_conexion2.darConexion());

        ServicioDarConexion servicio_dar_conexion3 = new ServicioDarConexion(grafo1, 3, 5, 2);
        System.out.println("Conexion entre 3 a 5 (fuera de servicio: 2): " + servicio_dar_conexion3.darConexion());

        ServicioDarConexion servicio_dar_conexion4 = new ServicioDarConexion(grafo1, 3, 6, 2);
        System.out.println("Conexion entre 3 a 6 (fuera de servicio: 2): " + servicio_dar_conexion4.darConexion());
    }
}
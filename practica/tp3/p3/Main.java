public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo1 = new GrafoDirigido<>();
        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);
        grafo1.agregarVertice(4);

        grafo1.agregarArco(1, 2, "se conecta con");
        /* grafo1.agregarArco(1, 3, "se conecta con"); */
        grafo1.agregarArco(2, 4, "se conecta con");
        grafo1.agregarArco(3, 1, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");

        ServicioCiclo servicio = new ServicioCiclo();
        System.out.println("Tiene ciclo: " + servicio.tieneCiclo(grafo1));
    }
}
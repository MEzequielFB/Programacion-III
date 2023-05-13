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

        //No borra nada
        grafo1.borrarVertice(-2);
        grafo1.borrarVertice(24);
        //Borra el 2
        grafo1.borrarVertice(2);

        //No los agrega
        grafo1.agregarArco(0, 1, "se conecta con");
        grafo1.agregarArco(1, 0, "se conecta con");
        //Lo agrega
        grafo1.agregarArco(1, 4, "se conecta con");
        grafo1.agregarArco(3, 4, "se conecta con");
        grafo1.agregarArco(1, 3, "se conecta con");
        grafo1.agregarArco(1, 6, "se conecta con");
        grafo1.agregarArco(1, 7, "se conecta con");
        grafo1.agregarArco(6, 5, "se conecta con");
        /* grafo1.agregarArco(6, 1, "se conecta con"); */
        grafo1.agregarArco(5, 1, "se conecta con");
        grafo1.agregarArco(3, 6, "se conecta con");
        //Lo borra
        grafo1.borrarArco(3, 4);

        grafo1.borrarVertice(3);

        System.out.println("Cantidad vertices: " + grafo1.cantidadVertices());
        System.out.println("Cantidad arcos: " + grafo1.cantidadArcos());
        System.out.println("Contiene vertice: " + grafo1.contieneVertice(10));
        System.out.println("Contiene vertice: " + grafo1.contieneVertice(7));
        System.out.println("Existe arco: " + grafo1.existeArco(3, 4));
        System.out.println("Existe arco: " + grafo1.existeArco(1, 4)+"\n");

        ServicioDfs servicio_dfs = new ServicioDfs(grafo1);
        System.out.println("Tiene ciclo: " + servicio_dfs.tieneCicloDfs());
    }
}
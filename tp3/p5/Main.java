import java.util.Iterator;

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
        grafo1.agregarArco(1, 7, "se conecta con");
        grafo1.agregarArco(6, 5, "se conecta con");
        grafo1.agregarArco(6, 1, "se conecta con");
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

        System.out.println("Vertices:");
        Iterator<Integer> vertices = grafo1.obtenerVertices();
        while (vertices.hasNext()) {
            System.out.println(vertices.next());
        }

        System.out.println("\nAdyacentes de 1:");
        Iterator<Integer> adyacentes = grafo1.obtenerAdyacentes(1);
        while (adyacentes.hasNext()) {
            System.out.println(adyacentes.next());
        }

        System.out.println("\nArcos:");
        Iterator<Arco<String>> arcos = grafo1.obtenerArcos();
        while (arcos.hasNext()) {
            System.out.println(arcos.next());
        }

        System.out.println("\nArcos compuestos por 6:");
        Iterator<Arco<String>> arcos_vertice = grafo1.obtenerArcos(6);
        while (arcos_vertice.hasNext()) {
            System.out.println(arcos_vertice.next());
        }

        ServicioVerticesCamino servicio_vertices_camino1 = new ServicioVerticesCamino(grafo1, 6);
        System.out.println("\nVertices que pueden llegar a 6: " + servicio_vertices_camino1.vertices());

        ServicioVerticesCamino servicio_vertices_camino2 = new ServicioVerticesCamino(grafo1, 4);
        System.out.println("Vertices que pueden llegar a 4: " + servicio_vertices_camino2.vertices());

        ServicioVerticesCamino servicio_vertices_camino3 = new ServicioVerticesCamino(grafo1, 1);
        System.out.println("Vertices que pueden llegar a 1: " + servicio_vertices_camino3.vertices());
    }
}
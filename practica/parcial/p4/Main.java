public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1, 2, null);
        grafo.agregarArco(1, 4, null);
        grafo.agregarArco(2, 3, null);
        grafo.agregarArco(2, 4, null);

        GrafoNoDirigido<Integer> grafo2 = new GrafoNoDirigido<>();
        grafo2.agregarVertice(1);
        grafo2.agregarVertice(2);
        grafo2.agregarVertice(3);
        grafo2.agregarVertice(4);
        grafo2.agregarVertice(5);
        grafo2.agregarVertice(6);

        grafo2.agregarArco(1, 1, null);
        grafo2.agregarArco(1, 2, null);
        grafo2.agregarArco(1, 4, null);
        grafo2.agregarArco(1, 5, null);
        grafo2.agregarArco(2, 3, null);
        grafo2.agregarArco(2, 4, null);
        grafo2.agregarArco(2, 6, null);
        grafo2.agregarArco(3, 4, null);
        

        MayorCiclo mayor_ciclo = new MayorCiclo();
        System.out.println("Solucion1: " + mayor_ciclo.mayorCiclo(grafo));
        System.out.println("Solucion2: " + mayor_ciclo.mayorCiclo(grafo2));
    }
}
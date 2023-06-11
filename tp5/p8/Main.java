import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArchivoCancion> canciones = new ArrayList<>();
        ArchivoCancion c1 = new ArchivoCancion("c1", "pop", 3.21, 3);
        ArchivoCancion c2 = new ArchivoCancion("c2", "rock", 6.02, 7);
        ArchivoCancion c3 = new ArchivoCancion("c3", "metal", 2, 1);
        ArchivoCancion c4 = new ArchivoCancion("c4", "rock", 4.42, 5);
        ArchivoCancion c5 = new ArchivoCancion("c5", "electro", 5, 6);
        ArchivoCancion c6 = new ArchivoCancion("c6", "metal", 3.42, 3);
        ArchivoCancion c7 = new ArchivoCancion("c7", "rock", 3.42, 3);
        ArchivoCancion c8 = new ArchivoCancion("c8", "metal", 3.42, 1);
        ArchivoCancion c9 = new ArchivoCancion("c9", "rock", 3.42, 6);

        canciones.add(c1);
        canciones.add(c2);
        canciones.add(c3);
        canciones.add(c4);
        canciones.add(c5);
        canciones.add(c6);
        canciones.add(c7);
        canciones.add(c8);
        canciones.add(c9);

        GreedyDisco greedy = new GreedyDisco(15, 2);
        GreedyDiscoMaxCantidad greedy2 = new GreedyDiscoMaxCantidad(15, 2);
        System.out.println("Solucion g1: " + greedy.greedy(canciones));
        System.out.println("Solucion g2: " + greedy2.greedy(canciones));
    }
}
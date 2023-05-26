public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(4, 4);
        matriz.imprimir();

        BacktrackingCaminoCorto back_camino_corto = new BacktrackingCaminoCorto(matriz, 3, 0);
        System.out.println("Solucion: " + back_camino_corto.camino());
        System.out.println(back_camino_corto);
    }
}
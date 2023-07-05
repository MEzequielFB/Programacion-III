public class Main {
    public static void main(String[] args) {
        int [][] matriz = new int[4][4];
        matriz[0][0] = 12;
        matriz[0][1] = 5;
        matriz[0][2] = 9;
        matriz[0][3] = 8;

        matriz[1][0] = 13;
        matriz[1][1] = 7;
        matriz[1][2] = 14;
        matriz[1][3] = 16;

        matriz[2][0] = 2;
        matriz[2][1] = 4;
        matriz[2][2] = 9;
        matriz[2][3] = 17;

        matriz[3][0] = 2;
        matriz[3][1] = 1;
        matriz[3][2] = 15;
        matriz[3][3] = 14;

        Greedy greedy = new Greedy();
        System.out.println("Solucion: " + greedy.greedy(matriz, new Posicion(3, 1), new Posicion(2, 3)));
        System.out.println("Solucion: " + greedy.greedy(matriz, new Posicion(1, 1), new Posicion(1, 3)));
    }
}
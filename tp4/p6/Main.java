public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(4, 4);
        matriz.setPosValor(0, 0, 1);
        matriz.setPosValor(1, 0, 1);
        matriz.setPosValor(2, 0, 1);
        matriz.setPosValor(2, 1, 1);
        matriz.setPosValor(3, 0, 1);
        matriz.setPosValor(3, 1, 1);
        matriz.setPosValor(3, 2, 1);
        matriz.setPosValor(3, 3, 1);

        matriz.imprimirMatriz();

        BackAtila back_atila = new BackAtila();
        System.out.println("Solucion: " + back_atila.encontrarPosibleCamino(matriz));
    }
}
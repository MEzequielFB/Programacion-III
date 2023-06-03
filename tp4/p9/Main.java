public class Main {
    public static void main(String[] args) {
        int [][] tablero = new int[4][4];

        BackOrdenar back_ordenar = new BackOrdenar(1, 3);
        back_ordenar.obtenerTableroOrdenado(tablero);
        imprimirMatriz(tablero);
    }

    public static void imprimirMatriz(int [][] tablero) {
        String string_matriz = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                string_matriz += " " + tablero[i][j] + " |";
            }
            string_matriz += "\n";
        }
        System.out.println(string_matriz);
    }
}
public class Main {
    public static void main(String[] args) {
        int [][] casa = new int[4][4];

        casa[1][1] = 1;
        casa[3][2] = 1;
        casa[1][3] = 1;

        imprimir(casa);
        BackCamino back_camino = new BackCamino(3, 3, 0, 3);
        System.out.println("Solucion: " + back_camino.buscarCamino(casa));
    }

    public static void imprimir(int [][] matriz) {
        String string_matriz = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                string_matriz += " " + matriz[i][j] + " |";
            }
            string_matriz += "\n";
        }
        System.out.println(string_matriz);
    }
}
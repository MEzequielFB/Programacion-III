import java.util.ArrayList;
import java.util.List;

public class BackPiramide {
    private List<int[][]> soluciones;
    private int k;
    private int b;

    public BackPiramide(int k, int b) {
        this.soluciones = new ArrayList<>();
        this.k = k;
        this.b = b;
    }

    public List<int[][]> obtenerPiramides() {
        int [][] estado = new int[this.b][this.b];
        int numero_actual = 1;
        if (this.k > 1 && this.b % 2 != 0) {
            this.backtracking(estado, numero_actual, this.b, numero_actual);
        }

        return this.soluciones;
    }

    private void backtracking(int [][] estado, int numero_actual, int fila, int columna) {

    }

    private void inicializar(int [][] estado) {
        int fila = this.b;
        int columna = 0;
        int resta = 1;
        while (fila >= 0) {
            while (columna < this.b) {
                
            }
            fila--;
        }
    }

    /* private void asd() {
        int [][] numeros = new int[2][2];
        int [][] numeros2 = new int[2][2];

        numeros[0][0] = 2;
        numeros[0][1] = 2;
        numeros[1][0] = 3;
        numeros[1][1] = 3;

        numeros2[0][0] = 3;
        numeros2[0][1] = 3;
        numeros2[1][0] = 2;
        numeros2[1][1] = 1;

        this.soluciones.add(numeros);
        this.soluciones.add(numeros2);
    }

    public void imprimir() {
        String string_soluciones = "";
        for (int[][] matriz : this.soluciones) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    string_soluciones += " " + matriz[i][j] + " |";
                }
                string_soluciones += "\n";
            }
            string_soluciones += "\n";
        }
        System.out.println(string_soluciones);
    } */
}
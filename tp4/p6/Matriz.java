public class Matriz {
    private int [][] numeros;
    private int cant_filas;
    private int cant_columnas;

    public Matriz(int cant_filas, int cant_columnas) {
        this.numeros = new int[cant_filas][cant_columnas];
        this.cant_filas = cant_filas;
        this.cant_columnas = cant_columnas;
    }

    public Integer getValorPos(int fila, int columna) {
        if (fila < this.cant_filas && columna < this.cant_columnas) {
            return this.numeros[fila][columna];
        }
        return null;
    }

    public void setPosValor(int fila, int columna, int valor) {
        if (fila < this.cant_filas && columna < this.cant_columnas) {
            this.numeros[fila][columna] = valor;
        }
    }

    public void imprimirMatriz() {
        String string_matriz = "";
        for (int i = 0; i < this.cant_filas; i++) {
            for (int j = 0; j < this.cant_columnas; j++) {
                string_matriz += " " + this.numeros[i][j] + " |";
            }
            string_matriz += "\n";
        }
        System.out.println(string_matriz);
    }

    public int getCantFilas() {
        return this.cant_filas;
    }

    public int getCantColumnas() {
        return this.cant_columnas;
    }
}
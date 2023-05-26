public class Matriz {
    private Integer [][] elementos;
    private int cant_filas;
    private int cant_columnas;

    public Matriz(int cant_filas, int cant_columnas) {
        this.cant_filas = cant_filas;
        this.cant_columnas = cant_columnas;
        this.elementos = new Integer[cant_filas][cant_columnas];
        this.inicializar();
    }

    public int getValorPosicion(int fila, int columna) {
        if (fila < this.cant_filas && columna < this.cant_columnas) {
            return elementos[fila][columna];
        }
        return -1;
    }

    public int getCantFilas() {
        return this.cant_filas;
    }

    public int getCantColumnas() {
        return this.cant_columnas;
    }

    private void inicializar() {
        for (int i = 0; i < this.cant_filas; i++) {
            for (int j = 0; j < this.cant_columnas; j++) {
                int valor_random = this.obtenerValor();
                if (!this.estaRepetida(valor_random)) {
                    this.elementos[i][j] = valor_random;
                } else {
                    j--;
                }
            }
        }
    }

    private int obtenerValor() {
        int maximo = this.cant_filas * this.cant_columnas;
        int valor_random = (int) (Math.random() * maximo + 1);
        return valor_random;
    }

    private boolean estaRepetida(int valor) {
        for (int i = 0; i < this.cant_filas; i++) {
            for (int j = 0; j < this.cant_columnas; j++) {
                if (this.elementos[i][j] != null) {
                    if (this.elementos[i][j].equals(valor)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void imprimir() {
        String matriz_string = "";
        for (int i = 0; i < cant_filas; i++) {
            for (int j = 0; j < cant_columnas; j++) {
                matriz_string += this.elementos[i][j] + " | ";
            }
            matriz_string += "\n";
        }
        System.out.println(matriz_string);
    }
}
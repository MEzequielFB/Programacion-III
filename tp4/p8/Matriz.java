public class Matriz {
    private int [][] numeros;
    private int base;

    public Matriz(int base) {
        this.numeros = new int[base][base];
        this.base = base;
    }

    public Integer getValorPos(int fila, int columna) {
        if (fila < this.base && columna < this.base) {
            return this.numeros[fila][columna];
        }
        return null;
    }

    public void setPosValor(int fila, int columna, int valor) {
        if (fila < this.base && columna < this.base) {
            this.numeros[fila][columna] = valor;
        }
    }

    public void imprimirMatriz() {
        String string_matriz = "";
        for (int i = 0; i < this.base; i++) {
            for (int j = 0; j < this.base; j++) {
                string_matriz += " " + this.numeros[i][j] + " |";
            }
            string_matriz += "\n";
        }
        System.out.println(string_matriz);
    }

    public int getBase() {
        return this.base;
    }
}
import java.util.ArrayList;

public class BackOrdenar {
    private static int _dimension;
    private static int _minimo;
    private static int _maximo;

    private int fila_vacio;
    private int columna_vacio;
    private int [][] solucion;

    public BackOrdenar(int fila_vacio, int columna_vacio) {
        _dimension = 4;
        _minimo = 1;
        _maximo = 15;
        this.fila_vacio = fila_vacio;
        this.columna_vacio = columna_vacio;
        this.solucion = new int[_dimension][_dimension];
    }

    private void inicializar() {
        ArrayList<Integer> numeros_agregados = new ArrayList<>();

        for (int i = 0; i < _dimension; i++) {
            for (int j = 0; j < _dimension; j++) {
                if (i != this.fila_vacio && j != this.columna_vacio) {
                    int numero_random = this.getNumeroRandom();
                    if (!numeros_agregados.contains(numero_random)) {
                        this.solucion[i][j] = numero_random;
                    }
                }
            }
        }
    }

    private int getNumeroRandom() {
        return (int) ((Math.random() * _maximo-1) + 1);
    }

    
}
import java.util.ArrayList;

public class BackOrdenar {
    private static int _minimo;
    private static int _maximo;

    //La cosa seria agarra al menor numero del tablero y llevarlo a la primera posicion y agregando la posicion y numero ya ordenados
    private ArrayList<Integer> posiciones_ordenadas; //(?)
    private ArrayList<Integer> numeros_ordenados;
    private int menor_numero;

    private Posicion ultima_posicion;
    private int fila_vacio;
    private int columna_vacio;

    public BackOrdenar(int fila_vacio, int columna_vacio) {
        _minimo = 1;
        _maximo = 15;
        this.menor_numero = -1;
        this.ultima_posicion = null;
        this.fila_vacio = fila_vacio;
        this.columna_vacio = columna_vacio;
    }

    public void obtenerTableroOrdenado(int [][] tablero) {
        this.ultima_posicion = new Posicion(tablero.length, tablero[0].length);
        this.inicializar(tablero);
        this.backtracking(tablero);
    }

    private boolean backtracking(int[][] tablero) {
        if (this.estaOrdenado(tablero)) {
            return true;
        } else {
            
        }
        return false;
    }

    private boolean estaOrdenado(int [][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length-1; j++) {
                Posicion posicion_proxima = new Posicion(i, j+1);
                if (posicion_proxima.equals(this.ultima_posicion)) {
                    return true;
                }
                if (tablero[i][j] > tablero[i][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void inicializar(int [][] tablero) {
        ArrayList<Integer> numeros_agregados = new ArrayList<>();

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i != this.fila_vacio || j != this.columna_vacio) {
                    int numero_random = this.getNumeroRandom();
                    if (!numeros_agregados.contains(numero_random)) {
                        tablero[i][j] = numero_random;
                        numeros_agregados.add(numero_random);
                    } else {
                        j--;
                    }
                }
            }
        }
    }

    private int getNumeroRandom() {
        return (int) ((Math.random() * _maximo) + _minimo);
    }
}
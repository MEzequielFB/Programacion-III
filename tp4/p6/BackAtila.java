import java.util.ArrayList;
import java.util.List;

public class BackAtila {
    private List<Posicion> solucion;
    private static int _valor_pisado;
    private static int _valor_sin_pisar;
    private static int _valor_pasado;

    public BackAtila() {
        this.solucion = new ArrayList<>();
        _valor_pisado = 0;
        _valor_sin_pisar = 1;
        _valor_pasado = 2;
    }

    public List<Posicion> encontrarPosibleCamino(Matriz matriz) {
        for (int i = 0; i < matriz.getCantFilas(); i++) {
            for (int j = 0; j < matriz.getCantColumnas(); j++) {
                if (matriz.getValorPos(i, j) == _valor_pisado && this.esEntrada(i, j, matriz)) {

                    this.backtracking(matriz, i, j);
                    this.solucion.remove(this.solucion.size()-1);
                }
            }
        }
        return solucion;
    }

    private void backtracking(Matriz matriz, int fila, int columna) {
        this.solucion.add(new Posicion(fila, columna));
        if (this.esSolucion(matriz, fila, columna)) {

        }
    }

    private boolean esSolucion(Matriz matriz, int fila, int columna) {
        return this.solucion.size() == this.getCantidadCasillasPisadas(matriz) && this.esEntrada(fila, columna, matriz) && this.sonAdyacentes();
    }

    private int getCantidadCasillasPisadas(Matriz matriz) {
        int cantidad = 0;
        for (int i = 0; i < matriz.getCantFilas(); i++) {
            for (int j = 0; j < matriz.getCantColumnas(); j++) {
                if (matriz.getValorPos(i, j) == _valor_pisado) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    private boolean esEntrada(int fila, int columna, Matriz matriz) {
        int ultima_fila = matriz.getCantFilas() - 1;
        int ultima_columna = matriz.getCantColumnas() - 1;
        return fila == 0 || columna == 0 || fila == ultima_fila || columna == ultima_columna;
    }

    private boolean sonAdyacentes() {
        if (this.solucion.size() > 1) {
            Posicion entrada = this.solucion.get(0);
            Posicion salida = this.solucion.get(this.solucion.size()-1);

            return ( entrada.getFila() == salida.getFila() && ( entrada.getColumna()-1 == salida.getColumna() || entrada.getColumna()+1 == salida.getColumna() ) || ( entrada.getColumna() == salida.getColumna() && (entrada.getFila()-1 == salida.getFila() || entrada.getFila()+1 == salida.getFila() ) ) );
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.List;

public class BackAtila {
    private List<Posicion> solucion;
    private static int _valor_pisado;

    public BackAtila() {
        this.solucion = new ArrayList<>();
        _valor_pisado = 0;
    }

    public List<Posicion> encontrarPosibleCamino(Matriz matriz) {
        for (int i = 0; i < matriz.getCantFilas(); i++) {
            for (int j = 0; j < matriz.getCantColumnas(); j++) {
                if (this.fuePisado(matriz, i, j) && this.esEntrada(i, j, matriz)) {
                    boolean hay_solucion = this.backtracking(matriz, i, j);
                    if (hay_solucion) {
                        return this.solucion;
                    }
                    this.solucion.remove(this.solucion.size()-1);
                }
            }
        }
        return this.solucion;
    }

    private boolean backtracking(Matriz matriz, int fila, int columna) {
        this.solucion.add(new Posicion(fila, columna));
        if (this.esSolucion(matriz, fila, columna)) {
            return true;
        } else {
            if (this.esPosicionValida(matriz, fila, columna)) {

                boolean hay_solucion = false;
                if (!this.fuePasado(matriz, fila, columna-1)) {
                    hay_solucion = this.backtracking(matriz, fila, columna-1);
                    if (hay_solucion) {
                        return hay_solucion;
                    }
                    this.solucion.remove(this.solucion.size()-1);
                }

                if (!this.fuePasado(matriz, fila+1, columna)) {
                    hay_solucion = this.backtracking(matriz, fila+1, columna);
                    if (hay_solucion) {
                        return hay_solucion;
                    }
                    this.solucion.remove(this.solucion.size()-1);
                }

                if (!this.fuePasado(matriz, fila, columna+1)) {
                    hay_solucion = this.backtracking(matriz, fila, columna+1);
                    if (hay_solucion) {
                        return hay_solucion;
                    }
                    this.solucion.remove(this.solucion.size()-1);
                }

                if (!this.fuePasado(matriz, fila-1, columna)) {
                    hay_solucion = this.backtracking(matriz, fila-1, columna);
                    if (hay_solucion) {
                        return hay_solucion;
                    }
                    this.solucion.remove(this.solucion.size()-1);
                }
            }
        }
        return false;
    }

    private boolean esPosicionValida(Matriz matriz, int fila, int columna) {
        return fila >= 0 && fila < matriz.getCantFilas() && columna >= 0 && columna < matriz.getCantColumnas() && this.fuePisado(matriz, fila, columna);
    }

    private boolean fuePisado(Matriz matriz, int fila, int columna) {
        return matriz.getValorPos(fila, columna) == _valor_pisado;
    }

    private boolean fuePasado(Matriz matriz, int fila, int columna) {
        for (Posicion posicion : this.solucion) {
            if (posicion.getFila() == fila && posicion.getColumna() == columna) {
                return true;
            }
        }
        return false;
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

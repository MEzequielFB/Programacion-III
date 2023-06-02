import java.util.ArrayList;
import java.util.List;

public class BackAtilaAllSolutions {
    private List<List<Posicion>> solucion;
    private static int _valor_pisado;

    public BackAtilaAllSolutions() {
        this.solucion = new ArrayList<>();
        _valor_pisado = 0;
    }

    public List<List<Posicion>> encontrarPosibleCamino(Matriz matriz) {
        List<Posicion> estado = new ArrayList<>();
        for (int i = 0; i < matriz.getCantFilas(); i++) {
            for (int j = 0; j < matriz.getCantColumnas(); j++) {
                if (this.fuePisado(matriz, i, j) && this.esEntrada(matriz, i, j)) {
                    this.backtracking(matriz, i, j, estado);
                    estado.remove(estado.size()-1);
                }
            }
        }
        return this.solucion;
    }

    private void backtracking(Matriz matriz, int fila, int columna, List<Posicion> estado) {
        estado.add(new Posicion(fila, columna));
        if (this.esSolucion(matriz, fila, columna, estado)) {
            this.solucion.add(new ArrayList<>(estado));
        } else {
            if (this.esPosicionValida(matriz, fila, columna)) {

                if (!this.fuePasado(matriz, fila, columna-1, estado)) {
                    this.backtracking(matriz, fila, columna-1, estado);
                    estado.remove(estado.size()-1);
                }

                if (!this.fuePasado(matriz, fila+1, columna, estado)) {
                    this.backtracking(matriz, fila+1, columna, estado);
                    estado.remove(estado.size()-1);
                }

                if (!this.fuePasado(matriz, fila, columna+1, estado)) {
                    this.backtracking(matriz, fila, columna+1, estado);
                    estado.remove(estado.size()-1);
                }

                if (!this.fuePasado(matriz, fila-1, columna, estado)) {
                    this.backtracking(matriz, fila-1, columna, estado);
                    estado.remove(estado.size()-1);
                }
            }
        }
    }

    private boolean esPosicionValida(Matriz matriz, int fila, int columna) {
        return fila >= 0 && fila < matriz.getCantFilas() && columna >= 0 && columna < matriz.getCantColumnas() && this.fuePisado(matriz, fila, columna);
    }

    private boolean fuePisado(Matriz matriz, int fila, int columna) {
        return matriz.getValorPos(fila, columna) == _valor_pisado;
    }

    private boolean fuePasado(Matriz matriz, int fila, int columna, List<Posicion> estado) {
        for (Posicion posicion : estado) {
            if (posicion.getFila() == fila && posicion.getColumna() == columna) {
                return true;
            }
        }
        return false;
    }

    private boolean esSolucion(Matriz matriz, int fila, int columna, List<Posicion> estado) {
        return estado.size() == this.getCantidadCasillasPisadas(matriz) && this.esEntrada(matriz, fila, columna) && this.sonAdyacentes(estado);
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

    private boolean esEntrada(Matriz matriz, int fila, int columna) {
        int ultima_fila = matriz.getCantFilas() - 1;
        int ultima_columna = matriz.getCantColumnas() - 1;
        return fila == 0 || columna == 0 || fila == ultima_fila || columna == ultima_columna;
    }

    private boolean sonAdyacentes(List<Posicion> estado) {
        if (estado.size() > 1) {
            Posicion entrada = estado.get(0);
            Posicion salida = estado.get(estado.size()-1);

            return ( entrada.getFila() == salida.getFila() && ( entrada.getColumna()-1 == salida.getColumna() || entrada.getColumna()+1 == salida.getColumna() ) || ( entrada.getColumna() == salida.getColumna() && (entrada.getFila()-1 == salida.getFila() || entrada.getFila()+1 == salida.getFila() ) ) );
        }
        return false;
    }
}
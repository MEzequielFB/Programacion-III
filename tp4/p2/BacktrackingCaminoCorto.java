import java.util.LinkedList;
import java.util.List;

public class BacktrackingCaminoCorto {
    private Matriz matriz;
    private int origen;
    private int destino;
    private LinkedList<Integer> solucion;
    private Integer valor_solucion;

    public BacktrackingCaminoCorto(Matriz matriz, int origen, int destino) {
        this.matriz = matriz;
        this.origen = origen;
        this.destino = destino;
        this.solucion = new LinkedList<>();
        this.valor_solucion = null;
    }

    public List<Integer> camino() {
        if (this.sonCasillasValidas()) {
            LinkedList<Integer> casillas_visitadas = new LinkedList<>();
            int fila_actual = this.origen;
            int columna_actual = this.origen;

            /* casillas_visitadas.add(this.origen); */
            this.buscarCaminos(this.matriz.getValorPosicion(fila_actual, columna_actual), casillas_visitadas, fila_actual, columna_actual);
        }
        return this.solucion;
    }

    private void buscarCaminos(int valor, LinkedList<Integer> casillas_visitadas, int fila_actual, int columna_actual) {
        casillas_visitadas.add(valor);
        /* if (valor == this.destino) { */
        if (this.esPosicionDestino(fila_actual, columna_actual)) {
            int valor_total_actual = this.calcularValor(casillas_visitadas);
            if (this.valor_solucion == null || valor_total_actual < this.valor_solucion) {
                this.solucion.clear();
                this.solucion.addAll(casillas_visitadas);
                this.valor_solucion = valor_total_actual;
            }
        } else {
            //Hacia arriba
            if (this.esCasillaValida(fila_actual - 1, columna_actual)) {
                int valor_adyacente = this.matriz.getValorPosicion(fila_actual - 1, columna_actual);
                if (!casillas_visitadas.contains(valor_adyacente)) {
                    this.buscarCaminos(valor_adyacente, casillas_visitadas, fila_actual - 1, columna_actual);
                    casillas_visitadas.removeLast();
                }
            }

            //Hacia izquierda
            if (this.esCasillaValida(fila_actual, columna_actual - 1)) {
                int valor_adyacente = this.matriz.getValorPosicion(fila_actual, columna_actual - 1);
                if (!casillas_visitadas.contains(valor_adyacente)) {
                    this.buscarCaminos(valor_adyacente, casillas_visitadas, fila_actual, columna_actual - 1);
                    casillas_visitadas.removeLast();
                }
            }

            //Hacia abajo
            if (this.esCasillaValida(fila_actual + 1, columna_actual)) {
                int valor_adyacente = this.matriz.getValorPosicion(fila_actual + 1, columna_actual);
                if (!casillas_visitadas.contains(valor_adyacente)) {
                    this.buscarCaminos(valor_adyacente, casillas_visitadas, fila_actual + 1, columna_actual);
                    casillas_visitadas.removeLast();
                }
            }

            //Hacia derecha
            if (this.esCasillaValida(fila_actual, columna_actual + 1)) {
                int valor_adyacente = this.matriz.getValorPosicion(fila_actual, columna_actual + 1);
                if (!casillas_visitadas.contains(valor_adyacente)) {
                    this.buscarCaminos(valor_adyacente, casillas_visitadas, fila_actual, columna_actual + 1);
                    casillas_visitadas.removeLast();
                }
            }
        }
    }

    private boolean esPosicionDestino(int fila, int columna) {
        return fila == this.destino && columna == this.destino;
    }

    private int calcularValor(LinkedList<Integer> casillas_visitadas) {
        int sumatoria = 0;
        for (int valor : casillas_visitadas) {
            sumatoria += valor;
        }
        return sumatoria;
    }

    private boolean esCasillaValida(int fila, int columna) {
        return fila >= 0 && fila < this.matriz.getCantFilas() && columna >= 0 && columna < this.matriz.getCantColumnas();
    }

    private boolean sonCasillasValidas() {
        return this.origen >= 0 && this.origen < this.matriz.getCantFilas() && this.origen < this.matriz.getCantColumnas() && this.destino >= 0 && this.destino < this.matriz.getCantFilas() && this.destino < this.matriz.getCantColumnas();
    }
}
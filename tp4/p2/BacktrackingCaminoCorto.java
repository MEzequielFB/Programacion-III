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

            this.buscarCaminos(casillas_visitadas, fila_actual, columna_actual);
        }
        return this.solucion;
    }

    private void buscarCaminos(LinkedList<Integer> casillas_visitadas, int fila_actual, int columna_actual) {
        //Obtiene el valor de una posicion de la matriz y lo agrega a las casillas visitadas (los valores de las casillas de la matriz no se repiten)
        int valor = this.matriz.getValorPosicion(fila_actual, columna_actual);
        casillas_visitadas.add(valor);

        //Verifica si la casilla actual es la destino
        //Si los es calcula el valor total del camino recorrido
        //Despues pregunta que ese valor total sea menor al valor solucion hasta el momento O que el valor solucion sea null
        //Si es true reemplaza el camino solucion y el valor solucion
        if (this.esPosicionDestino(fila_actual, columna_actual)) {
            int valor_total_actual = this.calcularValor(casillas_visitadas);
            if (this.valor_solucion == null || valor_total_actual < this.valor_solucion) {
                this.solucion.clear();
                this.solucion.addAll(casillas_visitadas);
                this.valor_solucion = valor_total_actual;
            }
        } else {
            //Si la posicion actual no es la destino...
            //Calcula el valor total obtenido hasta el momento
            //Usa el valor total como poda del backtracking
            //Si el valor solucion es null o el valor actual no se pasa del valor solucion obtenido hasta el momento procede

            int valor_total_actual = this.calcularValor(casillas_visitadas);
            if (this.valor_solucion == null || valor_total_actual < this.valor_solucion) {

                //Cambia el valor de la fila o la columna y pregunta si es una casilla valida (que esta dentro de los limites de la matriz)
                //Si lo esta, obtiene el valor de la casilla adyacente a la actual, verifica que no haya sido visitada y llama recursivamente
                //Despues elimina la ultima casilla visitada agregada a la lista

                //Hacia arriba
                if (this.esCasillaValida(fila_actual - 1, columna_actual)) {
                    int valor_adyacente = this.matriz.getValorPosicion(fila_actual - 1, columna_actual);
                    if (!casillas_visitadas.contains(valor_adyacente)) {
                        this.buscarCaminos(casillas_visitadas, fila_actual - 1, columna_actual);
                        casillas_visitadas.removeLast();
                    }
                }

                //Hacia izquierda
                if (this.esCasillaValida(fila_actual, columna_actual - 1)) {
                    int valor_adyacente = this.matriz.getValorPosicion(fila_actual, columna_actual - 1);
                    if (!casillas_visitadas.contains(valor_adyacente)) {
                        this.buscarCaminos(casillas_visitadas, fila_actual, columna_actual - 1);
                        casillas_visitadas.removeLast();
                    }
                }

                //Hacia abajo
                if (this.esCasillaValida(fila_actual + 1, columna_actual)) {
                    int valor_adyacente = this.matriz.getValorPosicion(fila_actual + 1, columna_actual);
                    if (!casillas_visitadas.contains(valor_adyacente)) {
                        this.buscarCaminos(casillas_visitadas, fila_actual + 1, columna_actual);
                        casillas_visitadas.removeLast();
                    }
                }

                //Hacia derecha
                if (this.esCasillaValida(fila_actual, columna_actual + 1)) {
                    int valor_adyacente = this.matriz.getValorPosicion(fila_actual, columna_actual + 1);
                    if (!casillas_visitadas.contains(valor_adyacente)) {
                        this.buscarCaminos(casillas_visitadas, fila_actual, columna_actual + 1);
                        casillas_visitadas.removeLast();
                    }
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

    @Override
    public String toString() {
        return "Solucion: " + this.solucion + ", valor total de la solucion: " + this.valor_solucion;
    }
}
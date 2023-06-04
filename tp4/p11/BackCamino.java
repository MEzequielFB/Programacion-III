import java.util.ArrayList;
import java.util.List;

public class BackCamino {
    private static int _obstaculo;
    private static int _libre;

    private List<Posicion> solucion;
    private List<Posicion> solucion_parcial;
    private int fila_robot;
    private int columna_robot;
    private int fila_carga;
    private int columna_carga;

    public BackCamino(int fila_robot, int columna_robot, int fila_carga, int columna_carga) {
        _obstaculo = 1;
        _libre = 0;

        this.solucion = new ArrayList<>();
        this.solucion_parcial = new ArrayList<>();
        this.fila_robot = fila_robot;
        this.columna_robot = columna_robot;
        this.fila_carga = fila_carga;
        this.columna_carga = columna_carga;
    }

    public List<Posicion> buscarCamino(int [][] estado) {
        if (estado.length > 0 && this.sonPosicionesValidas(estado)) {
            this.backtracking(estado, this.fila_robot, this.fila_robot);
            this.solucion_parcial.remove(this.solucion_parcial.size()-1);
        }
        return this.solucion;
    }

    private void backtracking(int [][] estado, int fila, int columna) {
        this.solucion_parcial.add(new Posicion(fila, columna));

        if (this.esSolucion() && this.esPasable(estado, fila, columna)) {
            this.solucion.clear();
            this.solucion.addAll(this.solucion_parcial);
        } else {
            if (this.esPasable(estado, fila, columna)) {
                if (this.solucion.isEmpty() || this.solucion_parcial.size() < this.solucion.size()) { //Poda

                    if (this.esPosicionValida(estado, fila, columna-1) && !solucion_parcial.contains(new Posicion(fila, columna-1)) ) {
                        this.backtracking(estado, fila, columna-1);
                        this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                    }

                    if (this.esPosicionValida(estado, fila+1, columna) && !solucion_parcial.contains(new Posicion(fila+1, columna))) {
                        this.backtracking(estado, fila+1, columna);
                        this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                    }

                    if (this.esPosicionValida(estado, fila, columna+1) && !solucion_parcial.contains(new Posicion(fila, columna+1))) {
                        this.backtracking(estado, fila, columna+1);
                        this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                    }

                    if (this.esPosicionValida(estado, fila-1, columna) && !solucion_parcial.contains(new Posicion(fila-1, columna))) {
                        this.backtracking(estado, fila-1, columna);
                        this.solucion_parcial.remove(this.solucion_parcial.size()-1);
                    }
                }
            }
        }
    }

    private boolean esSolucion() {
        Posicion ultima_posicion = this.solucion_parcial.get(this.solucion_parcial.size()-1);
        return ultima_posicion.getFila() == this.fila_carga && ultima_posicion.getColumna() == this.columna_carga;
    }

    private boolean sonPosicionesValidas(int [][] matriz) {
        return this.esPosicionValida(matriz, this.fila_robot, this.columna_robot) && this.esPosicionValida(matriz, fila_carga, columna_carga);
    }

    private boolean esPosicionValida(int [][] matriz, int fila, int columna) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
    }

    private boolean esPasable(int [][] matriz, int fila, int columna) {
        return matriz[fila][columna] == _libre;
    }
}
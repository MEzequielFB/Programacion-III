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
        if (estado.length > 0 && this.sonPosicionesValidas(estado) && !this.esSolucion()) {
            int cant_celdas_pasadas = 0;
            this.backtracking(estado, this.fila_robot, this.fila_robot, cant_celdas_pasadas);
            this.solucion_parcial.remove(this.solucion_parcial.size()-1);
            cant_celdas_pasadas--;
        }
        return this.solucion;
    }

    private void backtracking(int [][] estado, int fila, int columna, int cant_celdas_pasadas) {
        this.solucion_parcial.add(new Posicion(fila, columna));
        cant_celdas_pasadas++;

        if (this.esSolucion()) {
            this.solucion_parcial.clear();
            this.solucion.addAll(this.solucion_parcial);
        } else {
            
        }
    }

    private boolean esSolucion() {
        return this.fila_robot == this.fila_carga && this.columna_robot == this.columna_carga;
    }

    private boolean sonPosicionesValidas(int [][] matriz) {
        return this.fila_robot >= 0 && this.fila_robot < matriz.length && this.columna_robot >= 0 && this.columna_robot < matriz[0].length && this.fila_carga >= 0 && this.fila_carga < matriz.length && this.columna_carga >= 0 && this.columna_carga < matriz[0].length;
    }
}
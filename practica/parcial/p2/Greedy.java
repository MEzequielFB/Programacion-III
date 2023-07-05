import java.util.ArrayList;
import java.util.List;

public class Greedy {
    private List<Posicion> camino;

    public Greedy() {
        this.camino = new ArrayList<>();
    }

    public List<Posicion> greedy(int [][] matriz, Posicion origen, Posicion destino) {
        this.camino.clear();
        if (matriz.length > 0 && this.esPosicionValida(matriz, origen.getFila(), origen.getColumna()) && this.esPosicionValida(matriz, destino.getFila(), destino.getColumna())) {
            Posicion candidato = origen;
            this.camino.add(candidato);

            while (candidato != null && !this.esSolucion(destino)) {
                candidato = this.seleccionar(matriz);
                this.camino.add(candidato);
            }
        }

        if (this.camino.isEmpty() || this.camino.get(this.camino.size()-1) == null) {
            return null;
        }
        return this.camino;
    }

    private boolean esSolucion(Posicion destino) {
        return  this.camino.get(this.camino.size()-1).equals(destino);
    }

    private Posicion seleccionar(int [][] matriz) {
        Posicion mejor_candidato = null;
        Posicion posicion_actual = null;
        int fila_ultimo_candidato = this.camino.get(this.camino.size()-1).getFila();
        int columna_ultimo_candidato = this.camino.get(this.camino.size()-1).getColumna();

        posicion_actual = new Posicion(fila_ultimo_candidato, columna_ultimo_candidato-1);
        if (this.esPosicionValida(matriz, posicion_actual.getFila(), posicion_actual.getColumna()) && !this.camino.contains(posicion_actual)) {
            if (this.esApto(matriz, matriz[posicion_actual.getFila()][posicion_actual.getColumna()], mejor_candidato)) {
                mejor_candidato = posicion_actual;
            }
        }

        posicion_actual = new Posicion(fila_ultimo_candidato+1, columna_ultimo_candidato);
        if (this.esPosicionValida(matriz, posicion_actual.getFila(), posicion_actual.getColumna()) && !this.camino.contains(posicion_actual)) {
            if (this.esApto(matriz, matriz[posicion_actual.getFila()][posicion_actual.getColumna()], mejor_candidato)) {
                mejor_candidato = posicion_actual;
            }
        }

        posicion_actual = new Posicion(fila_ultimo_candidato, columna_ultimo_candidato+1);
        if (this.esPosicionValida(matriz, posicion_actual.getFila(), posicion_actual.getColumna()) && !this.camino.contains(posicion_actual)) {
            if (this.esApto(matriz, matriz[posicion_actual.getFila()][posicion_actual.getColumna()], mejor_candidato)) {
                mejor_candidato = posicion_actual;
            }
        }

        posicion_actual = new Posicion(fila_ultimo_candidato-1, columna_ultimo_candidato);
        if (this.esPosicionValida(matriz, posicion_actual.getFila(), posicion_actual.getColumna()) && !this.camino.contains(posicion_actual)) {
            if (this.esApto(matriz, matriz[posicion_actual.getFila()][posicion_actual.getColumna()], mejor_candidato)) {
                mejor_candidato = posicion_actual;
            }
        }

        return mejor_candidato;
    }

    private boolean esApto(int [][] matriz, int valor, Posicion mejor_candidato) {
        Posicion posicion_actual = this.camino.get(this.camino.size()-1);
        return ( mejor_candidato == null || valor > matriz[mejor_candidato.getFila()][mejor_candidato.getColumna()] ) && valor > matriz[posicion_actual.getFila()][posicion_actual.getColumna()];
    }

    private boolean esPosicionValida(int [][] matriz, int fila, int columna) {
        return fila >= 0 && columna >= 0 && fila < matriz.length && columna < matriz[0].length;
    }
}
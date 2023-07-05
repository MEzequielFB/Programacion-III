public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Posicion otra_posicion = (Posicion) o;
            return this.getFila() == otra_posicion.getFila() && this.getColumna() == otra_posicion.getColumna();
        }
        catch(Exception exc) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" + this.getFila() + "," + this.getColumna() + ")";
    }
}
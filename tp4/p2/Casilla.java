public class Casilla {
    private int valor;

    public Casilla(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return this.valor + "";
    }
}
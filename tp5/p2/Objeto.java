public class Objeto {
    private double peso;
    private double valor;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double getValorPeso() {
        double resultado = this.getValor() / this.getPeso();
        return Math.round(resultado * 100.0) / 100.0;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getValor() {
        return this.valor;
    }
}
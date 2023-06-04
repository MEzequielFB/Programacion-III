import java.util.ArrayList;
import java.util.List;

public class GreedyMochila {
    private List<Double> solucion;
    private double p;

    public GreedyMochila(double p) {
        this.solucion = new ArrayList<>();
        this.p = p;
    }

    public List<Double> greedy(List<Objeto> conjunto) {
        //Si la suma entre el peso de todos los elementos del conjunto pasado es mayor a igual a p entra al if
        //De lo contrario devuelve una lista vacia
        if (this.getPesoTotalConjunto(conjunto) >= this.p) {

            //Agrega ceros a la solucion en relacion a la cantidad de elementos del conjunto
            //Setea en 0 el peso actual
            for (int i = 0; i < conjunto.size(); i++) {
                this.solucion.add(0.0);
            }
            double peso_actual = 0;

            //Mientras el peso actual sea menor a p entra al while
            while (peso_actual < this.p) {

                //Obtiene la posicion del mejor candidato
                //Si la suma entre el peso actual y el peso del candidato es menor a p, se agrega el candidato en su totalidad (1)
                //De lo contrario se agrega lo mas posible del candidato al peso actual (porcentaje)
                int i = this.seleccionar(conjunto);

                if (peso_actual + conjunto.get(i).getPeso() < this.p) {
                    peso_actual += conjunto.get(i).getPeso();

                    this.solucion.set(i, 1.0);
                } else {
                    double porcentaje = (this.p - peso_actual) / conjunto.get(i).getPeso();
                    peso_actual += conjunto.get(i).getPeso() * porcentaje;

                    this.solucion.set(i, porcentaje);
                }
            }
            //Si el peso total es igual a p se devuelve la solucion
            if (peso_actual == this.p) {
                return this.solucion;
            }
        }
        return new ArrayList<>();
    }

    //Empieza con posicion -1
    //Se obtiene el mejor candidato posible segun el criterio utilizado
    //Solo cuentan aquellos candidatos que no hayan sido agregados a la solucion hasta el momento (this.solucion.get(i) == 0)
    private int seleccionar(List<Objeto> conjunto) {
        int posicion_mejor_candidato = -1;

        for (int i = 0; i < conjunto.size(); i++) {
            if (( posicion_mejor_candidato == -1 || conjunto.get(i).getValorPeso() > conjunto.get(posicion_mejor_candidato).getValorPeso() ) && this.solucion.get(i) == 0) {
                posicion_mejor_candidato = i;
            }
        }
        return posicion_mejor_candidato;
    }

    private double getPesoTotalConjunto(List<Objeto> conjunto) {
        double peso_total = 0;
        for (Objeto elemento : conjunto) {
            peso_total += elemento.getPeso();
        }
        return peso_total;
    }
}
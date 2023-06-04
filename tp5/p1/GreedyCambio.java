import java.util.ArrayList;
import java.util.List;

public class GreedyCambio {
    private List<Integer> solucion;
    private int m;

    public GreedyCambio(int m) {
        this.solucion = new ArrayList<>();
        this.m = m;
    }

    public List<Integer> greedy(List<Integer> conjunto) {
        //Mientras la suma de la solucion sea menor al del monto...
        while (this.getSumaSolucion() < this.m) {

            //Obtiene el mejor candidato posible segun el criterio seleccionado (en este caso el de mayor valor posible)
            int candidato = this.seleccionar(conjunto);

            //Si el candidato es apto se agrega a la solucion
            if (candidato != -1) {
                this.solucion.add(candidato);
            }
        }

        //Si es solucion devuelve la solucion formada
        //De lo contrario devuelve una lista vacia
        if (this.esSolucion()) {
            return this.solucion;
        }
        return new ArrayList<>();
    }

    private boolean esSolucion() {
        return this.getSumaSolucion() == this.m;
    }

    //Devuelve la suma de los elementos del conjunto solucion
    private int getSumaSolucion() {
        int suma = 0;
        for (int candidato : this.solucion) {
            suma += candidato;
        }
        return suma;
    }

    //Devuelve el valor del mejor candidato
    //Devuelve -1 si no existe un candidato apto
    private int seleccionar(List<Integer> conjunto) {
        int mejor_candidato = -1;
        int menor_candidato = (int) Double.POSITIVE_INFINITY;
        int monto_restante = this.getMontoRestante();

        for (int i = 0; i < conjunto.size(); i++) {
            int candidato_actual = conjunto.get(i);
            
            //Setea el menor candidato
            if (candidato_actual < menor_candidato) {
                menor_candidato = candidato_actual;
            }

            //Setea al mejor candidato hasta el momento
            if (candidato_actual <= monto_restante && candidato_actual > mejor_candidato) {
                mejor_candidato = candidato_actual;
            }

            //Si esta en el ultimo elemento de la lista y no encontro al mejor candidato
            //Setea al menor candidato como el mejor
            if (mejor_candidato == -1 && i == conjunto.size()-1) {
                mejor_candidato = menor_candidato;
            }
        }
        return mejor_candidato;
    }

    private int getMontoRestante() {
        return this.m - this.getSumaSolucion();
    }
}
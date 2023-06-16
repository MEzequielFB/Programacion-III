import java.util.ArrayList;
import java.util.List;

public class GreedyBilletes {
    private List<Integer> solucion;
    private int cantidad_actual;

    public GreedyBilletes() {
        this.solucion = new ArrayList<>();
        this.cantidad_actual = 0;
    }

    public List<Integer> getBilletes(List<Integer> tipos_billete, int cantidad) {
        while (cantidad_actual < cantidad) {
            int candidato = this.seleccionar(tipos_billete, this.getCantidadRestante(cantidad));
            this.solucion.add(candidato);
            this.cantidad_actual += candidato;
        }
        return this.solucion;
    }

    private int seleccionar(List<Integer> tipos_billetes, int cantidad_restante) {
        Integer mejor_cantidato = null;

        for (Integer billete : tipos_billetes) {
            if (mejor_cantidato == null || billete > mejor_cantidato) {
                if (billete <= cantidad_restante) {
                    mejor_cantidato = billete;
                }
            }
        }
        return mejor_cantidato;
    }

    private int getCantidadRestante(int cantidad) {
        return cantidad - this.cantidad_actual;
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(1);
        numeros.add(3);
        numeros.add(4);
        numeros.add(2);
        numeros.add(8);
        numeros.add(6);
        numeros.add(2);
        numeros.add(1);

        /* ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(1);
        numeros.add(3); */

        ServicioConjuntosDisjuntivos servicio = new ServicioConjuntosDisjuntivos(numeros);
        System.out.println("Solucion: " + servicio.conjuntos_disjuntivos());
    }
}
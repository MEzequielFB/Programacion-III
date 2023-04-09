package IncisoB;

public class Main {
    public static void main(String[] args) {
        int [] arreglo_a = new int[5];
        int [] arreglo_b = new int[5];

        arreglo_a[0] = 5;
        arreglo_a[1] = 7;
        arreglo_a[2] = 8;
        arreglo_a[3] = 9;
        arreglo_a[4] = 12;

        arreglo_b[0] = 7;
        arreglo_b[1] = 10;
        arreglo_b[2] = 12;
        arreglo_b[3] = 21;
        arreglo_b[4] = 30;

        /* arreglo_a[0] = 12;
        arreglo_a[1] = 16;
        arreglo_a[2] = 18;
        arreglo_a[3] = 19;
        arreglo_a[4] = 22;

        arreglo_b[0] = 4;
        arreglo_b[1] = 6;
        arreglo_b[2] = 9;
        arreglo_b[3] = 10;
        arreglo_b[4] = 16; */

        System.out.println("Arreglo A: " + getStringArreglo(arreglo_a));
        System.out.println("Arreglo B: " + getStringArreglo(arreglo_b));
        
        int [] arreglo_resultante = combinarArreglos(arreglo_a, arreglo_b);
        System.out.println("Arreglo resultante: " + getStringArreglo(arreglo_resultante));
    }

    public static int[] combinarArreglos(int [] arreglo1, int [] arreglo2) {
        int [] arreglo_resultante = new int [arreglo1.length + arreglo2.length];
        int i = 0;
        int j = 0;
        int cantidad_elementos_arreglo_resultante = 0;
        while (i < arreglo1.length && j < arreglo2.length) {
            int valor_a = arreglo1[i];
            int valor_b = arreglo2[j];
            if (valor_a == valor_b) {
                add(cantidad_elementos_arreglo_resultante, valor_a, arreglo_resultante);
                i++;
                j++;
                cantidad_elementos_arreglo_resultante++;
            } else if (valor_a < valor_b) {
                i++;
            } else if (valor_a > valor_b) {
                j++;
            }
        }
        return arreglo_resultante;
    }

    public static void add(int posicion, int valor, int [] arreglo) {
        arreglo[posicion] = valor;
    }

    public static String getStringArreglo(int [] arreglo) {
        String arreglo_string = "";
        for (int i = 0; i < arreglo.length; i++) {
            arreglo_string += arreglo[i] + " | ";
        }
        return arreglo_string;
    }
}
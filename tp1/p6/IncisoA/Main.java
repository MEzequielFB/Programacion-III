package IncisoA;
public class Main {
    public static void main(String[] args) {
        int [] arreglo_a = new int[5];
        int [] arreglo_b = new int[5];

        arreglo_a[0] = 2;
        arreglo_a[1] = 5;
        arreglo_a[2] = 3;
        arreglo_a[3] = 3;
        arreglo_a[4] = 9;

        arreglo_b[0] = 6;
        arreglo_b[1] = 3;
        arreglo_b[2] = 2;
        arreglo_b[3] = 5;
        arreglo_b[4] = 10;

        System.out.println("Arreglo A: " + getStringArreglo(arreglo_a));
        System.out.println("Arreglo B: " + getStringArreglo(arreglo_b));

        int [] arreglo_resultante = combinarArreglos(arreglo_a, arreglo_b);
        System.out.println("Arreglo resultante: " + getStringArreglo(arreglo_resultante));
    }

    public static int[] combinarArreglos(int [] arreglo1, int [] arreglo2) {
        int [] arreglo_resultante = new int[arreglo1.length + arreglo2.length];
        int i = 0;
        /* int j = 0; */
        while (i < arreglo1.length) {
            int valor_arreglo1 = arreglo1[i];
            boolean resultado_arreglo2 = contieneValor(valor_arreglo1, arreglo2);
            boolean resultado_arreglo_resultante = contieneValor(valor_arreglo1, arreglo_resultante);
            if (resultado_arreglo2 && !resultado_arreglo_resultante) {
                /* arreglo_resultante[j] = valor_arreglo1;
                j++; */
                addOrdenado(valor_arreglo1, arreglo_resultante);
            }
            i++;
        }
        /* ordenarArreglo(arreglo_resultante); */
        return arreglo_resultante;
    }

    public static void addOrdenado(int valor, int [] arreglo) {
        int i = 0;
        int valor_actual = arreglo[i];
        if (i == 0 && valor_actual == 0) {
            arreglo[i] = valor;
        }
        while (i < arreglo.length-1 && valor_actual != 0) {
            valor_actual = arreglo[i];
            if (valor_actual < valor && arreglo[i+1] == 0) {
                arreglo[i+1] = valor;
                return;
            }
            if (valor_actual > valor) {
                corrimientoDerecha(i, arreglo);
                arreglo[i] = valor;
                return;
            }
            i++;
        }
    }

    private static void corrimientoDerecha(int pos, int [] arreglo) {
        int i = arreglo.length-1;
        while (i > pos) {
            arreglo[i] = arreglo[i-1];
            i--;
        }
    }

    public static boolean contieneValor(int valor, int [] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (valor == arreglo[i]) {
                return true;
            }
        }
        return false;
    }

    /* public static void ordenarArreglo(int [] arreglo) {
        int i = 0;
        int valor_actual = 0;
        int valor_siguiente = 1;
        while (i < arreglo.length-1 && valor_siguiente != 0) {
            valor_actual = arreglo[i];
            valor_siguiente = arreglo[i+1];
            if (valor_actual > valor_siguiente && valor_siguiente != 0) {
                arreglo[i] = valor_siguiente;
                arreglo[i+1] = valor_actual;
                i = 0;
            } else {
                i++;
            }
        }
    } */

    public static String getStringArreglo(int [] arreglo) {
        String arreglo_string = "";
        for (int i = 0; i < arreglo.length; i++) {
            arreglo_string += arreglo[i] + " | ";
        }
        return arreglo_string;
    }
}
/*
 * Ambos tienen complejidad computacional O(n^2)
 */
public class Main {
    public static void main(String[] args) {
        int [] numeros = new int[5];
        numeros[0] = 10;
        numeros[1] = 5;
        numeros[2] = 7;
        numeros[3] = 17;
        numeros[4] = 14;
        
        /* ordenamientoPorBurbujeo(numeros); */
        ordenamientoPorSeleccion(numeros);
        imprimir(numeros);
    }

    public static void ordenamientoPorBurbujeo(int [] arreglo) {
        for (int i = 0; i < arreglo.length-1; i++) {
            for (int j = 0; j < arreglo.length-1-i; j++) {
                if (arreglo[j] > arreglo[j+1]) {
                    int aux = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = aux;
                }
            }
        }
    }

    public static void ordenamientoPorSeleccion(int [] arreglo) {
        if (arreglo.length > 0) {
            for (int i = 0; i < arreglo.length; i++) {
                int menor_numero = arreglo[i];
                int posicion_menor_numero = i;
                for (int j = i+1; j < arreglo.length; j++) {
                    if (arreglo[j] < menor_numero) {
                        menor_numero = arreglo[j];
                        posicion_menor_numero = j;
                    }
                }
                if (i != posicion_menor_numero) {
                    arreglo[posicion_menor_numero] = arreglo[i];
                    arreglo[i] = menor_numero;
                }
            }
        }
    }

    /* public static void ordenamientoPorSeleccion(int [] arreglo) {
        int iteracion = 0;
        for (int i = arreglo.length-1; i > 0; i--) {
            for (int j = arreglo.length-1; j > iteracion; j--) {
                if (arreglo[j] < arreglo[j-1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j-1];
                    arreglo[j-1] = aux;
                }
            }
            iteracion++;
        }
    } */

    public static void imprimir(int [] arreglo) {
        String string_arreglo = "";
        for (int i = 0; i < arreglo.length; i++) {
            string_arreglo += arreglo[i] + " | ";
        }
        System.out.println(string_arreglo);
    }
}
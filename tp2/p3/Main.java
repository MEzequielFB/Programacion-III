public class Main {
    public static void main(String[] args) {
        //MergeSort
        int [] valores = new int[3];
        valores[0] = 6;
        valores[1] = 2;
        valores[2] = 7;

        imprimir(valores);
        Mergesort ms1 = new Mergesort();
        ms1.sort(valores);
        imprimir(valores);

        //QuickSort
        int [] valores2 = new int[5];
        valores2[0] = 22;
        valores2[1] = 53;
        valores2[2] = 15;
        valores2[3] = 4;
        valores2[4] = 22;
        imprimir(valores2);
        Quicksort.quickSort(valores2, 0, valores2.length-1);
        imprimir(valores2);
    }

    public static void imprimir(int [] arreglo) {
        String string_arreglo = "";
        for (int i = 0; i < arreglo.length; i++) {
            string_arreglo += arreglo[i] + " | ";
        }
        System.out.println(string_arreglo+"\n");
    }

    public static int[] crearArreglo(int tamanio) {
        int [] arreglo = new int[tamanio];
        int minimo = 1;
        int maximo = 99;
        int resultado = 0;
        for (int i = 0; i < tamanio; i++) {
            resultado = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
            arreglo[i] = resultado;
        }
        return arreglo;
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
}
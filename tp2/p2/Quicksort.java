public class Quicksort {
    /*
     * Complejidad computacional
     * Peor caso: O(n^2)
     * Mejor caso: Omega(log2 n)
     */
    public static void quickSort(int [] arreglo, int menor, int mayor) {
        if (menor < mayor) {
            int posicion_pivote = particion(arreglo, menor, mayor);
            quickSort(arreglo, menor, posicion_pivote-1);
            quickSort(arreglo, posicion_pivote+1, mayor);
        }
    }

    private static int particion(int [] arreglo, int menor, int mayor) {
        int pivote = arreglo[mayor];
        int i = menor - 1;

        for (int j = menor; j < mayor; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                swap(arreglo, i, j);
            }
        }
        swap(arreglo, i+1, mayor);
        return i+1;
    }

    private static void swap(int [] arreglo, int i, int j) {
        int aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }
}

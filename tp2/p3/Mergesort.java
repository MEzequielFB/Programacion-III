public class Mergesort { // Complejidad computacional: O(n.log2 n)
    private int[] numeros;
    private int[] auxiliar;
    private int size;

    public void sort(int [] valores) {
        this.numeros = valores;
        this.size = valores.length;
        this.auxiliar = new int[this.size];
        mergesort(0, this.size-1);
    }

    private void mergesort(int menor, int mayor) {
        if (menor < mayor) {
            int medio = (menor + mayor) / 2;
            mergesort(menor, medio);
            mergesort(medio+1, mayor);
            merge(menor, medio, mayor);
        }
    }

    private void merge(int menor, int medio, int mayor) {
        for (int i = menor; i <= mayor; i++) {
            this.auxiliar[i] = this.numeros[i];
        }

        int i = menor;
        int j = medio + 1;
        int k = menor;
        while (i <= medio && j <= mayor) {
            if (this.auxiliar[i] <= this.auxiliar[j]) {
                this.numeros[k] = auxiliar[i];
                i++;
            } else {
                this.numeros[k] = this.auxiliar[j];
                j++;
            }
            k++;
        }

        while (i <= medio) {
            this.numeros[k] = this.auxiliar[i];
            k++;
            i++;
        }
        while (j <= mayor) {
            this.numeros[k] = this.auxiliar[j];
            k++;
            j++;
        }
    }
}
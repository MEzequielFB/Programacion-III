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
        valores2[3] = 7;
        valores2[4] = 25;
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
}
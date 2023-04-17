import java.util.Arrays;

public class TiempoEjecucion {
    public static void main(String[] args) {
        int iteraciones = 10000;
        int tamanio = 500;

        int [] arreglo1 = Main.crearArreglo(tamanio);
        int [] arreglo2 = arreglo1;
        int [] arreglo3 = arreglo2;
        int [] arreglo4 = arreglo3;
        int [] arreglo5 = arreglo4;

        /* Main.imprimir(arreglo1); */

        //MergeSort
        /* int [] arreglo1 = Main.crearArreglo(tamanio); */

        Mergesort mergesort = new Mergesort();
        long mergesort_start_time = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            mergesort.sort(arreglo1);
        }
        long mergesort_end_time = System.nanoTime();
        long mergesort_duration = (mergesort_end_time - mergesort_start_time) / 1000000; //Milisegundos
        System.out.println("Duracion de Mergesort: " + mergesort_duration);

        //Quicksort
        /* int [] arreglo2 = Main.crearArreglo(tamanio); */

        long quicksort_start_time = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            Quicksort.quickSort(arreglo2, 0, tamanio-1);
        }
        long quicksort_end_time = System.nanoTime();
        long quicksort_duration = (quicksort_end_time - quicksort_start_time) / 1000000; //Milisegundos
        System.out.println("Duracion de Quicksort: " + quicksort_duration);

        //Ordenamiento por burbujeo
        /* int [] arreglo3 = Main.crearArreglo(tamanio); */

        long burbujeo_start_time = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            Main.ordenamientoPorBurbujeo(arreglo3);
        }
        long burbujeo_end_time = System.nanoTime();
        long burbujeo_duration = (burbujeo_end_time - burbujeo_start_time) / 1000000; //Milisegundos
        System.out.println("Duracion de burbujeo: " + burbujeo_duration);

        //Ordenamiento por seleccion
        /* int [] arreglo4 = Main.crearArreglo(tamanio); */

        long seleccion_start_time = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            Main.ordenamientoPorSeleccion(arreglo4);
        }
        long seleccion_end_time = System.nanoTime();
        long seleccion_duration = (seleccion_end_time - seleccion_start_time) / 1000000; //Milisegundos
        System.out.println("Duracion de seleccion: " + seleccion_duration);

        //Arrays.sort
        long arrayssort_start_time = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            Arrays.sort(arreglo5);
        }
        long arrayssort_end_time = System.nanoTime();
        long arrayssort_duration = (arrayssort_end_time - arrayssort_start_time) / 1000000; //Milisegundos
        System.out.println("Duracion de arrayssort: " + arrayssort_duration);
    }
}
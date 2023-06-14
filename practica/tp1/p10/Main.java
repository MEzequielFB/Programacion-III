public class Main {
    public static void main(String[] args) {
        int [] arreglo = new int [5];
        arreglo[0] = 1;
        arreglo[1] = 12;
        arreglo[2] = 4;
        arreglo[3] = 3;
        arreglo[4] = 2;

        int [] arreglo2 = new int [5];
        arreglo2[0] = 1;
        arreglo2[1] = 3;
        arreglo2[2] = 5;
        arreglo2[3] = 8;
        arreglo2[4] = 11;

        System.out.println("Esta ordenado: " + estaOrdenado(arreglo, 0));
        System.out.println("Esta ordenado: " + estaOrdenado(arreglo2, 0));
    }

    public static boolean estaOrdenado(int [] arreglo, int posicion) {
        if (posicion < arreglo.length-1) {
            if (arreglo[posicion] < arreglo[posicion+1]) {
                return estaOrdenado(arreglo, posicion+1);
            }
            return false;
        }
        return true;
    }
}
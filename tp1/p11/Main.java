public class Main {
    public static void main(String[] args) {
        int [] numeros = new int[5];
        numeros[0] = 2;
        numeros[1] = 4;
        numeros[2] = 9;
        numeros[3] = 14;
        numeros[4] = 21;

        System.out.println(buscarElemento(numeros, 9, 0, numeros.length-1));
        System.out.println(buscarElemento(numeros, 42, 0, numeros.length-1));
        System.out.println(buscarElemento(numeros, 21, 0, numeros.length-1));
    }

    public static int buscarElemento(int [] arreglo, int elemento_buscado , int inicio, int fin) { //Devuelve la posicion del elemento buscado, devuelve -1 si no se encuentra
        if (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (elemento_buscado < arreglo[medio]) {
                return buscarElemento(arreglo, elemento_buscado, inicio, medio-1);
            } else if (elemento_buscado > arreglo[medio]) {
                return buscarElemento(arreglo, elemento_buscado, medio+1, fin);
            } else {
                return medio;
            }
        }
        return -1;
    }
}
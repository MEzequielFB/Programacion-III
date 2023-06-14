public class Main {
    public static void main(String[] args) {
        int [] arreglo = new int [5];
        arreglo[0] = 1;
        arreglo[1] = 2;
        arreglo[2] = 3;
        arreglo[3] = 8;
        arreglo[4] = 12;

        System.out.println("Existe elemento: " + existeElemento(arreglo, 8, 0, arreglo.length-1));
        System.out.println("Existe elemento: " + existeElemento(arreglo, 42, 0, arreglo.length-1));
    }

    public static boolean existeElemento(int [] arreglo, int elemento, int posicion_inicio, int posicion_fin) {
        if (posicion_inicio <= posicion_fin) {
            int medio = (posicion_inicio + posicion_fin) / 2;
            if (elemento < arreglo[medio]) {
                return existeElemento(arreglo, elemento, posicion_inicio, medio-1);
            } else if (elemento > arreglo[medio]) {
                return existeElemento(arreglo, elemento, medio+1, posicion_fin);
            } else {
                return true;
            }
        }
        return false;
    }
}
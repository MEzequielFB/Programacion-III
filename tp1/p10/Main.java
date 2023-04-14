/*
 * Complejidad en el peor caso: O(n)
 * Problema al ser recursivo: -_(*_*)_-
 * Que cambiaria si la estructura fuera un lista: La notacion Big O seria mas compleja -> O(n^2) ya que debo recorrer nuevamente la lista cada vez que quiero acceder a un elemento de una posicion, al contrario de los arrays que se necesita un acceso para obtener el elemento en un posicion determinada
 */

public class Main {
    public static void main(String[] args) {
        int [] numeros = new int[4];
        numeros[0] = 2;
        numeros[1] = 3;
        numeros[2] = 7;
        numeros[3] = 9;

        System.out.println("Esta ordenado: " + estaOrdenado2(numeros, 0));
    }

    public static boolean estaOrdenado2(int [] arreglo, int posicion) {
        boolean resultado = true;
        if (posicion >= 0 && posicion < arreglo.length-1) { //Si la posicion es >= a 0 y menor a size-1...
            if (arreglo[posicion] < arreglo[posicion+1]) { //Si el elemento en la posicion actual es menor al siguiente se llama al metodo
                resultado = estaOrdenado2(arreglo, posicion+1);
            } else { //Sino se declara false el resultado
                resultado = false;
            }
        }
        return resultado;
    }

    public static boolean estaOrdenado(int [] arreglo) {
        for (int i = 0; i < arreglo.length-1; i++) {
            if (arreglo[i] > arreglo[i+1]) {
                return false;
            }
        }
        return true;
    }
}
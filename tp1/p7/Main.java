public class Main {
    public static void main(String[] args) {
        int [] arreglo1 = new int[5];
        int [] arreglo2 = new int[5];

        arreglo1[0] = 43;
        arreglo1[1] = 2;
        arreglo1[2] = 94;
        arreglo1[3] = 2;
        arreglo1[4] = 23;

        arreglo2[0] = 65;
        arreglo2[1] = 5;
        arreglo2[2] = 3;
        arreglo2[3] = 43;
        arreglo2[4] = 23;

        System.out.println("Arreglo 1: " + getStringArreglo(arreglo1));
        System.out.println("Arreglo 2: " + getStringArreglo(arreglo2));

        int [] arreglo_nuevo = nuevoArreglo(arreglo1, arreglo2);
        System.out.println("Arreglo nuevo: " + getStringArreglo(arreglo_nuevo));
    }

    public static int[] nuevoArreglo(int [] arreglo1, int [] arreglo2) {
        int [] arreglo_nuevo = new int[arreglo1.length + arreglo2.length];
        int i = 0;
        int cantidad_elementos_arreglo_nuevo = 0;

        while (i < arreglo1.length) {
            boolean resultado_arreglo2 = contieneValor(arreglo1[i], arreglo2);
            boolean resultado_arreglo_nuevo = contieneValor(arreglo1[i], arreglo_nuevo);
            if (!resultado_arreglo2 && !resultado_arreglo_nuevo) {
                arreglo_nuevo[cantidad_elementos_arreglo_nuevo] = arreglo1[i];
                cantidad_elementos_arreglo_nuevo++;
            }
            i++;
        }
        return arreglo_nuevo;
    }

    public static boolean contieneValor(int valor, int [] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == valor) {
                return true;
            }
        }
        return false;
    }
    
    public static String getStringArreglo(int [] arreglo) {
        String string = "";
        for (int i = 0; i < arreglo.length; i++) {
            string += arreglo[i] + " | ";
        }
        return string;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(getFibonacci(6, 0, 0, 0));
    }

    public static String getFibonacci(int cantidad_numeros, int contador, int numero_actual, int numero_anterior) {
        String string_fibonacci = "";
        if (contador < cantidad_numeros) {
            /* int resultado = 0; */
            if (contador == 0) {
                numero_anterior = 0;
                string_fibonacci += numero_actual;
            } else if (contador == 1) {
                numero_anterior = 0;
                numero_actual = contador;
                string_fibonacci += contador;
            } else {
                int aux = numero_actual;
                numero_actual = numero_actual + numero_anterior;
                numero_anterior = aux;
                string_fibonacci += numero_actual;
            }
            string_fibonacci += getFibonacci(cantidad_numeros, contador+1, numero_actual, numero_anterior);
        }
        return string_fibonacci;
    }
}
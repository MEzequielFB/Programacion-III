public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(15, 0, 0, 0));
    }

    public static String fibonacci(int cantidad_numeros, int i, int numero_actual, int numero_anterior) {
        String fibonacci = "";
        if (i < cantidad_numeros) {
            if (i < 2) {
                return fibonacci += i + " " + fibonacci(cantidad_numeros, i+1, i, numero_anterior);
            } else {
                int suma = (numero_anterior + numero_actual);
                return fibonacci += suma + " " + fibonacci(cantidad_numeros, i+1, suma, numero_actual);
            }
        }
        return fibonacci;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(getBinario(26));
    }

    public static String getBinario(int numero) {
        String numero_binario = "";
        if (numero > 1) {
            int mitad = numero / 2;
            numero_binario += getBinario(mitad);
            numero_binario += numero % 2;
        } else {
            numero_binario += numero;
        }
        return numero_binario;
    }
}
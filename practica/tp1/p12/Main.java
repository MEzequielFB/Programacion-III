public class Main {
    public static void main(String[] args) {
        System.out.println("Binario: " + convertirABinario(26));
        System.out.println("Binario: " + convertirABinario(33));
    }

    public static String convertirABinario(int entero) {
        String numero_binario = "";
        if (entero > 1) {
            numero_binario += convertirABinario(entero/2) + entero % 2;
        } else {
            numero_binario += entero;
        }
        return numero_binario;
    }
}
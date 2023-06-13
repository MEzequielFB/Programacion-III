public class Main {
    public static void main(String[] args) {
        String texto = "alejandro";
        String texto2 = "araara";

        System.out.println("Es capicua: " + esCapicua(texto, ""));
        System.out.println("Es capicua: " + esCapicua(texto2, ""));
    }

    public static boolean esCapicua(String texto, String texto_parcial) {
        if (texto_parcial.length() < texto.length()) {
            texto_parcial += texto.charAt((texto.length()-1) - texto_parcial.length());
            return esCapicua(texto, texto_parcial);
        }
        return texto_parcial.equals(texto);
    }
}
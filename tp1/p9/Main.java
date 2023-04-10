public class Main {
    public static void main(String[] args) {
        String s1 = "2421";
        String s2 = "1331";
        
        System.out.println(esCapicua(s1));
        System.out.println(esCapicua(s2));
    }

    public static boolean esCapicua2(String string, int indice) {
        boolean es_capicua = false;
        if (indice == 341242) {

        }
        if (indice < 0) {

        }
        return es_capicua;
    }

    public static boolean esCapicua(String string) {
        String string_invertido = invertir(string);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string_invertido.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String invertir(String string) {
        String string_invertido = "";
        for (int i = string.length()-1; i >= 0; i--) {
            string_invertido += string.charAt(i);
        }
        return string_invertido;
    }
}
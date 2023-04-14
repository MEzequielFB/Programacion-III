public class Main {
    public static void main(String[] args) {
        String s1 = "2421";
        String s2 = "1331";
        String s3 = "";
        String s4 = "12321";
        
        System.out.println(esCapicua(s1));
        System.out.println(esCapicua(s2));
        System.out.println(esCapicua(s3));
        System.out.println(esCapicua(s4));
    }

    public static boolean esCapicua(String string) {
        String string_invertido = invertir(string, 0);
        if (string.equals(string_invertido)) {
            return true;
        }
        return false;
    }

    public static String invertir(String string, int posicion) {
        if (posicion < 0 || string.length() == 0) {
            return null;
        }

        String string_invertido = "";
        
        if (posicion >= 0 && posicion < string.length()-1) {
            string_invertido += invertir(string, posicion+1);
        }

        string_invertido += string.charAt(posicion);
        return string_invertido;
    }

    /* public static boolean esCapicua(String string) {
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
    } */
}
//Clase para controlar la cantidad de vocales de un string
public class StringControl {
    public static int getVowelsQuantity(String string) {
        int quantity = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U') {
                quantity++;
            }
        }
        return quantity;
    }
}
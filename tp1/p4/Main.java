public class Main {
    public static  void main(String[] args) {
        Pila pila = new Pila();
        pila.push("String 1");
        pila.push("String 3");
        pila.push("String 2");

        System.out.println(pila);
        System.out.println("Posicion elemento: " + pila.indexOf("String 1"));
        System.out.println("Posicion elemento: " + pila.indexOf("String 50"));
        System.out.println("Posicion elemento: " + pila.indexOf("String 2"));
    }
}
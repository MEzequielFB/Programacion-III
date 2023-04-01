public class Main {
    public static  void main(String[] args) {
        Pila pila = new Pila();
        pila.push("String 1");
        pila.push("String 3");
        pila.push("String 2");

        for (Object elemento : pila) {
            System.out.println(elemento);
        }
    }
}
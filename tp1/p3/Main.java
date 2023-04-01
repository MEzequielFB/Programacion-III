import javax.swing.Popup;

public class Main {
    public static  void main(String[] args) {
        Pila pila = new Pila();
        pila.push("String 1");
        pila.push("String 3");
        pila.push("String 2");

        System.out.println(pila);

        System.out.println("Top: " + pila.top());

        System.out.println("Nodo borrado: " + pila.pop());
        System.out.println(pila);

        pila.push("String 50");
        System.out.println(pila);

        pila.reverse();
        System.out.println("Pila invertida: " + pila);

        System.out.println("Nodo borrado: " + pila.pop());
        System.out.println("Nodo borrado: " + pila.pop());
        System.out.println(pila);
        pila.reverse();
        System.out.println("Pila invertida nuevamente: " + pila);
    }
}
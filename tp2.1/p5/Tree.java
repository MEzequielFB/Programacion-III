import java.util.LinkedList;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public LinkedList<String> getWords(int vowels_quantity) {
        return this.getWords(this.root, vowels_quantity, "");
    }

    private LinkedList<String> getWords(Node actual, int vowels_quantity, String word) {
        LinkedList<String> words = new LinkedList<>();
        if (actual != null) {
            //Agrega el valor del nodo actual a la palabra formada hasta el momento
            word += actual.getValue();

            //Se llama recursivamente enviando los hijos del nodo actual, la cantidad de vocales admitidas y la palabra formada hasta el momento
            //Se agregan las palabras formadas en obtenidas de la recursion a la lista de palabras
            words.addAll(this.getWords(actual.getLeft(), vowels_quantity, word));
            words.addAll(this.getWords(actual.getRight(), vowels_quantity, word));

            //Verifica que la cantidad de vocales de la palabra matchee con la pasada por parametro
            //La segunda condicion es para solo agregar las palabras que pertecen a toda un rama
            //Sacar la segunda condicion significa que se toman en cuenta palabras formadas en ciertas partes de las ramas
            if (StringControl.getVowelsQuantity(word) == vowels_quantity && actual.isExternalNode()) {
                words.add(word);
            }

            /* if (this.getVowelsQuantity(word) == vowels_quantity && actual.isExternalNode()) {
                words.add(word);
            } */
        }
        //Se retornan las palabras formadas que cumplen las condiciones
        return words;
    }

    /* private int getVowelsQuantity(String string) {
        int quantity = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U') {
                quantity++;
            }
        }
        return quantity;
    } */

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(Node actual) {
        if (actual != null) {
            System.out.println(actual);
            this.printPreOrder(actual.getLeft());
            this.printPreOrder(actual.getRight());
        }
    }

    public void setRoot(String value) {
        this.root = new Node(value);
    }

    //Rompe encapsulamiento a proposito para poder insertar nodos en el arbol binario (no de busqueda)
    public Node getRoot() {
        return this.root;
    }
}
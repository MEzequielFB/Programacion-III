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
            word += actual.getValue();
            words.addAll(this.getWords(actual.getLeft(), vowels_quantity, word));
            words.addAll(this.getWords(actual.getRight(), vowels_quantity, word));
            if (this.getVowelsQuantity(word) == vowels_quantity) {
                words.add(word);
            }

            /* words.addAll(this.getWords(actual.getRight(), vowels_quantity, word));
            if (this.getVowelsQuantity(word) == vowels_quantity) {
                words.add(word);
            } */
        }
        return words;
    }

    private int getVowelsQuantity(String string) {
        int quantity = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U') {
                quantity++;
            }
        }
        return quantity;
    }

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
import java.util.ArrayList;
import java.util.List;

public class TreeWithNode {
    private TreeNode root;

    public TreeWithNode() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public List<String> getWords(int cantidad_vocales) {
        ArrayList<String> palabras = new ArrayList<>();
        String palabra_parcial = "";
        this.getWords(this.root, cantidad_vocales, palabras, palabra_parcial);
        return palabras;
    }

    private void getWords(TreeNode nodo_actual, int cantidad_vocales, List<String> palabras, String palabra_parcial) {
        if (nodo_actual != null) {
            palabra_parcial += nodo_actual.getValue();

            TreeNode nodo_izquierda = nodo_actual.getLeft();
            TreeNode nodo_derecha = nodo_actual.getRight();

            if (nodo_izquierda != null) {
                this.getWords(nodo_izquierda, cantidad_vocales, palabras, palabra_parcial);
            }
            if (nodo_derecha != null) {
                this.getWords(nodo_derecha, cantidad_vocales, palabras, palabra_parcial);
            }

            if (nodo_izquierda == null && nodo_derecha == null) {
                int cantidad_vocales_palabra = this.getVowelsQuantity(palabra_parcial);
                if (cantidad_vocales_palabra == cantidad_vocales && !palabras.contains(palabra_parcial)) {
                    palabras.add(palabra_parcial);
                }
            }
        }
    }

    private int getVowelsQuantity(String palabra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = Character.toLowerCase(palabra.charAt(i));
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                contador++;
            }
        }
        return contador;
    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode nodo_actual) {
        if (nodo_actual != null) {
            System.out.println(nodo_actual);
            this.printPreOrder(nodo_actual.getLeft());
            this.printPreOrder(nodo_actual.getRight());
        }
    }

    public void insert(String value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        } else {
            this.insert(this.root, value);
        }
    }

    private void insert(TreeNode nodo_actual, String value) {
        if (nodo_actual != null) {
            String value_nodo_actual = nodo_actual.getValue();
            TreeNode nodo_izquierda = nodo_actual.getLeft();
            TreeNode nodo_derecha = nodo_actual.getRight();

            int resultado_comparacion = value_nodo_actual.compareToIgnoreCase(value);
            if (resultado_comparacion > 0) {
                if (nodo_izquierda != null) {
                    this.insert(nodo_izquierda, value);
                } else {
                    nodo_actual.setLeft(new TreeNode(value));
                }
            } else if (resultado_comparacion < 0) {
                if (nodo_derecha != null) {
                    this.insert(nodo_derecha, value);
                } else {
                    nodo_actual.setRight(new TreeNode(value));
                }
            }
        }
    }
}
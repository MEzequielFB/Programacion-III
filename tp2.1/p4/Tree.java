public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void completeTree() {
        this.completeTree(this.root);
    }

    private int completeTree(Node actual) {
        int result = 0;
        if (actual != null) {
            int left_value = this.completeTree(actual.getLeft());
            int right_value = this.completeTree(actual.getRight());

            result = right_value - left_value;
            if (actual.getValue() == null) {
                actual.setValue(result);
            } else {
                result += actual.getValue();
            }
        }
        return result;
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

    public void setRoot(Integer value) {
        this.root = new Node(value);
    }

    //Rompe encapsulamiento, pero es para poder llegar a hacer el arbol inicial del ejercicio
    public Node getRoot() {
        return this.root;
    }
}
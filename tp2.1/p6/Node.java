public class Node {
    private Book value;
    private Node left;
    private Node right;

    public Node(Book value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Book getValue() {
        return this.value;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setValue(Book book) {
        this.value = book;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
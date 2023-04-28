public class Node {
    private String value;
    private Node left;
    private Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean isExternalNode() {
        return this.left == null && this.right == null;
    }

    public boolean hasVowel() {
        return this.value == "A" || this.value == "E" || this.value == "I" || this.value == "O" || this.value == "U";
    }

    public String getValue() {
        return this.value;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
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
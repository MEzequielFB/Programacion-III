public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public int getQuantitySamplesById(int id) {
        return this.getQuantitySamplesById(this.root, id);
    }

    private int getQuantitySamplesById(Node actual, int id) {
        if (actual != null) {
            if (actual.getValue().getId() == id) {
                return actual.getValue().getSamplesQuantity();
            }
            if (actual.getValue().getId() > id) {
                return this.getQuantitySamplesById(actual.getLeft(), id);
            } else {
                return this.getQuantitySamplesById(actual.getRight(), id);
            }
        }
        return -1;
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

    public void printOrder() {
        this.printOrder(this.root);
    }

    private void printOrder(Node actual) {
        if (actual != null) {
            this.printOrder(actual.getLeft());
            System.out.println(actual);
            this.printOrder(actual.getRight());
        }
    }

    public void insert(Book book) {
        if (this.root == null) {
            this.root = new Node(book);
        } else {
            this.insert(this.root, book);
        }
    }

    private void insert(Node actual, Book book) {
        if (actual != null) {
            if (actual.getValue().compareTo(book) > 0) {
                if (actual.getLeft() == null) {
                    actual.setLeft(new Node(book));
                } else {
                    this.insert(actual.getLeft(), book);
                }
            } else if (actual.getValue().compareTo(book) < 0) {
                if (actual.getRight() == null) {
                    actual.setRight(new Node(book));
                } else {
                    this.insert(actual.getRight(), book);
                }
            }
        }
    }

    public Book getRoot() {
        return this.root.getValue();
    }
}
import java.util.LinkedList;

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

    //BUSQUEDA CON FILTRO
    public LinkedList<Book> searchBooks(Filter filter) {
        return this.searchBooks(this.root, filter);
    }

    private LinkedList<Book> searchBooks(Node actual, Filter filter) {
        LinkedList<Book> books = new LinkedList<>();
        if (actual != null) {
            if (actual.getValue().complies(filter)) {
                books.add(actual.getValue());
            }
            books.addAll(this.searchBooks(actual.getLeft(), filter));
            books.addAll(this.searchBooks(actual.getRight(), filter));
        }
        return books;
    }

    //BUSQUEDA SIN FILTRO
    public LinkedList<Book> getBooksBetweenYears(int initial_year, int end_year) {
        if (initial_year <= end_year) {
            return this.getBooksBetweenYears(this.root, initial_year, end_year);
        }
        return new LinkedList<>();
    }

    private LinkedList<Book> getBooksBetweenYears(Node actual, int initial_year, int end_year) {
        LinkedList<Book> books = new LinkedList<>();
        if (actual != null) {
            int actual_publication_year = actual.getValue().getPublicationYear();
            if (actual_publication_year >= initial_year && actual_publication_year <= end_year) {
                books.add(actual.getValue());
            }
            books.addAll(this.getBooksBetweenYears(actual.getLeft(), initial_year, end_year));
            books.addAll(this.getBooksBetweenYears(actual.getRight(), initial_year, end_year));
        }
        return books;
    }

    public LinkedList<Book> getBooksByGenre(String genre) {
        return this.getBooksByGenre(this.root, genre);
    }

    private LinkedList<Book> getBooksByGenre(Node actual, String genre) {
        LinkedList<Book> books = new LinkedList<>();
        if (actual != null) {
            if (actual.getValue().containsGenre(genre)) {
                books.add(actual.getValue());
            }
            books.addAll(this.getBooksByGenre(actual.getLeft(), genre));
            books.addAll(this.getBooksByGenre(actual.getRight(), genre));
        }
        return books;
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
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Book b1 = new Book("Cenicienta", 1986, 2);
        Book b2 = new Book("Sherlock", 1944, 5);
        Book b3 = new Book("Uzumaki", 2001, 3);
        Book b4 = new Book("English grammar in use", 2017, 10);

        tree.insert(b3);
        tree.insert(b2);
        tree.insert(b4);
        tree.insert(b1);

        /* tree.printPreOrder(); */
        System.out.println(tree.getQuantitySamplesById(2));
        System.out.println(tree.getQuantitySamplesById(3));
        System.out.println(tree.getQuantitySamplesById(14));
    }
}
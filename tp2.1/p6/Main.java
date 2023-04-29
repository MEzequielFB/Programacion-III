public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Book b1 = new Book("Cenicienta", 1986, 2);
        Book b2 = new Book("Sherlock", 1944, 5);
        Book b3 = new Book("Uzumaki", 2001, 3);
        Book b4 = new Book("English grammar in use", 2017, 10);

        b1.addGenre("fantasy");
        b1.addGenre("drama");

        b2.addGenre("mistery");
        b2.addGenre("drama");

        b3.addGenre("drama");

        b4.addGenre("academic");

        tree.insert(b3);
        tree.insert(b2);
        tree.insert(b4);
        tree.insert(b1);

        /* tree.printPreOrder(); */
        System.out.println("Book samples: " + tree.getQuantitySamplesById(2));
        System.out.println("Book samples: " + tree.getQuantitySamplesById(3));
        System.out.println("Book samples: " + tree.getQuantitySamplesById(14));

        FilterByGenre fg1 = new FilterByGenre("drama");
        FilterByGenre fg2 = new FilterByGenre("fantasy");
        FilterByGenre fg3 = new FilterByGenre("action");

        FilterByAfterYear fay1 = new FilterByAfterYear(2000);
        FilterByAfterYear fay2 = new FilterByAfterYear(1940);
        FilterByAfterYear fay3 = new FilterByAfterYear(1999);

        FilterByBeforeYear fby1 = new FilterByBeforeYear(2017);
        FilterByBeforeYear fby2 = new FilterByBeforeYear(2001);
        FilterByBeforeYear fby3 = new FilterByBeforeYear(1990);

        FilterAnd fand1 = new FilterAnd(fay1, fby1);
        FilterAnd fand2 = new FilterAnd(fay2, fby2);
        FilterAnd fand3 = new FilterAnd(fay3, fby3);

        System.out.println("\nBooks by genre: " + tree.searchBooks(fg1));
        System.out.println("Books by genre: " + tree.searchBooks(fg2));
        System.out.println("Books by genre: " + tree.searchBooks(fg3));

        System.out.println("\nBooks between years: " + tree.searchBooks(fand1));
        System.out.println("Books between years: " + tree.searchBooks(fand2));
        System.out.println("Books between years: " + tree.searchBooks(fand3));

        //BUSQUEDAS SIN FILTRO
        /* System.out.println("\nBooks by genre: " + tree.getBooksByGenre("drama"));
        System.out.println("Books by genre: " + tree.getBooksByGenre("fantasy"));
        System.out.println("Books by genre: " + tree.getBooksByGenre("action"));

        System.out.println("\nBooks between years: " + tree.getBooksBetweenYears(2000, 2017));
        System.out.println("Books between years: " + tree.getBooksBetweenYears(1940, 2001));
        System.out.println("Books between years: " + tree.getBooksBetweenYears(1999, 1990)); */
    }
}
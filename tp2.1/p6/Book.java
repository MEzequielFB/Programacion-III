import java.util.ArrayList;

public class Book implements Comparable<Book> {
    private static int cont;

    private int id;
    private String title;
    private int publication_year;
    private int samples_quantity;
    private ArrayList<String> genres;

    public Book(String title, int publication_year, int samples_quantity) {
        this.id = cont;
        this.title = title;
        this.publication_year = publication_year;
        this.samples_quantity = samples_quantity;
        this.genres = new ArrayList<>();
        cont++;
    }

    public void addGenre(String genre) {
        if (!this.genres.contains(genre)) {
            this.genres.add(genre);
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publication_year;
    }

    public int getSamplesQuantity() {
        return samples_quantity;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }

    @Override
    public int compareTo(Book book) {
        return this.getId() - book.getId();
    }
}
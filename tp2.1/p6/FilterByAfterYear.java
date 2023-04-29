public class FilterByAfterYear extends Filter {

    private int minimun_year;

    public FilterByAfterYear(int minimun_year) {
        this.minimun_year = minimun_year;
    }

    @Override
    public boolean complies(Book book) {
        return book.getPublicationYear() >= this.minimun_year;
    }
}
public class FilterByBeforeYear extends Filter {

    private int maximun_year;

    public FilterByBeforeYear(int maximun_year) {
        this.maximun_year = maximun_year;
    }

    @Override
    public boolean complies(Book book) {
        return book.getPublicationYear() <= this.maximun_year;
    }
}
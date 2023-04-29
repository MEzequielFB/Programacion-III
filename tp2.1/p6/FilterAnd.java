public class FilterAnd extends Filter {

    private Filter filter1;
    private Filter filter2;

    public FilterAnd(Filter filter1, Filter filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    @Override
    public boolean complies(Book book) {
        return this.filter1.complies(book) && this.filter2.complies(book);
    }
}
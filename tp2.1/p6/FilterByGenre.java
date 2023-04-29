public class FilterByGenre extends Filter {
    private String wanted_genre;

    public FilterByGenre(String wanted_genre) {
        this.wanted_genre = wanted_genre;
    }

    @Override
    public boolean complies(Book book) {
        return book.containsGenre(this.wanted_genre);
    }
}
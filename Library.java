import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addbook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Book getBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> booksWithTitle = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                booksWithTitle.add(book);
            }
        }
        return booksWithTitle;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> booksWithAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getauthor().equalsIgnoreCase(author)) {
                booksWithAuthor.add(book);
            }
        }
        return booksWithAuthor;
    }

    public ArrayList<Book> searchByCategory(String category) {
        ArrayList<Book> booksWithCategory = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                booksWithCategory.add(book);
            }
        }
        return booksWithCategory;
    }

    public boolean borrowBook(String isbn) {
        Book book = this.getBook(isbn);
        if (book != null)
            return book.borrowBook();
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = this.getBook(isbn);
        if (book != null)
            return book.returnBook();
        return false;
    }
}

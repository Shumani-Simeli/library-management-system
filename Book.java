public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final String edition;
    private final String category;
    private int availablequantity;
    private int quantity;
    
    public Book (String title, String author, String isbn, String edition,String category,
                    int quantity) {
                        this.title = title;
                        this.author = author;
                        this.isbn = isbn;
                        this.edition = edition;
                        this.category = category;
                        this.availablequantity = quantity;
                        this.quantity = quantity;
                    }

    public String getTitle() {
        return this.title;
    }

    public String getauthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }
    
    public String getEdition() {
        return this.edition;
    }

    public String getCategory() {
        return this.category;
    }

    public int getAvailablequantity() {
        return this.availablequantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addbook(int numBooks) {
        quantity += numBooks;
    }

    public boolean borrowBook() {
        if (this.quantity > 0) {
            availablequantity--;
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return (availablequantity > 0);
    }

    public boolean returnBook() {
        if (quantity > availablequantity) {
            availablequantity++;
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.printf("""
                    Title: %s
                    Author: %s
                    Isbn: %s
                    Edition: %s
                    Category: %s
                    Number of books available: %d
                """, title, author, isbn, edition, category, availablequantity);
    }
}

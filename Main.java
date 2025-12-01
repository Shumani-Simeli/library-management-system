import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void displayBooks(ArrayList<Book> books) {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Library library = new Library();
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        String service = null;
        System.out.println("Welcome member how can i help you today:");
        while (!exit) {
            try {
                if (service == null) {
                    System.out.println("""
                                Menu(select by number):
                                    1.Add new book/books
                                    2.Available books
                                    3.Search for book
                                    4.Borrow book
                                    5.Return Book
                                    6.Exit
                                """);
                    service = scan.nextLine();
                }

                switch (Integer.parseInt(service)) {
                    case 1:
                        boolean addMoreBooks = false;
                        System.out.println("""
                                Please provide the folloing:
                                1.Title of the book
                                2.Author
                                3.isbn
                                4.Edition
                                5.Category
                                6.Total number of books
                                """);
                        do {
                            System.out.print("Title: ");
                            String title = scan.nextLine();
                            System.out.print("Author: ");
                            String author = scan.nextLine();
                            System.out.print("Isbn: ");
                            String isbn = scan.nextLine();
                            System.out.print("Edition: ");
                            String edition = scan.nextLine();
                            System.out.print("Category: ");
                            String category = scan.nextLine();
                            System.out.print("Total number of books: ");
                            String quantity = scan.nextLine();
                            System.out.println("Are you sure you want to Save book? Y(Yes)|N(No)");
                            String saveAnswer = scan.nextLine();
                            if (saveAnswer.equalsIgnoreCase("y") || saveAnswer.equalsIgnoreCase("yes")){
                                Book book = new Book(title, author, isbn, edition,category,Integer.parseInt(quantity));
                                library.addbook(book);
                                System.out.println("Book added:");
                                book.displayInfo();
                                System.out.println("Would you like to add another book? Y(Yes)|N(No)");
                                String addbook1 = scan.nextLine();
                                if (addbook1.equalsIgnoreCase("y") || addbook1.equalsIgnoreCase("yes"))
                                    addMoreBooks = true;
                                else {
                                    addMoreBooks = false;
                                    service = null;
                                }
                            } 
                            else {
                                System.out.println("""
                                        1.Return back to main menu 
                                        2.Add new book
                                        """);
                                if (Integer.parseInt(scan.nextLine()) == 2)
                                    addMoreBooks = true;
                                else {
                                    addMoreBooks = false;
                                    service = null;
                                }
                            }
                        } while (addMoreBooks);
                        break;

                    case 2:
                        ArrayList<Book> books = library.getAllBooks();
                        if (books.isEmpty()) {
                            System.out.println("There are no available books in the system.\n1.Would you like to add a book? 2.return to menu");
                            String navi = scan.nextLine();
                            if (Integer.parseInt(navi) == 1){
                                service = "1";
                            }
                            else
                                service = null;
                        }
                        else {
                            System.out.println("Available books:");
                            displayBooks(books);
                            System.out.println("Would you like to add book(s)? Y(Yes)|N(No)");
                            String addbook2 = scan.nextLine();
                            if (addbook2.equalsIgnoreCase("y") || addbook2.equalsIgnoreCase("yes"))
                                    service = "1";
                            else 
                                    service = null;
                        }
                        break;
                    case 3:
                        System.out.println("""
                                Search using:
                                1. Title
                                2. Author
                                3. Isbn
                                4. category
                                """);
                        String search = scan.nextLine();
                        switch (Integer.parseInt(search)) {
                            case 1:
                                System.out.print("Please enter title: ");
                                String titleSearch = scan.nextLine();
                                ArrayList<Book> searchBooks = library.searchByTitle(titleSearch);
                                if (!searchBooks.isEmpty()) {
                                    displayBooks(searchBooks);
                                    service = null;
                                }
                                else{
                                    System.out.printf("Book(s) titled %s is not available.\n Would you like to add book? Y(Yes)|N(No)%n", titleSearch);
                                    String addbook = scan.nextLine();
                                    if (addbook.equalsIgnoreCase("y") || addbook.equalsIgnoreCase("yes"))
                                        service = "1";
                                    else 
                                        service = null;
                                }
                                break;
                            case 2:
                                System.out.print("Please enter author: ");
                                String authorSearch = scan.nextLine();
                                ArrayList<Book> authorBooks = library.searchByAuthor(authorSearch);
                                if (!authorBooks.isEmpty()) {
                                    displayBooks(authorBooks);
                                    service = null;
                                }
                                else{
                                    System.out.printf("Book(s) with author %s is not available.\n Would you like to add book? Y(Yes)|N(No)%n", authorSearch);
                                    String addbook = scan.nextLine();
                                    if (addbook.equalsIgnoreCase("y") || addbook.equalsIgnoreCase("yes"))
                                        service = "1";
                                    else 
                                        service = null;
                                }
                                break;
                            case 3:
                                System.out.print("Please enter isbn: ");
                                String isbnSearch = scan.nextLine();
                                Book isbnBook = library.getBook(isbnSearch);
                                if (isbnBook != null) {
                                    isbnBook.displayInfo();
                                    service = null;
                                } 
                                else{
                                    System.out.printf("Book(s) with isbn %s number is not available.\n Would you like to add book? Y(Yes)|N(No)%n", isbnBook);
                                    String addbook = scan.nextLine();
                                    if (addbook.equalsIgnoreCase("y") || addbook.equalsIgnoreCase("yes"))
                                        service = "1";
                                    else 
                                        service = null;
                                }
                                break;
                            case 4:
                                System.out.print("Please enter category: ");
                                String categorySearch = scan.nextLine();
                                ArrayList<Book> categoryBooks = library.searchByCategory(categorySearch);
                                if (!categoryBooks.isEmpty()) {
                                    displayBooks(categoryBooks);
                                    service = null;
                                }
                                else{
                                    System.out.printf("There are no Books in the %s category available.\n Would like to add book? Y(Yes)|N(No)%n", categorySearch);
                                    String addbook = scan.nextLine();
                                    if (addbook.equalsIgnoreCase("y") || addbook.equalsIgnoreCase("yes"))
                                        service = "1";
                                    else 
                                        service = null;
                                }
                                break;
                        }
                        break;

                    case 4:
                        System.out.print("Please enter ISBN: ");
                        String isbnBorrowBook = scan.nextLine();
                        if (library.getBook(isbnBorrowBook) == null) {
                            System.out.printf("No book found with ISBN: %s%n", isbnBorrowBook);
                            service = "1";
                        }
                        else if (library.borrowBook(isbnBorrowBook)) {
                            System.out.printf("%s book was successfully borrowed to member%n", library.getBook(isbnBorrowBook).getTitle());
                            service = null;
                        }   
                        else {
                            System.out.println("Something went wrong please try again");
                            service = "4";
                        }
                        break;
                    case 5:
                        System.out.print("Please enter the ISBN: ");
                        String isbnReturnbook = scan.nextLine();
                        if (library.getBook(isbnReturnbook) == null) {
                            System.out.printf("No book found with ISBN: %s%n", isbnReturnbook);
                            System.out.println("Would you like to add book, Y(yes) | N(no)");
                            String addBook = scan.nextLine();
                            if (addBook.equalsIgnoreCase("y") || addBook.equalsIgnoreCase("yes"))
                                service = "1";
                            else
                                service = null;
                            break;
                        }
                        boolean isReturned = library.returnBook(isbnReturnbook);
                        if (isReturned) {
                            System.out.println("Book successfully returned");
                            service = null;
                        }
                        else{
                            System.out.printf("Error all copies of this ISBN:%s book has been accounted for%n", isbnReturnbook);
                            service = null;
                        }
                        break;
                    case 6:
                        exit = true;
                        System.out.println("GoodBye");                   
                }
                scan.close();
            } 
            catch (NumberFormatException e) {
                System.out.printf("Error occured: %s %nPlease use the number option for desired selection.%n", e.getMessage()); 
                service = null;  
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                service = null;
            }
        }
    }
}

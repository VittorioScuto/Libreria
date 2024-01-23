import java.util.ArrayList;

public class Library {
    public static Library instance;
    ArrayList<Book> Booksinfo = new ArrayList<>();

    public Library() {
    }

    public static Library getInstance() {
        if (instance == null) {

            instance = new Library();
        }
        return instance;
    }

    public void addbook(Book book) {
        Booksinfo.add(book);
    }

    public void bookdisplay() {
        for (Book book : Booksinfo) {
            System.out.println(book);
        }
    }

    public void bookloan(String title) {
        for (Book book : Booksinfo) {
            if (book.getTitle().equals(title)) {
                int numberofcopies = book.getNumberofcopies();
                if (numberofcopies > 0) {
                    book.setNumberofcopies(numberofcopies - 1);
                    System.out.println("Loan completed successfully. Copies available: " + (numberofcopies - 1));
                } else {
                    System.out.println("The book is not available for loan. Copies sold out.");
                }
                return;
            }
        }
        System.out.println("Book not found in library.");
    }
}

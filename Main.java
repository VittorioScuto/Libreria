import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean logout = false;

        while(!logout) {
            System.out.println("\nMENU \n1) Add book \n2) Viewing books \n3) Borrow a book \n4) Logout \nChoose the operation to perform ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    try {

                        System.out.println("Enter the title of the book: ");
                        String title = input.nextLine();
                        System.out.println("Enter the author of the book: ");
                        String author = input.nextLine();
                        System.out.println("Enter the year the book was published: ");
                        int yearofpublication = input.nextInt();
                        System.out.println("Enter the number of available copies of the book: ");
                        int numberofcopies = input.nextInt();

                        Book book = new Book(title, author, yearofpublication, numberofcopies);
                        Library.getInstance().addbook(book);
                        System.out.println("Book inserted successfully!");
                    } catch (InputMismatchException e) {
                        System.out.println("Error");
                        input.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("List of all books: ");
                    Library.getInstance().bookdisplay();
                    break;

                case 3:
                    System.out.println("Enter the title of the book to borrow: ");
                    String loantitle = input.nextLine();
                    Library.getInstance().bookloan(loantitle);
                    break;

                case 4:
                    logout = true;
                    System.out.println("Logged out");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }
}

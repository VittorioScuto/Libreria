import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static class Handler {

        private interface MenuHandler {
            void handleRequest(int choice, Library library, Scanner input);
            void setNextHandler(MenuHandler nextHandler);
            MenuHandler getNextHandler();
        }

        private static class AddBookHandler implements MenuHandler {
            private MenuHandler nextHandler;

            @Override
            public void handleRequest(int choice, Library library, Scanner input) {
                if (choice == 1) {
                    try {
                        System.out.print("Enter the title of the book: ");
                        String title = input.nextLine();
                        System.out.print("Enter the author of the book: ");
                        String author = input.nextLine();
                        System.out.print("Enter the publication year of the book: ");
                        int publicationYear = input.nextInt();
                        System.out.print("Enter the number of copies available: ");
                        int numberOfCopies = input.nextInt();

                        Book book = new Book(title, author, publicationYear, numberOfCopies);
                        library.addbook(book);
                        System.out.println("Book inserted successfully!");
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("ERROR: Please enter the correct data type.");
                        input.nextLine();
                    }
                } else if (nextHandler != null) {
                    nextHandler.handleRequest(choice, library, input);
                }
            }

            @Override
            public void setNextHandler(MenuHandler nextHandler) {
                this.nextHandler = nextHandler;
            }

            @Override
            public MenuHandler getNextHandler() {
                return nextHandler;
            }
        }

        private static class ViewBookHandler implements MenuHandler {
            private MenuHandler nextHandler;

            @Override
            public void handleRequest(int choice, Library library, Scanner input) {
                if (choice == 2) {
                    System.out.println("List of all books: ");
                    library.bookdisplay();
                } else if (nextHandler != null) {
                    nextHandler.handleRequest(choice, library, input);
                }
            }

            @Override
            public void setNextHandler(MenuHandler nextHandler) {
                this.nextHandler = nextHandler;
            }

            @Override
            public MenuHandler getNextHandler() {
                return nextHandler;
            }
        }

        private static class BorrowBookHandler implements MenuHandler {
            private MenuHandler nextHandler;

            @Override
            public void handleRequest(int choice, Library library, Scanner input) {
                if (choice == 3) {
                    System.out.print("Enter the title of the book to borrow: ");
                    String titleToBorrow = input.nextLine();
                    library.bookloan(titleToBorrow);
                } else if (nextHandler != null) {
                    nextHandler.handleRequest(choice, library, input);
                }
            }

            @Override
            public void setNextHandler(MenuHandler nextHandler) {
                this.nextHandler = nextHandler;
            }

            @Override
            public MenuHandler getNextHandler() {
                return nextHandler;
            }
        }

        private MenuHandler chain;

        public Handler() {
            chain = new AddBookHandler();
            chain.setNextHandler(new ViewBookHandler());
            chain.getNextHandler().setNextHandler(new BorrowBookHandler());
        }

        public void processRequest(int choice, Library library, Scanner input) {
            chain.handleRequest(choice, library, input);
        }
    }

    public static void main(String[] args) {
        Handler handler = new Handler();

        Scanner input = new Scanner(System.in);

        Library library = Library.getInstance();

        boolean logout = false;

        while (!logout) {
            System.out.print("\nMENU \n1) Insert a book \n2) Display books \n3) Borrow a book \n4) Logout \nChoose an operation to perform: ");

            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 4) {
                    logout = true;
                    System.out.println("Logout successful");
                } else {
                    handler.processRequest(choice, library, input);
                }
            } else {
                System.out.println("ERROR: Invalid choice. Please try again.");
                input.nextLine();
            }
        }

        input.close();
    }
}

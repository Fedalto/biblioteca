import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        Biblioteca bibl = new Biblioteca();
        bibl.welcomeScreen();
        bibl.setup();
        bibl.mainMenu();
    }

    private void setup() {
        Book book1 = new Book("Alice in Wonderland", "Lewis Carroll");
        Book book2 = new Book("The Adventures of Sherlock Holmes", "Sir Arthur Conan Doyle");
        Book book3 = new Book("War and Peace", "Leo Tolstoy");

        addBook(book1);
        addBook(book2);
        addBook(book3);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void welcomeScreen() {
        System.out.println("Welcome to the Bangalore Public Library System");
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1) View all books");
        System.out.println("2) Reserve a book");
        System.out.println("3) Check library number");
        System.out.println("Q) Quit");
        System.out.print("Option: ");
    }

    // Menu loop
    public void mainMenu() {
        String choice;

        do {
            showMenu();
            choice = getMenuChoice();

            selectMenuOption(choice);

        } while (!choice.equalsIgnoreCase("q"));
    }

    public void selectMenuOption(String choice) {
        switch(choice) {
            case "1":
                showAllBooks();
                break;
            case "2":
                // Reserve a book
                break;
            case "3":
                // Check library number
                break;
            case "q":
            case "Q":
                // Quit
                break;
            default:
                System.out.println("Select a valid option!!");
        }
    }

    private String getMenuChoice() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book.getId() + ") " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}

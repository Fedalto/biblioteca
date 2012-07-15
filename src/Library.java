import java.util.Scanner;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public void start() {
        setup();
        welcomeScreen();
        mainMenu();
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
        System.out.println("============================");
        System.out.println("=     Welcome to the       =");
        System.out.println("=        Bangalore         =");
        System.out.println("=   Public Library System  =");
        System.out.println("============================");
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1) View all books");
        System.out.println("2) Reserve a book");
        System.out.println("3) Check library number");
        System.out.println("Q) Quit");
        System.out.print("Select an option: ");
    }

    // Menu loop
    public void mainMenu() {
        String choice;

        do {
            showMenu();
            choice = getMenuChoice();
            selectMenuOption(choice);
        } while (!choice.equals("q"));
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
                // Quit
                break;
            default:
                System.out.println("Select a valid option!!");
        }
    }

    private String getMenuChoice() {
        Scanner in = new Scanner(System.in);
        return in.next().toLowerCase();
    }

    public void showAllBooks() {
        int index = 1;
        for (Book book : books) {
            System.out.println(index + ") " + book.getTitle() + " by " + book.getAuthor());
            index++;
        }
    }
}

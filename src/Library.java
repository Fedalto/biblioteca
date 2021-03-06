import java.util.Scanner;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private User currentUser;

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

        addMovie(new Movie("The Godfather", "Francis Ford Coppola", 10));
        addMovie(new Movie("Fight Club", "David Fincher"));
        addMovie(new Movie("Star Wars", "George Lucas", 9));
        addMovie(new Movie("Shrek", "Andrew Adamson", 0));

        new User("librarian", "1234");
        new User("steve", "12345");
        new User("michael", "123456");
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Book getBook(int index) {
        return books.get(index-1);
    }

    public User getCurrentUser() {
        return currentUser;
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
        System.out.println("4) View all movies");
        if (UserLoggedIn())
            System.out.println("L) Logout");
        else
            System.out.println("L) Login");
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
                System.out.print("Which book would you like to reserve? ");
                int bookNumber = getNumberInput();
                reserveBook(bookNumber);
                break;
            case "3":
                checkLibraryNumber();
                break;
            case "4":
                showAllMovies();
                break;
            case "l":
                if (UserLoggedIn())
                    logout();
                else {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Username: ");
                    String username = in.nextLine();

                    System.out.print("Password: ");
                    String password = in.nextLine();

                    login(username, password);
                }
                break;
            case "q":
                // Quit
                break;
            default:
                System.out.println("Select a valid option!!");
        }
    }

    public void reserveBook(int bookNumber) {
        Book book;

        if (bookNumber <= 0 || bookNumber > books.size()) {
            System.out.println("Book number not found.");
            return;
        }

        book = getBook(bookNumber);
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Thank You! Enjoy the book.");
        } else {
            System.out.println("Sorry we don't have that book yet.");
        }
    }

    private String getMenuChoice() {
        Scanner in = new Scanner(System.in);
        return in.next().toLowerCase();
    }

    private int getNumberInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void showAllBooks() {
        int index = 1;
        for (Book book : books) {
            System.out.println(index + ") " + book.getTitle() + " by " + book.getAuthor());
            index++;
        }
    }

    public void showAllMovies() {
        System.out.println("    Movie Name | Director | Rating");
        int index = 1;
        for (Movie movie : movies) {
            System.out.print(index + ") " + movie.getTitle() + " | " + movie.getDirector() + " | ");
            if (movie.getRating() < 1)
                System.out.println("N/A");
            else
                System.out.println(movie.getRating());
            index++;
        }
    }

    public void checkLibraryNumber() {
        if (UserLoggedIn())
            System.out.println("Your library number is " + getCurrentUser().getLibraryNumber());
        else
            System.out.println("Please talk to Librarian. Thank you");
    }

    public void login(String username, String password) {
        currentUser = User.authenticate(username, password);
        if (!UserLoggedIn())
            System.out.println("Error: Invalid username/password");
    }

    public void logout() {
        currentUser = null;
    }

    private boolean UserLoggedIn() {
        return !(getCurrentUser() == null);
    }
}

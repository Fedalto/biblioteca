import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class LibraryTest extends TestCase {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    Library lib;

    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        lib = new Library();
        Book book = new Book("Alice in Wonderland", "Lewis Carroll");
        lib.addBook(book);
    }

    public void tearDown() throws Exception {
        System.setOut(null);
    }

    // The customer should see a welcome when they start the application.
    public void testWelcomeScreen() throws Exception {
        lib.welcomeScreen();
        assertThat(out.toString(), containsString("Welcome"));
    }

    // A customer should have a list of menu options at the start of the application.
    public void testShowMenu() throws Exception {
        lib.showMenu();
        assertThat(out.toString(), containsString("Menu"));
    }

    // A customer should be able to select a menu option.
    public void testSelectMenuOption() throws Exception {
        lib.selectMenuOption("1");
        lib.selectMenuOption("3");
        lib.selectMenuOption("Q");
    }

    // A customer should be notified if they do not select a valid option with “Select a valid option!!”
    public void testInvalidOption() throws Exception {
        lib.selectMenuOption("invalid");
        assertThat(out.toString(), containsString("Select a valid option"));
    }

    // A customer should be able to view all books the library has.
    public void testShowAllBooks() throws Exception {
        lib.showAllBooks();
        assertThat(out.toString(), containsString("Alice in Wonderland by Lewis Carroll"));
    }

    // A customer should be able to reserve a book for collection.
    // A customer should be notified if their selected book was reserved successfully with “Thank You! Enjoy the book.”
    public void testReserveBook() throws Exception {
        lib.reserveBook(1);
        assertThat(out.toString(), containsString("Thank You! Enjoy the book"));
    }

    // A customer should be notified if their selected book is not available with “Sorry we don't have that book yet.”
    public void testReserveBookNotAvailable() throws Exception {
        lib.reserveBook(1);
        lib.reserveBook(1);
        assertThat(out.toString(), containsString("Sorry we don't have that book yet"));
    }

    // A customer should be able to check their library number and be notified with “Please talk to Librarian. Thank you.”
    public void testCheckLibraryNumber() throws Exception {
        lib.checkLibraryNumber(1234);
        assertThat(out.toString(), containsString("Please talk to Librarian. Thank you"));
    }
}

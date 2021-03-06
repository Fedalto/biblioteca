import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class LibraryTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    Library lib;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        lib = new Library();

        Book book = new Book("Alice in Wonderland", "Lewis Carroll");
        lib.addBook(book);
        lib.addMovie(new Movie("The Godfather", "Francis Ford Coppola"));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        User.cleanUp();
    }

    @Test
    public void testWelcomeScreen() throws Exception {
        lib.welcomeScreen();
        assertThat(out.toString(), containsString("Welcome"));
    }

    @Test
    public void testShowMenu() throws Exception {
        lib.showMenu();
        assertThat(out.toString(), containsString("Menu"));
    }

    @Test
    public void testSelectMenuOption() throws Exception {
        lib.selectMenuOption("1");
        lib.selectMenuOption("Q");
    }

    @Test
    public void testSelectInvalidMenuOption() throws Exception {
        lib.selectMenuOption("invalid");
        assertThat(out.toString(), containsString("Select a valid option"));
    }

    @Test
    public void testShowAllBooks() throws Exception {
        lib.showAllBooks();
        assertThat(out.toString(), containsString("Alice in Wonderland by Lewis Carroll"));
    }

    @Test
    public void testReserveBook() throws Exception {
        Book book = lib.getBook(1);

        assertEquals(true, book.isAvailable());

        lib.reserveBook(1);

        assertEquals(false, book.isAvailable());
        assertThat(out.toString(), containsString("Thank You! Enjoy the book"));
    }

    @Test
    public void testReserveBookNotAvailable() throws Exception {
        Book book = lib.getBook(1);
        assertEquals(true, book.isAvailable());

        lib.reserveBook(1);
        assertEquals(false, book.isAvailable());

        lib.reserveBook(1);

        assertEquals(false, book.isAvailable());
        assertThat(out.toString(), containsString("Sorry we don't have that book yet"));
    }

    @Test
    public void CheckLibraryNumber() {
        lib.checkLibraryNumber();
        assertThat(out.toString(), containsString("Please talk to Librarian. Thank you"));
    }

    @Test
    public void checkLibraryNumberWhileLoggedIn() {
        User steve = new User("steve", "12345");
        lib.login("steve", "12345");
        lib.checkLibraryNumber();
        assertThat(out.toString(), containsString(steve.getLibraryNumber()));
    }

    @Test
    public void showAllMovies() {
        lib.showAllMovies();
        assertThat(out.toString(), containsString("The Godfather"));
        assertThat(out.toString(), containsString("Francis Ford Coppola"));
    }

    @Test
    public void login() {
        User steve = new User("steve", "12345");

        lib.login("steve", "12345");
        assert steve == lib.getCurrentUser();
    }

    @Test
    public void loginWithInvalidCredentials() {
        User steve = new User("steve", "12345");

        lib.login("steve", "wrong pass");
        assertEquals(null, lib.getCurrentUser());
        assertThat(out.toString(), containsString("Invalid username/password"));
    }

    @Test
    public void logout() {
        User steve = new User("steve", "12345");
        lib.login("steve", "12345");
        lib.logout();
        assertEquals(null, lib.getCurrentUser());
    }
}

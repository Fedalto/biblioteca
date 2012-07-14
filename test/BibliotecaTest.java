import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class BibliotecaTest extends TestCase {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private ByteArrayInputStream in;
    Biblioteca bibl;

    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        bibl = new Biblioteca();
    }

    public void tearDown() throws Exception {
        System.setOut(null);
    }

    // The customer should see a welcome when they start the application.
    public void testWelcomeScreen() throws Exception {
        bibl.welcomeScreen();
        assertThat(out.toString(), containsString("Welcome to the Bangalore Public Library System"));
    }

    // A customer should have a list of menu options at the start of the application.
    public void testShowMenu() throws Exception {
        bibl.showMenu();
        assertThat(out.toString(), containsString("Menu"));
    }

    // A customer should be able to select a menu option.
    public void testSelectMenuOption() throws Exception {
        in = new ByteArrayInputStream("q".getBytes());
        System.setIn(in);
        bibl.mainMenu();
    }
}

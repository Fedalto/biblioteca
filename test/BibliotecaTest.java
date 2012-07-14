import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaTest extends TestCase {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    public void tearDown() throws Exception {
        System.setOut(null);
    }

    public void testWelcomeScreen() throws Exception {
        Biblioteca bibl = new Biblioteca();
        bibl.welcomeScreen();
        assertEquals("Welcome to the Bangalore Public Library System\n", outContent.toString());
    }
}

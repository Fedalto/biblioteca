import junit.framework.TestCase;

public class BookTest extends TestCase {
    public void testCreateBooks() throws Exception {
        Book book1 = new Book("Alice in Wonderland", "Lewis Carroll");
        Book book2 = new Book("The Adventures of Sherlock Holmes", "Sir Arthur Conan Doyle");
        Book book3 = new Book("War and Peace", "Leo Tolstoy");
    }
}

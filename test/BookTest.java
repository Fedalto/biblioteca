import junit.framework.TestCase;

public class BookTest extends TestCase {
    // Test IDs
    public void testIds() throws Exception {
        Book book1 = new Book("Alice in Wonderland", "Lewis Carroll");
        Book book2 = new Book("The Adventures of Sherlock Holmes", "Sir Arthur Conan Doyle");
        Book book3 = new Book("War and Peace", "Leo Tolstoy");

        assertEquals(1, book1.getId());
        assertEquals(2, book2.getId());
        assertEquals(3, book3.getId());
    }
}

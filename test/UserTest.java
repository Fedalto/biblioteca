import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void createTestUser() {
        user = new User("john", "12345");
    }

    @After
    public void cleanUp() {
        User.cleanUp();
    }

    @Test
    public void testLibraryNumber() {
        User new_user = new User("mike", "1234");
        assertEquals("111-1111", user.getLibraryNumber());
        assertEquals("111-1112", new_user.getLibraryNumber());
    }

    @Test
    public void authenticateUser() {
        User john = User.authenticate("john", "12345");
        assert user == john;
    }

    @Test
    public void authenticateUserFail() {
        User john = User.authenticate("john", "wrong password");
        assertEquals(null, john);
    }
}

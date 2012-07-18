import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie("The Godfather", "Francis Ford Coppola");
    }

    @Test
    public void createMovieWithoutRating() {
        assertEquals(0, movie.getRating());
    }

    @Test
    public void setInvalidRating() {
        movie.setRating(-1);
        assertEquals(0, movie.getRating());
    }
}

import StubsAndMocks.Library;
import StubsAndMocks.Movie;
import StubsAndMocks.MovieInfo;
import StubsAndMocks.StubMovieInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StubsAndMocksTest {
    @Test
    public void donateMovvieAddedToCatalogWithIMDBInfo() {
        String imdbId = "jogght666";
        String title = "The Goonies";
        int year = 1985;
        MovieInfo movieInfo = new StubMovieInfo(title,year);
        Library library = new Library(movieInfo);
        library.donate(imdbId);
        Movie movie = library.findMovie(imdbId);
        assertEquals(title,movie.getTitle());
        assertEquals(year,movie.getYear());
    }
}

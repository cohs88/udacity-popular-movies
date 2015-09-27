package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.IMovieRepository;
import Model.Movie;

/**
 * Created by zoila on 23/09/2015.
 */
public class MovieStubRepository implements IMovieRepository {
    @Override
    public List<Movie> GetMostPopular() {
        List<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie();

        movie.setId(2541);
        movie.setOriginalTitle("M1");
        movies.add(movie);

        movie.setId(854);
        movie.setOriginalTitle("M2");
        movies.add(movie);

        movie.setId(987);
        movie.setOriginalTitle("M3");
        movies.add(movie);

        return movies;
    }
}

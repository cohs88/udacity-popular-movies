package Repository;

import java.util.ArrayList;
import java.util.Date;
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
        movie.setOriginalTitle("Interstellar");
        movies.add(movie);

        movie = new Movie();
        movie.setId(854);
        movie.setOriginalTitle("Jurassic Park");
        movies.add(movie);

        movie = new Movie();
        movie.setId(987);
        movie.setOriginalTitle("Back to the future");
        movies.add(movie);

        return movies;
    }
}

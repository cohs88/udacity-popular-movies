package Model;

import java.util.List;

/**
 *
 * Created by zoila on 23/09/2015.
 */
public interface IMovieRepository {
    List<Movie> GetMostPopular();
    List<Movie> GetDiscoverMovies(String sortBy);
}

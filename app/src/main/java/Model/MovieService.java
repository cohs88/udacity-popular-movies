package Model;

import java.util.List;

/**
 * Created by zoila on 25/09/2015.
 */
public class MovieService {
    private IMovieRepository _movieRepository;

    public MovieService(IMovieRepository movieRepository)
    {
        _movieRepository = movieRepository;
    }

    public List<Movie> GetPopular(String sortBy)
    {
        return _movieRepository.GetDiscoverMovies(sortBy);
    }
}

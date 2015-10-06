package Repository;

import android.util.Log;

import com.example.popularmoviesudacity.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import Model.IMovieRepository;
import Model.Movie;

/**
 * Created by zoila on 23/09/2015.
 */
public class MovieStubRepository implements IMovieRepository {

    class MovieComparatorByHighestRating implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) {
            Movie m1 = (Movie)o1;
            Movie m2 = (Movie)o2;

            return m1.getReleaseDate().compareTo(m2.getReleaseDate());

            /*
            if(m1.getId() > m2.getId())
                return 1;
            else if(m2.getId() > m1.getId())
                return -1;
            else
                return 0;
            */
        }
    }

    class MovieComparatorByMostPopular implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) {
            Movie m1 = (Movie)o1;
            Movie m2 = (Movie)o2;

            return m1.getOriginalTitle().compareTo(m2.getOriginalTitle());
        }
    }

    @Override
    public List<Movie> GetMostPopular() {
        List<Movie> movies = this.GetMocks();

        //Collections.sort(movies, new MovieComparatorByHighestRating());

        return  null;
    }

    @Override
    public List<Movie> GetDiscoverMovies(String sortBy) {
        List<Movie> movies = this.GetMocks();


        if(sortBy.equals("popularity.desc")) {
            Collections.sort(movies, new MovieComparatorByMostPopular());
        }
        else if(sortBy.equals("vote_average.desc")){
            Collections.sort(movies, new MovieComparatorByHighestRating());
        }

        //Collections.sort(movies, new MovieComparatorByMostPopular());

        return movies;
    }

    private List<Movie> GetMocks()
    {
        List<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie();

        movie.setId(41);
        movie.setImageResource(R.drawable.sample_0);
        movie.setReleaseDate(movie.convertStringToDate("2018-11-09"));
        movie.setOriginalTitle("Interstellar");
        movie.setOverview("An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life.");
        movies.add(movie);

        movie = new Movie();
        movie.setId(2);
        movie.setImageResource(R.drawable.sample_1);
        movie.setReleaseDate(movie.convertStringToDate("2015-02-07"));
        movie.setOriginalTitle("Jurassic Park");
        movie.setOverview("As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.");
        movies.add(movie);

        movie = new Movie();
        movie.setId(7);
        movie.setImageResource(R.drawable.sample_2);
        movie.setReleaseDate(movie.convertStringToDate("1917-08-06"));
        movie.setOriginalTitle("Back to the future");
        movie.setOverview("Thomas and his fellow Gladers face their greatest challenge yet: searching for clues about the mysterious and powerful organization known as WCKD. Their journey takes them to the Scorch, a desolate landscape filled with unimaginable obstacles.");
        movies.add(movie);

        movie = new Movie();
        movie.setId(17);
        movie.setImageResource(R.drawable.sample_3);
        movie.setReleaseDate(movie.convertStringToDate("1995-03-06"));
        movie.setOriginalTitle("Titanic");
        movie.setOverview("Thomas and his fellow Gladers face their greatest challenge yet: searching for clues about the mysterious and powerful organization known as WCKD. Their journey takes them to the Scorch, a desolate landscape filled with unimaginable obstacles.");
        movies.add(movie);

        movie = new Movie();
        movie.setId(63);
        movie.setImageResource(R.drawable.sample_4);
        movie.setReleaseDate(movie.convertStringToDate("2014-01-10"));
        movie.setOriginalTitle("Kerminator");
        movie.setOverview("Thomas and his fellow Gladers face their greatest challenge yet: searching for clues about the mysterious and powerful organization known as WCKD. Their journey takes them to the Scorch, a desolate landscape filled with unimaginable obstacles.");
        movies.add(movie);


        return movies;
    }
}

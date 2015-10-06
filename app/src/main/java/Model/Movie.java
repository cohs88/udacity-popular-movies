package Model;


import com.example.popularmoviesudacity.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zoila on 23/09/2015.
 */
public class Movie {
    private int id;
    private String originalTitle;
    private Date releaseDate;
    private String overview;
    private boolean hasVideo;
    private String posterPath;
    private double voteAverage;
    private Integer imageResource;

    public void setImageResource(Integer imageResource)
    {
        this.imageResource = imageResource;
    }

    public Integer getImageResource()
    {
        return this.imageResource;
    }

    public Date convertStringToDate(String stringDate)
    {
        DateFormat format;
        Date date = new Date();

        format = new SimpleDateFormat("yy-MM-dd");

        try{
            date = format.parse(stringDate);
        }
        catch (Exception e)
        {
            // oops!
        }

        return date;
    }

    public Integer getTestPicasso()
    {
        return R.drawable.sample_0;
    }

    public String getFullPosterPath()
    {
        return "http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
        //return "http://i.imgur.com/DvpvklR.png";
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getOriginalTitle()
    {
        return originalTitle;
    }

    public void setOriginalTitle(String title)
    {
        this.originalTitle = title;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean HasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }
}

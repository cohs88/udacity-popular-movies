package com.example.popularmoviesudacity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import Model.IMovieRepository;
import Model.Movie;
import Model.MovieService;

/**
 * Created by zoila on 25/09/2015.
 */
public class MoviesAdapter extends BaseAdapter {
    private Context mContext;
    private MovieService _moviesService;
    private List<Movie> _movies;

    public MoviesAdapter(Context context, IMovieRepository movieRepository)
    {
        mContext = context;
        _moviesService = new MovieService(movieRepository);
        _movies = _moviesService.GetPopular();
    }

    @Override
    public int getCount() {
        return _movies.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null)
        {

        }

        return null;
    }
}

package com.example.popularmoviesudacity;

import android.app.ActionBar;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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

    public MoviesAdapter(Context context, IMovieRepository movieRepository, String sortBy)
    {
        mContext = context;
        _moviesService = new MovieService(movieRepository);
        _movies = _moviesService.GetPopular(sortBy);
    }

    @Override
    public int getCount() {
        return _movies.size();
    }

    @Override
    public Object getItem(int position) {
        return _movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _movies.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        ImageView imageView;
        if (convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            //imageView.setPadding(8, 8, 8, 8);
        }
        else {
            imageView = (ImageView)convertView;
        }
        */



        SquaredImageView imageView = (SquaredImageView) convertView;
        if (convertView == null) {
            imageView = new SquaredImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else
        {
            imageView = (SquaredImageView)convertView;
        }


        /*
        Picasso.with(mContext)
                .load(_movies.get(position).getFullPosterPath())
                //.resize(85, 85)
                .into(imageView);
        */
        //imageView.setImageResource(_movies.get(position).getTestPicasso());
        //imageView.setImageResource(mImages[position]);
        imageView.setImageResource(_movies.get(position).getImageResource());

        return imageView;
    }

    public Integer[] mImages = {
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7
    };
}

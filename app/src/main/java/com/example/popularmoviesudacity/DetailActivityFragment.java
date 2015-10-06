package com.example.popularmoviesudacity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Model.Movie;
import Repository.MovieStubRepository;

/**
 * Created by servando on 9/30/2015.
 */
public class DetailActivityFragment extends Fragment {
    private Context mContext;
    private TextView mTxtMovieTitle;
    private TextView mTxtMovieOverview;
    private TextView mTxtMovieReleaseDate;
    private ImageView mIvMovieThumbnail;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_activity_fragment, container, false);

        // intent data
        Intent intent = getActivity().getIntent();

        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
            MoviesAdapter moviesAdapter = new MoviesAdapter(mContext, new MovieStubRepository(), "vote_average.desc");

            int positionSelected = intent.getIntExtra(Intent.EXTRA_TEXT, 100);

            Movie movieSelected = (Movie)moviesAdapter.getItem(positionSelected);

            mTxtMovieTitle = (TextView)view.findViewById(R.id.txtMovieTitle);
            mTxtMovieOverview = (TextView)view.findViewById(R.id.txtMovieOverView);
            mTxtMovieReleaseDate = (TextView)view.findViewById(R.id.txtMovieReleaseDate);
            mIvMovieThumbnail = (ImageView)view.findViewById(R.id.ivMovieThumbnail);

            mTxtMovieTitle.setText(movieSelected.getOriginalTitle());
            mTxtMovieOverview.setText(movieSelected.getOverview());
            mTxtMovieReleaseDate.setText(movieSelected.getReleaseDate().toString());
            mIvMovieThumbnail.setImageResource(moviesAdapter.mImages[positionSelected]);

        }
        // intent data

        return view;
    }
}

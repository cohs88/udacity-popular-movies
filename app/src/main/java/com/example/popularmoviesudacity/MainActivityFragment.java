package com.example.popularmoviesudacity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import Model.Movie;
import Repository.MovieStubRepository;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Context mContext;
    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        mContext = getActivity().getApplicationContext();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_activity_fragment, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView)view.findViewById(R.id.gridview);

        gridView.setAdapter(new MoviesAdapter(mContext, new MovieStubRepository()));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movie =  (Movie)adapterView.getItemAtPosition(position);

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, position);

                Toast.makeText(mContext, "" + position + " " + movie.getOriginalTitle(), Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });


        return view;
    }
}

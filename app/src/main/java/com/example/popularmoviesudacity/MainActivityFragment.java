package com.example.popularmoviesudacity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import android.widget.ListAdapter;
import android.widget.Toast;

import Model.Movie;
import Repository.MovieStubRepository;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Context mContext;
    private View theRootView;
    GridView mGridView;

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String sortBySetting = sharedPreferences.getString(
                getString(R.string.pref_movies_sort_key),
                getString(R.string.pref_movies_sort_default)
        );


        mGridView.setAdapter(new MoviesAdapter(mContext, new MovieStubRepository(), sortBySetting));
        synchronized (mGridView)
        {
            mGridView.notifyAll();
        }
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
        View view = theRootView = inflater.inflate(R.layout.fragment_main, container, false);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String sortBySetting = sharedPreferences.getString(
                getString(R.string.pref_movies_sort_key),
                getString(R.string.pref_movies_sort_default)
        );

        //GridView gridView = (GridView)view.findViewById(R.id.gridview);
        mGridView = (GridView)view.findViewById(R.id.gridview);

        //listAdapter = new MoviesAdapter(mContext, new MovieStubRepository(), sortBySetting);
        //gridView.setAdapter(listAdapter);

        mGridView.setAdapter(new MoviesAdapter(mContext, new MovieStubRepository(), sortBySetting));

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movie = (Movie) adapterView.getItemAtPosition(position);

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, position);

                startActivity(intent);
            }
        });


        return view;
    }
}

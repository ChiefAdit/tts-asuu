package com.example.tts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HeadlinesFragment extends Fragment {
    private ListView listView;

    // Sample data for the list
    private final String[] headlines = {"Headline 1", "Headline 2"};

    public HeadlinesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headlines, container, false);

        // Initialize the list view
        listView = view.findViewById(R.id.list_view_headlines);

        // Set the adapter for the list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, headlines);
        listView.setAdapter(adapter);

        // Set the item click listener for the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Open the ArticleFragment and pass the selected headline as an argument
                String selectedHeadline = headlines[position];
                ArticleFragment articleFragment = new ArticleFragment();
                Bundle args = new Bundle();
                args.putString("headline", selectedHeadline);
                articleFragment.setArguments(args);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, articleFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}

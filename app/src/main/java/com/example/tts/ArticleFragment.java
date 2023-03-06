package com.example.tts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ArticleFragment extends Fragment {

    private TextView articleTitleTextView;
    private TextView articleContentTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_article, container, false);

        // Get references to UI components
        articleTitleTextView = rootView.findViewById(R.id.article_title_textview);
        articleContentTextView = rootView.findViewById(R.id.article_content_textview);

        // Get the selected article data from arguments
        Bundle args = getArguments();
        if (args != null) {
            String articleTitle = args.getString("article_title");
            String articleContent = args.getString("article_content");

            // Set the article data to UI components
            articleTitleTextView.setText(articleTitle);
            articleContentTextView.setText(articleContent);
        }

        return rootView;
    }
}

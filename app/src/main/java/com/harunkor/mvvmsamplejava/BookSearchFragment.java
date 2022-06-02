package com.harunkor.mvvmsamplejava;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.harunkor.mvvmsamplejava.adapter.BookSearchResultsAdapter;
import com.harunkor.mvvmsamplejava.model.VolumesResponse;
import com.harunkor.mvvmsamplejava.viewmodel.BookSearchViewModel;


public class BookSearchFragment extends Fragment {
    private BookSearchViewModel bookSearchViewModel;
    private BookSearchResultsAdapter bookSearchResultsAdapter;

    private TextInputLayout keywordEditText,authorEditText;
    private Button searhButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookSearchResultsAdapter = new BookSearchResultsAdapter();
        bookSearchViewModel = new ViewModelProvider(this).get(BookSearchViewModel.class);
        bookSearchViewModel.getVolumesResponseLiveData().observe(this, new Observer<VolumesResponse>() {
               @Override
               public void onChanged(VolumesResponse volumesResponse) {
                   if(volumesResponse !=null){
                       bookSearchResultsAdapter.setResults(volumesResponse.getItems());
                   }
               }
           });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(bookSearchResultsAdapter);

        keywordEditText = view.findViewById(R.id.fragment_booksearch_keyword);
        authorEditText = view.findViewById(R.id.fragment_booksearch_author);
        searhButton = view.findViewById(R.id.fragment_booksearch_search);


        searhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSearch();
            }
        });

    }
    public void performSearch(){
        String keyword = keywordEditText.getEditText().getText().toString();
        String author = authorEditText.getEditText().getText().toString();
        bookSearchViewModel.searchVolumes(keyword,author);
    }
}
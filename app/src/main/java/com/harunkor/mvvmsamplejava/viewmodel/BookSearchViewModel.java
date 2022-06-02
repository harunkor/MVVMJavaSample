package com.harunkor.mvvmsamplejava.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.harunkor.mvvmsamplejava.model.VolumesResponse;
import com.harunkor.mvvmsamplejava.repository.BookRepository;

public class BookSearchViewModel extends ViewModel {

    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel() {
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }


    public void searchVolumes(String keyword,String author){
        bookRepository.searchVolumes(keyword,author);
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }

}

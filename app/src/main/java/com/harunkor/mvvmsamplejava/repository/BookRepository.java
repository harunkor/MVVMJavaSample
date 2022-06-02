package com.harunkor.mvvmsamplejava.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.harunkor.mvvmsamplejava.api.BookSearchService;
import com.harunkor.mvvmsamplejava.model.VolumesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookRepository {
    private static final String BASE_URL = "https://www.googleapis.com/";

    private BookSearchService bookSearchService;
    private MutableLiveData<VolumesResponse> volumesResponseMutableLiveData;

    public BookRepository() {
        volumesResponseMutableLiveData = new MutableLiveData<>();

        bookSearchService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(BookSearchService.class);

    }

    public void searchVolumes(String keyword,String author){
        bookSearchService.searchVolumes(keyword,author).enqueue(new Callback<VolumesResponse>() {
            @Override
            public void onResponse(Call<VolumesResponse> call, Response<VolumesResponse> response) {
                if(response.body() !=null){
                    volumesResponseMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<VolumesResponse> call, Throwable t) {
                    volumesResponseMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData(){
        return volumesResponseMutableLiveData;
    }


}

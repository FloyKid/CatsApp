package com.floykid.catsapp.network;

import com.floykid.catsapp.models.BreedTitle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPlaceHolder {

    @GET("v1/breeds/")
    Call<List<BreedTitle>> getApiBreedTitles();
}

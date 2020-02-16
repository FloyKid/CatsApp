package com.floykid.catsapp.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.floykid.catsapp.models.BreedTitle;
import com.floykid.catsapp.network.ApiClient;
import com.floykid.catsapp.network.ApiPlaceHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BreedTitlesRepository {

    private static BreedTitlesRepository instance;

    private ApiPlaceHolder apiPlaceHolder;

    public BreedTitlesRepository() {
        apiPlaceHolder = ApiClient.getRetrofitClient().create(ApiPlaceHolder.class);
    }

    public static BreedTitlesRepository getInstance() {
        if (instance == null) {
            instance = new BreedTitlesRepository();
        }
        return instance;
    }

    public MutableLiveData<List<BreedTitle>> getBreedTitles() {
        final MutableLiveData<List<BreedTitle>> data = new MutableLiveData<>();

        Call<List<BreedTitle>> callApi = apiPlaceHolder.getApiBreedTitles();
        callApi.enqueue(new Callback<List<BreedTitle>>() {
            @Override
            public void onResponse(@NotNull Call<List<BreedTitle>> call, @NotNull Response<List<BreedTitle>> response) {

                if (!response.isSuccessful()) {
                    Log.e("sFetchBreedTitles", String.valueOf(response.code()));
                    return;
                }

                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<BreedTitle>> call, @NotNull Throwable t) {
                Log.e("fFetchBreedTitles", t.getMessage());
            }
        });
        return data;
    }
}

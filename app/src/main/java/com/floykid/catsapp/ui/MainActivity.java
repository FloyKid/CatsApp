package com.floykid.catsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.floykid.catsapp.R;
import com.floykid.catsapp.adapters.BreedTitlesAdapter;
import com.floykid.catsapp.models.BreedTitle;
import com.floykid.catsapp.viewmodels.BreedTitlesViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BreedTitlesViewModel mBreedTitlesViewModel;
    private List<BreedTitle> mBreedList = new ArrayList<>();
    BreedTitlesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new BreedTitlesAdapter(mBreedList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BreedTitlesAdapter.onItemClickListener() {
            @Override
            public void onItemClick(BreedTitle title) {
                Intent intent = new Intent(MainActivity.this, BreedDescriptionActivity.class);
                intent.putExtra(BreedDescriptionActivity.EXTRA_BREED, title);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mBreedTitlesViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(BreedTitlesViewModel.class);

        mBreedTitlesViewModel.init();

        mBreedTitlesViewModel.getBreedTitles().observe(this, new Observer<List<BreedTitle>>() {
            @Override
            public void onChanged(List<BreedTitle> breedTitles) {
                mBreedList.addAll(breedTitles);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}

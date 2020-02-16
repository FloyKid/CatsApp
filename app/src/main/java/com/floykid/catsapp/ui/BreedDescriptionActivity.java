package com.floykid.catsapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.floykid.catsapp.R;
import com.floykid.catsapp.models.BreedTitle;

import java.util.ArrayList;

public class BreedDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_BREED = "com.floykid.catsapp.EXTRA_BREED";

    private BreedTitle mBreedTitle;
    ArrayList<String> breedDescriptionParts;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_description);

        mTitle = findViewById(R.id.textView_description);

        mBreedTitle = getIntent().getParcelableExtra(EXTRA_BREED);

        breedDescriptionParts = mBreedTitle.getBreedTitleList();

        for (int i = 0; i < breedDescriptionParts.size(); i++) {
            mTitle.setText(mTitle.getText() + breedDescriptionParts.get(i) + "\n");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        breedDescriptionParts.clear();
    }
}

package com.floykid.catsapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BreedTitle implements Parcelable {

    private static final String TAG = "BreedTitle";

    private static ArrayList<String> mBreedTitleList = new ArrayList<>();

    @SerializedName("name")
    private String title;

    private String id;
    private String temperament;

    @SerializedName("lifeSpan")
    private String lifeSpan;

    @SerializedName("wikipediaUrl")
    private String wikipediaUrl;
    private String origin;

    @SerializedName("weightImperial")
    private String weightImperial;
    private int experimental;
    private int hairless;
    private int hypoallergenic;
    private int natural;
    private int rare;
    private int rex;

    @SerializedName("shortLegs")
    private int shortLegs;

    @SerializedName("suppressedTail")
    private int suppressedTail;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(temperament);
        dest.writeString(lifeSpan);
        dest.writeString(wikipediaUrl);
        dest.writeString(origin);
        dest.writeString(weightImperial);
        dest.writeInt(experimental);
        dest.writeInt(hairless);
        dest.writeInt(hypoallergenic);
        dest.writeInt(natural);
        dest.writeInt(rare);
        dest.writeInt(rex);
        dest.writeInt(shortLegs);
        dest.writeInt(suppressedTail);
    }

    public static final Parcelable.Creator<BreedTitle> CREATOR = new Parcelable.Creator<BreedTitle>() {
        @Override
        public BreedTitle createFromParcel(Parcel in) {
            return new BreedTitle(in);
        }

        @Override
        public BreedTitle[] newArray(int size) {
            return new BreedTitle[size];
        }
    };

    private BreedTitle(Parcel in) {
        id = in.readString();
        title = in.readString();
        temperament = in.readString();
        lifeSpan = in.readString();
        wikipediaUrl = in.readString();
        origin = in.readString();
        weightImperial = in.readString();
        experimental = in.readInt();
        hairless = in.readInt();
        hypoallergenic = in.readInt();
        natural = in.readInt();
        rare = in.readInt();
        rex = in.readInt();
        shortLegs = in.readInt();
        suppressedTail = in.readInt();
    }

    public ArrayList<String> getBreedTitleList() {
        mBreedTitleList.add(title);
        mBreedTitleList.add(temperament);
        mBreedTitleList.add(lifeSpan);
        mBreedTitleList.add(wikipediaUrl);
        mBreedTitleList.add(origin);
        mBreedTitleList.add(weightImperial);
        mBreedTitleList.add(Integer.toString(experimental));
        mBreedTitleList.add(Integer.toString(hairless));
        mBreedTitleList.add(Integer.toString(hypoallergenic));
        mBreedTitleList.add(Integer.toString(natural));
        mBreedTitleList.add(Integer.toString(rare));
        mBreedTitleList.add(Integer.toString(rex));
        mBreedTitleList.add(Integer.toString(shortLegs));
        mBreedTitleList.add(Integer.toString(suppressedTail));

        return mBreedTitleList;
    }

    public String getTitle() {
        return title;
    }

}

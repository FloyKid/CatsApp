package com.floykid.catsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.floykid.catsapp.R;
import com.floykid.catsapp.models.BreedTitle;

import java.util.List;

public class BreedTitlesAdapter extends RecyclerView.Adapter<BreedTitlesAdapter.ViewHolder> {

    private List<BreedTitle> mBreedTitles;
    private onItemClickListener listener;

    public BreedTitlesAdapter(List<BreedTitle> mBreedTitles) {
        this.mBreedTitles = mBreedTitles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breed_listitem,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.breedName.setText(mBreedTitles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mBreedTitles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout relativeLayout;
        private TextView breedName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.breed_listItem_layout);
            breedName = itemView.findViewById(R.id.breed_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(mBreedTitles.get(position));
                    }
                }
            });
        }
    }

    public interface onItemClickListener {
        void onItemClick(BreedTitle title);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }
}

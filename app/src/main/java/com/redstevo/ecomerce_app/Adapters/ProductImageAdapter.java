package com.redstevo.ecomerce_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.redstevo.ecomerce_app.R;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ViewHolder> {

    private final Context context;

    private final int imagesCount;

    private final ImageView imageView;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.circle_icon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageDrawable(context.getDrawable(R.drawable.image_video_ring));

        holder.cardView.setOnClickListener(view -> {
            Toast.makeText(context, position, Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return imagesCount;
    }

    @Getter
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        private final CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_selector);
            cardView = itemView.findViewById(R.id.image_selector_holder);
        }
    }
}

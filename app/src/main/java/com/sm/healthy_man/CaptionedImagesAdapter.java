package com.sm.healthy_man;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;




public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {


    private final String[] captions;
    private final int[] imagesId;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public CaptionedImagesAdapter(String[] captions, int[] imagesId) {
        this.captions = captions;
        this.imagesId = imagesId;
    }

    @NonNull
    @Override
  public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent, false);
      return new ViewHolder(cv);
  }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final CardView cardView = holder.cardView;

        ImageView imageView = cardView.findViewById(R.id.division_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imagesId[position]);
        imageView.setBackground(drawable);

        cardView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        private final CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }

    }
}


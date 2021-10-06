package com.sm.healthy_man;


import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;



public class CaptionedImagesAdapter2 extends RecyclerView.Adapter<CaptionedImagesAdapter2.ViewHolder> {


    private final String[] captions;
    private final int[] imagesId;
    private Listener listener;
    private final String[] stringDay;
    interface Listener
    {
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public CaptionedImagesAdapter2(String[] captions, int[] imagesId, String[] stringDay) {
        this.captions = captions;
        this.imagesId = imagesId;
        this.stringDay = stringDay;
    }

    @NonNull
    @Override
    public CaptionedImagesAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image2, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,  final int position) {
        final CardView cardView = holder.cardView;

        TextView textView = cardView.findViewById(R.id.day_text);
        textView.setText(stringDay[position]);

        ImageView imageView = cardView.findViewById(R.id.division_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imagesId[position]);
        imageView.setBackground(drawable);


        cardView.setOnClickListener(v -> {
            if (listener != null)
            {
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

        public ViewHolder(CardView v)
        {
            super(v);
            cardView = v;
        }

    }
}
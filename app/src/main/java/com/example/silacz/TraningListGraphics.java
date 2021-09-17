package com.example.silacz;

import androidx.annotation.NonNull;

public class TraningListGraphics {

    private final int imageId;



    public static final TraningListGraphics[] traningListGraphics = {
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),
            new TraningListGraphics(R.drawable.list_training),

    };

    public TraningListGraphics(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(imageId);
    }
}

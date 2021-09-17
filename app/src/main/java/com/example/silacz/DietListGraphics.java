package com.example.silacz;

import androidx.annotation.NonNull;

public class DietListGraphics {

    private final int imageId;


    public static final DietListGraphics[] dietListGraphics = {
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),
            new DietListGraphics(R.drawable.menu_dieta),




    };

    public DietListGraphics(int imageId) {
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

package com.example.silacz;

public class MenuGraphics {

    private int imageId;



    public static final MenuGraphics[] menuResource = {
            new MenuGraphics(R.drawable.menu_training),
            new MenuGraphics(R.drawable.menu_dieta),
            new MenuGraphics(R.drawable.menu_walking),
            new MenuGraphics(R.drawable.menu_chart),
            new MenuGraphics(R.drawable.menu_water),
            new MenuGraphics(R.drawable.menu_settings),
            new MenuGraphics(R.drawable.menu_reset),
            new MenuGraphics(R.drawable.menu_exit),

    };

    public MenuGraphics(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return String.valueOf(imageId);
    }
}

package com.sm.healthy_man;

import androidx.annotation.NonNull;

public class Musics {

    private final int imageId;
    private final String title;


    public static final Musics[] musicsList = {
            new Musics(R.raw.music1, "Vanze & Reunify - Angel"),
            new Musics(R.raw.music2, "S7EAZE - Outta Luck"),
            new Musics(R.raw.music3, "Nick Gunner - Lucid Dreaming"),
            new Musics(R.raw.music4, "Moco - Chimney Tonight"),
            new Musics(R.raw.music5, "Mister Ed - Go Hard"),
            new Musics(R.raw.music6, "Like We Did Before - Löwentanz"),
            new Musics(R.raw.music7, "Leil - Would You"),
            new Musics(R.raw.music8, "Elektronomia - Shine On"),
            new Musics(R.raw.music9, "Egzod & EMM - Game Over"),
            new Musics(R.raw.music10, "Alex Oliver - Occult"),

            new Musics(R.raw.music11, "Big Daddy Kave - Zombozo"),
            new Musics(R.raw.music12, "Bushey - That Mine"),
            new Musics(R.raw.music13, "Mindslip - 20 Below Zero"),
            new Musics(R.raw.music14, "LUKA & NIKO - Grind"),
            new Musics(R.raw.music15, "Kam Michael - Nothing New"),
            new Musics(R.raw.music16, "Dom Sarfo - Shine"),
            new Musics(R.raw.music17, "Diamond Eyes - Flutter"),
            new Musics(R.raw.music18, "Showdown - Freedom"),
            new Musics(R.raw.music19, "Schec - Like I Do"),
            new Musics(R.raw.music20, "Skurly - Stay With You"),

            new Musics(R.raw.music21, "Moco - Snowy"),
            new Musics(R.raw.music22, "Abstract - Still Woke"),
            new Musics(R.raw.music23, "KVBA - Memories"),
            new Musics(R.raw.music24, "Citizen Soldier - Soldier"),
            new Musics(R.raw.music25, "D.Rat Sinho Hervás - Afrodrugs"),
            new Musics(R.raw.music26, "Dr. Alban - It's My Life"),
            new Musics(R.raw.music27, "Mario Sterling - Changes"),
            new Musics(R.raw.music28, "Mindslip - Jade"),
            new Musics(R.raw.music29, "Breathing Theory - The Darkness"),
            new Musics(R.raw.music30, "Arc North - Raging"),
    };

    public Musics(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }



    @NonNull
    @Override
    public String toString() {
        return String.valueOf(imageId);
    }
}

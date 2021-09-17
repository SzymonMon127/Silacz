package com.example.silacz;


public class TrainingDayMassMedium {

    private String training1;
    private String training2;
    private String training3;
    private String training4;
    private String training5;
    private String training6;
    private String training7;
    private String training8;
    private String training9;
    private String training10;
    private String training11;
    private String training12;

    public static final TrainingDayMassMedium [] trainingDayMassMedium ={

            new TrainingDayMassMedium("Brzuszki x15" ,

                    "Izometryczne spięcie brzucha 20 sekund \n \n Przerwa 30 sekund" ,

                    "Naprzemienne podnoszenie nóg x5 na stronę" ,

                    "Rowerek 30 sekund" ,

                    "Double crunch x15 \n \n Przerwa 30 sekund" ,

                    "Mountain climber 30 sekund " ,

                    "Reverse crunches x15" ,

                    " Plank 30 sekund \n \n Przerwa 30 sekund" ,

                    "High stepping 30 sekund " ,

                    "Izometryczne spięcie brzucha 20 sekund"),
            new TrainingDayMassMedium("Przysiady x20" ,

                    "Krzesełko przy ścianie 30 sekund " ,

                    "Wykroków x20 \n \n Przerwa 30 sekund" ,

                    "Niskie podskoki x20" ,

                    "Przysiady sumo x20 " ,

                    "Przysiady z wyskokiem x10 \n \n Przerwa 30 sekund" ,

                    "Przysiady pulsacyjne x20 " ,

                    "Plank z unoszeniem nóg 30 sekund" ,

                    "Unoszenie nogi na boku x10 na stronę"),
            new TrainingDayMassMedium("Pompki x20" ,

                    "Pajacyki x20" ,

                    "Krążenie ramion 20 sekund \n \n Przerwa 30 sekund" ,

                    "Plank z podnoszeniem naprzemiennym rąk do przodu 30 sekund" ,

                    "Pompki strzeleckie x15" ,

                    "Pompki z zatrzymaniem na dole \n  3 sekundy x10 \n \n Przerwa 30 sekund" ,

                    "Pompki na podwyższeniu \n  (np. nogi na łóżku) x10" ,

                    "Pompki diamentowe x10" ,

                    "Dipy (na krzesłach) x20"),
            new TrainingDayMassMedium("WOLNE"),
            new TrainingDayMassMedium("Trucht w miejscu 30 sekund" ,

                    "Pajacyki x20 " ,

                    "Sprint w miejscu 30 sekund \n \n Przerwa 30 sekund" ,

                    "Podskoki (2 niższe potem 1 wyższy) x15" ,

                    "Skiping A 30 sekund" ,

                    "Skiping C 30 sekund \n \n Przerwa 30 sekund" ,

                    "Mountain climber energicznie 15 sekund" ,

                    "Stopy złączone, skok \n  do przodu i do tyłu x15 " ,

                    "Sprint w miejscu 30 sekund"),


            new TrainingDayMassMedium("Przysiady sumo  x20" ,

                    "Unoszenie bioder x20 \n \n Przerwa 30 sekund" ,

                    "Wykroki boczne x10 (jedna strona)" ,

                    "Wykopy w tył na czworaka x15 prawa strona " ,

                    "Wykopy w tył na czworaka x15 lewa strona " ,

                    "Wznoszenie nóg w leżeniu na boku \n x15 prawa strona" ,

                    "Wznoszenie nóg w leżeniu na boku x15 lewa strona"),
            new TrainingDayMassMedium("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x10" ,

                    "Siad płotkarski z wyprostowaną prawą nogą 30 sekund " ,

                    "Siad płotkarski z wyprostowaną lewą nogą  30 sekund \n \n Przerwa 30 sekund" ,

                    "Siad rozkroczny 30 sekund" ,

                    "Motylek 30 sekund" ,

                    "Powolne przenoszenie ciężaru ciała z lewa na prawo x8 razy " ,

                    "Przyciąganie prawego kolana do klatki piersiowej 20 sekund \n \n Przerwa 30 sekund" ,

                    "Przyciąganie lewego kolana do klatki piersiowej 20 sekund" ,

                    "Analogiczne przyciąganie pięty do pośladka (prawa noga) x8 razy" ,

                    "Analogiczne przyciąganie pięty do pośladka (lewa noga) x8 razy" ,

                    "Luźne podskoki na rozluźnienie mięśni x15"),
            new TrainingDayMassMedium("WOLNE"),
            new TrainingDayMassMedium("Brzuszki x20" ,

                    "Izometryczne spięcie brzucha 25 sekund \n \n Przerwa 30 sekund" ,

                    "Naprzemienne podnoszenie nóg 8 na stronę" ,

                    "Rowerek 35 sekund" ,

                    "Double crunch x20 \n \n Przerwa 30 sekund" ,

                    "Mountain climber 35 sekund" ,

                    "Reverse crunches x20 " ,

                    "Sekund plank x35 \n \n Przerwa 30 sekund" ,

                    "High stepping 35 sekund " ,

                    "Izometryczne spięcie brzucha 25 sekund"),
            new TrainingDayMassMedium("Przysiadów x25" ,

                    "Krzesełko przy ścianie 35 sekund " ,

                    "Wykroków x25 \n \n Przerwa 30 sekund " ,

                    "Niskie podskoki x25 " ,

                    "Przysiady sumo  x25 " ,

                    "Przysiadów z wyskokiem x25 \n \n Przerwa 30 sekund" ,

                    "Przysiadów pulsacyjnych x25 " ,

                    "Plank z unoszeniem nóg 35 sekund" ,

                    "Unoszenie nogi na boku 15 razy na stronę"),


            new TrainingDayMassMedium("Pompki zwykłe x25" ,

                    "Pajacyki x25" ,

                    "Krążenie ramion 20 sekund \n \n Przerwa 30 sekund" ,

                    "Plank z podnoszeniem naprzemiennym rąk do przodu 35 sekund" ,

                    "Pompki strzeleckie x15" ,

                    "Pompki z zatrzymaniem na dole po 3 sekundy x10 \n \n Przerwa 30 sekund" ,

                    "Pompki na podwyższeniu (np. nogi na łóżku) x10" ,

                    "Pompki diamentowe x12" ,

                    "Dipy (na krzesłach) x20"),
            new TrainingDayMassMedium("WOLNE"),
            new TrainingDayMassMedium("Trucht w miejscu 40 sekund" ,

                    "Pajacyki x25 " ,

                    "Sprint w miejscu 30 sekund \n \n Przerwa 30 sekund" ,

                    "Podskoki (2 niższe potem 1 wyższy) x15 " ,

                    "Skiping A 35 sekund" ,

                    "Skiping C 35 sekund \n \n Przerwa 30 sekund" ,

                    "Mountain climber energicznie 20 sekund" ,

                    "Stopy złączone, skok do przodu i do tyłu x20 " ,

                    "Sprint w miejscu 30 sekund"),
            new TrainingDayMassMedium("Przysiady sumo  x25" ,

                    "Unoszenie bioder x25 \n \n Przerwa 30 sekund" ,

                    "Wykroki boczne x15 (jedna strona)" ,

                    "Wykopy w tył na czworaka x20 prawa strona " ,

                    "Wykopy w tył na czworaka x20 lewa strona \n \n Przerwa 30 sekund" ,

                    "Wznoszenie nóg w leżeniu na boku x15 prawa strona" ,

                    "Wznoszenie nóg w leżeniu na boku x15 lewa strona"),
            new TrainingDayMassMedium("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x15" ,

                    "Siad płotkarski z wyprostowaną prawą nogą 40 sekund " ,

                    "Siad płotkarski z wyprostowaną lewą nogą  40 sekund" ,

                    "Siad rozkroczny 40 sekund \n \n Przerwa 30 sekund" ,

                    "Motylek 35 sekund" ,

                    "Powolne przenoszenie ciężaru ciała z lewa na prawo x8 " ,

                    "Przyciąganie prawego kolana do klatki piersiowej 20 sekund" ,

                    "Przyciąganie lewego kolana do klatki piersiowej 20 sekund \n \n Przerwa 30 sekund" ,

                    "Analogiczne przyciąganie pięty do pośladka (prawa noga) x8 " ,

                    "Analogiczne przyciąganie pięty do pośladka (lewa noga) x8 " ,

                    "Luźne podskoki na rozluźnienie mięśni x15"),

            new TrainingDayMassMedium("WOLNE"),
            new TrainingDayMassMedium("Brzuszki x25" ,

                    "Izometryczne spięcie brzucha 30 sekund \n \n Przerwa 30 sekund" ,

                    "Naprzemienne podnoszenie nóg x12 na stronę" ,

                    "Rowerek 35 sekund" ,

                    "25x Double crunch \n \n Przerwa 30 sekund" ,

                    "Sekund mountain climber 40 sekund" ,

                    "Reverse crunches x20" ,

                    "Plank 35 sekund" ,

                    "Przerwa 30 sekund" ,

                    "High stepping 35 sekund" ,

                    "Izometryczne spięcie brzucha 25 sekund"),
            new TrainingDayMassMedium("Przysiady x30" ,

                    "Krzesełko przy ścianie 40 sekund " ,

                    "Wykroki x30 \n \n Przerwa 30 sekund" ,

                    "Niskie podskoki x30" ,

                    "Przysiady sumo x30" ,

                    "Przysiady z wyskokiem x30 \n \n Przerwa 30 sekund" ,

                    "Przysiady pulsacyjne x30" ,

                    "Plank z unoszeniem nóg 35 sekund" ,

                    "Unoszenie nogi na boku 15 razy na stronę"),
            new TrainingDayMassMedium("Pompki x30" ,

                    "Pajacyki x30" ,

                    "Krążenie ramion 25 sekund \n \n Przerwa 30 sekund" ,

                    "Plank z podnoszeniem naprzemiennym rąk do przodu 35 sekund" ,

                    "Pompki strzeleckie x25" ,

                    "Pompki z zatrzymaniem 3 sekundy x15 \n \n Przerwa 30 sekund" ,

                    "Pompki na podwyższeniu (np. nogi na łóżku) x10" ,

                    "Pompki diamentowe x15" ,

                    "Dipy (na krzesłach) x25"),
            new TrainingDayMassMedium("WOLNE"),


            new TrainingDayMassMedium("Trucht w miejscu 50 sekund" ,

                    "Pajacyki x30 " ,

                    "Sprint w miejscu 35 sekund \n \n Przerwa 30 sekund" ,

                    "Podskoki (2 niższe potem 1 wyższy) x20 " ,

                    "Skiping A 35 sekund" ,

                    "Skiping C 35 sekund \n \n Przerwa 30 sekund" ,

                    "Mountain climber energicznie 25 sekund" ,

                    "Stopy złączone, skok do przodu i do tyłu x20 " ,

                    "Sprint w miejscu 35 sekund"),
            new TrainingDayMassMedium("Przysiady sumo x30" ,

                    "Unoszenie bioder x30 \n \n Przerwa 30 sekund" ,

                    "Wykroki boczne x20 (jedna strona)" ,

                    "Wykopy w tył na czworaka x20 prawa strona " ,

                    "Wykopy w tył na czworaka x20 lewa strona \n \n Przerwa 30 sekund" ,

                    "Wznoszenie nóg w leżeniu na boku x20 prawa strona" ,

                    "Wznoszenie nóg w leżeniu na boku x20 lewa strona"),
            new TrainingDayMassMedium("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x20" ,

                    "Siad płotkarski z wyprostowaną prawą nogą 50 sekund " ,

                    "Siad płotkarski z wyprostowaną lewą nogą  50 sekund" ,

                    "Siad rozkroczny 50 sekund" ,

                    "Przerwa 30 sekund" ,

                    "Motylek 40 sekund" ,

                    "Powolne przenoszenie ciężaru ciała z lewa na prawo x10 " ,

                    "Przyciąganie prawego kolana do klatki piersiowej 25 sekund" ,

                    "Przyciąganie lewego kolana do klatki piersiowej 25 sekund \n \n Przerwa 30 sekund" ,

                    "Analogiczne przyciąganie pięty do pośladka (prawa noga) x10 " ,

                    "Analogiczne przyciąganie pięty do pośladka (lewa noga) x10 " ,

                    "Luźne podskoki na rozluźnienie mięśni x20"),
            new TrainingDayMassMedium("WOLNE"),
            new TrainingDayMassMedium("Brzuszki x30" ,

                    "Izometryczne spięcie brzucha 35 sekund \n \n Przerwa 30 sekund" ,

                    "Naprzemienne podnoszenie nóg x15 na stronę" ,

                    "Rowerek 40 sekund" ,

                    "Double crunch x25 \n \n Przerwa 30 sekund" ,

                    "Mountain climber 45 sekund" ,

                    "Reverse crunches x25" ,

                    "Plank 40 sekund \n \n Przerwa 30 sekund" ,

                    "High stepping 35 sekund" ,

                    "Izometryczne spięcie brzucha 30 sekund"),


            new TrainingDayMassMedium("35 przysiadów" ,

                    "Krzesełko przy ścianie 45 sekund " ,

                    "35 wykroków \n \n Przerwa 30 sekund" ,

                    "35 Niskie podskoki " ,

                    "35 Przysiady sumo" ,

                    "35 przysiadów z wyskokiem \n \n Przerwa 30 sekund" ,

                    "Przysiady pulsacyjne x35 " ,

                    "Plank z unoszeniem nóg 35 sekund" ,

                    "Unoszenie nogi na boku x30 na stronę"),
            new TrainingDayMassMedium("Pompki x 35" ,

                    "Pajacyki 35" ,

                    "Krążenie ramion 25 sekund \n \n Przerwa 30 sekund" ,

                    "Plank z podnoszeniem naprzemiennym rąk do przodu 35 sekund" ,

                    "Pompki strzeleckie x30" ,

                    "Pompki z zatrzymaniem 3 sekundy x20 \n \n Przerwa 30 sekund" ,

                    "Pompki na podwyższeniu (np. nogi na łóżku) x15" ,

                    "Pompki diamentowe x15" ,

                    "Dipy (na krzesłach) x30"),
            new TrainingDayMassMedium("WOLNE"),
            new TrainingDayMassMedium("Trucht w miejscu 50 sekund" ,

                    "Pajacyki x30 " ,

                    "Sprint w miejscu 35 sekund \n \n Przerwa 30 sekund" ,

                    "Podskoki (2 niższe potem 1 wyższy) 30 razy" ,

                    "Skiping A 35 sekund" ,

                    "Skiping C 35 sekund \n \n Przerwa 30 sekund" ,

                    "Mountain climber energicznie 35 sekund" ,

                    "Stopy złączone i skok do przodu i do tyłu 25 razy" ,

                    "Sprint w miejscu 40 sekund"),
            new TrainingDayMassMedium("Przysiady sumo  x40" ,

                    "Unoszenie bioder x40 \n \n Przerwa 30 sekund" ,

                    "Wykroki boczne x25 (jedna strona)" ,

                    "Wykopy w tył na czworaka x25 prawa strona " ,

                    "Wykopy w tył na czworaka x25 lewa strona \n \n Przerwa 30 sekund" ,

                    "Wznoszenie nóg w leżeniu na boku x25 prawa strona" ,

                    "Wznoszenie nóg w leżeniu na boku x25 lewa strona"),




            };

    public TrainingDayMassMedium() {
    }

    public TrainingDayMassMedium(String training1) {
        this.training1 = training1;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5, String training6) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5, String training6, String training7) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
        this.training9 = training9;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10, String training11) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
        this.training9 = training9;
        this.training10 = training10;
        this.training11 = training11;
    }

    public TrainingDayMassMedium(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10, String training11, String training12) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
        this.training9 = training9;
        this.training10 = training10;
        this.training11 = training11;
        this.training12 = training12;
    }

    public TrainingDayMassMedium (String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
        this.training9 = training9;
        this.training10 = training10;






    } // cons

    public String getTraining1() {
        return training1;
    }

    public String getTraining2() {
        return training2;
    }

    public String getTraining3() {
        return training3;
    }

    public String getTraining4() {
        return training4;
    }

    public String getTraining5() {
        return training5;
    }

    public String getTraining6() {
        return training6;
    }

    public String getTraining7() {
        return training7;
    }

    public String getTraining8() {
        return training8;
    }

    public String getTraining9() {
        return training9;
    }

    public String getTraining10() {
        return training10;
    }

    public String getTraining11() {
        return training11;
    }

    public String getTraining12() {
        return training12;
    }

    public static TrainingDayMassMedium[] getTrainingDayMassMedium() {
        return trainingDayMassMedium;
    } // gett
}

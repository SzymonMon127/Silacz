package com.example.silacz;

public class TrainingDayMassHard {

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

    public static final TrainingDayMassHard [] trainingDayMassHard =
            {

                    new TrainingDayMassHard("Brzuszki x25" ,

                            "Izometryczne spięcie brzucha 25 sekund \n \n Przerwa 30 sekund" ,

                            "Naprzemienne podnoszenie nóg x7 na stronę" ,

                            "Rowerek 45 sekund" ,

                            "Double crunch x20 \n \n Przerwa 30 sekund" ,

                            "Mountain climber 45 sekund " ,

                            "Reverse crunches x20" ,

                            " Plank 45 sekund \n \n Przerwa 30 sekund" ,

                            "High stepping 45 sekund " ,

                            "Izometryczne spięcie brzucha 25 sekund"),
                    new TrainingDayMassHard("Przysiadów x25" ,

                            "Krzesełko przy ścianie 35 sekund 2 serie" ,

                            "Wykroków x25 \n \n Przerwa 30 sekund" ,

                            "Niskie podskoki x25 " ,

                            "Przysiady sumo  x25 " ,

                            "Przysiadów z wyskokiem x25 \n \n Przerwa 30 sekund" ,

                            "Przysiadów pulsacyjnych x25 " ,

                            "Plank z unoszeniem nóg 35 sekund" ,

                            "Unoszenie nogi na boku 15 razy na stronę"),
                    new TrainingDayMassHard("Pompki zwykłe x25" ,

                            "Pajacyki x25" ,

                            "Krążenie ramion 20 sekund \n \n Przerwa 30 sekund" ,

                            "Plank z podnoszeniem naprzemiennym rąk do przodu 35 sekund" ,

                            "Pompki strzeleckie x15" ,

                            "Pompki z zatrzymaniem na dole po 3 sekundy x10 \n \n Przerwa 30 sekund" ,

                            "Pompki na podwyższeniu (np. nogi na łóżku) x10" ,

                            "Pompki diamentowe x12" ,

                            "Dipy (na krzesłach) x20"),
                    new TrainingDayMassHard("WOLNE"),
                    new TrainingDayMassHard("Trucht w miejscu 40 sekund" ,

                            "Pajacyki x25 " ,

                            "Sprint w miejscu 30 sekund \n \n Przerwa 30 sekund" ,

                            "Podskoki (2 niższe potem 1 wyższy) x15 " ,

                            "Skiping A 35 sekund" ,

                            "Skiping C 35 sekund \n \n Przerwa 30 sekund" ,

                            "Mountain climber energicznie 20 sekund" ,

                            "Stopy złączone, skok do przodu i do tyłu x20 " ,

                            "Sprint w miejscu 30 sekund"),

                    new TrainingDayMassHard("Przysiady sumo  x25" ,

                            "Unoszenie bioder x25  \n \n Przerwa 30 sekund" ,

                            "Wykroki boczne x15 (jedna strona)" ,

                            "Wykopy w tył na czworaka x20 prawa strona " ,

                            "Wykopy w tył na czworaka x20 lewa strona \n \n Przerwa 30 sekund" ,

                            "Wznoszenie nóg w leżeniu na boku x15 prawa strona" ,

                            "Wznoszenie nóg w leżeniu na boku x15 lewa strona"),
                    new TrainingDayMassHard("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x15" ,

                            "Siad płotkarski z wyprostowaną prawą nogą 40 sekund " ,

                            "Siad płotkarski z wyprostowaną lewą nogą  40 sekund" ,

                            "Siad rozkroczny 40 sekund \n \n  \n \n Przerwa 30 sekund" ,

                            "Motylek 35 sekund" ,

                            "Powolne przenoszenie ciężaru ciała z lewa na prawo x8 " ,

                            "Przyciąganie prawego kolana do klatki piersiowej 20 sekund" ,

                            "Przyciąganie lewego kolana do klatki piersiowej 20 sekund \n \n  \n \n Przerwa 30 sekund" ,

                            "Analogiczne przyciąganie pięty do pośladka (prawa noga) x8 " ,

                            "Analogiczne przyciąganie pięty do pośladka (lewa noga) x8 " ,

                            "Luźne podskoki na rozluźnienie mięśni x15"),
                    new TrainingDayMassHard("WOLNE"),
                    new TrainingDayMassHard("Brzuszki x30" ,

                            "Izometryczne spięcie brzucha 30 sekund \n \n Przerwa 30 sekund" ,

                            "Naprzemienne podnoszenie nóg x10 na stronę" ,

                            "Rowerek 50 sekund" ,

                            "Double crunch x25 \n \n Przerwa 30 sekund" ,

                            "Mountain climber 50 sekund " ,

                            "Reverse crunches x25" ,

                            " Plank 50 sekund \n \n Przerwa 30 sekund" ,

                            "High stepping 50 sekund " ,

                            "Izometryczne spięcie brzucha 30 sekund"),
                    new TrainingDayMassHard("Przysiadów x30" ,

                            "Krzesełko przy ścianie 40 sekund 2 serie" ,

                            "Wykroków x30 \n \n Przerwa 30 sekund" ,

                            "Niskie podskoki x30" ,

                            "Przysiady sumo  x30 " ,

                            "Przysiadów z wyskokiem x30 \n \n Przerwa 30 sekund" ,

                            "Przysiadów pulsacyjnych x30 " ,

                            "Plank z unoszeniem nóg 40 sekund" ,

                            "Unoszenie nogi na boku 20 razy na stronę"),

                    new TrainingDayMassHard("Pompki zwykłe x30" ,

                            "Pajacyki x30" ,

                            "Krążenie ramion 20 sekund  \n \n Przerwa 30 sekund" ,

                            "Plank z podnoszeniem naprzemiennym rąk do przodu 40 sekund" ,

                            "Pompki strzeleckie x20" ,

                            "Pompki z zatrzymaniem na dole po 3 sekundy x15  \n \n Przerwa 30 sekund" ,

                            "Pompki na podwyższeniu (np. nogi na łóżku) x15" ,

                            "Pompki diamentowe x15" ,

                            "Dipy (na krzesłach) x25"),
                    new TrainingDayMassHard("WOLNE"),
                    new TrainingDayMassHard("Trucht w miejscu 45 sekund" ,

                            "Pajacyki x30" ,

                            "Sprint w miejscu 35 sekund \n \n Przerwa 30 sekund" ,

                            "Podskoki (2 niższe potem 1 wyższy) x20 " ,

                            "Skiping A 40 sekund" ,

                            "Skiping C 40 sekund  \n \n Przerwa 30 sekund" ,

                            "Mountain climber energicznie 25 sekund" ,

                            "Stopy złączone, skok do przodu i do tyłu x25 " ,

                            "Sprint w miejscu 35 sekund"),
                    new TrainingDayMassHard("Przysiady sumo  x30" ,

                            "Unoszenie bioder x30 \n \n Przerwa 30 sekund" ,

                            "Wykroki boczne x20 (jedna strona)" ,

                            "Wykopy w tył na czworaka x25 prawa strona " ,

                            "Wykopy w tył na czworaka x25 lewa strona \n \n Przerwa 30 sekund" ,

                            "Wznoszenie nóg w leżeniu na boku x20 prawa strona" ,

                            "Wznoszenie nóg w leżeniu na boku x20 lewa strona"),
                    new TrainingDayMassHard("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x20" ,

                            "Siad płotkarski z wyprostowaną prawą nogą 45 sekund " ,

                            "Siad płotkarski z wyprostowaną lewą nogą  45 sekund" ,

                            "Siad rozkroczny 45 sekund \n \n Przerwa 30 sekund" ,

                            "Motylek 40 sekund" ,

                            "Powolne przenoszenie ciężaru ciała z lewa na prawo x12 " ,

                            "Przyciąganie prawego kolana do klatki piersiowej 25 sekund" ,

                            "Przyciąganie lewego kolana do klatki piersiowej 25 sekund \n \n Przerwa 30 sekund" ,

                            "Analogiczne przyciąganie pięty do pośladka (prawa noga) x12" ,

                            "Analogiczne przyciąganie pięty do pośladka (lewa noga) x12 " ,

                            "Luźne podskoki na rozluźnienie mięśni x20"),

                    new TrainingDayMassHard("WOLNE"),
                    new TrainingDayMassHard("Brzuszki x35" ,
                            "Izometryczne spięcie brzucha 35 sekund \n \n Przerwa 30 sekund" ,
                            "Naprzemienne podnoszenie nóg x15 na stronę" ,
                            "Rowerek 55 sekund" ,
                            "Double crunch x30 \n \n Przerwa 30 sekund" ,
                            "Mountain climber 55 sekund " ,
                            "Reverse crunches x30" ,
                            " Plank 55 sekund \n \n Przerwa 30 sekund" ,
                            "High stepping 55 sekund " ,
                            "Izometryczne spięcie brzucha 35 sekund"),
                    new TrainingDayMassHard("Przysiadów x35\t" ,
                            "Krzesełko przy ścianie 45 sekund 2 serie" ,
                            "Wykroków x35 \n \n Przerwa 30 sekund" ,
                            "Niskie podskoki x35 " ,
                            "Przysiady sumo  x35 " ,
                            "Przysiadów z wyskokiem x35 \n \n Przerwa 30 sekund" ,
                            "Przysiadów pulsacyjnych x35 " ,
                            "Plank z unoszeniem nóg 45 sekund" ,
                            "Unoszenie nogi na boku 25 razy na stronę"),
                    new TrainingDayMassHard("Pompki zwykłe x35" ,
                            "Pajacyki x35" ,
                            "Krążenie ramion 20 sekund \n \n Przerwa 30 sekund" ,
                            "Plank z podnoszeniem naprzemiennym rąk do przodu 45 sekund" ,
                            "Pompki strzeleckie x25" ,
                            "Pompki z zatrzymaniem na dole po 3 sekundy x20 \n \n Przerwa 30 sekund" ,
                            "Pompki na podwyższeniu (np. nogi na łóżku) x20" ,
                            "Pompki diamentowe x18" ,
                            "Dipy (na krzesłach) x30"),
                    new TrainingDayMassHard("WOLNE"),

                    new TrainingDayMassHard("Trucht w miejscu 50 sekund" ,
                            "Pajacyki x35" ,
                            "Sprint w miejscu 40 sekund \n \n Przerwa 30 sekund" ,
                            "Podskoki (2 niższe potem 1 wyższy) x25" ,
                            "Skiping A 45 sekund" ,
                            "Skiping C 45 sekund \n \n Przerwa 30 sekund" ,
                            "Mountain climber energicznie 30 sekund" ,
                            "Stopy złączone, skok do przodu i do tyłu x30" ,
                            "Sprint w miejscu 40 sekund"),
                    new TrainingDayMassHard("Przysiady sumo  x35" ,
                            "Unoszenie bioder x35 \n \n Przerwa 30 sekund" ,
                            "Wykroki boczne x25 (jedna strona)" ,
                            "Wykopy w tył na czworaka x30 prawa strona " ,
                            "Wykopy w tył na czworaka x30 lewa strona \n \n Przerwa 30 sekund" ,
                            "Wznoszenie nóg w leżeniu na boku x25 prawa strona" ,
                            "Wznoszenie nóg w leżeniu na boku x25 lewa strona"),
                    new TrainingDayMassHard("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x25" ,
                            "Siad płotkarski z wyprostowaną prawą nogą 50 sekund " ,
                            "Siad płotkarski z wyprostowaną lewą nogą  50 sekund" ,
                            "Siad rozkroczny 50 sekund \n \n Przerwa 30 sekund" ,
                            "Motylek 45 sekund" ,
                            "Powolne przenoszenie ciężaru ciała z lewa na prawo x15" ,
                            "Przyciąganie prawego kolana do klatki piersiowej 30 sekund" ,
                            "Przyciąganie lewego kolana do klatki piersiowej 30 sekund \n \n Przerwa 30 sekund" ,
                            "Analogiczne przyciąganie pięty do pośladka (prawa noga) x15" ,
                            "Analogiczne przyciąganie pięty do pośladka (lewa noga) x15" ,
                            "Luźne podskoki na rozluźnienie mięśni x25"),
                    new TrainingDayMassHard("WOLNE"),
                    new TrainingDayMassHard("Brzuszki x40" ,
                            "Izometryczne spięcie brzucha 40 sekund \n \n Przerwa 30 sekund" ,
                            "Naprzemienne podnoszenie nóg x18 na stronę" ,
                            "Rowerek 60 sekund" ,
                            "Double crunch x35 \n \n Przerwa 30 sekund" ,
                            "Mountain climber 60 sekund " ,
                            "Reverse crunches x35" ,
                            " Plank 60 sekund \n \n Przerwa 30 sekund" ,
                            "High stepping 60 sekund " ,
                            "Izometryczne spięcie brzucha 40 sekund"),

                    new TrainingDayMassHard("Przysiadów x40" ,
                            "Krzesełko przy ścianie 50 sekund 2 serie" ,
                            "Wykroków x40 \n \n Przerwa 30 sekund" ,
                            "Niskie podskoki x40" ,
                            "Przysiady sumo  x40 " ,
                            "Przysiadów z wyskokiem x40 \n \n Przerwa 30 sekund" ,
                            "Przysiadów pulsacyjnych x40" ,
                            "Plank z unoszeniem nóg 50 sekund" ,
                            "Unoszenie nogi na boku 30 razy na stronę"),
                    new TrainingDayMassHard("Pompki zwykłe x40" ,
                            "Pajacyki x40" ,
                            "Krążenie ramion 20 sekund \n \n Przerwa 30 sekund" ,
                            "Plank z podnoszeniem naprzemiennym rąk do przodu 50 sekund" ,
                            "Pompki strzeleckie x30" ,
                            "Pompki z zatrzymaniem na dole po 3 sekundy x25 \n \n Przerwa 30 sekund" ,
                            "Pompki na podwyższeniu (np. nogi na łóżku) x25" ,
                            "Pompki diamentowe x21" ,
                            "Dipy (na krzesłach) x35"),
                    new TrainingDayMassHard("WOLNE"),
                    new TrainingDayMassHard("Trucht w miejscu 55 sekund" ,
                            "Pajacyki x40" ,
                            "Sprint w miejscu 45 sekund \n \n Przerwa 30 sekund" ,
                            "Podskoki (2 niższe potem 1 wyższy) x30" ,
                            "Skiping A 50 sekund" ,
                            "Skiping C 50 sekund \n \n Przerwa 30 sekund" ,
                            "Mountain climber energicznie 35 sekund" ,
                            "Stopy złączone, skok do przodu i do tyłu x35" ,
                            "Sprint w miejscu 45 sekund"),
                    new TrainingDayMassHard("Przysiady sumo  x40" ,

                            "Unoszenie bioder x40 \n \n Przerwa 30 sekund" ,
                            "Wykroki boczne x35 (jedna strona)" ,
                            "Wykopy w tył na czworaka x35 prawa strona " ,
                            "Wykopy w tył na czworaka x35 lewa strona \n \n Przerwa 30 sekund" ,
                            "Wznoszenie nóg w leżeniu na boku x30 prawa strona" ,
                            "Wznoszenie nóg w leżeniu na boku x30 lewa strona")
            };

    public TrainingDayMassHard() {
    }

    public TrainingDayMassHard(String training1) {
        this.training1 = training1;
    }

    public TrainingDayMassHard(String training1, String training2, String training3, String training4, String training5) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
    }

    public TrainingDayMassHard(String training1, String training2, String training3, String training4, String training5, String training6) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
    }

    public TrainingDayMassHard(String training1, String training2, String training3, String training4, String training5, String training6, String training7) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
    }

    public TrainingDayMassHard(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
    }

    public TrainingDayMassHard(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9) {
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

    public TrainingDayMassHard(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10, String training11) {
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

    public TrainingDayMassHard (String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10) {
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

    public static TrainingDayMassHard[] getTrainingDayMassHard() {
        return trainingDayMassHard;
    } // gett
}

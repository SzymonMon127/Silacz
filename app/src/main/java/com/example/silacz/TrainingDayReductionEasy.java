package com.example.silacz;

public class TrainingDayReductionEasy {

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


    public static final TrainingDayReductionEasy [] trainingDayReductionEasy =
            {
                    new TrainingDayReductionEasy("Brzuszki x5", "Izometryczne spięcie brzucha 8s \n \n Przerwa  30s", "Naprzemienne podnoszenie nóg x3 na strone ", "Rowerek 10s", "Double crunch x5 \n \n Przerwa 30s",  "Mountain climber 15s", "Reverse crunches x5",  "Plank 10s \n \n Przerwa 30s", "High stepping 15s", "Izometryczne spięcie brzucha 10s"),
                    new TrainingDayReductionEasy("Przysiady x5 "," Krzesełko przy ścianie 10s "," Wykroki x5 \n \n Przerwa 30s "," Niskie podskoki x10 "," Przysiady sumo x5 "," Przysiady z wyskokiem x5 \n \n Przerwa 30s "," Przysiady pulsacyjne x5 "," Plank z unoszeniem nóg 10s "," Unoszenie nogi na boku x5 na strone "),
                    new TrainingDayReductionEasy("Bieganie 2km "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Trucht w miejscu 15s "," Pajacyki x10 "," Sprint w miejscu 15s \n \n Przerwa 30s "," Podskoki (2 niższe potem 1 wyższy) x5 "," Skiping A 15s "," Skiping C 15s \n \n Przerwa 30s "," Mountain climber energicznie 5s "," Stopy złączone"," skok do przodu i do tyłu x5 "," Sprint w miejscu 15s "),
                    new TrainingDayReductionEasy("Przysiady sumo x5 "," Unoszenie bioder x5 \n \n Przerwa 30s "," Wykroki boczne x5 na strone "," Wykopy w tył na czworaka x5 na strone \n \n Przerwa 30s "," Wznoszenie nóg w leżeniu na boku x15 na stronę "),
                    new TrainingDayReductionEasy("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x5 "," Siad płotkarski z wyprostowaną prawą nogą 10s "," Siad płotkarski z wyprostowaną lewą nogą 10s "," Siad rozkroczny 15s "," Motylek 15s "," Powolne przenoszenie ciężaru ciała z lewa na prawo x4 "," Przyciąganie prawego kolana do klatki piersiowej 10s "," Przyciąganie lewego kolana do klatki piersiowej 10s "," Analogiczne przyciąganie pięty do pośladka (prawa noga) x4 "," Analogiczne przyciąganie pięty do pośladka (lewa noga) x4 "," Luźne podskoki na rozluźnienie mięśni x10 "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Brzuszki x10 "," Izometryczne spięcie brzucha  10s \n \n Przerwa 30s "," Naprzemienne podnoszenie nóg x5 na strone "," Rowerek 15s "," Double crunch x10 \n \n Przerwa 30s "," Mountain climber 20s "," Reverse crunches x8 "," Plank 15s \n \n Przerwa 30s "," High stepping 20s "," Izometryczne spięcie brzucha 10s "),
                    new TrainingDayReductionEasy("Przysiady x8 "," Krzesełko przy ścianie 10s "," Wykroki x5 \n \n Przerwa 30s "," Niskie podskoki x12 "," Przysiady sumo x7 "," Przysiady z wyskokiem x7 \n \n Przerwa 30s "," Przysiady pulsacyjne x7 "," Plank z unoszeniem nóg 10s "," Unoszenie nogi na boku x8 na strone "),
                    new TrainingDayReductionEasy("Bieganie 2km "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Trucht w miejscu 20s "," Pajacyki x12 "," Sprint w miejscu 20s \n \n Przerwa 30s "," Podskoki (2 niższe potem 1 wyższy) x7 "," Skiping A 20s "," Skiping C 20s \n \n Przerwa 30s "," Mountain climber energicznie "," 7s "," Stopy złączone"," skok do przodu i do tyłu x7 "," Sprint w miejscu 20s "),
                    new TrainingDayReductionEasy("Przysiady sumo x7 "," Unoszenie bioder x7 \n \n Przerwa 30s "," Wykroki boczne x7 na strone "," Wykopy w tył na czworaka x7 na strone \n \n Przerwa 30s "," Wznoszenie nóg w leżeniu na boku x15 na stronę "),
                    new TrainingDayReductionEasy("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x7 "," Siad płotkarski z wyprostowaną prawą nogą 15s "," Siad płotkarski z wyprostowaną lewą nogą 15s "," Siad rozkroczny 15s "," Motylek 20s "," Powolne przenoszenie ciężaru ciała z lewa na prawo x8 "," Przyciąganie prawego kolana do klatki piersiowej 15s "," Przyciąganie lewego kolana do klatki piersiowej 15s "," Analogiczne przyciąganie pięty do pośladka (prawa noga) x7 "," Analogiczne przyciąganie pięty do pośladka (lewa noga) x7 "," Luźne podskoki na rozluźnienie mięśni x15 "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Brzuszki x15 "," Izometryczne spięcie brzucha  15s \n \n Przerwa 30s "," Naprzemienne podnoszenie nóg x10 na strone "," Rowerek 20s "," Double crunch x15 \n \n Przerwa 30s "," Mountain climber 25s "," Reverse crunches x10 "," Plank 20s \n \n Przerwa 30s "," High stepping 25s "," Izometryczne spięcie brzucha 15s "),
                    new TrainingDayReductionEasy("Przysiady x10 "," Krzesełko przy ścianie 15s "," Wykroki x7 \n \n Przerwa 30s "," Niskie podskoki x15 "," Przysiady sumo x10 "," Przysiady z wyskokiem x10 \n \n Przerwa 30s "," Przysiady pulsacyjne x10 "," Plank z unoszeniem nóg 15s "," Unoszenie nogi na boku x10 na strone "),
                    new TrainingDayReductionEasy("Bieganie 2km "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Trucht w miejscu 25s "," Pajacyki x15 "," Sprint w miejscu 25s \n \n Przerwa 30s "," Podskoki (2 niższe potem 1 wyższy) x10 "," Skiping A 25s "," Skiping C 25s \n \n Przerwa 30s "," Mountain climber energicznie 10s "," Stopy złączone"," skok do przodu i do tyłu x10 "," Sprint w miejscu 20s "),
                    new TrainingDayReductionEasy("Przysiady sumo x10 "," Unoszenie bioder x10 \n \n Przerwa 30s "," Wykroki boczne x10 na strone "," Wykopy w tył na czworaka x10 na strone \n \n Przerwa 30s "," Wznoszenie nóg w leżeniu na boku x18 na stronę "),
                    new TrainingDayReductionEasy("W rozkroku pochylamy się i próbujemy dotknąć ziemi (z pogłębieniem) x10 "," Siad płotkarski z wyprostowaną prawą nogą 20s "," Siad płotkarski z wyprostowaną lewą nogą 20s "," Siad rozkroczny 20s "," Motylek 25s "," Powolne przenoszenie ciężaru ciała z lewa na prawo x10 "," Przyciąganie prawego kolana do klatki piersiowej 20s "," Przyciąganie lewego kolana do klatki piersiowej 20s "," Analogiczne przyciąganie pięty do pośladka (prawa noga) x10 "," Analogiczne przyciąganie pięty do pośladka (lewa noga) x10 "," Luźne podskoki na rozluźnienie mięśni x20 "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Brzuszki x10 "," Izometryczne spięcie brzucha  20s \n \n Przerwa 30s "," Naprzemienne podnoszenie nóg x15 na strone "," Rowerek 25s "," Double crunch x20 \n \n Przerwa 30s "," Mountain climber 30s "," Reverse crunches x15 "," Plank 25s \n \n Przerwa 30s "," High stepping 30s "," Izometryczne spięcie brzucha 20s "),
                    new TrainingDayReductionEasy("Przysiady x10 "," Krzesełko przy ścianie 20s "," Wykroki x10 \n \n Przerwa 30s "," Niskie podskoki x15 "," Przysiady sumo x15 "," Przysiady z wyskokiem x15 \n \n Przerwa 30s "," Przysiady pulsacyjne x15 "," Plank z unoszeniem nóg 20s "," Unoszenie nogi na boku x15 na strone "),
                    new TrainingDayReductionEasy("Bieganie 2km "),
                    new TrainingDayReductionEasy("WOLNE"),
                    new TrainingDayReductionEasy("Trucht w miejscu 30s "," Pajacyki x20 "," Sprint w miejscu 30s \n \n Przerwa 30s "," Podskoki (2 niższe potem 1 wyższy) x15 "," Skiping A 30s "," Skiping C 30s \n \n Przerwa 30s "," Mountain climber energicznie 15s "," Stopy złączone"," skok do przodu i do tyłu x15 "," Sprint w miejscu 25s "),
                    new TrainingDayReductionEasy("Przysiady sumo x15 "," Unoszenie bioder x15 \n \n Przerwa 30s "," Wykroki boczne x15 na strone "," Wykopy w tył na czworaka x15 na strone \n \n Przerwa 30s "," Wznoszenie nóg w leżeniu na boku x18 na stronę "),
            };


    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
    }

    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
        this.training8 = training8;
    }

    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5, String training6, String training7) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
        this.training7 = training7;
    }

    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5, String training6) {
        this.training1 = training1;
        this.training2 = training2;
        this.training3 = training3;
        this.training4 = training4;
        this.training5 = training5;
        this.training6 = training6;
    }

    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9) {
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

    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10) {
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
    }

    public TrainingDayReductionEasy(String training1, String training2, String training3, String training4, String training5, String training6, String training7, String training8, String training9, String training10, String training11) {
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



    public TrainingDayReductionEasy(String training1) {
        this.training1 = training1;
    }

    public TrainingDayReductionEasy() {
    }

    public String getTraining9() {
        return training9;
    }

    public String getTraining10() {
        return training10;
    } // getter

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

    public String getTraining11() {
        return training11;
    }

    public static TrainingDayReductionEasy[] getTrainingDayReductionEasy() {
        return trainingDayReductionEasy;
    } // getters



}



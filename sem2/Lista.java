package com.company;

public class Lista {
    static class ObiektListy {
        Osoba element;
        ObiektListy nastepny = null;
    }
    ObiektListy pierwszy;

    public void drukuj() {
        ObiektListy biezacy = pierwszy;
        while(biezacy.nastepny != null) {
            System.out.println(biezacy.element);
            biezacy = biezacy.nastepny;
        }
        System.out.println(biezacy.element);
    }
    public boolean zamien(int ktory, String nowe) {
        ObiektListy biezacy = pierwszy;
        for(int j=0; j<ktory&&biezacy!=null; j++) {
            biezacy = biezacy.nastepny;
        }
        if(biezacy==null) return false;
        else {
            biezacy.element.nazwisko = nowe;
            return true;
        }
    }
    public boolean zamien(int ktory, String nowe, String imie) {
        ObiektListy biezacy = pierwszy;
        for(int j=0; j<ktory&&biezacy!=null; j++) {
            biezacy = biezacy.nastepny;
        }
        if(biezacy==null) return false;
        else {
            biezacy.element.nazwisko = nowe;
            biezacy.element.imie = imie;
            return true;
        }
    }
    public static void main(String[] args) {
        Lista obiekt = new Lista();
        String[][] dane = {{"Wiśniak", "Janusz", "1965-12-09"},{"Żabiński", "Zbigniew","1987-04-09"},{"Nowak", "Jan", "1990-03-07"},{"Cegielski", "Jakub", "1994-06-02"}};
        obiekt.pierwszy = new ObiektListy();

        ObiektListy pierwszy = obiekt.pierwszy;
        pierwszy.element = new Osoba("Wiśniewski", "Kazimierz", "1982-12-03");
        ObiektListy kolejny = pierwszy;

        for(int i=0; i<dane.length; i++) {
            kolejny.nastepny = new ObiektListy();
            kolejny = kolejny.nastepny;
            kolejny.element = new Osoba(dane[i][0], dane[i][1], dane[i][2]);
        }

        obiekt.drukuj();
        obiekt.zamien(2, "Leszczyński", "Andrzej");
        System.out.println();
        obiekt.drukuj();
    }
}

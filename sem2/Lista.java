package com.company;

public class Lista {
    static class ObiektListy {
        Osoba element;
        ObiektListy nastepny = null;
    }

    public static void main(String[] args) {
        Lista lista = new Lista();
        String[][] dane = {{"Wiśniak", "Janusz", "1965-12-09"},{"Żabiński", "Zbigniew","1987-04-09"},{"Nowak", "Jan", "1990-03-07"}};
        ObiektListy pierwszy = new ObiektListy();
        pierwszy.element = new Osoba("Wiśniewski", "Kazimierz", "1982-12-03");
        ObiektListy kolejny = pierwszy;
        for(int i=1; i<4; i++) { //lista jednokierunkowa
            kolejny.nastepny = new ObiektListy();
            kolejny = kolejny.nastepny;
            kolejny.element = new Osoba(dane[i-1, i-1, i-1]);
        }
    }
}

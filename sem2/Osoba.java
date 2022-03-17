package com.company;

import java.text.Collator;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Locale;

public class Osoba implements Comparable<Osoba> {
    @Override
    public int compareTo(Osoba o) {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));
        int porownanieNazwisk = c.compare(this.nazwisko, o.nazwisko);
        int porownanieImion = c.compare(this.imie, o.nazwisko);
        if(porownanieNazwisk == 0) return porownanieImion;
        return porownanieNazwisk;
    }

    String nazwisko = "Kowalski";
    String imie = "Jan";
    String dataUr = "1990-10-12";
    static LocalDate dzisiaj = LocalDate.now();
    static int bRok = dzisiaj.getYear();

    public Osoba () {}

    public Osoba (String nazwisko, String imie, String dataUr) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.dataUr = dataUr;
    }
    public String toString() {
        return nazwisko + " " + imie + " " + dataUr + " wiek " + String.format("%6.2f", wiek(dataUr));
    }
    public double wiek(String dataUr) {
        String[] data = dataUr.split("-");
        LocalDate urodzenie = LocalDate.of(Integer.parseInt(data[0]),
                Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        Period per = Period.between(urodzenie, dzisiaj);
        return per.getYears()+per.getMonths()/12.0+per.getDays()/365.0;

    }

    public static void main(String[] args) {
        Osoba osoba = new Osoba();
        new Osoba("Kowalski", "Jan", "1989-12-02");
    }
}

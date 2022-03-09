package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Kopiec<T extends Comparable<T>> {
    ArrayList<T> lista = new ArrayList<>();


    public boolean czyJestKopcem() {
        int dlugosc = lista.size();
        boolean jestKopcem = true;
        for(int k = 1; k< lista.size(); k++){
            if(2*k>=dlugosc) return true;
            jestKopcem = lista.get(k).compareTo(lista.get(2*k))>=0;
            if(2*k+1>=dlugosc) return jestKopcem;
            jestKopcem = jestKopcem && lista.get(k).compareTo(lista.get(2*k+1))>=0;
            if(!jestKopcem) return false;
        }
        return true;
    }

    public void utworzKopiec() {
        int N = lista.size();
        for(int k=N/2; k>=1; k--) zanurzanie(k);
    }

    public void zanurzanie(int k) {
        int N = lista.size() - 1;
        int j;
        while (2*k<=N) {
            j=2*k;
            if(j<N && lista.get(j).compareTo(lista.get(j+1))<0) j++;
            if(!(lista.get(k).compareTo(lista.get(j))<0)) break;
            T pom=lista.get(k);
            lista.set(k, lista.get(j));
            lista.set(j, pom);
            k=j;
        }
    }

    public void zanurzanie(int k, int N) {
        int j;
        while (2*k<=N) {
            j=2*k;
            if(j<N && lista.get(j).compareTo(lista.get(j+1))<0) j++;
            if(!(lista.get(k).compareTo(lista.get(j))<0)) break;
            T pom=lista.get(k);
            lista.set(k, lista.get(j));
            lista.set(j, pom);
            k=j;
        }
    }

    public void wynurzanie(int k) {
        T pom;
        while (k>1 && lista.get(k/2).compareTo(lista.get(k))<0) {
            pom = lista.get(k);
            lista.set(k, lista.get(k/2));
            lista.set(k/2, pom);
            k = k/2;
        }
    }

    public void drukuj() {
        for(int i = 0; i < lista.size(); i++)
            System.out.print(lista.get(i) + " ");
        System.out.println();
    }

    public void sortuj() {
        int N = lista.size()-1;
        utworzKopiec();
        while (N>1) {
            T pom = lista.get(1);
            lista.set(1, lista.get(N));
            lista.set(N--, pom);
            zanurzanie(1, N);
        }
    }
    public void dopisz(T dopisywany) {
        lista.add(dopisywany);
        wynurzanie(lista.size()-1);
    }
    public T pobierzPierwszego() {
        T pom = lista.get(1);
        lista.set(1, lista.get(lista.size()-1));
        lista.remove(lista.size()-1);
        zanurzanie(1);
        return pom;
    }

    public static void main(String[] args) {
        Kopiec<Osoba> kopiecO = new Kopiec<>();
        kopiecO.dopisz(new Osoba());
        kopiecO.dopisz(new Osoba());
        kopiecO.dopisz(new Osoba("Nowak", "Janusz","1999-10-06"));
        kopiecO.dopisz(new Osoba("Żabiński", "Zbigniew","1978-03-09"));
        kopiecO.drukuj();
        kopiecO.pobierzPierwszego();

        kopiecO.drukuj();
    }
}

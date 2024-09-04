package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {
    public static void main(String[] args) {
        int[] a = randPerm(10);
        int[] b = new int[] {77,4,2,74,23,56,77,32,41,90,21,21,21};
        System.out.println(antallUlikeUsortert(b));
    }

    //plass for oppgave 0

    /**
    * OPPGAVE 1 - FINN STØRSTE TALL
    * a) Det vil være n - 1 sammenlikninger av tabellen, med denne metoden.
    * b) Det vil være færrest ombyttninger hvis tabellen er sortert fra minst til størst. (0)
    * c) Og flest dersom største verdien er første elementet i tabellen(n - 1 ombyttninger).
    * d) Mangler gjennomsnitt.
    *
    * På grunn av at det er færre optimaliseringer, samt at vi har flere tabelloperasjoner der de andre har ingen,
    * vil denne metoden generelt være tregere. Unntak er om vi har kun 1 verdi, da vi ikke initialiserer nye variabler,
    * og bare returnerer verdien som er tilstede.
     **/

    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen kan ikke være tom!");
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i, i - 1);
            }
        }
        return a[a.length - 1];
    }

//kopi av maks-metoden
    public static int ombyttninger(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen kan ikke være tom!");
        }
        int ombyttninger = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                bytt(a, i, i - 1);
                ombyttninger++;
            }
        }
        return ombyttninger;
    }

    //Kopi av programkode 1.1.8 e), brukt for tilfeldige permutasjoner av tabeller.
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n
        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }
        return a;                        // permutasjonen returneres
    }

    private static void bytt(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /** OPPGAVE 2 - ANTALL ULIKE (SORTERT)
     *
    **/

    public static int antallUlikeSortert(int[] a) {
        if (a.length < 1) return 0;

        int antallUlike = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                throw new IllegalStateException("Tabellen er ikke sortert stigende!");
            }
            else if(a[i - 1] < a[i]) {
                antallUlike++;
            }
        }
        return antallUlike;
    }

    /** OPPGAVE 3 - ANTALL ULIKE (USORTERT)
     *
    **/
    public static int antallUlikeUsortert(int[] a) {
        if (a.length < 1) return 0;

        int antallUlike = 0;
        for (int i = 0; i < a.length; i++) {
            int j;
            for (j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]){
                    break;
                }
            }
            if (j == a.length) {
                antallUlike++;
            }
        }
        return antallUlike;
    }
}
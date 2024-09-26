package com.btcag.bootcamp;

import java.util.Scanner;

public class Sortieren {

    public static int[] sortieren(int[] zahlen){
        for (int i = zahlen.length; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (zahlen[j] > zahlen[(j + 1)]) {
                    int currZahl = zahlen[j];
                    int nextZahl = zahlen[(j + 1)];
                    zahlen[j] = nextZahl;
                    zahlen[(j + 1)] = currZahl;
                }
            }
        }
        return zahlen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] zahlen = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Gibt eine Ganzzahl ein");
            zahlen[i] = scanner.nextInt();
            System.out.println();
        }
        sortieren(zahlen);

        System.out.println("Der Größe nach geordnet:");

        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + " ");
        }


    }
}

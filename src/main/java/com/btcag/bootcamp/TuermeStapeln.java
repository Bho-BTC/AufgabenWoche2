package com.btcag.bootcamp;
import java.util.Scanner;
public class TuermeStapeln {
    public static void turmVerlegen (int hoehe){
        int scheibe1

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib die Höhe des Turms ein.");
        int turmHoehe = scanner.nextInt();

        int[] stab1 = new int [turmHoehe];
        int[] stab2 = new int [turmHoehe];
        int[] stab3 = new int [turmHoehe];

        turmVerlegen(turmHoehe);

//      überlegung von Ablauf
//      1 2 3 4    0 0 0 0     0 0 0 0
//      0 2 3 4    0 0 0 1     0 0 0 0
//      0 0 3 4    0 0 0 1     0 0 0 2
//      0 0 0 4    0 0 0 3     0 0 1 2
//      0 0 1 4    0 0 2 3     0 0 0 0
//      0 0 0 0    0 1 2 3     0 0 0 4
//      0 0 0 2    0 0 0 3     0 0 1 4
//      0 0 1 2    0 0 0 0     0 0 3 4
//      0 0 0 2    0 0 0 1     0 0 3 4
//      0 0 0 0    0 0 0 0     1 2 3 4
    }
}

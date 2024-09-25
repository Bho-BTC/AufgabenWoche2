package com.btcag.bootcamp;

import java.util.Scanner;

public class QuadratischeGleichungen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a = ");
        double a = scanner.nextDouble();

        System.out.println("b = ");
        double b = scanner.nextDouble();

        System.out.println("c = ");
        double c = scanner.nextDouble();


        double bSquare = b * b;

        double fourAC = 4 * (a * c);

        double diskriminante = bSquare - fourAC;

        double nullstellen = 0;
        if (diskriminante > 0) {
            nullstellen = 2;
        } else if (diskriminante == 0) {
            nullstellen = 1;
        } else if (diskriminante < 0) {
            nullstellen = 0;
        }

        System.out.println("Die Gleichung a =" + a + "x², b = " + b + "x, c = " + c + " hat " + nullstellen + " Nullstellen/Lösungen.");
    }
}

package com.btcag.bootcamp;
import java.util.Scanner;
public class ImmerPositiv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib eine Ganzzahl ein:");
        int zahl = scanner.nextInt();

        if(zahl <0){
            zahl*=-1;
        }
        System.out.println("Der positive Wert ist: "+zahl);

    }






}

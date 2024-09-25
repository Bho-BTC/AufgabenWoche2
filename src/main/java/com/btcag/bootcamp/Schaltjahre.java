package com.btcag.bootcamp;
import java.util.Scanner;
public class Schaltjahre {

    public static boolean istSchaltJahr (int jahr){
        if(jahr%400 == 0){
            return true;
        } else if (jahr%100==0) {
            return false;
        } else return jahr % 4 == 0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben sie ein Jahr ein um zu prüfen, ob es ein Schaltjahr ist.");
        int jahr=scanner.nextInt();
        String einKein="";
        if (istSchaltJahr(jahr)){
            einKein=" ein ";
        }else {
            einKein = " kein ";
        }

        System.out.println("Das Jahr "+ jahr+ " ist"+einKein+ "Schaltjahr.");



    }
}

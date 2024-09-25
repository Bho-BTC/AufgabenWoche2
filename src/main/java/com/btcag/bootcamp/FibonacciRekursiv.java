package com.btcag.bootcamp;

import java.util.Scanner;

public class FibonacciRekursiv {
    public static int firstNbr = 0;
    public static int secondNbr = 1;

    public static int fibonacci(int maxRounds) {
        int newNbr = secondNbr;
        secondNbr += firstNbr;
        firstNbr = newNbr;
        if (maxRounds > 1) {
            maxRounds--;
            fibonacci(maxRounds);
        }
        return secondNbr;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Die wievielte Fibonacci Zahl willst du haben?");
        int input = scanner.nextInt();
        System.out.println("Die " + input + ". Fibonaccizahl ist " + fibonacci(input));
    }


}

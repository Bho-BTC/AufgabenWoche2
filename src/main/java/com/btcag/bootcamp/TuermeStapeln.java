package com.btcag.bootcamp;

import java.util.Scanner;

public class TuermeStapeln {
    public static int[][] towers = {
            {4, 3, 2, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };
    private static int getInput(String message) {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println(message);
            input = sc.nextInt();
        } while (input > 3 || input < 1);
        return input;
    }

    //holt den intex der ersten disk des QuellTurms, sonst gibt -1
    public static int getSourceIndex(int tower) {
        for (int i = towers[tower].length - 1; i >= 0; i--) {
            if (towers[tower][i] != 0) {
                return i;
            }
        }
        return -1;
    }
    public static int getFreeIndex(int tower) {
        for (int i = 0; i < towers[tower].length; i++) {
            if (towers[tower][i] == 0) {
                return i;
            }
        }
        return -1;
    }
    public static void printTowers() {
        int rows = towers[0].length;
        int columns = towers.length;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                System.out.print("|" + towers[j][i] + "| ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        while (!(towers[2][0] == 4 && towers[2][1] == 3 && towers[2][2] == 2 && towers[2][3] == 1)) {
            printTowers();
            int sourceIndex;
            int destinationIndex;
            int source;
            int destination;
            boolean valid = false;
            do {
                valid = false;
                do {
                    do {
                        source = getInput("Von welchen Turm wollen sie eine Disk bewegen?") - 1;
                        System.out.println();
                        destination = getInput("Zu welchem Turm soll die Disk bewegt werden?") - 1;
                    } while (source == destination);
                    destinationIndex = getFreeIndex(destination);
                    sourceIndex = getSourceIndex(source);
                } while (sourceIndex == -1 || destinationIndex == -1);
                if (destinationIndex != 0) {
                    if (towers[source][sourceIndex] < towers[destination][destinationIndex - 1]) {
                        towers[destination][destinationIndex] = towers[source][sourceIndex];
                        towers[source][sourceIndex] = 0;
                        valid = true;
                    }
                } else {
                        towers[destination][destinationIndex] = towers[source][sourceIndex];
                        towers[source][sourceIndex] = 0;
                        valid = true;
                }
            } while (!valid);
        }
        printTowers();
        System.out.println("Solved :) ");
    }
}

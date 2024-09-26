package com.btcag.bootcamp;

import java.util.Scanner;

public class vierGewinnt {
    public static String[] playerNames = getNames();
    public static String[][] field = new String[7][6];


    //------------------------------------------------------Namen abfragen-------------------------------------------------------------------
    public static String[] getNames() {
        Scanner scanner = new Scanner(System.in);
        String player1;
        String player2;
        String[] players = new String[2];
        do {
            System.out.println("Bitte gibt den Namen des ersten Spielers an. Namen müssen mindestens 3 Zeichen und dürfen höchstens 15 Zeichen lang sein.");
            player1 = scanner.next();
        } while (player1.length() < 3 || player1.length() > 15);

        do {
            System.out.println("Bitte gibt den Namen des zweiten Spielers an. Namen müssen mindestens 3 Zeichen und dürfen höchstens 15 Zeichen lang sein.");
            player2 = scanner.next();
        } while (player2.length() < 3 || player2.length() > 15);

        players[0] = player1;
        players[1] = player2;

        return players;
    }

    //--------------------------------------------------Spielfeld ausgeben------------------------------------------------------------------
    public static void drawField() {
        int rowCount = 0;
        int maxRow = 7;
        int maxColumn = 6;
        while (rowCount < maxRow) {
            int columnCount = 0;
            System.out.println();
            while (columnCount < maxColumn) {
                if (field[rowCount][columnCount] == "x") {
                    System.out.print("[ x ]  ");
                } else if (field[rowCount][columnCount] == "o") {
                    System.out.print("[ o ]  ");
                } else {
                    System.out.print("[   ]  ");
                }
                columnCount++;
            }
            rowCount++;
        }
    }

    //-------------------------------------------spielen aka turn aufrufen-----------------------------------------------------------
    public static String play(String[] playerNames) {
        int turnCount = 0;
        String player1 = playerNames[0];
        String player2 = playerNames[1];
        String winner = "";
        boolean gameWon = false;

        if (turnCount % 2 == 0) {
            turn(player1);
            turnCount++;
        } else {
            turn(player2);
            turnCount++;
        }
        return winner;

    }

    public static boolean oneOrTwo = true;

    //----------------------------------------------------------------turn----------------------------------------------------------------------
    public static void turn(String playerName) {
        Scanner scanner = new Scanner(System.in);
        int chipColumn;
        if (oneOrTwo) { //turn für spieler 1
            int rowNbr = -1;
            boolean columnFree;
            do {
                do {
                    System.out.println(playerName + " in welche Spalte wollen wollen sie Ihren Chip setzen?");
                    chipColumn = scanner.nextInt();
                    columnFree = true;
                } while (chipColumn < 1 || chipColumn > 6);
                for (int i = 0; i < 7; i++) {
                    if (field[i][(chipColumn - 1)] != "x" && field[i][(chipColumn - 1)] != "o") {
                        rowNbr = i;
                    }
                }
                if (rowNbr < 0) {
                    columnFree = false;
                }
            } while (!columnFree);

            field[rowNbr][(chipColumn - 1)] = "x";
            oneOrTwo = (!oneOrTwo);
        } else {
            int rowNbr = -1;
            boolean columnFree;
            do {
                do {
                    System.out.println(playerName + " in welche Spalte wollen wollen sie Ihren Chip setzen?");
                    chipColumn = scanner.nextInt();
                    columnFree = true;
                } while (chipColumn < 1 || chipColumn > 6);

                for (int i = 0; i < 7; i++) {
                    if (field[i][(chipColumn - 1)] != "x" && field[i][(chipColumn - 1)] != "o") {
                        rowNbr = i;
                    }
                }
                if (rowNbr < 0) {
                    columnFree = false;
                }
            } while (!columnFree);

            field[rowNbr][(chipColumn - 1)] = "o";
            oneOrTwo = (!oneOrTwo);
        }
        drawField();


        play(playerNames);


    }

    public static boolean checkWin() {

        for (int i = 0; i < 7; i++) {

        }

    }


    public static void main(String[] args) {
        System.out.println(playerNames[0] + "                                       " + playerNames[1]);
        drawField();
        play(playerNames);


    }


}

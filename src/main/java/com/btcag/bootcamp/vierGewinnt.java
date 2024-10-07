package com.btcag.bootcamp;

import java.util.Scanner;

public class vierGewinnt {
    public static String[] playerNames = getNames();
    public static String[][] field = new String[6][7];
    public static int turnCount = 0;
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
        int maxRow = 6;
        int maxColumn = 7;
        while (rowCount < maxRow) {
            int columnCount = 0;
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
            System.out.println();
            rowCount++;
        }
    }

    //-------------------------------------------spielen aka turn aufrufen-----------------------------------------------------------
    public static String play(String[] playerNames) {

        String player1 = playerNames[0];
        String player2 = playerNames[1];
        String winner;

        if (!checkWin()) {

            if (turnCount % 2 == 0) {
                turnCount++;
                turn(player1);
            } else {
                turnCount++;
                turn(player2);
            }
        }

        if (turnCount % 2 == 0) {
            winner = player2;
        } else {
            winner = player1;
        }
        return winner;
    }

    public static boolean oneOrTwo = true;

    //----------------------------------------------------------------turn----------------------------------------------------------------------
    public static void turn(String playerName) {
        Scanner scanner = new Scanner(System.in);
        int chipColumn;
        int rowNbr = -1;
        if (oneOrTwo) { //turn für Spieler 1
            boolean columnFree;
            do {
                do {
                    System.out.println(playerName + " in welche Spalte wollen wollen sie Ihren Chip setzen?");
                    chipColumn = scanner.nextInt();
                    columnFree = true;
                } while (chipColumn < 1 || chipColumn > 7);

                for (int i = 0; i < 6; i++) {
                    if (field[i][(chipColumn - 1)] != "x" && field[i][(chipColumn - 1)] != "o") {
                        rowNbr = i;
                    }
                }
                if (rowNbr < 0) {
                    columnFree = false;
                }
            } while (!columnFree);

            field[rowNbr][(chipColumn - 1)] = "x";
        } else {
            boolean columnFree;
            do {
                do {
                    System.out.println(playerName + " in welche Spalte wollen wollen sie Ihren Chip setzen?");
                    chipColumn = scanner.nextInt();
                    columnFree = true;
                } while (chipColumn < 1 || chipColumn > 7);

                for (int i = 0; i < 6; i++) {
                    if (field[i][(chipColumn - 1)] != "x" && field[i][(chipColumn - 1)] != "o") {
                        rowNbr = i;
                    }
                }
                if (rowNbr < 0) {
                    columnFree = false;
                }
            } while (!columnFree);

            field[rowNbr][(chipColumn - 1)] = "o";
        }
        oneOrTwo = (!oneOrTwo);
        drawField();
        play(playerNames);
    }
    //------------------------------------------------------Check Win-----------------------------------------------------------------------
    public static boolean checkWin() {
        String[] players = {"x", "o"};

        for (String player : players) {
            //---------------------------------------Check horizontal-------------------------------------------------------------------
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    if (field[i][j] == player && field[i][j + 1] == player && field[i][j + 2] == player && field[i][j + 3] == player) {
                        return true;
                    }
                }
            }
            //----------------------------------------Check vertikal---------------------------------------------------------------------
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[j][i] == player && field[j + 1][i] == player && field[j + 2][i] == player && field[j + 3][i] == player) {
                        return true;
                    }
                }
            }
            //----------------------------------------Check oben link nach unten rechts------------------------------------------------------------
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (field[i][j] == player && field[i + 1][j + 1] == player && field[i + 2][j + 2] == player && field[i + 3][j + 3] == player) {
                        return true;
                    }
                }
            }
            //---------------------------------------------Check unten links nach oben rechts-------------------------------------------------
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == player && field[i - 1][j + 1] == player && field[i - 2][j + 2] == player && field[i - 3][j + 3] == player) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(playerNames[0] + "                                       " + playerNames[1]);
        drawField();
        System.out.println("Der Spieler: " + play(playerNames) + " hat das Spiel in " + turnCount + " Zügen gewonnen.");
    }
}
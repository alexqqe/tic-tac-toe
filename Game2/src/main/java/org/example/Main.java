package org.example;

import java.io.IOException;

public class Main {
    private enum Cell {
        X, O, EMPTY
    }
    private int moveNumber = 0;

    private Cell[][] field;

    public Main() {
        field = initializeGame();
    }

    public void run() {
        while (isMoveAvailable()) {
            System.out.println(formatGame());

            Cell winner = checkWin();
            if (winner != Cell.EMPTY) {
                System.out.println("The winner is " + winner); // win

                return;
            }

            checkInput();
        }
        System.out.println("draw"); // draw
    }

    private Cell[][] initializeGame() {
        field = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = Cell.EMPTY;
            }
        }
        return field;
    }

    private void checkInput() {
        System.out.println("Input your position in format {letter}{number}");
        try {
            int rawValue = System.in.read() - 'a';
            int colValue = System.in.read() - 49;

            if (colValue < 0 || colValue > 2 || rawValue < 0 || rawValue > 2) {
                throw new IllegalArgumentException("Letter need to be in 'abc' and number in '123'; a=" + rawValue + ", b=" + colValue);
            }

            move(rawValue, colValue);

        } catch (IOException ie) {
            System.out.println(ie.toString());
//            ie.printStackTrace();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.toString());
        }
    }

    private void move(int raw, int col) {
        if (field[raw][col] != Cell.EMPTY) throw new IllegalArgumentException("Occupied cell");
        field[raw][col] = (moveNumber % 2 == 0 ? Cell.X : Cell.O);
        moveNumber++;
    }

    private String formatGame() {
        StringBuilder board = new StringBuilder();
        board.append("   1 2 3\n");
        board.append("  ------\n");

        for (int i = 0; i < 3; i++) {
            board.append((char) ('a' + i)).append("| ");
            for (int j = 0; j < 3; j++) {
                board.append(field[i][j] == Cell.EMPTY ? "_" : field[i][j]).append(" ");
            }
            board.append("\n");
        }
        return board.toString();
    }

    private boolean isMoveAvailable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == Cell.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    private Cell checkWin() {
        // rows
        for (int i = 0; i < 3; i++) {
            if (field[i][0] != Cell.EMPTY && field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                return field[i][0];
            }
        }

        // columns
        for (int j = 0; j < 3; j++) {
            if (field[0][j] != Cell.EMPTY && field[0][j] == field[1][j] && field[1][j] == field[2][j]) {
                return field[0][j];
            }
        }

        // diagonals
        if (field[0][0] != Cell.EMPTY && field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            return field[0][0];
        }
        if (field[0][2] != Cell.EMPTY && field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            return field[0][2];
        }

        return Cell.EMPTY;
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.run();
    }
}
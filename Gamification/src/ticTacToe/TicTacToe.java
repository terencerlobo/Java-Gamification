package ticTacToe;

import java.util.Scanner;

public class TicTacToe {
	


    private static final char EMPTY = ' ';
    private static final char X = 'X';
    private static final char O = 'O';
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = X;
        gameEnded = false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row and column (0, 1, 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != EMPTY) {
                System.out.println("Invalid move!");
            } else {
                board[row][col] = currentPlayer;
                checkGameState(row, col);
                currentPlayer = (currentPlayer == X) ? O : X;
            }
        }
        scanner.close();
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    private void checkGameState(int row, int col) {
        if (checkRow(row) || checkColumn(col) || (row == col && checkDiagonal()) || (row + col == 2 && checkAntiDiagonal())) {
            printBoard();
            System.out.println("Player " + currentPlayer + " wins!");
            gameEnded = true;
        } else if (isBoardFull()) {
            printBoard();
            System.out.println("The game is a draw!");
            gameEnded = true;
        }
    }

    private boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    private boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    private boolean checkDiagonal() {
        return board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer;
    }

    private boolean checkAntiDiagonal() {
        return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }

}

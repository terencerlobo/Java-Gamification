package sudoku;

import java.util.Scanner;

public class SudokuGame {
	


    private static final int SIZE = 9;
    private static final int EMPTY = 0; 
    private static int[][] board = {
        {5, 3, EMPTY, EMPTY, 7, EMPTY, EMPTY, EMPTY, EMPTY},
        {6, EMPTY, EMPTY, 1, 9, 5, EMPTY, EMPTY, EMPTY},
        {EMPTY, 9, 8, EMPTY, EMPTY, EMPTY, EMPTY, 6, EMPTY},
        {8, EMPTY, EMPTY, EMPTY, 6, EMPTY, EMPTY, EMPTY, 3},
        {4, EMPTY, EMPTY, 8, EMPTY, 3, EMPTY, EMPTY, 1},
        {7, EMPTY, EMPTY, EMPTY, 2, EMPTY, EMPTY, EMPTY, 6},
        {EMPTY, 6, EMPTY, EMPTY, EMPTY, EMPTY, 2, 8, EMPTY},
        {EMPTY, EMPTY, EMPTY, 4, 1, 9, EMPTY, EMPTY, 5},
        {EMPTY, EMPTY, EMPTY, EMPTY, 8, EMPTY, EMPTY, 7, 9}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!isSolved()) {
            printBoard();
            System.out.println("Enter row, column, and number to fill (1-9, separated by spaces): ");
            int row = scanner.nextInt() - 1; 
            int col = scanner.nextInt() - 1;
            int num = scanner.nextInt();

            if (isValidPlacement(row, col, num)) {
                board[row][col] = num;
            } else {
                System.out.println("Invalid placement. Try again.");
            }
        }
        System.out.println("Congratulations! You've solved the puzzle!");
        scanner.close();
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isValidPlacement(int row, int col, int num) {
        return !isInRow(row, num) && !isInCol(col, num) && !isInBox(row, col, num);
    }

    private static boolean isInRow(int row, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInCol(int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInBox(int row, int col, int num) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}

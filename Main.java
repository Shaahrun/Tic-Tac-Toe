package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static char[][] cells = new char[3][3];

    public static void main(String[] args) {
        // write your code here
        /*System.out.println("X O X");
        System.out.println("O X O");
        System.out.println("X X O");*/


        int points = 3 * 3;
        int countO = 0;
        int countX = 0;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println("Enter cells: " + input);
        System.out.println("---------");

        //int i = 0;
        //while (i < 3)
        int fill = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cells[i][j] = input.charAt(fill);
                    if (cells[i][j] == 'X') {
                        countX++;
                    } else if (cells[i][j] == 'O') {
                        countO++;
                    }
                    fill++;
                }
            }

        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case (0):
                        System.out.printf("| %c ", cells[k][j]);
                        break;
                    case (1):
                        System.out.printf("%c ", cells[k][j]);
                        break;
                    case (2):
                        System.out.printf("%c |\n", cells[k][j]);
                        break;
                }
                //System.out.print(cells[k][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("---------");

        String gnf = "Game not finished";
        String draw = "Draw";
        String xwin = "X wins";
        String owin = "O wins";
        String impossible = "Impossible";


        boolean winX = hasAll('X');
        boolean winO = hasAll('O');
        boolean notPossible = (winO && winX) || Math.abs(countO - countX) > 1;
        boolean equal = countO + countX == 9;

        if (winX && !winO) {
            System.out.println(xwin);
        } else if (winO && !winX) {
            System.out.println(owin);
        } else if (notPossible) {
            System.out.println(impossible);
        } else if (equal) {
            System.out.println(draw);
        } else {
            System.out.println(gnf);
        }

    }

    private static boolean hasAll(char o) {
        boolean check;
        for (int i = 0; i < 3; i++) {
            check = true;
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] != o) {
                    check = false;
                    break;
                }
            }
            if (check) return true;

            check = true;
            for (int j = 0; j < 3; j++) {
                if (cells[j][i] != o) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
        }
        check = true;
        for (int i = 0; i < 3; i++) {
            if (cells[i][i] != o) {
                check = false;
                break;
            }
        }
        if (check) return true;

        check = true;
        for (int i = 0; i < 3; i++) {
            if (cells[i][2 - i] != o) {
                check = false;
                break;
            }
        }
        return check;
    }
}

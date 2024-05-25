/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1100
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhiteBlock {

    private static final int BOARD_SIZE = 8;
    private static final char PIECE = 'F';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

        for (int n = 0; n < BOARD_SIZE; n++) {
            board[n] = bufferedReader.readLine().toCharArray();
        }

        System.out.print(solution(board));
    }

    private static int solution(char[][] board) {
        int count = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if ((i + j) % 2 == 0 && board[i][j] == PIECE) {
                    count++;
                }
            }
        }

        return count;
    }
}

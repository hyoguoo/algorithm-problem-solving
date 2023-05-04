/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1018
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RepaintChessboard {
    public static final int CHESSBOARD_LENGTH = 8;
    public static char[][] CHESSBOARD;
    public static int M;
    public static int N;
    public static char BLACK = 'B';
    public static char WHITE = 'W';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = numbers[0];
        N = numbers[1];
        CHESSBOARD = new char[M][N];

        for (int i = 0; i < M; i++) {
            char[] row = bufferedReader.readLine().toCharArray();
            System.arraycopy(row, 0, CHESSBOARD[i], 0, N);
        }

        System.out.println(findMinCount());
    }

    private static int findMinCount() {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i <= M - CHESSBOARD_LENGTH; i++) {
            for (int j = 0; j <= N - CHESSBOARD_LENGTH; j++) {
                minCount = Math.min(minCount, getCount(i, j, BLACK));
                minCount = Math.min(minCount, getCount(i, j, WHITE));
            }
        }
        return minCount;
    }

    private static int getCount(int i, int j, char startColor) {
        int count = 0;
        for (int x = i; x < i + CHESSBOARD_LENGTH; x++) {
            for (int y = j; y < j + CHESSBOARD_LENGTH; y++) {
                char correctColor = getCorrectColor(startColor, i, j, x, y);
                if (CHESSBOARD[x][y] != correctColor) count++;
            }
        }
        return count;
    }

    private static char getCorrectColor(char startColor, int i, int j, int x, int y) {
        int opposite = (x - i + y - j) % 2;
        if (startColor == BLACK) {
            if (opposite == 0) return BLACK;
            else return WHITE;
        } else {
            if (opposite == 0) return WHITE;
            else return BLACK;
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2447
 * Cheat Level: 0
 * Algorithm: Implementation / Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CreateStar10 {

    final static char STAR = '*';
    final static char SPACE = ' ';
    final static int DIVIDE = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int N) {
        char[][] result = new char[N][N];
        for (char[] chars : result) Arrays.fill(chars, SPACE);
        recursion(result, 0, 0, N);
        return charArrayToString(result);
    }

    private static void recursion(char[][] result, int startN, int startM, int size) {
        if (size == 1) {
            result[startN][startM] = STAR;
            return;
        }

        for (int n = 0; n < DIVIDE; n++) {
            for (int m = 0; m < DIVIDE; m++) {
                if (n == 1 && m == 1) continue;
                recursion(result, startN + n * (size / DIVIDE), startM + m * (size / DIVIDE), size / DIVIDE);
            }
        }
    }

    private static String charArrayToString(char[][] result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : result) stringBuilder.append(chars).append("\n");
        return stringBuilder.toString();
    }
}

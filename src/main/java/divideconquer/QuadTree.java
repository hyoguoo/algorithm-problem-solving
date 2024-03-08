/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1992
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class QuadTree {

    static final char OPEN_PARENTHESIS = '(';
    static final char CLOSE_PARENTHESIS = ')';
    static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = bufferedReader.readLine().toCharArray();
        }

        solution(matrix, 0, 0, n);
        System.out.println(stringBuilder);
    }

    private static void solution(char[][] matrix, int n, int m, int length) {
        recursion(matrix, n, m, length);
    }

    private static void recursion(char[][] matrix, int n, int m, int length) {
        if (checkIsCompleted(matrix, n, m, length)) {
            stringBuilder.append(matrix[n][m]);
            return;
        }

        length /= 2;
        stringBuilder.append(OPEN_PARENTHESIS);
        if (length == 0) {
            solution(matrix, n, m, length);
        }

        solution(matrix, n, m, length);
        solution(matrix, n, m + length, length);
        solution(matrix, n + length, m, length);
        solution(matrix, n + length, m + length, length);

        stringBuilder.append(CLOSE_PARENTHESIS);
    }

    private static boolean checkIsCompleted(char[][] matrix, int n, int m, int length) {
        char reference = matrix[n][m];

        return IntStream.range(n, n + length)
                .allMatch(i -> IntStream.range(m, m + length)
                        .allMatch(j -> matrix[i][j] == reference));
    }
}

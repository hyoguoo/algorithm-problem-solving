/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4779
 * Cheat Level: 0
 * Algorithm: Divide and Conquer
 */

package divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CantoringAlong {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input == null) {
                break;
            }
            int n = Integer.parseInt(input);
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    public static String solution(int n) {
        if (n == 0) {
            return "-";
        }

        int length = (int) Math.pow(3, n);
        char[] cantor = new char[length];
        Arrays.fill(cantor, '-');

        cantoring(cantor, 0, length, n);

        return new String(cantor);
    }

    public static void cantoring(char[] cantor, int start, int length, int n) {
        if (n == 0) {
            return;
        }

        int third = length / 3;
        for (int i = start + third; i < start + 2 * third; i++) {
            cantor[i] = ' ';
        }

        cantoring(cantor, start, third, n - 1);
        cantoring(cantor, start + 2 * third, third, n - 1);
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2822
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CalculateScore {

    static final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] score = new int[8];

        for (int i = 0; i < score.length; i++) {
            score[i] = Integer.parseInt(bufferReader.readLine());
        }

        solution(score);
    }

    private static void solution(int[] score) {
        int[] numbers = new int[3];
        int sum = 0;
        int[] newScore = Arrays.copyOf(score, 8);
        Arrays.sort(newScore);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < score.length; j++)
                if (newScore[i] == score[j])
                    numbers[i] = j;

        for (int i = 0; i < score.length; i++) {
            if (i == numbers[0] || i == numbers[1] || i == numbers[2])
                continue;
            sum += score[i];
        }

        printResult(score, numbers, sum);
    }

    private static void printResult(int[] score, int[] numbers, int sum) {
        System.out.println(sum);
        for (int i = 0; i < score.length; i++) {
            if (i == numbers[0] || i == numbers[1] || i == numbers[2])
                continue;
            System.out.print(i + 1 + " ");
        }
    }
}

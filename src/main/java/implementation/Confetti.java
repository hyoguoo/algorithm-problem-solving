/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2563
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Confetti {

    static final int CONFETTI_SIZE = 10;
    static final int PAPER_SIZE = 100;
    static boolean[][] paper = new boolean[PAPER_SIZE][PAPER_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int confettiCount = Integer.parseInt(bufferedReader.readLine());
        int size = getSize(bufferedReader, confettiCount);

        System.out.println(size);
    }

    private static int getSize(BufferedReader bufferedReader, int confettiCount) throws IOException {
        int size = 0;

        for (int i = 0; i < confettiCount; i++) {
            int[] confettiInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = confettiInfo[0];
            int y = confettiInfo[1];
            for (int j = x; j < x + CONFETTI_SIZE; j++) {
                for (int k = y; k < y + CONFETTI_SIZE; k++) {
                    if (paper[j][k]) continue;
                    paper[j][k] = true;
                    size++;
                }
            }
        }

        return size;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3943
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HailstoneSequence {

    private static final int END_NUMBER = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int n) {
        int maxNumber = n;

        while (true) {
            if (n == END_NUMBER) {
                return maxNumber;
            }
            n = getNextHailstoneNumber(n);
            maxNumber = Math.max(maxNumber, n);
        }
    }

    private static int getNextHailstoneNumber(int n) {
        return n % 2 == 0
                ? n / 2
                : n * 3 + 1;
    }
}

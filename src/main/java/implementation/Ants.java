
/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4307
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ants {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int stickLength = info[0];
            int antCount = info[1];
            int[] ants = new int[antCount];
            for (int i = 0; i < antCount; i++) {
                ants[i] = Integer.parseInt(bufferedReader.readLine());
            }
            stringBuilder.append(solution(stickLength, ants)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int stickLength, int[] ants) {
        int minTime = 0;
        int maxTime = 0;

        for (int ant : ants) {
            minTime = Math.max(minTime, Math.min(ant, stickLength - ant));
            maxTime = Math.max(maxTime, Math.max(ant, stickLength - ant));
        }

        return minTime + " " + maxTime;
    }
}

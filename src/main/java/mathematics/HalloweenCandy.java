/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10178
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HalloweenCandy {

    private static final String RESULT_FORMAT = "You get %d piece(s) and your dad gets %d piece(s).";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int candyCount = info[0];
            int peopleCount = info[1];

            stringBuilder.append(solution(candyCount, peopleCount)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int candyCount, int peopleCount) {
        return String.format(RESULT_FORMAT, candyCount / peopleCount, candyCount % peopleCount);
    }
}

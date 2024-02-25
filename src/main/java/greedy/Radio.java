/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3135
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Radio {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] info = Arrays.stream(BUFFERED_READER.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = info[0];
        int to = info[1];

        System.out.print(
                Math.min(
                        calculateMinimumDiff(to),
                        Math.abs(start - to)
                )
        );
    }

    private static int calculateMinimumDiff(int to) throws IOException {
        int buttonCount = Integer.parseInt(BUFFERED_READER.readLine());
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < buttonCount; i++) {
            int channel = Integer.parseInt(BUFFERED_READER.readLine());
            int diff = Math.abs(channel - to) + 1;
            min = Math.min(min, diff);
        }

        return min;
    }
}

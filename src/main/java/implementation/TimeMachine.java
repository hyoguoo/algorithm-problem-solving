/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1440
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TimeMachine {

    private static final TimeUnit[] TIME_UNITS = TimeUnit.values();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] components = Arrays.stream(bufferedReader.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(components));
    }

    private static int solution(int[] components) {
        return countValidAssignments(components, 0, 0);
    }

    private static int countValidAssignments(int[] components, int usedMask, int unitIndex) {
        if (unitIndex == TIME_UNITS.length) {
            return 1;
        }

        return IntStream.range(0, components.length)
                .filter(i -> (usedMask & (1 << i)) == 0)
                .filter(i -> TIME_UNITS[unitIndex].isValid(components[i]))
                .map(i -> countValidAssignments(components, usedMask | (1 << i), unitIndex + 1))
                .sum();
    }

    enum TimeUnit {
        HOUR(1, 12),
        MINUTE(0, 59),
        SECOND(0, 59);

        private final int min;
        private final int max;

        TimeUnit(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public boolean isValid(int value) {
            return value >= min && value <= max;
        }
    }
}

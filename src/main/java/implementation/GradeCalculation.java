/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25374
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GradeCalculation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] scores = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(scores));
    }

    private static String solution(int[] scores) {
        int[] sorted = Arrays.stream(scores).sorted().toArray();
        int n = sorted.length;

        long[] cumulative = Arrays.stream(Grade.values())
                .mapToLong(g -> countStudentUpperScore(scores, sorted[n - (int) Math.ceil(g.getCumulativePercentage() * n / 100.0)]))
                .toArray();

        return IntStream.range(0, cumulative.length)
                .mapToLong(i -> cumulative[i] - (i == 0 ? 0 : cumulative[i - 1]))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static long countStudentUpperScore(int[] scores, int value) {
        return Arrays.stream(scores)
                .filter(score -> score >= value)
                .count();
    }

    enum Grade {
        FIRST(4),
        SECOND(11),
        THIRD(23),
        FOURTH(40),
        FIFTH(60),
        SIXTH(77),
        SEVENTH(89),
        EIGHTH(96),
        NINTH(100);

        private final int cumulativePercentage;

        Grade(int cumulativePercentage) {
            this.cumulativePercentage = cumulativePercentage;
        }

        public int getCumulativePercentage() {
            return cumulativePercentage;
        }
    }
}

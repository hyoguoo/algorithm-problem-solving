/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14241
 * Cheat Level: 0
 * Algorithm: Mathematics / Greedy
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SlimeMerging {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] slimeSizes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(slimeSizes));
    }

    private static int solution(int[] slimeSizes) {
        int[] sortedSizes = Arrays.stream(slimeSizes)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        return IntStream.range(1, sortedSizes.length)
                .map(i -> sortedSizes[i] * Arrays.stream(sortedSizes, 0, i).sum())
                .sum();
    }
}

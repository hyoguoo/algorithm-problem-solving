/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30457
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupJumpRope {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] studentHeights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(studentHeights));
    }

    private static long solution(int[] studentHeights) {
        Map<Integer, Long> heightCounts = Arrays.stream(studentHeights)
                .boxed()
                .collect(Collectors.groupingBy(
                        height -> height,
                        Collectors.counting()
                ));

        return heightCounts.values().stream()
                .mapToLong(count -> Math.min(count, Direction.values().length))
                .sum();
    }

    private enum Direction {
        LEFT,
        RIGHT
    }
}

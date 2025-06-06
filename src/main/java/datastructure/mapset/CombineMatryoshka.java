/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25631
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CombineMatryoshka {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] sizes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(sizes));
    }

    private static long solution(int[] sizes) {
        return Arrays.stream(sizes)
                .boxed()
                .collect(Collectors.groupingBy(size -> size, Collectors.counting()))
                .values()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);
    }
}

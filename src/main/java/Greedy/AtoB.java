/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16953
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AtoB {

    final static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long src = numbers[0];
        long dist = numbers[1];

        solution(src, dist, 0);
        Integer min = result.size() == 0 ? -1 : Collections.min(result) + 1;
        System.out.println(min);
    }

    private static void solution(long src, long dist, int count) {
        if (src == dist) result.add(count);

        if (src * 10 + 1 <= dist) solution(src * 10 + 1, dist, count + 1);
        if (src * 2 <= dist) solution(src * 2, dist, count + 1);
    }
}

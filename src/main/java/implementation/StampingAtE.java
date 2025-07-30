/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23811
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StampingAtE {

    private static final String STAMP = "@";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        return IntStream.range(0, 5 * n)
                .mapToObj(
                        i -> i % (2 * n) < n
                                ? STAMP.repeat(n * 5)
                                : STAMP.repeat(n)
                )
                .collect(Collectors.joining("\n"));
    }
}


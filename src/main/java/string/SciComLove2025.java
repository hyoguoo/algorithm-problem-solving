/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 33810
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SciComLove2025 {

    private static final String TARGET = "SciComLove";

    public static void main(String[] args) throws IOException {
        System.out.print(solution(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    private static long solution(String s) {
        return IntStream.range(0, TARGET.length())
                .filter(i -> s.charAt(i) != TARGET.charAt(i))
                .count();
    }
}

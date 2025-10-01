/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19564
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Repetition {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static long solution(String s) {
        return IntStream.range(1, s.length())
                .filter(i -> s.charAt(i - 1) >= s.charAt(i))
                .count() + 1;
    }
}

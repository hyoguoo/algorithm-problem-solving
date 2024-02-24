/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14912
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberFrequency {

    static final int ASCII_ZERO = 48;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(info[0], info[1]));
    }

    private static int solution(int n, int target) {
        return (int) IntStream.rangeClosed(1, n)
                .mapToObj(String::valueOf)
                .flatMapToInt(String::chars)
                .filter(c -> isTargetAscii(target, c))
                .count();
    }

    private static boolean isTargetAscii(int target, int c) {
        return c == convertToAscii(target);
    }

    private static int convertToAscii(int target) {
        return target + ASCII_ZERO;
    }
}

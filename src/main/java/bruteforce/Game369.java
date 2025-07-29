/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17614
 * Cheat Level: 0
 * Algorithm: Brute Force / Implementation
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Game369 {

    private static final String SPECIAL_DIGITS = "369";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static long solution(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(String::valueOf)
                .mapToLong(num -> num.chars()
                        .filter(ch -> SPECIAL_DIGITS.indexOf(ch) >= 0)
                        .count())
                .sum();
    }
}

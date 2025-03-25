/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10093
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Numbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static String solution(long a, long b) {
        if ( a == b) {
            return "0";
        }
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        return b - a - 1 + "\n" +
                LongStream.rangeClosed(a + 1, b - 1)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
    }
}

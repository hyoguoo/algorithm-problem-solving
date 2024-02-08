/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1850
 * Cheat Level: 2
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreatestCommonDivisor {

    static final String ONE = "1";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static String solution(long a, long b) {
        return ONE.repeat((int) getGCD(Math.max(a, b), Math.min(a, b)));
    }

    private static long getGCD(long a, long b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}

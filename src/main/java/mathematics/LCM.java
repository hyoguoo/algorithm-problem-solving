/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13241
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCM {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        System.out.println(getLcm(numberArray[0], numberArray[1]));
    }

    public static long getLcm(long x, long y) {
        return x * y / getGcd(x, y);
    }

    public static long getGcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}

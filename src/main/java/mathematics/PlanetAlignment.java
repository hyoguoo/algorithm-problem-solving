/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25344
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlanetAlignment {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static long solution(int[] numbers) {
        long lcm = 1;

        for (int number : numbers) {
            lcm = lcm * number / gcd(lcm, number);
        }

        return lcm;
    }

    private static long gcd(long a, long b) {
        return b != 0
                ? gcd(b, a % b)
                : a;
    }
}

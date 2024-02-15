/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2331
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LifeCycle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays
                .stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static int solution(long n, int pow) {
        List<Long> sequence = new ArrayList<>();
        sequence.add(n);

        while (true) {
            long digitSumToPower = calculateSumOfDigitsToPower(sequence.get(sequence.size() - 1), pow);
            if (sequence.contains(digitSumToPower)) {
                return sequence.indexOf(digitSumToPower);
            }
            sequence.add(digitSumToPower);
        }
    }

    private static long calculateSumOfDigitsToPower(long n, int pow) {
        long sum = 0;

        while (n > 0) {
            sum += (long) Math.pow(n % 10, pow);
            n /= 10;
        }

        return sum;
    }
}

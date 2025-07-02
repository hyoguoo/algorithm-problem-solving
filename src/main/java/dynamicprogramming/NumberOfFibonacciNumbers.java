/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6571
 * Cheat Level: 0
 * Algorithm: Dynamic Programming / Mathematics
 */

package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfFibonacciNumbers {

    private static final List<BigInteger> fibonacciNumberList = new ArrayList<>();
    private static final BigInteger MAX_FIBONACCI = BigInteger.valueOf(10).pow(100);

    static {
        fibonacciNumberList.add(BigInteger.ONE);
        fibonacciNumberList.add(BigInteger.TWO);

        while (true) {
            BigInteger nextFibonacci = fibonacciNumberList
                    .get(fibonacciNumberList.size() - 1)
                    .add(fibonacciNumberList.get(fibonacciNumberList.size() - 2));
            if (nextFibonacci.compareTo(MAX_FIBONACCI) > 0) {
                break;
            }
            fibonacciNumberList.add(nextFibonacci);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            BigInteger[] interval = Arrays.stream(bufferedReader.readLine().split(" "))
                    .map(BigInteger::new)
                    .toArray(BigInteger[]::new);

            if (interval[0].equals(BigInteger.ZERO) && interval[1].equals(BigInteger.ZERO)) {
                break;
            }

            stringBuilder.append(solution(interval[0], interval[1])).append("\n");

        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(BigInteger start, BigInteger end) {
        return fibonacciNumberList.stream()
                .filter(fibonacci -> 0 <= fibonacci.compareTo(start) && fibonacci.compareTo(end) <= 0)
                .count();
    }
}

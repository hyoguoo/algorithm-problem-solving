/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17206
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JunseokMathHomework {

    private static final int[] PRIMES = {3, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .map(JunseokMathHomework::calculateSumOfDivisors)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static int calculateSumOfDivisors(int number) {
        int sum = 0;

        for (int prime : PRIMES) {
            sum += sumOfMultiples(number, prime);
        }

        int lcm = lcm(PRIMES[0], PRIMES[1]);
        sum -= sumOfMultiples(number, lcm);

        return sum;
    }

    private static int sumOfMultiples(int number, int base) {
        int count = number / base;
        return base * count * (count + 1) / 2;
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

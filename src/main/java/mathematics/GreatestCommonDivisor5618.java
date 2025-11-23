/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5618
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GreatestCommonDivisor5618 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(numbers));
    }

    private static String solution(int[] numbers) {
        List<Integer> divisors = getDivisorsOfGCD(numbers);

        return divisors.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static List<Integer> getDivisorsOfGCD(int[] numbers) {
        int gcd = Arrays.stream(numbers)
                .reduce(GreatestCommonDivisor5618::gcd)
                .orElse(1);

        return getDivisors(gcd);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static List<Integer> getDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i) {
                    divisors.add(number / i);
                }
            }
        }

        return divisors.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}

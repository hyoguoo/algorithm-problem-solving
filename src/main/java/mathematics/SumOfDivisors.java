/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9506
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SumOfDivisors {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == -1) {
                break;
            }
            stringBuilder.append(solution(n)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(int n) {
        List<Integer> divisors = getDivisors(n);
        int sum = calculateSum(divisors);

        return sum == n
                ? n + getDivisorsString(divisors)
                : n + " is NOT perfect.";
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static int calculateSum(List<Integer> divisors) {
        return divisors.stream().mapToInt(Integer::intValue).sum();
    }

    private static String getDivisorsString(List<Integer> divisors) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(" = ");

        divisors.stream()
                .map(String::valueOf)
                .forEach(s -> stringBuilder.append(s).append(" + "));

        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());

        return stringBuilder.toString();
    }
}

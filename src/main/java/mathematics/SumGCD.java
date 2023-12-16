/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9613
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumGCD {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            stringBuilder.append(
                    solution(
                            Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()
                    )
            ).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static long solution(int[] numbers) {
        long sum = 0;

        for (int i = 1; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum += gcd(numbers[i], numbers[j]);
            }
        }

        return sum;
    }

    private static long gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

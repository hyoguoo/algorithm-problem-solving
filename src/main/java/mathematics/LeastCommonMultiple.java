/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1934
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeastCommonMultiple {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- >0) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stringBuilder.append(solution(numbers[0], numbers[1])).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int solution(int number1, int number2) {
        return number1 * number2 / gcd(number1, number2);
    }

    private static int gcd(int number1, int number2) {
        return number2 == 0 ? number1 : gcd(number2, number1 % number2);
    }
}

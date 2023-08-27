/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1110
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AdditionCycles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int number) {
        int count = 0;
        int copyNumber = number;

        do {
            copyNumber = calculate(copyNumber);
            count++;
        } while (copyNumber != number);

        return count;
    }

    private static int calculate(int number) {
        int sum = Arrays.stream(String.valueOf(number).split("")).mapToInt(Integer::parseInt).sum();
        return Integer.parseInt(number % 10 + "" + sum % 10);
    }
}

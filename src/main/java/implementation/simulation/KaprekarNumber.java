/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9047
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.stream.Collectors;

public class KaprekarNumber {

    private static final int KAPREKAR_CONSTANT = 6174;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int number = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(number)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int number) {
        int currentNumber = number;
        int count = 0;

        while (true) {
            if (currentNumber == KAPREKAR_CONSTANT) {
                return count;
            }
            currentNumber = calculateNextNumber(currentNumber);
            count++;
        }
    }

    private static int calculateNextNumber(int number) {
        String formatted = String.format("%04d", number);

        String ascending = formatted.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        String descending = formatted.chars()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(c -> String.valueOf((char) c.intValue()))
                .collect(Collectors.joining());

        return Integer.parseInt(descending) - Integer.parseInt(ascending);
    }
}

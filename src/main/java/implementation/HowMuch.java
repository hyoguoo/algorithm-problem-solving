/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9325
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HowMuch {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            int originalPrice = Integer.parseInt(bufferedReader.readLine());
            int optionCount = Integer.parseInt(bufferedReader.readLine());
            Option[] options = new Option[optionCount];
            for (int i = 0; i < optionCount; i++) {
                int[] optionInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                options[i] = new Option(optionInfo[0], optionInfo[1]);
            }

            stringBuilder
                    .append(solution(originalPrice, options))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int originalPrice, Option[] options) {
        return Arrays.stream(options)
                .mapToInt(option -> option.count * option.price)
                .sum()
                + originalPrice;
    }

    static class Option {

        private final int count;
        private final int price;

        public Option(int count, int price) {
            this.count = count;
            this.price = price;
        }
    }
}

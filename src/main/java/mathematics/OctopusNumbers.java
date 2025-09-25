/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1864
 * Cheat Level: 0
 * Algorithm: Implementation / Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class OctopusNumbers {

    private static final String END_COMMAND = "#";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals(END_COMMAND)) {
                break;
            }
            stringBuilder.append(solution(input)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(String input) {
        OctopusNumber[] octopusNumbers = input.chars()
                .mapToObj(c -> OctopusNumber.fromChar((char) c))
                .toArray(OctopusNumber[]::new);

        return IntStream.range(0, octopusNumbers.length)
                .map(i -> calculate(octopusNumbers[octopusNumbers.length - 1 - i], i))
                .sum();
    }

    private static int calculate(OctopusNumber octopusNumber, int i) {
        return octopusNumber.value * (int) Math.pow(8, i);
    }

    enum OctopusNumber {
        MINUS('-', 0),
        BACKSLASH('\\', 1),
        LEFT_PARENTHESIS('(', 2),
        AT('@', 3),
        QUESTION_MARK('?', 4),
        GREATER_THAN('>', 5),
        AMPERSAND('&', 6),
        PERCENT('%', 7),
        SLASH('/', -1);

        private final char symbol;
        private final int value;

        OctopusNumber(char symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }

        public static OctopusNumber fromChar(char c) {
            return Arrays.stream(OctopusNumber.values())
                    .filter(octopusNumber -> octopusNumber.symbol == c)
                    .findFirst()
                    .orElseThrow();
        }
    }
}

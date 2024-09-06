/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17413
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord2 {

    private static final char SPACE = ' ';
    private static final char LEFT_BRACKET = '<';
    private static final char RIGHT_BRACKET = '>';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String s) {
        return new WordProcessor(s).process();
    }

    static class WordProcessor {

        private final String input;
        private final StringBuilder result;
        private final StringBuilder temp;
        private boolean isInBracket;

        public WordProcessor(String input) {
            this.input = input;
            this.result = new StringBuilder();
            this.temp = new StringBuilder();
            this.isInBracket = false;
        }

        public String process() {
            for (char c : input.toCharArray()) {
                switch (c) {
                    case SPACE:
                        appendToResult();
                        result.append(SPACE);
                        break;
                    case LEFT_BRACKET:
                        appendToResult();
                        result.append(LEFT_BRACKET);
                        isInBracket = true;
                        break;
                    case RIGHT_BRACKET:
                        appendToResult();
                        result.append(RIGHT_BRACKET);
                        isInBracket = false;
                        break;
                    default:
                        temp.append(c);
                        break;
                }
            }

            appendToResult();

            return result.toString().trim();
        }

        private void appendToResult() {
            result.append(
                    isInBracket
                            ? temp
                            : temp.reverse()
            );
            clearTemp();
        }

        private void clearTemp() {
            temp.setLength(0);
        }
    }
}

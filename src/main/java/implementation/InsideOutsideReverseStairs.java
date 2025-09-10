/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28290
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsideOutsideReverseStairs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static TypingMethod solution(String s) {
        return TypingMethod.of(s);
    }

    enum TypingMethod {
        INSIDE_OUTSIDE("in-out", "fdsajkl;", "jkl;fdsa"),
        OUTSIDE_INSIDE("out-in", "asdf;lkj", ";lkjasdf"),
        STAIRS("stairs", "asdfjkl;"),
        REVERSE_STAIRS("reverse", ";lkjfdsa"),
        NONE("molu");

        private final String method;
        private final String[] patterns;

        TypingMethod(String method, String... patterns) {
            this.method = method;
            this.patterns = patterns;
        }

        public static TypingMethod of(String input) {
            return Arrays.stream(values())
                    .filter(typingMethod -> Arrays.asList(typingMethod.patterns).contains(input))
                    .findFirst()
                    .orElse(NONE);
        }

        @Override
        public String toString() {
            return method;
        }
    }
}

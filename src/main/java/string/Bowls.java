/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7567
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bowls {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        Bowl[] bowls = new Bowl[s.length()];

        for (int i = 0; i < s.length(); i++) {
            bowls[i] = Bowl.of(s.charAt(i));
        }

        System.out.print(solution(bowls));
    }

    private static int solution(Bowl[] bowls) {
        int result = 10;

        for (int i = 1; i < bowls.length; i++) {
            if (bowls[i - 1] != bowls[i]) {
                result += 10;
            } else {
                result += 5;
            }
        }

        return result;
    }

    enum Bowl {
        UP('('),
        DOWN(')');

        private final char value;

        Bowl(char value) {
            this.value = value;
        }

        public static Bowl of(char value) {
            return Arrays.stream(Bowl.values())
                    .filter(bowl -> bowl.value == value)
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}

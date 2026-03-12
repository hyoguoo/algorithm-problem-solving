/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20310
 * Cheat Level: 0
 * Algorithm: Greedy / String
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Thanos {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(bufferedReader.readLine()));
    }

    private static String solution(String s) {
        ThanosFilter filter = new ThanosFilter(s);

        return s.chars()
                .filter(c -> filter.shouldKeep((char) c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private enum CharacterType {
        ZERO('0'),
        ONE('1');

        private final char value;

        CharacterType(char value) {
            this.value = value;
        }

        public static CharacterType of(char c) {
            return Arrays.stream(values())
                    .filter(type -> type.value == c)
                    .findFirst()
                    .orElseThrow();
        }

        public boolean isMatch(char c) {
            return this.value == c;
        }
    }

    private static class ThanosFilter {

        private final long half0;
        private final long half1;
        private int count0 = 0;
        private int count1 = 0;

        public ThanosFilter(String s) {
            this.half0 = s.chars().filter(c -> CharacterType.ZERO.isMatch((char) c)).count() / 2;
            this.half1 = s.chars().filter(c -> CharacterType.ONE.isMatch((char) c)).count() / 2;
        }

        public boolean shouldKeep(char c) {
            CharacterType type = CharacterType.of(c);
            switch (type) {
                case ZERO:
                    return count0++ < half0;
                case ONE:
                    return count1++ >= half1;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}

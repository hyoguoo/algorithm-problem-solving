/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11536
 * Cheat Level: 0
 * Algorithm: String / Implementation
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LineUp {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nameCount = Integer.parseInt(bufferedReader.readLine());
        String[] names = new String[nameCount];

        for (int i = 0; i < nameCount; i++) {
            names[i] = bufferedReader.readLine();
        }

        System.out.print(solution(names));
    }

    private static Order solution(String[] names) {
        return Arrays.stream(Order.values())
                .filter(order -> order.isMatched(names))
                .findFirst()
                .orElse(Order.NEITHER);
    }

    enum Order {
        INCREASING(names -> allMatchPairs(names, (a, b) -> a.compareTo(b) < 0)),
        DECREASING(names -> allMatchPairs(names, (a, b) -> a.compareTo(b) > 0)),
        NEITHER(names -> true);

        private final Predicate<String[]> matcher;

        Order(Predicate<String[]> matcher) {
            this.matcher = matcher;
        }

        private static boolean allMatchPairs(String[] names, BiPredicate<String, String> predicate) {
            return IntStream.range(0, names.length - 1)
                    .allMatch(i -> predicate.test(names[i], names[i + 1]));
        }

        public boolean isMatched(String[] names) {
            return this.matcher.test(names);
        }

        @Override
        public String toString() {
            return this.name();
        }
    }
}

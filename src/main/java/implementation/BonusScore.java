/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17389
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BonusScore {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        Result[] results = bufferedReader.readLine().chars()
                .mapToObj(c -> c == 'O' ? Result.O : Result.X)
                .toArray(Result[]::new);
        System.out.print(solution(results));
    }

    private static int solution(Result[] results) {
        return IntStream.range(0, results.length)
                .collect(ScoreState::new,
                        (state, i) -> state.process(results[i], i + 1),
                        (a, b) -> a.total += b.total)
                .total;
    }

    enum Result {
        O, X;

        boolean isCorrect() {
            return this == O;
        }
    }

    private static class ScoreState {

        private int total;
        private int bonus;

        void process(Result result, int base) {
            if (result.isCorrect()) {
                addCorrect(base);
            } else {
                resetBonus();
            }
        }

        void addCorrect(int base) {
            total += base + bonus;
            bonus++;
        }

        void resetBonus() {
            bonus = 0;
        }
    }
}

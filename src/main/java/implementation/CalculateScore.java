/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2506
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CalculateScore {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        Correctness[] scores = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Correctness::of)
                .toArray(Correctness[]::new);

        System.out.print(solution(scores));
    }

    private static int solution(Correctness[] scores) {
        int totalScore = 0;
        int currentScore = 0;

        for (Correctness score : scores) {
            if (score == Correctness.CORRECT) {
                currentScore++;
                totalScore += currentScore;
            } else if (score == Correctness.INCORRECT) {
                currentScore = 0;
            }
        }

        return totalScore;
    }

    enum Correctness {
        CORRECT(1),
        INCORRECT(0);

        private final int value;

        Correctness(int value) {
            this.value = value;
        }

        public static Correctness of(int value) {
            return Arrays.stream(values())
                    .filter(correctness -> correctness.value == value)
                    .findFirst()
                    .orElseThrow();
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10902
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PenaltyCalculation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int answerCount = Integer.parseInt(bufferedReader.readLine());

        Answer[] answers = new Answer[answerCount];

        for (int i = 0; i < answerCount; i++) {
            int[] answerInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            answers[i] = new Answer(answerInfo[0], answerInfo[1]);
        }

        System.out.print(solution(answers));
    }

    private static int solution(Answer[] answers) {
        int maxScore = Arrays.stream(answers)
                .mapToInt(answer -> answer.score)
                .max()
                .orElse(0);
        if (maxScore == 0) {
            return 0;
        }
        int maxScoreTime = Arrays.stream(answers)
                .filter(answer -> answer.score == maxScore)
                .mapToInt(answer -> answer.time)
                .findFirst()
                .orElseThrow();
        int maxScoreIndex = IntStream.range(0, answers.length)
                .filter(i -> answers[i].score == maxScore)
                .findFirst()
                .orElseThrow();

        return maxScoreTime + maxScoreIndex * 20;
    }

    static class Answer {

        private final int time;
        private final int score;

        public Answer(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
}

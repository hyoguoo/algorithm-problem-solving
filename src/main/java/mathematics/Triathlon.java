/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25600
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Triathlon {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantCount = Integer.parseInt(bufferedReader.readLine());

        Score[] scores = new Score[participantCount];

        for (int i = 0; i < participantCount; i++) {
            int[] scoreInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            scores[i] = new Score(scoreInfo[0], scoreInfo[1], scoreInfo[2]);
        }

        System.out.print(solution(scores));
    }

    private static int solution(Score[] scores) {
        return Arrays.stream(scores)
                .mapToInt(Score::getTriathlonScore)
                .max()
                .orElseThrow();
    }

    static class Score {

        private final int adhoc;
        private final int dp;
        private final int greedy;

        public Score(int adhoc, int dp, int greedy) {
            this.adhoc = adhoc;
            this.dp = dp;
            this.greedy = greedy;
        }

        public int getTriathlonScore() {
            int dpGreedySum = dp + greedy;

            return adhoc == dpGreedySum
                    ? adhoc * dpGreedySum * 2
                    : adhoc * dpGreedySum;
        }
    }
}

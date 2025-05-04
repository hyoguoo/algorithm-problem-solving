/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11637
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PopularVote {

    private static final int NOT_A_WINNER = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int peopleCount = Integer.parseInt(bufferedReader.readLine());
            int[] votes = new int[peopleCount];
            for (int i = 0; i < peopleCount; i++) {
                votes[i] = Integer.parseInt(bufferedReader.readLine());
            }

            Result result = solution(votes);
            stringBuilder.append(
                    result.resultType == ResultType.NO_WINNER
                            ? result.resultType.toString()
                            : result.resultType + " " + result.winner
                            )
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static Result solution(int[] votes) {
        int totalVotes = Arrays.stream(votes).sum();
        int maxVotes = Arrays.stream(votes).max().orElse(0);
        int maxVotesCount = (int) Arrays.stream(votes).filter(vote -> vote == maxVotes).count();

        if (maxVotesCount > 1) {
            return new Result(ResultType.NO_WINNER, NOT_A_WINNER);
        }

        int winner = IntStream.range(0, votes.length)
                .filter(i -> votes[i] == maxVotes)
                .findFirst()
                .orElseThrow();

        return maxVotes > totalVotes / 2
                ? new Result(ResultType.MAJORITY, winner + 1)
                : new Result(ResultType.MINORITY, winner + 1);
    }

    enum ResultType {
        MAJORITY("majority winner"),
        MINORITY("minority winner"),
        NO_WINNER("no winner");

        private final String value;

        ResultType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    static class Result {

        private final ResultType resultType;
        private final int winner;

        public Result(ResultType resultType, int winner) {
            this.resultType = resultType;
            this.winner = winner;
        }
    }
}

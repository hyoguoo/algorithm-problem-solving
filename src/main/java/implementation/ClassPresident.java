/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2456
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class ClassPresident {

    private static final int CANDIDATE_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int voteCount = Integer.parseInt(bufferedReader.readLine());
        int[][] votes = new int[voteCount][CANDIDATE_COUNT];

        for (int i = 0; i < voteCount; i++) {
            votes[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.print(solution(votes));
    }

    private static String solution(int[][] votes) {
        Result result = new Result();
        for (int[] vote : votes) {
            for (int candidateNumber = 1; candidateNumber <= CANDIDATE_COUNT; candidateNumber++) {
                result.addVote(candidateNumber, vote[candidateNumber - 1]);
            }
        }
        return result.getWinner();
    }

    static class Result {

        private final Candidate[] candidates;

        public Result() {
            this.candidates = new Candidate[CANDIDATE_COUNT];
            for (int i = 0; i < CANDIDATE_COUNT; i++) {
                candidates[i] = new Candidate();
            }
        }

        public void addVote(int candidateNumber, int weight) {
            candidates[candidateNumber - 1].addVote(weight);
        }

        public String getWinner() {
            Candidate winner = Arrays.stream(candidates)
                    .max(Candidate::compareTo)
                    .orElseThrow();

            long winnerCount = Arrays.stream(candidates)
                    .filter(candidate -> candidate.equals(winner))
                    .count();

            if (winnerCount > 1) {
                return "0 " + winner.getTotalVoteValue();
            }

            int winnerIndex = -1;
            for (int i = 0; i < CANDIDATE_COUNT; i++) {
                if (candidates[i].equals(winner)) {
                    winnerIndex = i + 1;
                    break;
                }
            }

            return winnerIndex + " " + winner.getTotalVoteValue();
        }
    }

    static class Candidate implements Comparable<Candidate> {

        private final int[] votes;

        public Candidate() {
            this.votes = new int[CANDIDATE_COUNT];
        }

        public void addVote(int weight) {
            votes[weight - 1]++;
        }

        private int getTotalVoteValue() {
            return IntStream.range(0, votes.length)
                    .map(i -> votes[i] * (i + 1))
                    .sum();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Candidate candidate = (Candidate) o;
            return Objects.deepEquals(votes, candidate.votes);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(votes);
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.getTotalVoteValue() != o.getTotalVoteValue()) {
                return Integer.compare(this.getTotalVoteValue(), o.getTotalVoteValue());
            }

            for (int i = CANDIDATE_COUNT - 1; i >= 0; i--) {
                if (this.votes[i] != o.votes[i]) {
                    return Integer.compare(this.votes[i], o.votes[i]);
                }
            }

            return 0;
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 20124
 * Cheat Level: 0
 * Algorithm: Sort / Implementation
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecommendedChairmanMolgorism {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int candidateCount = Integer.parseInt(bufferedReader.readLine());
        Candidate[] candidates = new Candidate[candidateCount];

        for (int i = 0; i < candidateCount; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            String name = input[0];
            int score = Integer.parseInt(input[1]);
            candidates[i] = new Candidate(name, score);
        }

        System.out.print(solution(candidates));
    }

    private static String solution(Candidate[] candidates) {
        return Arrays.stream(candidates)
                .sorted(RecommendedChairmanMolgorism::compareCandidates)
                .map(candidate -> candidate.name)
                .findFirst()
                .orElseThrow();
    }

    private static int compareCandidates(Candidate c1, Candidate c2) {
        if (c2.score != c1.score) {
            return Integer.compare(c2.score, c1.score);
        } else {
            return c1.name.compareTo(c2.name);
        }
    }

    static class Candidate {

        private final String name;
        private final int score;

        public Candidate(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}

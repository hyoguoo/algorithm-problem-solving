/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11531
 * Cheat Level: 0
 * Algorithm: Set
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ACMContestScoring {

    private static final String END_SIGNAL = "-1";
    private static final int PENALTY_WEIGHT = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<ProblemQuery> problemQueryList = new ArrayList<>();
        while (true) {
            String[] input = bufferedReader.readLine().split(" ");
            if (input[0].equals(END_SIGNAL)) {
                break;
            }
            problemQueryList.add(new ProblemQuery(
                    Integer.parseInt(input[0]),
                    input[1],
                    Result.of(input[2])
            ));
        }

        System.out.print(solution(problemQueryList));
    }

    private static String solution(List<ProblemQuery> problemQueryList) {
        Map<String, Integer> triedProblems = new HashMap<>();
        Set<String> solvedProblems = new HashSet<>();
        int totalTime = 0;

        for (ProblemQuery problemQuery : problemQueryList) {
            if (solvedProblems.contains(problemQuery.problemName)) {
                continue;
            }
            if (problemQuery.result == Result.RIGHT) {
                int penaltyTime = triedProblems.getOrDefault(problemQuery.problemName, 0) * PENALTY_WEIGHT;
                totalTime += problemQuery.submissionTime + penaltyTime;
                solvedProblems.add(problemQuery.problemName);
            } else {
                triedProblems.merge(problemQuery.problemName, 1, Integer::sum);
            }
        }

        return solvedProblems.size() + " " + totalTime;
    }

    enum Result {
        RIGHT("right"),
        WRONG("wrong");

        private final String value;

        Result(String value) {
            this.value = value;
        }

        public static Result of(String value) {
            return Arrays.stream(Result.values())
                    .filter(result -> result.value.equals(value))
                    .findFirst()
                    .orElseThrow();
        }
    }

    static class ProblemQuery {

        private final int submissionTime;
        private final String problemName;
        private final Result result;

        public ProblemQuery(int submissionTime, String problemName, Result result) {
            this.submissionTime = submissionTime;
            this.problemName = problemName;
            this.result = result;
        }
    }
}

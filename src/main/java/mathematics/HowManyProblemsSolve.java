/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29720
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HowManyProblemsSolve {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalTargetProblems = inputs[0];
        int dailySolveCount = inputs[1];
        int requiredMinimumDays = inputs[2];

        System.out.print(solution(totalTargetProblems, dailySolveCount, requiredMinimumDays));
    }

    private static Result solution(int totalTargetProblems, int dailySolveCount, int requiredMinimumDays) {
        int maxRemainingProblems = dailySolveCount * requiredMinimumDays;
        int minRemainingProblems = dailySolveCount * (requiredMinimumDays - 1) + 1;

        int minSolvedProblems = totalTargetProblems - maxRemainingProblems;
        int maxSolvedProblems = totalTargetProblems - minRemainingProblems;

        if (minSolvedProblems < 0) {
            minSolvedProblems = 0;
        }
        if (maxSolvedProblems < 0) {
            maxSolvedProblems = 0;
        }

        return new Result(minSolvedProblems, maxSolvedProblems);
    }

    static class Result {

        private final int minSolvedProblems;
        private final int maxSolvedProblems;

        public Result(int minSolvedProblems, int maxSolvedProblems) {
            this.minSolvedProblems = minSolvedProblems;
            this.maxSolvedProblems = maxSolvedProblems;
        }

        @Override
        public String toString() {
            return minSolvedProblems + " " + maxSolvedProblems;
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29155
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AspiringDeveloperGoormJobHunt {

    private static final long LEVEL_LIMIT = 5;
    private static final int BREAK_TIME = 60;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int problemCount = Integer.parseInt(bufferedReader.readLine());
        int[] requiredSolveCounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Problem[] problems = new Problem[problemCount];

        for (int i = 0; i < problemCount; i++) {
            int[] problemInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            problems[i] = new Problem(problemInfo[0], problemInfo[1]);
        }

        System.out.print(solution(problems, requiredSolveCounts));
    }

    private static int solution(Problem[] problems, int[] requiredSolveCounts) {
        List<List<Integer>> levelTimeList = Stream.<List<Integer>>generate(ArrayList::new)
                .limit(LEVEL_LIMIT)
                .collect(Collectors.toList());

        for (Problem problem : problems) {
            levelTimeList.get(problem.level).add(problem.time);
        }
        for (List<Integer> level : levelTimeList) {
            level.sort(Integer::compareTo);
        }

        int answer = 0;
        int currentLevel = 0;
        boolean isFirstProblem = true;

        for (int l = 0; l < levelTimeList.size(); l++) {
            int requiredSolveCount = requiredSolveCounts[l];
            List<Integer> timeList = levelTimeList.get(l);

            int currentTime = 0;

            for (int p = 0; p < requiredSolveCount; p++) {
                int time = timeList.get(p);
                if (isFirstProblem) {
                    isFirstProblem = false;
                } else if (currentLevel < l) {
                    answer += BREAK_TIME;
                    currentLevel = l;
                } else {
                    answer += time - currentTime;
                }
                currentTime = time;
                answer += time;
            }
        }

        return answer;
    }

    static class Problem {

        private final int level;
        private final int time;

        public Problem(int level, int time) {
            this.level = level - 1;
            this.time = time;
        }
    }
}

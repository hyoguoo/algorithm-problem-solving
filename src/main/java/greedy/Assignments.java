/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13904
 * Cheat Level: 2
 * Algorithm:
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Assignments {

    final static List<Assignment> assignmentList = new ArrayList<>();
    static int N, LIMIT_DATE;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(solution());
    }

    private static int solution() {
        int score = 0;
        int currentDate = LIMIT_DATE;

        while (currentDate > 0) {
            for (Assignment assignment : assignmentList) {
                if (assignment.dueDate >= currentDate) {
                    score += assignment.score;
                    assignmentList.remove(assignment);
                    break;
                }
            }
            currentDate--;
        }

        return score;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        for (int n = 0; n < N; n++) {
            int[] assignmentInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            assignmentList.add(new Assignment(assignmentInfo[0], assignmentInfo[1]));
            LIMIT_DATE = Math.max(LIMIT_DATE, assignmentInfo[0]);
        }
        Collections.sort(assignmentList);
    }

    static class Assignment implements Comparable<Assignment> {
        int dueDate;
        int score;

        public Assignment(int dueDate, int score) {
            this.dueDate = dueDate;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            return o.score - this.score;
        }
    }
}

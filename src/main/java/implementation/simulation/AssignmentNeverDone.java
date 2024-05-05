/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17592
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AssignmentNeverDone {

    public static void main(String[] args) throws IOException {
        Assignment[] assignments = parseAssignments();

        System.out.print(solution(assignments));
    }

    private static int solution(Assignment[] assignments) {
        int result = 0;
        Deque<Assignment> stack = new ArrayDeque<>();

        for (Assignment assignment : assignments) {
            if (!assignment.isZeroScore()) {
                stack.push(assignment);
            }

            if (!stack.isEmpty()) {
                Assignment current = stack.peek();
                current.process();
                if (current.isDone()) {
                    stack.pop();
                    result += current.score;
                }
            }
        }

        return result;
    }

    private static Assignment[] parseAssignments() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        Assignment[] assignments = new Assignment[length];

        for (int i = 0; i < length; i++) {
            int[] assignmentInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (assignmentInfo[0] == 0) {
                assignments[i] = new Assignment(0, 0);
            } else {
                assignments[i] = new Assignment(assignmentInfo[1], assignmentInfo[2]);
            }
        }

        return assignments;
    }

    static class Assignment {

        private final int score;
        private int time;

        public Assignment(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public void process() {
            this.time--;
        }

        public boolean isDone() {
            return this.time <= 0;
        }

        public boolean isZeroScore() {
            return this.score == 0;
        }
    }
}

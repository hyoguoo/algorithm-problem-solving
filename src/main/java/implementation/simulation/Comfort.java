/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3258
 * Cheat Level: 0
 * Algorithm: Implementation / Simulation / Brute Force
 */

package implementation.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Comfort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int fieldCount = info[0];
        int targetPosition = info[1];
        int[] obstacles = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(fieldCount, targetPosition, obstacles));
    }

    private static int solution(int fieldCount, int targetPosition, int[] obstacles) {
        Set<Integer> obstacleSet = Arrays.stream(obstacles)
                .boxed()
                .collect(Collectors.toSet());

        for (int moveDistance = 1; moveDistance <= fieldCount; moveDistance++) {
            if (canMove(obstacleSet, moveDistance, targetPosition, fieldCount)) {
                return moveDistance;
            }
        }

        return -1;
    }

    private static boolean canMove(Set<Integer> obstacleSet, int moveDistance, int targetPosition, int fieldCount) {
        int currentPosition = 1;
        boolean[] visited = new boolean[fieldCount + 1];
        visited[currentPosition] = true;
        while (true) {
            int nextPosition = currentPosition + moveDistance;
            currentPosition = nextPosition > fieldCount
                    ? nextPosition - fieldCount
                    : nextPosition;
            if (visited[currentPosition]) {
                return false;
            }
            visited[currentPosition] = true;
            if (obstacleSet.contains(currentPosition)) {
                return false;
            }
            if (currentPosition == targetPosition) {
                return true;
            }
        }
    }
}

/*
10 4 2
1 2
 */
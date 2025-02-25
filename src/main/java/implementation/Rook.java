/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32370
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rook {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] targetInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Position target = new Position(targetInfo[0], targetInfo[1]);
        int[] obstacleInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Position obstacle = new Position(obstacleInfo[0], obstacleInfo[1]);

        System.out.print(solution(target, obstacle));
    }


    private static int solution(Position target, Position obstacle) {
        int targetX = target.x;
        int targetY = target.y;
        int obstacleX = obstacle.x;
        int obstacleY = obstacle.y;

        boolean sameRow = (targetX == 0);
        boolean sameCol = (targetY == 0);

        boolean obstacleBlocksRow = (targetX == obstacleX && 0 < obstacleY && obstacleY < targetY);
        boolean obstacleBlocksCol = (targetY == obstacleY && 0 < obstacleX && obstacleX < targetX);

        if ((sameRow || sameCol) && !(obstacleBlocksRow || obstacleBlocksCol)) {
            return 1;
        }

        if (obstacleBlocksRow || obstacleBlocksCol) {
            return 3;
        }

        return 2;
    }


    static class Position {

        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

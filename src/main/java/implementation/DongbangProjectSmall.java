/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14594
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DongbangProjectSmall {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roomCount = Integer.parseInt(bufferedReader.readLine());
        int actionCount = Integer.parseInt(bufferedReader.readLine());

        Action[] actions = new Action[actionCount];
        for (int i = 0; i < actionCount; i++) {
            int[] actionInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            actions[i] = new Action(actionInfo[0], actionInfo[1]);
        }

        System.out.print(solution(roomCount, actions));
    }

    private static int solution(int roomCount, Action[] actions) {
        WallStatus[] wallStatuses = new WallStatus[roomCount];
        Arrays.fill(wallStatuses, WallStatus.EXIST);

        for (Action action : actions) {
            for (int i = action.startRoomNumber; i < action.endRoomNumber; i++) {
                wallStatuses[i] = WallStatus.REMOVED;
            }
        }

        int remainingRoomCount = 0;
        for (int i = 1; i < roomCount; i++) {
            if (wallStatuses[i] == WallStatus.EXIST) {
                remainingRoomCount++;
            }
        }

        return remainingRoomCount + 1;
    }

    enum WallStatus {
        EXIST, REMOVED
    }

    static class Action {

        private final int startRoomNumber;
        private final int endRoomNumber;

        public Action(int startRoomNumber, int endRoomNumber) {
            this.startRoomNumber = startRoomNumber;
            this.endRoomNumber = endRoomNumber;
        }
    }
}

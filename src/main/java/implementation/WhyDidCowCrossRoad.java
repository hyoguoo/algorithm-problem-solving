/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14467
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WhyDidCowCrossRoad {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countInfoCows = Integer.parseInt(bufferedReader.readLine());
        CowInfo[] cowInfos = new CowInfo[countInfoCows];

        for (int i = 0; i < countInfoCows; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            cowInfos[i] = new CowInfo(info[0], info[1] == 0 ? Position.LEFT : Position.RIGHT);
        }

        System.out.print(solution(cowInfos));
    }

    private static int solution(CowInfo[] cowInfos) {
        Map<Integer, Position> cowPositions = new HashMap<>();

        int countCrossed = 0;

        for (CowInfo cowInfo : cowInfos) {
            int id = cowInfo.id;
            Position position = cowInfo.position;

            if (cowPositions.containsKey(id)) {
                if (cowPositions.get(id) != position) {
                    countCrossed++;
                    cowPositions.put(id, position);
                }
            } else {
                cowPositions.put(id, position);
            }
        }

        return countCrossed;
    }

    enum Position {
        LEFT, RIGHT;
    }

    static class CowInfo {

        private final int id;
        private final Position position;

        public CowInfo(int id, Position position) {
            this.id = id;
            this.position = position;
        }
    }
}

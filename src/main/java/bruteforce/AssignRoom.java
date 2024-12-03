/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14697
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AssignRoom {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] roomsSizes = Arrays.copyOfRange(info, 0, info.length - 1);
        int peopleCount = info[info.length - 1];

        System.out.print(solution(roomsSizes, peopleCount) ? 1 : 0);
    }

    private static boolean solution(int[] roomsSizes, int peopleCount) {
        return recursion(roomsSizes, peopleCount, 0, 0);
    }

    private static boolean recursion(int[] roomsSizes, int peopleCount, int currentPeopleCount, int roomIndex) {
        if (currentPeopleCount == peopleCount) {
            return true;
        }

        if (roomIndex == roomsSizes.length) {
            return false;
        }

        for (int roomCount = 1; currentPeopleCount + roomsSizes[roomIndex] * roomCount <= peopleCount; roomCount++) {
            int nextPeopleCount = currentPeopleCount + roomsSizes[roomIndex] * roomCount;
            if (recursion(roomsSizes, peopleCount, nextPeopleCount, roomIndex + 1)) {
                return true;
            }
        }

        return recursion(roomsSizes, peopleCount, currentPeopleCount, roomIndex + 1);
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2458
 * Cheat Level: 0
 * Algorithm: Graph / Floyd Warshall
 */

package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeightOrder {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];
        int compareCount = info[1];
        boolean[][] connected = new boolean[peopleCount + 1][peopleCount + 1];

        for (int i = 0; i < compareCount; i++) {
            int[] compare = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            connected[compare[0]][compare[1]] = true;
        }

        System.out.print(solution(connected, peopleCount));
    }

    private static int solution(boolean[][] connected, int peopleCount) {
        updateConnections(connected, peopleCount);

        int[] connectionsCount = countConnections(connected, peopleCount);

        return countAllConnectedPeople(peopleCount, connectionsCount);
    }

    private static void updateConnections(boolean[][] connected, int peopleCount) {
        for (int middle = 1; middle <= peopleCount; middle++) {
            for (int start = 1; start <= peopleCount; start++) {
                for (int end = 1; end <= peopleCount; end++) {
                    if (connected[start][middle] && connected[middle][end]) {
                        connected[start][end] = true;
                    }
                }
            }
        }
    }

    private static int[] countConnections(boolean[][] connected, int peopleCount) {
        int[] count = new int[connected.length + 1];
        for (int start = 1; start <= peopleCount; start++) {
            for (int end = 1; end <= peopleCount; end++) {
                if (connected[start][end] || connected[end][start]) {
                    count[start]++;
                }
            }
        }
        return count;
    }

    private static int countAllConnectedPeople(int peopleCount, int[] connectionsCount) {
        return (int) Arrays.stream(connectionsCount)
                .filter(value -> value == peopleCount - 1)
                .count();
    }
}

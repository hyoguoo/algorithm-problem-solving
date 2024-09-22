/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1236
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DefendingCastle {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sizeN = info[0];
        int sizeM = info[1];
        String[] map = new String[sizeN];

        for (int i = 0; i < sizeN; i++) {
            map[i] = bufferedReader.readLine();
        }

        System.out.print(solution(map, sizeN, sizeM));
    }

    private static int solution(String[] map, int sizeN, int sizeM) {
        int rowGuardCount = 0;
        int columnGuardCount = 0;

        for (String row : map) {
            if (!row.contains("X")) {
                rowGuardCount++;
            }
        }

        for (int col = 0; col < sizeM; col++) {
            boolean hasGuardInColumn = false;
            for (int row = 0; row < sizeN; row++) {
                if (map[row].charAt(col) == 'X') {
                    hasGuardInColumn = true;
                    break;
                }
            }
            if (!hasGuardInColumn) {
                columnGuardCount++;
            }
        }

        return Math.max(rowGuardCount, columnGuardCount);
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 23971
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZOAC4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(info[0], info[1], info[2], info[3]));
    }

    private static long solution(
            long totalRows,
            long totalColumns,
            long verticalDistance,
            long horizontalDistance
    ) {
        long availableRows =
                (totalRows + verticalDistance) / (verticalDistance + 1);

        long availableColumns =
                (totalColumns + horizontalDistance) / (horizontalDistance + 1);

        return availableRows * availableColumns;
    }
}

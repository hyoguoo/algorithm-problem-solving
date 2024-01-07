/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2669
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindArea {

    static final int MAX = 101;
    static final int RECTANGLE_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] isFilled = new boolean[MAX][MAX];

        for (int i = 0; i < RECTANGLE_COUNT; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = info[0];
            int y1 = info[1];
            int x2 = info[2];
            int y2 = info[3];

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    isFilled[y][x] = true;
                }
            }
        }

        System.out.println(solution(isFilled));

    }

    private static int solution(boolean[][] isFilled) {
        int count = 0;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (isFilled[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

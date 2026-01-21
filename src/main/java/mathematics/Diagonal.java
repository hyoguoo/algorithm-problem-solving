/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34346
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;

public class Diagonal {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new java.io.InputStreamReader(System.in));
        int gridSize = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(gridSize));
    }

    private static int solution(int gridSize) {
        return gridSize % 2 == 1 ? 1 : 2;
    }
}

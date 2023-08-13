/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15803
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PLAYERJINAHBOTTLEGROUNDS {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] player1 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] player2 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] player3 = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(player1, player2, player3) ? "WHERE IS MY CHICKEN?" : "WINNER WINNER CHICKEN DINNER!");
    }

    private static boolean solution(int[] player1, int[] player2, int[] player3) {
        int x1 = player1[0];
        int y1 = player1[1];
        int x2 = player2[0];
        int y2 = player2[1];
        int x3 = player3[0];
        int y3 = player3[1];

        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }
}

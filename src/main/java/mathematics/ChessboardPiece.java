/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3004
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessboardPiece {

    public static void main(String[] args) throws IOException {
        System.out.print(solution(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

    private static int solution(int n) {
        return (n + 2) * (n + 2) / 4;
    }
}

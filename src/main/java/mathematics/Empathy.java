/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14623
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Empathy {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String binaryA = bufferedReader.readLine();
        String binaryB = bufferedReader.readLine();

        System.out.print(solution(binaryA, binaryB));
    }

    private static String solution(String binaryA, String binaryB) {
        return Long.toBinaryString(
                Long.parseLong(binaryA, 2) * Long.parseLong(binaryB, 2)
        );
    }
}

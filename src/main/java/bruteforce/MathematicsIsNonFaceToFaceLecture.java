/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19532
 * Cheat Level: 0
 * Algorithm: Mathematics / Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MathematicsIsNonFaceToFaceLecture {

    private static final int MAX = 999;
    private static final int MIN = -999;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = info[0];
        int b = info[1];
        int c = info[2];
        int d = info[3];
        int e = info[4];
        int f = info[5];

        System.out.print(solution(a, b, c, d, e, f));
    }

    private static String solution(int a, int b, int c, int d, int e, int f) {
        for (int i = MIN; i <= MAX; i++) {
            for (int j = MIN; j <= MAX; j++) {
                if (a * i + b * j == c &&
                        d * i + e * j == f) {
                    return i + " " + j;
                }
            }
        }
        return "";
    }
}

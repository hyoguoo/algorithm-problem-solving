/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25591
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FuangAndJongYun {

    private static final int DIGIT_LENGTH = 2;
    private static final int BASE = (int) Math.pow(10, DIGIT_LENGTH);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static String solution(int n1, int n2) {
        int a = BASE - n1;
        int b = BASE - n2;
        int c = BASE - (a + b);
        int d = a * b;
        int q = d / BASE;
        int r = d % BASE;

        return String.format("%d %d %d %d %d %d", a, b, c, d, q, r) + "\n" +
                String.format("%d %d", c + q, r);
    }
}

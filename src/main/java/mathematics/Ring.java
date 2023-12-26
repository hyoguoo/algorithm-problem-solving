/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3036
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ring {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        solution(Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
    }

    private static void solution(int[] rings) {
        int firstRing = rings[0];

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < rings.length; i++) {
            int gcd = getGCD(firstRing, rings[i]);
            stringBuilder.append(firstRing / gcd)
                    .append("/")
                    .append(rings[i] / gcd)
                    .append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}

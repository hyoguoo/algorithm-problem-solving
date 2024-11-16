/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9471
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PisanoPeriods {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder
                    .append(i)
                    .append(" ")
                    .append(solution(info[1]))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int m) {
        int a = 1;
        int b = 1;
        int period = 0;

        do {
            int next = (a + b) % m;
            a = b;
            b = next;
            period++;

        } while (a != 1 || b != 1);

        return period;
    }
}

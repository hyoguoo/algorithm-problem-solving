/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4536
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythagorasRevenge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            long a = Long.parseLong(bufferedReader.readLine());
            if (a == 0) {
                break;
            }

            stringBuilder.append(solution(a)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(long a) {
        int count = 0;

        long a2 = a * a;

        for (long sub = 1; sub <= a; sub++) {
            if (a2 % sub != 0) {
                continue;
            }
            long sum = a2 / sub;
            if ((sum - sub) / 2 > a && (sub - sum) % 2 == 0) {
                count++;
            }
        }


        return count;
    }
}

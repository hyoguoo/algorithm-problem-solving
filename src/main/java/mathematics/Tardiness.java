/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10419
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tardiness {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int time = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(solution(time)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int time) {
        int i = 0;
        while (i * (i + 1) <= time) {
            i++;
        }
        return i - 1;
    }
}

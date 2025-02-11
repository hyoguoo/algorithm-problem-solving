/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6359
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class DrunkJailer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            stringBuilder
                    .append(solution(Integer.parseInt(bufferedReader.readLine())))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> Math.sqrt(i) % 1 == 0)
                .count();
    }
}

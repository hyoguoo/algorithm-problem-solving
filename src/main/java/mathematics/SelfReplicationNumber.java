/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2028
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelfReplicationNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            long number = Long.parseLong(bufferedReader.readLine());

            stringBuilder
                    .append(solution(number) ? "YES" : "NO")
                    .append(System.lineSeparator());
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(long number) {
        long square = number * number;
        String numberString = String.valueOf(number);
        String squareString = String.valueOf(square);
        return squareString.endsWith(numberString);
    }
}

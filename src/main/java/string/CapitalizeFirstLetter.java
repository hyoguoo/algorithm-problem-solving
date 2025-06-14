/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4458
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapitalizeFirstLetter {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCaseCount-- > 0) {
            stringBuilder.append(solution(bufferedReader.readLine()))
                    .append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String read) {
        if (read.isEmpty()) {
            return read;
        }

        return read.substring(0, 1).toUpperCase() + read.substring(1);
    }
}

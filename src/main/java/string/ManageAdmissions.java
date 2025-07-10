/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5524
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ManageAdmissions {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int recordCount = Integer.parseInt(bufferedReader.readLine());
        String[] records = new String[recordCount];

        for (int i = 0; i < recordCount; i++) {
            records[i] = bufferedReader.readLine();
        }

        System.out.print(solution(records));
    }

    private static String solution(String[] records) {
        return Arrays.stream(records)
                .map(String::toLowerCase)
                .collect(Collectors.joining("\n"));
    }
}

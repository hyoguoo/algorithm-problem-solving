/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9996
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MissKoreaConnectServer {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int fileCount = Integer.parseInt(bufferedReader.readLine());
        String pattern = bufferedReader.readLine();
        String[] fileNames = new String[fileCount];
        for (int i = 0; i < fileCount; i++) {
            fileNames[i] = bufferedReader.readLine();
        }

        System.out.print(Arrays.stream(solution(fileNames, pattern))
                .map(result -> Boolean.TRUE.equals(result) ? "DA" : "NE")
                .collect(Collectors.joining("\n")));
    }

    private static Boolean[] solution(String[] fileNames, String pattern) {
        Pattern regexPattern = Pattern.compile(pattern.replace("*", ".*"));

        return Arrays.stream(fileNames)
                .map(regexPattern::matcher)
                .map(Matcher::matches)
                .toArray(Boolean[]::new);
    }
}

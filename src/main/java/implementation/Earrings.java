/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1380
 * Cheat Level: 0
 * Algorithm: Implementation / String
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Earrings {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();
        int scenarioCount = 1;

        while (true) {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n == 0) {
                break;
            }

            List<String> studentNames = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                studentNames.add(bufferedReader.readLine());
            }

            List<String> records = new ArrayList<>();
            for (int i = 0; i < 2 * n - 1; i++) {
                records.add(bufferedReader.readLine());
            }

            outputBuilder
                    .append(scenarioCount++)
                    .append(" ")
                    .append(solution(n, studentNames, records))
                    .append(System.lineSeparator());
        }

        System.out.print(outputBuilder.toString().trim());
    }

    public static String solution(int n, List<String> studentNames, List<String> records) {
        Map<Integer, Set<Side>> returnedCheck = new HashMap<>();

        for (String record : records) {
            String[] recordComponents = record.split(" ");
            int studentNumber = Integer.parseInt(recordComponents[0]);
            Side side = Side.valueOf(recordComponents[1]);

            returnedCheck.computeIfAbsent(studentNumber, k -> new HashSet<>()).add(side);
        }

        for (int i = 1; i <= n; i++) {
            Set<Side> returnedSides = returnedCheck.get(i);
            if (returnedSides == null || returnedSides.size() == 1) {
                return studentNames.get(i - 1);
            }
        }

        return "";
    }

    public enum Side {
        A, B
    }
}

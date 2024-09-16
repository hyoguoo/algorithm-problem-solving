/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30008
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JunyoungGrade {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int studentCount = info[0];
        int[] ranks = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(studentCount, ranks));
    }

    private static String solution(int studentCount, int[] ranks) {
        int[] grade = Arrays.stream(ranks)
                .map(rank -> getGrade(rank * 100 / studentCount))
                .toArray();

        return Arrays.toString(grade).replaceAll("[\\[\\],]", "");
    }

    private static int getGrade(int percentile) {
        if (0 <= percentile && percentile <= 4) {
            return 1;
        } else if (percentile <= 11) {
            return 2;
        } else if (percentile <= 23) {
            return 3;
        } else if (percentile <= 40) {
            return 4;
        } else if (percentile <= 60) {
            return 5;
        } else if (percentile <= 77) {
            return 6;
        } else if (percentile <= 89) {
            return 7;
        } else if (percentile <= 96) {
            return 8;
        } else if (percentile <= 100) {
            return 9;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

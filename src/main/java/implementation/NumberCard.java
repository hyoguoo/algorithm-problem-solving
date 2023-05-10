/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10815
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCard {

    final static int MAX = 10000000;
    final static boolean[] minus = new boolean[MAX + 1];
    final static boolean[] plus = new boolean[MAX + 1];
    static int[] holdList;
    static int[] checkList;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getResult());
    }

    private static String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int check : checkList) {
            if (check >= 0) stringBuilder.append(plus[check] ? "1 " : "0 ");
            else stringBuilder.append(minus[Math.abs(check)] ? "1 " : "0 ");
        }
        return stringBuilder.toString();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        holdList = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int hold : holdList) {
            if (hold >= 0) plus[hold] = true;
            else minus[Math.abs(hold)] = true;
        }
        bufferedReader.readLine();
        checkList = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

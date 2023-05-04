/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7568
 * Cheat Level: 0
 * Algorithm: Brute Force / Implementation
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Physique {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[][] people = new int[length][2];

        for (int i = 0; i < length; i++) {
            int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            people[i] = infos;
        }

        System.out.println(getResult(people));
    }

    private static StringBuilder getResult(int[][] people) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] person : people) {
            stringBuilder.append(getRank(people, person)).append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder;
    }

    private static int getRank(int[][] people, int[] targetPerson) {
        int rank = 1;

        for (int[] person : people) {
            if (person[0] > targetPerson[0] && person[1] > targetPerson[1]) rank++;
        }

        return rank;
    }
}
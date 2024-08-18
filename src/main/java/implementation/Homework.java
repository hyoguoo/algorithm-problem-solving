/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5532
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalDays = Integer.parseInt(bufferedReader.readLine());
        int totalPageA = Integer.parseInt(bufferedReader.readLine());
        int totalPageB = Integer.parseInt(bufferedReader.readLine());
        int maxPageDailyA = Integer.parseInt(bufferedReader.readLine());
        int maxPageDailyB = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(totalDays, totalPageA, totalPageB, maxPageDailyA, maxPageDailyB));
    }

    private static int solution(int totalDays, int totalPageA, int totalPageB, int maxPageDailyA, int maxPageDailyB) {
        int daysA = totalPageA / maxPageDailyA;
        if (totalPageA % maxPageDailyA != 0) {
            daysA++;
        }

        int daysB = totalPageB / maxPageDailyB;
        if (totalPageB % maxPageDailyB != 0) {
            daysB++;
        }

        return totalDays - Math.max(daysA, daysB);
    }
}

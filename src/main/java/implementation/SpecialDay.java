/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10768
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.MonthDay;

public class SpecialDay {

    private static final MonthDay SPECIAL_DAY = MonthDay.of(2, 18);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(bufferedReader.readLine());
        int day = Integer.parseInt(bufferedReader.readLine());

        MonthDay inputDate = MonthDay.of(month, day);

        System.out.print(solution(inputDate));
    }

    private static String solution(MonthDay inputDate) {
        if (inputDate.isBefore(SPECIAL_DAY)) {
            return "Before";
        } else if (inputDate.isAfter(SPECIAL_DAY)) {
            return "After";
        } else if (inputDate.equals(SPECIAL_DAY)) {
            return "Special";
        } else {
            throw new IllegalArgumentException();
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2948
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public class Year2009 {

    private static final int BASE_YEAR = 2009;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] dateInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(dateInfo[1], dateInfo[0]).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }

    private static DayOfWeek solution(int month, int day) {
        return LocalDate.of(BASE_YEAR, month, day).getDayOfWeek();
    }
}

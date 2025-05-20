/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1308
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;

public class DDay {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] todayInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalDate today = LocalDate.of(todayInfo[0], todayInfo[1], todayInfo[2]);
        int[] dDayInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalDate dDay = LocalDate.of(dDayInfo[0], dDayInfo[1], dDayInfo[2]);

        System.out.print(solution(today, dDay));
    }

    private static String solution(LocalDate today, LocalDate dDay) {
        LocalDate maxDate = today.plusYears(1000);

        if (!dDay.isBefore(maxDate)) {
            return "gg";
        }

        return String.format("D-%d", calculateDiffDays(today, dDay));
    }

    private static long calculateDiffDays(LocalDate today, LocalDate dDay) {
        return dDay.toEpochDay() - today.toEpochDay();
    }
}

/*
1000 1 12
3000 1 13
 */
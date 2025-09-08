/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1340
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class YearProgressBar {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        LocalDateTime dateTime = LocalDateTime.parse(input,
                DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH));

        System.out.print(solution(dateTime));
    }

    private static BigDecimal solution(LocalDateTime dateTime) {
        LocalDateTime startOfYear = dateTime.with(MonthDay.of(1, 1)).with(LocalTime.MIN);
        LocalDateTime endOfYear = dateTime.with(MonthDay.of(12, 31)).with(LocalTime.MAX);

        long point = dateTime.toEpochSecond(ZoneOffset.UTC) - startOfYear.toEpochSecond(ZoneOffset.UTC);
        long total = endOfYear.toEpochSecond(ZoneOffset.UTC) - startOfYear.toEpochSecond(ZoneOffset.UTC) + 1;

        if (point == 0) {
            return BigDecimal.ZERO.setScale(10, RoundingMode.HALF_UP);
        }

        return BigDecimal.valueOf(point * 100L)
                .divide(BigDecimal.valueOf(total), 20, RoundingMode.HALF_UP)
                .setScale(10, RoundingMode.HALF_UP);
    }
}

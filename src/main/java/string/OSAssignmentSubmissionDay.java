/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2730
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Stream;

public class OSAssignmentSubmissionDay {

    private static final String DEADLINE_FORMAT = "M/d/yyyy";
    private static final String SUBMIT_FORMAT = "M/d";
    private static final int RANGE_DAYS = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            stringBuilder.append(solution(bufferedReader.readLine())).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static String solution(String input) {
        String[] split = input.split(" ");
        String deadlineDate = split[0];
        String submitDate = split[1];

        LocalDate deadlineLocaldate = LocalDate.parse(deadlineDate, DateTimeFormatter.ofPattern(DEADLINE_FORMAT));
        MonthDay submitMonthDay = MonthDay.parse(submitDate, DateTimeFormatter.ofPattern(SUBMIT_FORMAT));
        LocalDate submitLocalDate = findSubmitLocalDate(deadlineLocaldate, submitMonthDay);

        long diffDays = deadlineLocaldate.toEpochDay() - submitLocalDate.toEpochDay();

        return formatDiffDays(submitLocalDate, diffDays);
    }

    private static String formatDiffDays(LocalDate submitLocalDate, long diffDays) {
        if (diffDays == 0) {
            return "SAME DAY";
        }

        long absDays = Math.abs(diffDays);
        if (absDays > RANGE_DAYS) {
            return "OUT OF RANGE";
        }

        return String.format("%s IS %d DAY%s %s",
                submitLocalDate.format(DateTimeFormatter.ofPattern(DEADLINE_FORMAT)),
                absDays,
                (absDays > 1) ? "S" : "",
                (diffDays > 0) ? "PRIOR" : "AFTER");
    }

    private static LocalDate findSubmitLocalDate(LocalDate deadlineLocaldate, MonthDay submitMonthDay) {
        int year = deadlineLocaldate.getYear();
        long deadlineEpoch = deadlineLocaldate.toEpochDay();

        LocalDate lastYear = submitMonthDay.atYear(year - 1);
        LocalDate currentYear = submitMonthDay.atYear(year);
        LocalDate nextYear = submitMonthDay.atYear(year + 1);

        return Stream.of(lastYear, currentYear, nextYear)
                .min(Comparator.comparingLong(d -> Math.abs(d.toEpochDay() - deadlineEpoch)))
                .orElseThrow();
    }
}

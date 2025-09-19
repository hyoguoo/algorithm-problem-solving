/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24465
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class DreamOfDebut {

    private static final int EXISTING_MEMBER_COUNT = 7;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        MonthDay[] memberBirthDates = new MonthDay[EXISTING_MEMBER_COUNT];

        for (int i = 0; i < EXISTING_MEMBER_COUNT; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            memberBirthDates[i] = MonthDay.of(info[0], info[1]);
        }

        int applicantCount = Integer.parseInt(bufferedReader.readLine());
        MonthDay[] applicantBirthDates = new MonthDay[applicantCount];
        for (int i = 0; i < applicantCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            applicantBirthDates[i] = MonthDay.of(info[0], info[1]);
        }

        System.out.print(solution(memberBirthDates, applicantBirthDates));
    }

    private static Result solution(MonthDay[] memberBirthDates, MonthDay[] applicantBirthDates) {
        EnumSet<Constellation> memberConstellations = Arrays.stream(memberBirthDates)
                .map(Constellation::of)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Constellation.class)));
        List<MonthDay> selectedApplicantBirthDates = Arrays.stream(applicantBirthDates)
                .filter(applicantBirthDate -> !memberConstellations.contains(Constellation.of(applicantBirthDate)))
                .sorted()
                .collect(Collectors.toList());
        return new Result(selectedApplicantBirthDates);
    }

    enum Constellation {
        AQUARIUS(MonthDay.of(1, 20), MonthDay.of(2, 18)),
        PISCES(MonthDay.of(2, 19), MonthDay.of(3, 20)),
        ARIES(MonthDay.of(3, 21), MonthDay.of(4, 19)),
        TAURUS(MonthDay.of(4, 20), MonthDay.of(5, 20)),
        GEMINI(MonthDay.of(5, 21), MonthDay.of(6, 21)),
        CANCER(MonthDay.of(6, 22), MonthDay.of(7, 22)),
        LEO(MonthDay.of(7, 23), MonthDay.of(8, 22)),
        VIRGO(MonthDay.of(8, 23), MonthDay.of(9, 22)),
        LIBRA(MonthDay.of(9, 23), MonthDay.of(10, 22)),
        SCORPIO(MonthDay.of(10, 23), MonthDay.of(11, 22)),
        SAGITTARIUS(MonthDay.of(11, 23), MonthDay.of(12, 21)),
        CAPRICORN(MonthDay.of(12, 22), MonthDay.of(1, 19));

        private final MonthDay start;
        private final MonthDay end;

        Constellation(MonthDay start, MonthDay end) {
            this.start = start;
            this.end = end;
        }

        public static Constellation of(MonthDay monthDay) {
            return Arrays.stream(Constellation.values())
                    .filter(constellation -> constellation.isInRange(monthDay))
                    .findFirst()
                    .orElseThrow();
        }

        private boolean isInRange(MonthDay monthDay) {
            if (this.start.isBefore(this.end) || this.start.equals(this.end)) {
                return (monthDay.isAfter(this.start) || monthDay.equals(this.start))
                        && (monthDay.isBefore(this.end) || monthDay.equals(this.end));
            } else {
                return (monthDay.isAfter(this.start) || monthDay.equals(this.start))
                        || (monthDay.isBefore(this.end) || monthDay.equals(this.end));
            }
        }
    }

    static class Result {

        private final List<MonthDay> selectedApplicantBirthDates;

        public Result(List<MonthDay> selectedApplicantBirthDates) {
            this.selectedApplicantBirthDates = selectedApplicantBirthDates;
        }

        @Override
        public String toString() {
            if (selectedApplicantBirthDates.isEmpty()) {
                return "ALL FAILED";
            }
            return selectedApplicantBirthDates.stream()
                    .map(monthDay -> monthDay.getMonthValue() + " " + monthDay.getDayOfMonth())
                    .collect(Collectors.joining("\n"));
        }
    }
}

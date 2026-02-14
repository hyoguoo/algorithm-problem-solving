/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16199
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class CalculatingAge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] birthDateInput = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalDate birthDate = LocalDate.of(birthDateInput[0], birthDateInput[1], birthDateInput[2]);

        int[] refDateInput = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        LocalDate refDate = LocalDate.of(refDateInput[0], refDateInput[1], refDateInput[2]);

        System.out.println(solution(birthDate, refDate));
    }

    private static AgeResult solution(LocalDate birthDate, LocalDate refDate) {
        int internationalAge = Period.between(birthDate, refDate).getYears();
        int countingAge = refDate.getYear() - birthDate.getYear() + 1;
        int yearAge = refDate.getYear() - birthDate.getYear();

        return new AgeResult(internationalAge, countingAge, yearAge);
    }

    static class AgeResult {

        int internationalAge;
        int countingAge;
        int yearAge;

        public AgeResult(int internationalAge, int countingAge, int yearAge) {
            this.internationalAge = internationalAge;
            this.countingAge = countingAge;
            this.yearAge = yearAge;
        }

        @Override
        public String toString() {
            return internationalAge + "\n" + countingAge + "\n" + yearAge;
        }
    }
}

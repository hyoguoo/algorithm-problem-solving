/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2875
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompetitionsOrInterns {

    private static final int NEED_FEMALE_STUDENT_PER_TEAM = 2;
    private static final int NEED_MALE_STUDENT_PER_TEAM = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int femaleStudent = info[0];
        int maleStudent = info[1];
        int internCount = info[2];

        System.out.print(solution(femaleStudent, maleStudent, internCount));
    }

    private static int solution(int femaleStudent, int maleStudent, int internCount) {
        int teamCount = 0;

        while (canFormTeam(femaleStudent, maleStudent, internCount)) {
            femaleStudent -= NEED_FEMALE_STUDENT_PER_TEAM;
            maleStudent -= NEED_MALE_STUDENT_PER_TEAM;
            teamCount++;
        }

        return teamCount;
    }

    private static boolean canFormTeam(int femaleStudent, int maleStudent, int internCount) {
        return femaleStudent >= NEED_FEMALE_STUDENT_PER_TEAM &&
                maleStudent >= NEED_MALE_STUDENT_PER_TEAM &&
                femaleStudent + maleStudent - NEED_FEMALE_STUDENT_PER_TEAM - NEED_MALE_STUDENT_PER_TEAM >= internCount;
    }
}

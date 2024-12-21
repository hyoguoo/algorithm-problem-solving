/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10833
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Apple {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int schoolCount = Integer.parseInt(bufferedReader.readLine());
        School[] schools = new School[schoolCount];

        for (int i = 0; i < schoolCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            schools[i] = new School(info[0], info[1]);
        }

        System.out.print(solution(schools));
    }

    private static int solution(School[] schools) {
        return Arrays.stream(schools)
                .mapToInt(school -> school.getAppleCount() % school.getStudentCount())
                .sum();
    }

    static class School {

        private final int studentCount;
        private final int appleCount;

        public School(int studentCount, int appleCount) {
            this.studentCount = studentCount;
            this.appleCount = appleCount;
        }

        public int getStudentCount() {
            return studentCount;
        }

        public int getAppleCount() {
            return appleCount;
        }
    }
}

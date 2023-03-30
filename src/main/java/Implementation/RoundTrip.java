/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18311
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RoundTrip {

    static long runningDistance;
    static long[] COURSES;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        runningDistance = info[1];
        COURSES = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        System.out.println(solution());
    }

    private static int solution() {
        for (int i = 0; i < COURSES.length; i++) {
            runningDistance -= COURSES[i];
            if (runningDistance < 0) return i + 1;
        }

        for (int i = COURSES.length - 1; i >= 0; i--) {
            runningDistance -= COURSES[i];
            if (runningDistance < 0) return i + 1;
        }

        return -1;
    }
}

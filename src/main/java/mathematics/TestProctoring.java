/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13458
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestProctoring {

    static int[] STUDENT_COUNTS;
    static int ROOM_COUNT, PROCTOR_LIMIT, SUB_PROCTOR_LIMIT;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static long solution() {
         return Arrays.stream(STUDENT_COUNTS).mapToLong(studentCount -> {
            long count = 1;
            studentCount -= PROCTOR_LIMIT;
            if (studentCount > 0) count += Math.ceil((double) studentCount / SUB_PROCTOR_LIMIT);
            return count;
         }).sum();
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ROOM_COUNT = Integer.parseInt(bufferedReader.readLine());
        STUDENT_COUNTS = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PROCTOR_LIMIT = info[0];
        SUB_PROCTOR_LIMIT = info[1];
    }
}

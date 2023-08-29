/*
 * goormlevel
 * https://level.goorm.io
 * Goormthon Challenge: 11일차
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pain2 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(start, numbers[0], numbers[1]));
    }

    private static int solution(int start, int numberA, int numberB) {
        for (int divide = start / numberB; divide >= 0; divide--) {
            int remain = start - (numberB * divide);
            if (remain % numberA == 0) return divide + (remain / numberA);
        }

        return -1;
    }
}

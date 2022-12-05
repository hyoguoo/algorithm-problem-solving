/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2869
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SnailWantsToClimb {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(info[0], info[1], info[2]));
    }

    private static int solution(int climb, int fall, int target) {
        int day = (target - fall) / (climb - fall);
        if ((target - fall) % (climb - fall) != 0) day++;
        return day;
    }
}

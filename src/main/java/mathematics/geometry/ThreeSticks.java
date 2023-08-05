/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14215
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeSticks {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()));
    }

    private static int solution(int[] sticks) {
        Arrays.sort(sticks);
        int largestStickLength = sticks[2];
        int sum = sticks[0] + sticks[1];

        return sum > largestStickLength ? sum + largestStickLength : sum + sum - 1;
    }
}

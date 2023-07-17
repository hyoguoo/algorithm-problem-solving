/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1449
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Repairman {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] holes = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(holes);

        System.out.println(solution(holes, info[1]));
    }

    private static int solution(int[] holes, int tapeLength) {
        int startAt = holes[0];
        int count = 1;

        for (int i = 1; i < holes.length; i++) {
            int hole = holes[i];

            if (startAt + tapeLength <= hole) {
                startAt = holes[i];
                count++;
            }
        }

        return count;
    }
}

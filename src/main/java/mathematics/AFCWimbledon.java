/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4299
 * Cheat Level: 0
 * Algorithm: Math, Implementation
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AFCWimbledon {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = info[0];
        int diff = info[1];

        System.out.print(solution(sum, diff));
    }

    private static String solution(int sum, int diff) {
        if ((sum + diff) % 2 != 0 || sum < diff) {
            return "-1";
        }

        int maxScore = (sum + diff) / 2;
        int minScore = (sum - diff) / 2;

        return maxScore + " " + minScore;
    }
}

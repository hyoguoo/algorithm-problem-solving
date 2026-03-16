/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14659
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HanzoRanking {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print(solution(heights));
    }

    private static int solution(int[] heights) {
        int maxKills = 0;
        int currentMaxHeight = 0;
        int currentKills = 0;

        for (int height : heights) {
            if (height > currentMaxHeight) {
                currentMaxHeight = height;
                currentKills = 0;
            } else {
                currentKills++;
                maxKills = Math.max(maxKills, currentKills);
            }
        }

        return maxKills;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17266
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DarkCrawlspace {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        int[] lamps = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(lamps, length));
    }

    private static int solution(int[] lamps, int length) {
        int maxDistance = Math.max(lamps[0], length - lamps[lamps.length - 1]);
        for (int i = 1; i < lamps.length - 1; i++) {
            int lamp = lamps[i];
            int distance = (int) Math.ceil((lamp - lamps[i - 1]) / 2.0);
            maxDistance = Math.max(maxDistance, distance);
        }
        return maxDistance;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22986
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlatEarth {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int earthSize = info[0];
            int time = info[1];

            stringBuilder.append(solution(earthSize, time)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(long earthSize, long time) {
        time = Math.min(time, earthSize);

        return (time + 1) * (earthSize + earthSize - time) * 2;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11880
 * Cheat Level: 0
 * Algorithm: Mathematics / Geometry
 */

package mathematics.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ant {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (caseCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stringBuilder.append(solution(info[0], info[1], info[2])).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static long solution(int x, int y, int z) {
        long sum = x + y + z;
        long max = Math.max(x, Math.max(y, z));

        return max * max + (sum - max) * (sum - max);
    }
}

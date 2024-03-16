/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1009
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DistributedProcessing {

    static final int COMPUTE_COUNT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            stringBuilder.append(solution(info[0], info[1])).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(int a, int b) {
        long result = 1;

        for (int i = 0; i < b; i++) {
            result = (result * a) % COMPUTE_COUNT;
        }

        return result == 0
                ? COMPUTE_COUNT
                : result;
    }
}

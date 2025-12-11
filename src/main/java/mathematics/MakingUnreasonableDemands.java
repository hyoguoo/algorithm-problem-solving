/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 34893
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakingUnreasonableDemands {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long uCount = info[0];
        long oCount = info[1];
        long sCount = info[2];

        System.out.print(solution(uCount, oCount, sCount));
    }

    private static long solution(long uCount, long oCount, long sCount) {
        return Math.min(oCount, Math.min(uCount, (uCount + 2 * sCount) / 3));
    }
}

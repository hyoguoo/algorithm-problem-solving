/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24228
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chopsticks {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solution(info[0], info[1]));
    }

    private static long solution(long typeCount, long pairCount) {
        return typeCount + 1 + 2 * (pairCount - 1);
    }
}

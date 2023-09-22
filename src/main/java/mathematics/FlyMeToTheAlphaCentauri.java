/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1011
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlyMeToTheAlphaCentauri {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            stringBuilder.append(solution(info[0], info[1])).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static int solution(int src, int dist) {
        int distance = dist - src;
        int sqrt = (int) Math.sqrt(distance);
        int result = sqrt * 2 - 1;
        int remainder = distance - sqrt * sqrt;

        if (remainder > sqrt) return result + 2;
        else if (remainder > 0) return result + 1;
        return result;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11134
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CookieMonster {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int cookieCount = info[0];
            int monsterCount = info[1];

            stringBuilder.append(solution(cookieCount, monsterCount)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int cookieCount, int monsterCount) {
        return cookieCount % monsterCount == 0
                ? cookieCount / monsterCount
                : cookieCount / monsterCount + 1;
    }
}

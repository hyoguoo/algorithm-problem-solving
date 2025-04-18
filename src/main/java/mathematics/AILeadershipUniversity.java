/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 32951
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AILeadershipUniversity {

    private static final int ORIGIN_YEAR = 2024;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int targetYear) {
        return targetYear - ORIGIN_YEAR;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1072
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(info[0], info[1]));
    }

    private static int solution(long gameCount, long winCount) {
        long winRate = getWinRate(gameCount, winCount);
        if (winRate >= 99) return -1;
        return (int) Math.ceil((double) ((winCount * 100) - (gameCount * winRate) - gameCount) / (winRate - 99));
    }

    private static long getWinRate(long gameCount, long winCount) {
        return (winCount * 100) / gameCount;
    }
}

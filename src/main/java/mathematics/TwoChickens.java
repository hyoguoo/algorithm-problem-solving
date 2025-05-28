/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14489
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoChickens {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] balances = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int chickenPrice = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(balances, chickenPrice));
    }

    private static int solution(int[] balances, int chickenPrice) {
        int totalBalance = Arrays.stream(balances).sum();

        return chickenPrice * 2 <= totalBalance
                ? totalBalance - chickenPrice * 2
                : totalBalance;
    }
}

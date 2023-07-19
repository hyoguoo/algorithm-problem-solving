/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14916
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static int solution(int money) {
        if (money == 1 || money == 3) return -1;

        int count = money / 5;
        money %= 5;

        if (money == 0) return count;
        else if (money % 2 == 0) return count + money / 2;
        else return (count - 1) + (money + 5) / 2;
    }
}

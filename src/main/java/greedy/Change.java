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
        int count = 0;
        while (money >= 0) {
            if (money % 5 == 0) {
                count += money / 5;
                return count;
            } else {
                money -= 2;
                count++;
            }
        }

        return -1;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16237
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Movers {

    private static final int BAG_CAPACITY = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] stuffs = Arrays.stream(("0 " + bufferedReader.readLine()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print(solution(stuffs));
    }

    private static int solution(int[] stuffs) {
        int result = 0;

        for (int weightA = BAG_CAPACITY; weightA >= 1; weightA--) {
            while (stuffs[weightA]-- > 0) {
                int remainingWeight = BAG_CAPACITY - weightA;
                result++;
                for (int weightB = remainingWeight; weightB >= 1; weightB--) {
                    while (remainingWeight >= weightB && stuffs[weightB]-- > 0) {
                        remainingWeight -= weightB;
                    }
                }
            }
        }

        return result;
    }
}

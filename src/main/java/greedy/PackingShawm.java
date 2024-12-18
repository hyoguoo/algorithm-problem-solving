/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1817
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PackingShawm {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bookCount = info[0];
        int maxWeight = info[1];

        if (bookCount == 0) {
            System.out.print(0);
            return;
        }

        int[] bookWeights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(bookWeights, maxWeight));
    }

    private static int solution(int[] bookWeights, int maxWeight) {
        int count = 0;
        int sum = 0;
        for (int bookWeight : bookWeights) {
            if (sum + bookWeight > maxWeight) {
                count++;
                sum = 0;
            }
            sum += bookWeight;
        }
        return count + 1;
    }
}

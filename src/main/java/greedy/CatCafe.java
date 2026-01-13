/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28353
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CatCafe {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxWeight = info[1];

        int[] weights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(weights, maxWeight));
    }

    private static int solution(int[] weights, int maxWeight) {
        Arrays.sort(weights);

        int left = 0;
        int right = weights.length - 1;
        int happyPeople = 0;

        while (left < right) {
            if (weights[left] + weights[right] <= maxWeight) {
                happyPeople++;
                left++;
                right--;
            } else {
                right--;
            }
        }

        return happyPeople;
    }
}

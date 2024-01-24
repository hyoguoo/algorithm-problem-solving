/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11508
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPlusOneSale {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] products = new int[n];
        for (int i = 0; i < n; i++) {
            products[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(products));
    }

    private static int solution(int[] products) {
        Arrays.sort(products);

        int cost = 0;

        for (int i = products.length - 1; i >= 0; i--) {
            if ((products.length - i) % 3 == 0) continue;
            cost += products[i];
        }

        return cost;
    }
}

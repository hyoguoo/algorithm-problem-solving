/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11047
 * Cheat Level: 1
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Coin0 {

    static int target;
    static List<Integer> coinList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = infos[0];
        target = infos[1];

        for (int i = 0; i < length; i++) coinList.add(Integer.parseInt(bufferedReader.readLine()));

        coinList.sort(Collections.reverseOrder());
        System.out.println(getCount());

    }

    private static int getCount() {
        int count = 0;
        int sum = 0;

        for (Integer coin : coinList) {
            while (sum < target) {
                if (sum + coin <= target) {
                    sum += coin;
                    count++;
                } else break;
            }
        }

        return count;
    }
}

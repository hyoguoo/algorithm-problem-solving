/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30504
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SegwaYoungHasLegend {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int[] requiredAmounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bagAmounts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(n, requiredAmounts, bagAmounts));
    }

    private static String solution(int n, int[] requiredAmounts, int[] bagAmounts) {
        Pair[] requires = new Pair[n];
        Pair[] bags = new Pair[n];
        for (int i = 0; i < n; i++) {
            requires[i] = new Pair(requiredAmounts[i], i);
            bags[i] = new Pair(bagAmounts[i], i);
        }

        Arrays.sort(requires, Comparator.comparingInt(x -> x.value));
        Arrays.sort(bags, Comparator.comparingInt(x -> x.value));

        int[] result = new int[n];

        int bagIndex = 0;

        for (int i = 0; i < n; i++) {
            if (bagIndex >= n || bags[bagIndex].value < requires[i].value) {
                return "-1";
            }
            result[requires[i].index] = bags[bagIndex].value;
            bagIndex++;
        }

        return Arrays.toString(result).replaceAll("[\\[\\],]", "");
    }

    static class Pair {

        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

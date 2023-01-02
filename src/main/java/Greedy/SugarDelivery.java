/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2839
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {

    static final int THREE = 3;
    static final int FIVE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());

        System.out.println(countMinimumBag(target));
    }

    private static int countMinimumBag(int target) {
        int bag5count = target / FIVE;
        int bag3count = 0;

        while (true) {
            int current = bag5count * FIVE + bag3count * THREE;
            if (current == target) return bag3count + bag5count;
            else if (current < target) bag3count++;
            else bag5count--;
            if (bag5count < 0) return -1;
        }
    }
}

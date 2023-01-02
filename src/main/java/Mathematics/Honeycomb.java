/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2292
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Honeycomb {

    private static final int DIFFERENCE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());

        System.out.println(getNumberOfLayer(target));
    }

    private static int getNumberOfLayer(int target) {
        int sum = 1;
        int depth = 0;

        while (true) {
            sum += depth * DIFFERENCE;
            if (sum >= target) return depth + 1;
            depth++;
        }
    }
}
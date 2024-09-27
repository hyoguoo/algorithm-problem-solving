/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13116
 * Cheat Level: 0
 * Algorithm: Tree / Mathematics
 */

package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question30 {

    private static final int WEIGHT = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(info[0], info[1])).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int a, int b) {
        int lca = findLCA(a, b);
        return WEIGHT * lca;
    }

    private static int findLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else {
                b /= 2;
            }
        }
        return a;
    }
}

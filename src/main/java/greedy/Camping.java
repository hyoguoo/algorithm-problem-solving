/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4796
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Camping {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = 1;

        while (true) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] == 0 && input[1] == 0 && input[2] == 0) break;
            System.out.println("Case " + caseNumber++ + ": " + solution(input[0], input[1], input[2]));
        }
    }

    private static int solution(int L, int P, int V) {
        int quotient = V / P;
        int remainder = V % P;
        return quotient * L + Math.min(remainder, L);
    }
}

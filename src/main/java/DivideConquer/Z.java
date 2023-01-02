/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1074
 * Cheat Level: 0
 * Algorithm: Divide Conquer
 */

package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Z {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(recursion(infos[1], infos[2], infos[0], 0));
    }

    private static int getQuadrant(float x, float y, int N) {
        int mid = N / 2;
        if (x < mid && y < mid) return 0;
        else if (x < mid && y >= mid) return 1;
        else if (x >= mid && y < mid) return 2;
        else return 3;
    }

    private static int recursion(float c, float r, int division, int result) {
        int quadrant = getQuadrant(c, r, (int) Math.pow(2, division));
        if (division == 1) return result + quadrant;

        int calculateSum = (int) Math.pow(2, (division - 1) * 2) * quadrant;
        int half = (int) Math.pow(2, division - 1);
        return recursion(c % half, r % half, division - 1, result + calculateSum);
    }
}

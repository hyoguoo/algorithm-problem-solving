/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1193
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindFountain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        solution(Integer.parseInt(bufferedReader.readLine()));
    }

    private static void solution(int N) {
        int crossCount = 1;
        int previousCount = 0;

        while (true) {
            if (N <= previousCount + crossCount) {
                if (crossCount % 2 == 1) {
                    System.out.print((crossCount - (N - previousCount - 1)) + "/" + (N - previousCount));
                }
                else {
                    System.out.print((N - previousCount) + "/" + (crossCount - (N - previousCount - 1)));
                }
                break;
            } else {
                previousCount += crossCount;
                crossCount++;
            }
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31589
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WineTasting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int tastingCount = info[1];
        int[] wines = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(wines, tastingCount));
    }

    private static long solution(int[] wines, int tastingCount) {
        int[] sortedWines = Arrays.stream(wines)
                .sorted()
                .toArray();
        long sum = sortedWines[sortedWines.length - 1];
        tastingCount--;

        int leftIndex = 0;
        int rightIndex = sortedWines.length - 2;
        while (tastingCount >= 2) {
            sum += sortedWines[rightIndex] - sortedWines[leftIndex];
            leftIndex++;
            rightIndex--;
            tastingCount -= 2;
        }

        return sum;
    }
}

// 3 6 8 8 15
/*
5 1
8 3 15 8 6
 */

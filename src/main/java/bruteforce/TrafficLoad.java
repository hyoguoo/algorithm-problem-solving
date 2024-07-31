/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11116
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrafficLoad {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        
        StringBuilder stringBuilder = new StringBuilder();
        
        while (testCount-- > 0) {
            bufferedReader.readLine();
            int[] leftRecords = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] rightRecords = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            stringBuilder.append(solution(leftRecords, rightRecords)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] leftRecords, int[] rightRecords) {
        int count = 0;

        for (int target : leftRecords) {
            if (Arrays.binarySearch(leftRecords, target + 500) >= 0 &&
                    Arrays.binarySearch(rightRecords, target + 1000) >= 0 &&
                    Arrays.binarySearch(rightRecords, target + 1500) >= 0) {
                count++;
            }
        }

        return count;
    }
}

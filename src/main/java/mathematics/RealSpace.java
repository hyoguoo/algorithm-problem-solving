/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1350
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RealSpace {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] fileSizes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int clusterSize = Integer.parseInt(bufferedReader.readLine());

        System.out.print(solution(fileSizes, clusterSize));
    }

    private static long solution(int[] fileSizes, int clusterSize) {
        return Arrays.stream(fileSizes)
                .mapToLong(fileSize -> calculateClusterCount(clusterSize, fileSize))
                .sum();
    }

    private static long calculateClusterCount(int clusterSize, int fileSize) {
        return (long) Math.ceil(fileSize / (double) clusterSize) * clusterSize;
    }
}

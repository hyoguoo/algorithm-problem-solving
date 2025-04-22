/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1911
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MuddyRoads {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int poolCount = info[0];
        int plankLength = info[1];
        Pool[] pools = new Pool[poolCount];

        for (int p = 0; p < poolCount; p++) {
            int[] poolInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pools[p] = new Pool(poolInfo[0], poolInfo[1]);
        }

        System.out.print(solution(pools, plankLength));
    }

    private static int solution(Pool[] pools, int plankLength) {
        Arrays.sort(pools, MuddyRoads::compare);
        int current = -1;
        int totalPlankCount = 0;

        for (Pool pool : pools) {
            current = Math.max(current, pool.left);
            int diff = pool.right - current;
            int neededPlankCount = (int) Math.ceil((double) diff / plankLength);
            totalPlankCount += neededPlankCount;
            current += neededPlankCount * plankLength;
        }

        return totalPlankCount;
    }

    private static int compare(Pool o1, Pool o2) {
        if (o1.left == o2.left) {
            return Integer.compare(o1.right, o2.right);
        }
        return Integer.compare(o1.left, o2.left);
    }

    static class Pool {

        private final int left;
        private final int right;

        public Pool(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}

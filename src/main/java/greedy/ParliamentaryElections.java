/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1417
 * Cheat Level: 0
 * Algorithm: Greedy / Priority Queue
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ParliamentaryElections {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int me = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> voteCounts = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 1; i < n; i++) {
            voteCounts.add(Integer.parseInt(bufferedReader.readLine()));
        }

        System.out.print(solution(voteCounts, me));
    }

    private static int solution(PriorityQueue<Integer> voteCounts, int me) {
        int count = 0;

        while (!voteCounts.isEmpty()) {
            int max = voteCounts.poll();
            if (max < me) {
                break;
            }
            voteCounts.add(max - 1);
            me++;
            count++;
        }

        return count;
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1715
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortingCards {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int n = 0; n < N; n++) {
            priorityQueue.add(Long.parseLong(bufferedReader.readLine()));
        }

        System.out.println(solution(priorityQueue));
    }

    private static long solution(PriorityQueue<Long> priorityQueue) {
        long sum = 0;
        while (priorityQueue.size() != 1) {
            long first = priorityQueue.poll();
            long second = priorityQueue.poll();
            sum += first + second;
            priorityQueue.add(first + second);
        }

        return sum;
    }
}

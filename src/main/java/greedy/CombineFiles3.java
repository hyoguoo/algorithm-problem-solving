/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13975
 * Cheat Level: 0
 * Algorithm: Greedy / Priority Queue
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CombineFiles3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            bufferedReader.readLine();
            long[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            stringBuilder.append(solution(numbers)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static long solution(long[] numbers) {
        SumPriorityQueue sumPriorityQueue = new SumPriorityQueue(numbers);
        sumPriorityQueue.combineFiles();
        return sumPriorityQueue.getResult();
    }

    static class SumPriorityQueue {

        private final PriorityQueue<Long> priorityQueue;
        private long result;

        public SumPriorityQueue(long[] numbers) {
            this.priorityQueue = new PriorityQueue<>();
            Arrays.stream(numbers).forEach(priorityQueue::add);
            result = 0;
        }

        public void combineFiles() {
            while (priorityQueue.size() > 1) {
                long sum = priorityQueue.poll() + priorityQueue.poll();
                result += sum;
                priorityQueue.add(sum);
            }
        }

        public long getResult() {
            return result;
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2075
 */

package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NthLargestNumber {

    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int number : numbers) priorityQueue.add(number);
        }

        for (int i = 0; i < length - 1; i++) priorityQueue.poll();
        System.out.println(priorityQueue.poll());
    }
}

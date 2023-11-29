/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13335
 * Cheat Level: 0
 * Algorithm: Queue
 */

package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Trucks {

    static final int EMPTY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] weights = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(info[1], info[2], weights));
    }


    public static int solution(int bridgeLength, int maxWeight, int[] weigths) {
        Deque<Integer> queue = new ArrayDeque<>();

        int time = 0;
        int currentWeight = 0;
        int index = 0;

        while (index < weigths.length) {
            if (queue.size() == bridgeLength && !queue.isEmpty()) {
                currentWeight -= queue.poll();
            }

            if (currentWeight + weigths[index] <= maxWeight) {
                queue.offer(weigths[index]);
                currentWeight += weigths[index];
                index++;
            } else {
                queue.offer(EMPTY);
            }

            time++;
        }

        return time + bridgeLength;
    }
}

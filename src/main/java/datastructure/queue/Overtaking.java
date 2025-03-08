/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2002
 * Cheat Level: 0
 * Algorithm: Queue
 */

package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

public class Overtaking {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carCount = Integer.parseInt(bufferedReader.readLine());

        String[] inOrder = new String[carCount];
        String[] outOrder = new String[carCount];

        for (int i = 0; i < carCount; i++) {
            inOrder[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < carCount; i++) {
            outOrder[i] = bufferedReader.readLine();
        }

        System.out.print(solution(inOrder, outOrder));
    }

    private static long solution(String[] inOrder, String[] outOrder) {
        Queue<String> inQueue = Arrays.stream(inOrder)
                .collect(Collectors.toCollection(java.util.LinkedList::new));
        Queue<String> outQueue = Arrays.stream(outOrder)
                .collect(Collectors.toCollection(java.util.LinkedList::new));

        int count = 0;
        while (!outQueue.isEmpty()) {
            String outCar = outQueue.poll();

            if (inQueue.peek().equals(outCar)) {
                inQueue.poll();
            } else {
                count++;
                inQueue.remove(outCar);
            }
        }

        return count;
    }
}

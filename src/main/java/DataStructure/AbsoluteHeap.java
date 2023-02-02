/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11286
 * Cheat Level: 0
 * Algorithm: Heap / Priority Queue
 */

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AbsoluteHeap {

    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) return o1 - o2;
            else return abs1 - abs2;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            int result = solution(number);
            if (number == 0) System.out.println(result);
        }
    }

    private static int solution(int number) {
        if (number == 0) {
            if (priorityQueue.isEmpty()) return 0;
            return priorityQueue.poll();
        } else {
            priorityQueue.add(number);
            return -1;
        }
    }
}

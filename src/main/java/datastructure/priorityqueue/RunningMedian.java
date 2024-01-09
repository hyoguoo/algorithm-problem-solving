/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2696
 * Cheat Level: 0
 * Algorithm: Priority Queue
 */

package datastructure.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (testCount-- > 0) {
            List<Integer> numberList = readNumberList();
            stringBuilder.append(integerListToString(solution(numberList))).append("\n");
        }

        System.out.print(stringBuilder);
    }

    private static List<Integer> solution(List<Integer> numberList) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numberList.size(); i++) {
            int number = numberList.get(i);

            if (minHeap.size() == maxHeap.size()) maxHeap.add(number);
            else minHeap.add(number);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }

            if (i % 2 == 0) result.add(maxHeap.peek());
        }

        return result;
    }

    private static String integerListToString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        stringBuilder.append(size);

        for (int i = 0; i < size; i++) {
            if (i % 10 == 0) stringBuilder.append("\n");
            stringBuilder.append(list.get(i)).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    private static List<Integer> readNumberList() throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());

        int readLineCount = n / 10 + 1;

        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < readLineCount; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int number : numbers) {
                numberList.add(number);
            }
        }

        return numberList;
    }
}

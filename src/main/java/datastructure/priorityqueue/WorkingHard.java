/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31860
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

public class WorkingHard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int taskCount = info[0];
        int throughPut = info[1];
        int consideredComplete = info[2];
        int[] tasks = new int[taskCount];
        for (int i = 0; i < taskCount; i++) {
            tasks[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(tasks, throughPut, consideredComplete));
    }

    private static String solution(int[] tasks, int throughPut, int consideredComplete) {
        List<Integer> satisfactionList = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = createPriorityQueue(tasks);

        while (!priorityQueue.isEmpty()) {
            Integer importance = priorityQueue.poll();
            int previousSatisfaction = satisfactionList.isEmpty()
                    ? 0
                    : satisfactionList.get(satisfactionList.size() - 1);
            satisfactionList.add(
                    calculateSatisfaction(
                            previousSatisfaction,
                            importance
                    )
            );
            int remainingImportance = importance - throughPut;
            if (remainingImportance > consideredComplete) {
                priorityQueue.add(remainingImportance);
            }
        }

        return convertResult(satisfactionList);
    }

    private static PriorityQueue<Integer> createPriorityQueue(int[] tasks) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int task : tasks) {
            priorityQueue.add(task);
        }
        return priorityQueue;
    }

    private static int calculateSatisfaction(int previousSatisfaction, int currentImportance) {
        return previousSatisfaction / 2 + currentImportance;
    }

    private static String convertResult(List<Integer> satisfactionList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(satisfactionList.size()).append("\n");
        for (Integer satisfaction : satisfactionList) {
            stringBuilder.append(satisfaction).append("\n");
        }

        return stringBuilder.toString().trim();
    }
}

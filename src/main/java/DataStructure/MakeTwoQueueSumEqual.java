/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 92341
 * Cheat Level: 0
 * Algorithm: Queue
 */

package DataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MakeTwoQueueSumEqual {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    long sum1, sum2, sum, average;
    int size;

    public int solution(int[] numbers1, int[] numbers2) {
        init(numbers1, numbers2);
        if (sum % 2 != 0) return -1;

        int count = 0;

        while (sum1 != average) {
            count++;
            if (sum1 > average) delete();
            else add();
            if (count > (size) * 2) return -1;
        }

        return count;
    }

    private void add() {
        int numberB = queue2.remove();
        sum1 += numberB;
        sum2 -= numberB;
        queue1.add(numberB);
    }

    private void delete() {
        int numberA = queue1.remove();
        sum1 -= numberA;
        sum2 += numberA;
        queue2.add(numberA);
    }

    private void init(int[] numbers1, int[] numbers2) {
        sum1 = getArraySum(numbers1);
        sum2 = getArraySum(numbers2);
        sum = sum1 + sum2;
        average = sum / 2;
        queue1 = getQueue(numbers1);
        queue2 = getQueue(numbers2);
        size = numbers1.length + numbers2.length;
    }

    private Queue<Integer> getQueue(int[] numbers) {
        Queue<Integer> queue = new LinkedList<>();
        for (int number : numbers) queue.add(number);

        return queue;
    }

    private long getArraySum(int[] array) {
        return Arrays.stream(array).sum();
    }
}

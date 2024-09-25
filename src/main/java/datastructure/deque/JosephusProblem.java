/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1158 / 11866
 * Cheat Level: 0
 * Algorithm: Deque
 */

package datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JosephusProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int peopleCount = info[0];
        int removeIndex = info[1];
        
        System.out.print(solution(peopleCount, removeIndex));
    }

    private static String solution(int peopleCount, int removeIndex) {
        JosephusDeque josephusDeque = new JosephusDeque(peopleCount);

        while (!josephusDeque.isRemovedAll()) {
            josephusDeque.removePeople(removeIndex);
        }

        return josephusDeque.formatRemovedPeople();
    }

    static class JosephusDeque {

        private final Queue<Integer> queue;
        private final List<Integer> removedPeopleHistory;

        public JosephusDeque(int peopleCount) {
            queue = new LinkedList<>();
            removedPeopleHistory = new ArrayList<>();
            for (int i = 1; i <= peopleCount; i++) {
                queue.add(i);
            }
        }

        public void removePeople(int removeIndex) {
            int index = calculateRemoveIndex(removeIndex - 1);
            removePerson(index);
        }

        public boolean isRemovedAll() {
            return queue.isEmpty();
        }

        private void removePerson(int index) {
            for (int i = 0; i < index; i++) {
                queue.add(queue.poll());
            }
            removedPeopleHistory.add(queue.poll());
        }

        private int calculateRemoveIndex(int removeIndex) {
            return removeIndex % queue.size();
        }

        public String formatRemovedPeople() {
            StringBuilder result = new StringBuilder("<");
            for (int i = 0; i < removedPeopleHistory.size(); i++) {
                result.append(removedPeopleHistory.get(i));
                if (i < removedPeopleHistory.size() - 1) {
                    result.append(", ");
                }
            }
            result.append(">");
            return result.toString();
        }
    }
}

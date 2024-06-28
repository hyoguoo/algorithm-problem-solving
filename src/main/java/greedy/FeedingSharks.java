/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30892
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FeedingSharks {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int eatingLimit = info[1];
        int currentSize = info[2];
        int[] feed = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Shark shark = new Shark(currentSize, eatingLimit);

        System.out.print(solution(shark, feed));
    }

    private static long solution(Shark shark, int[] feed) {
        Arrays.sort(feed);
        Deque<Integer> biggerDeque = new ArrayDeque<>();
        Deque<Integer> smallerDeque = new ArrayDeque<>();
        for (int f : feed) {
            if (!shark.isEatableSize(f)) {
                biggerDeque.addLast(f);
            } else {
                smallerDeque.addFirst(f);
            }
        }

        while (shark.isEatingLimitRemaining() && !smallerDeque.isEmpty()) {
            shark.eat(smallerDeque.pollFirst());

            while (!biggerDeque.isEmpty() && shark.isEatableSize(biggerDeque.peekFirst())) {
                smallerDeque.addFirst(biggerDeque.pollFirst());
            }
        }

        return shark.getSize();
    }

    static class Shark {

        private long size;
        private int eatingLimit;

        public Shark(long size, int eatingLimit) {
            this.size = size;
            this.eatingLimit = eatingLimit;
        }

        public boolean isEatingLimitRemaining() {
            return this.eatingLimit > 0;
        }

        public boolean isEatableSize(int feed) {
            return this.size > feed;
        }

        public void eat(int feed) {
            if (this.isEatingLimitRemaining() && this.isEatableSize(feed)) {
                this.size += feed;
                this.eatingLimit--;
            }
        }

        public long getSize() {
            return size;
        }
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1863
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

public class SkylineEasyVersion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int heightChangeCount = Integer.parseInt(bufferedReader.readLine());

        HeightChange[] heightChanges = new HeightChange[heightChangeCount];

        for (int i = 0; i < heightChangeCount; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            heightChanges[i] = new HeightChange(info[0], info[1]);
        }

        System.out.print(solution(heightChanges));
    }

    private static long solution(HeightChange[] heightChanges) {
        int count = 0;
        Deque<Integer> heightStack = new ArrayDeque<>();

        for (HeightChange heightChange : heightChanges) {
            while (!heightStack.isEmpty() && heightStack.peek() > heightChange.height) {
                heightStack.pop();
                count++;
            }

            if (heightStack.isEmpty() || heightStack.peek() < heightChange.height) {
                heightStack.push(heightChange.height);
            }
        }

        return count +
                heightStack.stream()
                        .mapToInt(Integer::intValue)
                        .filter(height -> height != 0)
                        .count();
    }

    static class HeightChange {

        private final int index;
        private final int height;

        public HeightChange(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}

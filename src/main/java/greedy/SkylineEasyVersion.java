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
import java.util.Arrays;
import java.util.Stack;

public class SkylineEasyVersion {

    static int count = 0;
    static final Stack<Integer> heightStack = new Stack<>() {
        @Override
        public synchronized Integer peek() {
            if (heightStack.isEmpty()) return 0;
            return heightStack.elementAt(heightStack.size() - 1);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            int[] skyline = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            getCount(skyline[1]);
        }
        System.out.println(count);
    }

    private static void getCount(int height) {
        if (heightStack.peek() < height) {
            count++;
            heightStack.push(height);
        } else if (heightStack.peek() > height) {
            while (heightStack.peek() > height) heightStack.pop();
            if (heightStack.peek() != height) {
                count++;
                heightStack.push(height);
            }
        }
    }
}

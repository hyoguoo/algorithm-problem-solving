/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1461
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Library {

    final static List<Integer> leftList = new ArrayList<>();
    final static List<Integer> rightList = new ArrayList<>();
    static int CARRYING_CAPACITY;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static int solution() {
        int result = 0;

        leftList.sort(Comparator.comparingInt(o -> o));
        rightList.sort(Comparator.reverseOrder());

        result += removeLongestSideBook();
        result += removeBook(leftList);
        result += removeBook(rightList);

        return result;
    }

    private static int removeLongestSideBook() {
        int leftMax = leftList.isEmpty() ? 0 : Math.abs(leftList.get(0));
        int rightMax = rightList.isEmpty() ? 0 : rightList.get(0);

        List<Integer> listToRemove = leftMax > rightMax ? leftList : rightList;
        for (int i = listToRemove.size() - 1; i >= 0; i--) {
            if (i < CARRYING_CAPACITY) listToRemove.remove(i);
        }

        return Math.max(leftMax, rightMax);
    }

    private static int removeBook(List<Integer> list) {
        int index = 0;
        int result = 0;

        while (index < list.size()) {
            result += Math.abs(list.get(index)) * 2;
            index += CARRYING_CAPACITY;
        }

        return result;
    }


    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bookCount = info[0];
        CARRYING_CAPACITY = info[1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int count = 0; count < bookCount; count++) {
            int distance = Integer.parseInt(stringTokenizer.nextToken());
            if (distance < 0) leftList.add(distance);
            else rightList.add(distance);
        }
    }
}

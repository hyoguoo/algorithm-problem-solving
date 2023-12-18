/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2828
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int basketLength = info[1];
        int appleCount = Integer.parseInt(bufferedReader.readLine());
        List<Integer> appleList = new ArrayList<>();
        for (int i = 0; i < appleCount; i++) appleList.add(Integer.parseInt(bufferedReader.readLine()));

        System.out.println(solution(basketLength, appleList));
    }

    private static int solution(int basketLength, List<Integer> appleList) {
        int distance = 0;

        int left = 1;
        int right = basketLength;

        for (Integer apple : appleList) {
            if (apple < left) {
                distance += (left - apple);
                left = apple;
                right = left + basketLength - 1;
            } else if (apple > right) {
                distance += (apple - right);
                right = apple;
                left = right - basketLength + 1;
            }
        }

        return distance;
    }
}

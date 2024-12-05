/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2605
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LineUp {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] offsets = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(offsets));
    }

    private static String solution(int[] offsets) {
        List<Integer> resultList = new LinkedList<>();

        for (int i = 0; i < offsets.length; i++) {
            int element = i + 1;
            int offset = offsets[i];
            resultList.add(resultList.size() - offset, element);
        }

        return resultList.toString().replaceAll("[^0-9 ]", "");
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2460
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntelligentTrain {
    static final int TRAIN_NUMBER = 10;
    static List<Integer> peopleCount = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < TRAIN_NUMBER; i++) {
            int[] countInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            count += (countInfo[1] - countInfo[0]);
            peopleCount.add(count);
        }

        System.out.println(Collections.max(peopleCount));
    }
}

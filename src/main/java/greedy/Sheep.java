/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2853
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sheep {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int excitingDayCount = Integer.parseInt(bufferedReader.readLine());
        int[] excitingDays = new int[excitingDayCount];

        for (int i = 0; i < excitingDayCount; i++) {
            excitingDays[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(excitingDays));
    }

    private static int solution(int[] excitingDays) {
        List<Integer> days = Arrays.stream(excitingDays)
                .skip(1)
                .map(i -> i - 1)
                .boxed()
                .collect(Collectors.toList());

        int count = 0;

        while (!days.isEmpty()) {
            int d = days.remove(0);
            days.removeIf(day -> day % d == 0);
            count++;
        }

        return count;
    }
}

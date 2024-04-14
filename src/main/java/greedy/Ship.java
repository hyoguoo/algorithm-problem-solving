/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1092
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

public class Ship {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] limits = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        bufferedReader.readLine();
        int[] weights = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(limits, weights));
    }

    private static int solution(int[] limits, int[] weights) {
        List<Integer> limitList = getSortedDescendingList(limits);
        List<Integer> weightList = getSortedDescendingList(weights);

        if (limitList.get(0) < weightList.get(0)) {
            return -1;
        }

        int time = 0;
        while (!weightList.isEmpty()) {
            for (Integer limit : limitList) {
                for (int i = 0; i < weightList.size(); i++) {
                    if (limit >= weightList.get(i)) {
                        weightList.remove(i);
                        break;
                    }
                }
            }
            time++;
        }

        return time;
    }

    private static List<Integer> getSortedDescendingList(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
    }
}

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 29615
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class AlphaVilleAndBetaVille {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] waitingNumbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] friendNumbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(waitingNumbers, friendNumbers));
    }

    private static long solution(int[] waitingNumbers, int[] friendNumbers) {
        Set<Integer> friendSet = Arrays.stream(friendNumbers)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(waitingNumbers, 0, friendSet.size())
                .filter(o -> !friendSet.contains(o))
                .count();
    }
}

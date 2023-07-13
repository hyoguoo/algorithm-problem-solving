/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2217
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Rope {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<Integer> ropeList = new ArrayList<>();
        for (int n = 0; n < N; n++) ropeList.add(Integer.parseInt(bufferedReader.readLine()));
        ropeList.sort(Integer::compareTo);

        System.out.println(solution(ropeList));
    }

    private static int solution(List<Integer> ropeList) {
        return IntStream.range(0, ropeList.size())
                .map(i -> ropeList.get(i) * (ropeList.size() - i))
                .max().orElse(0);
    }
}

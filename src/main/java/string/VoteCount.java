/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10102
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VoteCount {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String s) {
        Map<Character, Long> voteCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long maxVotes = voteCount.values().stream().max(Long::compare).orElse(0L);

        long tieCount = voteCount.values().stream().filter(v -> v == maxVotes).count();

        return tieCount > 1
                ? "Tie"
                : voteCount.entrySet().stream()
                        .filter(entry -> entry.getValue() == maxVotes)
                        .findFirst()
                        .map(entry -> entry.getKey().toString())
                        .orElse("");
    }
}

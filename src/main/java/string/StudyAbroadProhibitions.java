/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2789
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class StudyAbroadProhibitions {

    private static final Set<Character> PROHIBITED_CHARACTERS = Set.of('C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E');

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static String solution(String input) {
        return input.chars()
                .filter(c -> !PROHIBITED_CHARACTERS.contains((char) c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}

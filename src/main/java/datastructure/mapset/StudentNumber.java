/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1235
 * Cheat Level: 0
 * Algorithm: Set / String
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class StudentNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());
        String[] studentNumbers = new String[studentCount];

        for (int i = 0; i < studentCount; i++) {
            studentNumbers[i] = bufferedReader.readLine();
        }

        System.out.print(solution(studentNumbers));
    }

    private static int solution(String[] studentNumbers) {
        return IntStream.rangeClosed(1, studentNumbers[0].length())
                .filter(length -> isUnique(studentNumbers, length))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean isUnique(String[] studentNumbers, int length) {
        return Arrays.stream(studentNumbers)
                .map(studentNumber -> studentNumber.substring(studentNumber.length() - length))
                .collect(HashSet::new, Set::add, Set::addAll)
                .size() == studentNumbers.length;
    }
}

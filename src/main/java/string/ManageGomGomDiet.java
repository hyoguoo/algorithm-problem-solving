/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 25193
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManageGomGomDiet {

    static final char CHICKEN = 'C';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static long solution(String s) {
        long chickenCount = calculateChickenCount(s);
        long otherCount = s.length() - chickenCount;

        return otherCount == 0
                ? chickenCount
                : (long) Math.ceil((double) chickenCount / (otherCount + 1));
    }

    private static long calculateChickenCount(String s) {
        return s.chars()
                .filter(c -> c == CHICKEN)
                .count();
    }
}

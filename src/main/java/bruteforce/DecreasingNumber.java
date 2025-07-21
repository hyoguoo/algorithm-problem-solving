/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1038
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DecreasingNumber {

    private static final List<Long> decreasingNumberList = new ArrayList<>();

    static {
        for (int i = 0; i <= 9; i++) {
            generateDecreasingNumbers(i, i - 1);
        }
        decreasingNumberList.sort(Long::compareTo);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static long solution(int n) {
        if (n >= decreasingNumberList.size()) {
            return -1;
        }
        return decreasingNumberList.get(n);
    }

    private static void generateDecreasingNumbers(long currentNumber, int nextDigit) {
        decreasingNumberList.add(currentNumber);
        for (int i = nextDigit; i >= 0; i--) {
            generateDecreasingNumbers(currentNumber * 10 + i, i - 1);
        }
    }
}

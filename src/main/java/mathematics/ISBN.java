/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14626
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBN {

    private static final char CORRUPTED_CHARACTER = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String s) {
        int sum = 0;
        int findCorruptedIndex = s.indexOf(CORRUPTED_CHARACTER);

        for (int i = 0; i < s.length(); i++) {
            if (i == findCorruptedIndex) {
                continue;
            }
            sum += i % 2 == 0
                    ? s.charAt(i) - '0'
                    : (s.charAt(i) - '0') * 3;
        }

        for (int answer = 0; answer < 10; answer++) {
            int weights = findCorruptedIndex % 2 == 0
                    ? 1
                    : 3;
            int currentSum = sum + answer * weights;

            if (currentSum % 10 == 0) {
                return answer;
            }
        }

        return -1;
    }
}

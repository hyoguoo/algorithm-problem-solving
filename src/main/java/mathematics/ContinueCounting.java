/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2635
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContinueCounting {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(Integer.parseInt(bufferedReader.readLine())));
    }

    private static String solution(int n) {
        List<Integer> result = new ArrayList<>();

        for (int second = n / 2; second <= n; second++) {
            List<Integer> sequence = new ArrayList<>();

            sequence.add(n);
            sequence.add(second);
            while (true) {
                int nextNumber =
                        sequence.get(sequence.size() - 2) - sequence.get(sequence.size() - 1);
                if (nextNumber < 0) {
                    break;
                }
                sequence.add(nextNumber);
            }
            if (result.size() < sequence.size()) {
                result = sequence;
            }
        }

        return result.size() + "\n" + result.toString().replaceAll("[\\[\\],]", "");
    }
}

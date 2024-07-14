/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10448
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EurekaTheorem {

    private static final int MAX = 1000;
    private static final List<Integer> TRIANGULAR_NUMBER_LIST = new ArrayList<>();

    static {
        for (int i = 1; i <= MAX; i++) {
            int triangularNumber = i * (i + 1) / 2;
            if (triangularNumber > MAX) {
                break;
            }
            TRIANGULAR_NUMBER_LIST.add(triangularNumber);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (testCount-- > 0) {
            stringBuilder
                    .append(
                            solution(Integer.parseInt(bufferedReader.readLine()))
                                    ? 1 : 0
                    ).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(int n) {
        for (int i = 0; i < TRIANGULAR_NUMBER_LIST.size(); i++) {
            for (int j = 0; j < TRIANGULAR_NUMBER_LIST.size(); j++) {
                for (int k = 0; k < TRIANGULAR_NUMBER_LIST.size(); k++) {
                    int result = TRIANGULAR_NUMBER_LIST.get(i)
                            + TRIANGULAR_NUMBER_LIST.get(j)
                            + TRIANGULAR_NUMBER_LIST.get(k);
                    if (result == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

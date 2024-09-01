/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1703
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GrowthTips {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int length = Integer.parseInt(stringTokenizer.nextToken());
            if (length == 0) {
                break;
            }
            int[] splittingFactors = new int[length];
            int[] pruningCount = new int[length];
            for (int i = 0; i < length; i++) {
                splittingFactors[i] = Integer.parseInt(stringTokenizer.nextToken());
                pruningCount[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringBuilder.append(solution(splittingFactors, pruningCount)).append("\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static int solution(int[] splittingFactors, int[] pruningCount) {
        int result = 1;

        for (int i = 0; i < splittingFactors.length; i++) {
            result *= splittingFactors[i];
            result -= pruningCount[i];
        }

        return result;
    }
}

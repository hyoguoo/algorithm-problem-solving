/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5525
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        String targetString = getTargetString(n);
        String baseString = bufferedReader.readLine();

        System.out.println(solution(targetString, baseString));
    }

    private static String getTargetString(int n) {
        return String.format("I%s", "OI".repeat(Math.max(0, n)));
    }

    private static int solution(String targetString, String baseString) {
        int[] pi = getPi(targetString);
        int j = 0;
        int count = 0;
        for (int i = 0; i < baseString.length(); i++) {
            while (j > 0 && baseString.charAt(i) != targetString.charAt(j)) j = pi[j - 1];
            if (baseString.charAt(i) == targetString.charAt(j)) {
                if (j == targetString.length() - 1) {
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    private static int[] getPi(String targetString) {
        int[] pi = new int[targetString.length()];
        int j = 0;
        for (int i = 1; i < targetString.length(); i++) {
            while (j > 0 && targetString.charAt(i) != targetString.charAt(j)) j = pi[j - 1];
            if (targetString.charAt(i) == targetString.charAt(j)) pi[i] = ++j;
        }
        return pi;
    }
}

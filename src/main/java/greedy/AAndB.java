/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12904
 * Cheat Level: 0
 * Algorithm: Greedy / String
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AAndB {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String target = bufferedReader.readLine();
        String src = bufferedReader.readLine();
        System.out.println(solution(src, target) ? 1 : 0);
    }

    private static boolean solution(String src, String target) {
        StringBuilder srcBuilder = new StringBuilder(src);

        while (srcBuilder.length() != target.length()) {
            if (srcBuilder.charAt(srcBuilder.length() - 1) == 'A') srcBuilder.deleteCharAt(srcBuilder.length() - 1);
            else {
                srcBuilder.deleteCharAt(srcBuilder.length() - 1);
                srcBuilder.reverse();
            }
        }

        return srcBuilder.toString().equals(target);
    }
}

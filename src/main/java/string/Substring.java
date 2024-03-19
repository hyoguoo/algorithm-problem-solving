/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 6550
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substring {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            String s = bufferedReader.readLine();
            if (s == null) {
                break;
            }
            String[] info = s.split(" ");

            stringBuilder.append(solution(info[0], info[1]) ? "Yes\n" : "No\n");
        }

        System.out.print(stringBuilder.toString().trim());
    }

    private static boolean solution(String a, String b) {
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < a.length() && bIndex < b.length()) {
            if (a.charAt(aIndex) == b.charAt(bIndex)) {
                aIndex++;
            }
            bIndex++;
        }

        return aIndex == a.length();
    }
}

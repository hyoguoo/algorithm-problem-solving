/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3107
 * Cheat Level: 0
 * Algorithm: String
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPv6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String v6 = bufferedReader.readLine();
        String v4 = convertV4FromV6(v6);

        System.out.println(v4);
    }

    private static String convertV4FromV6(String v6) {
        String replaced = processDoubleColon(v6);
        String[] splitString = replaced.split(":");
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : splitString) {
            String addString = padLeft(string, "0", 4);
            stringBuilder.append(addString).append(":");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    private static String processDoubleColon(String v6) {
        StringBuilder stringBuilder = new StringBuilder(v6.replace("::", ":0000:0000:0000:0000:0000:0000:0000:"));

        if (stringBuilder.charAt(0) == ':') stringBuilder.deleteCharAt(0);
        String string = stringBuilder.toString();
        int length = string.split(":").length;

        for (int i = length; i > 8; i--) {
            string = string.replaceFirst(":0000", "");
        }

        return string;
    }


    private static String padLeft(String string, String addString, int length) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length - string.length(); i++) stringBuilder.append(addString);
        stringBuilder.append(string);

        return stringBuilder.toString();
    }
}

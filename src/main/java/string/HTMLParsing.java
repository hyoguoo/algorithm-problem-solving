/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22859
 * Cheat Level: 4
 * Algorithm: String / Regular Expression
 */

package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParsing {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        System.out.println(solution(input));
    }

    public static String solution(String input) {
        List<String> answer = new ArrayList<>();

        Pattern divPattern = Pattern.compile("<div title=\"(.*?)\">(.*?)</div>");
        Matcher divMatcher = divPattern.matcher(input);

        while (divMatcher.find()) {
            String title = divMatcher.group(1);
            String divContent = divMatcher.group(2);

            Pattern pPattern = Pattern.compile("<p>(.*?)</p>");
            Matcher pMatcher = pPattern.matcher(divContent);
            List<String> result = new ArrayList<>();
            while (pMatcher.find()) {
                String p = pMatcher.group(1);
                p = deleteTags(p);
                p = p.replaceAll("\\s{2,}", " ");
                result.add(p);
            }

            answer.add("title : " + title + "\n" + String.join("\n", result));
        }

        return String.join("\n", answer);
    }

    public static String deleteTags(String p) {
        return p.replaceAll("<.*?>", "").trim();
    }
}

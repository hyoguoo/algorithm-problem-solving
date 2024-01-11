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

    static final String DIV_TITLE_REGEX = "<div title=\"(.*?)\">(.*?)</div>";
    static final String PARAGRAPH_REGEX = "<p>(.*?)</p>";
    static final String MULTIPLE_SPACES_REGEX = "\\s{2,}";
    static final String HTML_TAG_REGEX = "<.*?>";
    static final String SINGLE_SPACE = " ";
    static final String EMPTY = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    public static String solution(String input) {
        List<String> answer = new ArrayList<>();

        Matcher titleMatcher = Pattern.compile(DIV_TITLE_REGEX)
                .matcher(input);

        while (titleMatcher.find()) {
            String title = titleMatcher.group(1);
            String divContent = titleMatcher.group(2);

            Matcher pMatcher = Pattern.compile(PARAGRAPH_REGEX)
                    .matcher(divContent);
            List<String> content = new ArrayList<>();
            while (pMatcher.find()) {
                String p = pMatcher.group(1);
                p = deleteTags(p);
                p = p.replaceAll(MULTIPLE_SPACES_REGEX, SINGLE_SPACE);
                content.add(p);
            }

            answer.add("title : " + title + "\n" +
                       String.join("\n", content));
        }

        return String.join("\n", answer);
    }

    public static String deleteTags(String p) {
        return p.replaceAll(HTML_TAG_REGEX, EMPTY).trim();
    }
}

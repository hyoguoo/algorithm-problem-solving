/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1181
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordSort {
    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        Comparator<String> customComparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                else return o1.compareTo(o2);
            }
        };

        for (int i = 0; i < length; i++) stringList.add(bufferedReader.readLine());
        List<String> uniqueStringList = stringList.stream().distinct().collect(Collectors.toList());
        uniqueStringList.sort(customComparator);

        for (String string : uniqueStringList) System.out.println(string);
    }
}

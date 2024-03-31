/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11931
 * Cheat Level: 0
 * Algorithm: Sort
 */

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSort4 {

    static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.print(
                solution(
                        parseNumberList(
                                Integer.parseInt(BUFFERED_READER.readLine())
                        )
                )
        );
    }

    private static List<Integer> parseNumberList(int n) throws IOException {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numberList.add(Integer.parseInt(BUFFERED_READER.readLine()));
        }
        return numberList;
    }

    private static String solution(List<Integer> numberList) {
        numberList.sort(Collections.reverseOrder());

        return printList(numberList);
    }

    private static String printList(List<Integer> numberList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numberList) {
            stringBuilder.append(number).append("\n");
        }
        return stringBuilder.toString();
    }
}

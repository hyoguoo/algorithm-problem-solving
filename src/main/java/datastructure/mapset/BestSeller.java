/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1302
 * Cheat Level: 0
 * Algorithm: Map
 */

package datastructure.mapset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BestSeller {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] books = new String[n];
        for (int i = 0; i < n; i++) {
            books[i] = bufferedReader.readLine();
        }

        System.out.print(solution(books));
    }

    private static String solution(String[] books) {
        Map<String, Integer> bookCount = getBookCount(books);

        return bookCount
                .entrySet()
                .stream()
                .max(entryComparator())
                .orElseThrow()
                .getKey();
    }

    private static Map<String, Integer> getBookCount(String[] books) {
        Map<String, Integer> bookCount = new HashMap<>();

        for (String book : books) {
            bookCount.put(book, bookCount.getOrDefault(book, 0) + 1);
        }

        return bookCount;
    }

    private static Comparator<Entry<String, Integer>> entryComparator() {
        return (entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                return entry2.getKey().compareTo(entry1.getKey());
            }
            return entry1.getValue().compareTo(entry2.getValue());
        };
    }
}

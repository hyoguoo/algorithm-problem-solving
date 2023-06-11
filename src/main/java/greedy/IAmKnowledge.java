/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 28068
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IAmKnowledge {

    final static List<Book> GAIN_BOOK_LIST = new ArrayList<>();
    final static List<Book> PAIN_BOOK_LIST = new ArrayList<>();
    static long remain = 0;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution() ? "1" : "0");
    }

    private static boolean solution() {
        for (Book book : GAIN_BOOK_LIST) {
            remain -= book.pain;
            if (remain < 0) return false;
            remain += book.gain;
        }

        for (Book book : PAIN_BOOK_LIST) {
            remain -= book.pain;
            if (remain < 0) return false;
            remain += book.gain;
        }

        return remain >= 0;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int bookCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < bookCount; i++) {
            int[] bookInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int pain = bookInfo[0];
            int gain = bookInfo[1];
            if (pain == 0) remain += gain;
            else if (gain - pain >= 0) GAIN_BOOK_LIST.add(new Book(pain, gain));
            else PAIN_BOOK_LIST.add(new Book(pain, gain));
        }

        GAIN_BOOK_LIST.sort((o1, o2) -> o1.pain - o2.pain);
        PAIN_BOOK_LIST.sort((o1, o2) -> o2.gain - o1.gain);
    }

    static class Book {
        int pain;
        int gain;

        public Book(int pain, int gain) {
            this.pain = pain;
            this.gain = gain;
        }
    }
}

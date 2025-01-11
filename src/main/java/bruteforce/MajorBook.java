/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16508
 * Cheat Level: 0
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class MajorBook {

    private static final char ALPHABET_START = 'A';
    private static final char ALPHABET_END = 'Z';
    private static final int ALPHABET_COUNT = ALPHABET_END - ALPHABET_START + 1;
    private static final int NOT_FOUND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();
        int bookCount = Integer.parseInt(bufferedReader.readLine());
        BookInfo[] bookInfos = new BookInfo[bookCount];

        for (int b = 0; b < bookCount; b++) {
            String[] bookInfo = bufferedReader.readLine().split(" ");
            bookInfos[b] = new BookInfo(Integer.parseInt(bookInfo[0]), bookInfo[1]);
        }

        System.out.print(solution(bookInfos, word));
    }

    private static int solution(BookInfo[] bookInfos, String word) {
        int[] needAlphabetCount = countAlphabet(word);

        List<Integer> costList = new ArrayList<>();
        Deque<BookInfo> checkedBookList = new ArrayDeque<>();
        findMatchingBooksCost(bookInfos, needAlphabetCount, 0, costList, checkedBookList);

        return costList.stream()
                .min(Integer::compareTo)
                .orElse(NOT_FOUND);
    }

    private static void findMatchingBooksCost(BookInfo[] bookInfos,
            int[] needAlphabetCount,
            int index,
            List<Integer> costList,
            Deque<BookInfo> checkedBookList) {
        if (checkNeedAlphabet(checkedBookList, needAlphabetCount)) {
            costList.add(calculateCheckedBookCost(checkedBookList));
        }

        for (int i = index; i < bookInfos.length; i++) {
            checkedBookList.add(bookInfos[i]);
            findMatchingBooksCost(bookInfos, needAlphabetCount, i + 1, costList, checkedBookList);
            checkedBookList.removeLast();
        }
    }

    private static int calculateCheckedBookCost(Deque<BookInfo> checkedBookList) {
        return checkedBookList.stream()
                .map(checkedBook -> checkedBook.price)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static boolean checkNeedAlphabet(Deque<BookInfo> checkedBookList, int[] needAlphabetCount) {
        int[] checkedBookAlphabetCount = countBookListAlphabet(checkedBookList);

        return IntStream.range(0, ALPHABET_COUNT)
                .allMatch(i -> checkedBookAlphabetCount[i] >= needAlphabetCount[i]);
    }

    private static int[] countBookListAlphabet(Deque<BookInfo> checkedBookList) {
        int[] checkedBookAlphabetCount = new int[ALPHABET_COUNT];

        checkedBookList
                .forEach(bookInfo -> {
                    int[] bookAlphabetCount = countAlphabet(bookInfo.name);
                    for (int i = 0; i < ALPHABET_COUNT; i++) {
                        checkedBookAlphabetCount[i] += bookAlphabetCount[i];
                    }
                });

        return checkedBookAlphabetCount;
    }

    private static int[] countAlphabet(String word) {
        int[] alphabetCount = new int[ALPHABET_COUNT];

        Arrays.stream(word.split(""))
                .forEach(c -> alphabetCount[c.charAt(0) - ALPHABET_START]++);

        return alphabetCount;
    }

    static class BookInfo {

        private final int price;
        private final String name;

        public BookInfo(int price, String name) {
            this.price = price;
            this.name = name;
        }
    }
}

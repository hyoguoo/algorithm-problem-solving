/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 31423
 * Cheat Level: 3
 * Algorithm: Linked List
 */

package datastructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SinchonConsolidationPlan {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[wordCount + 1];

        for (int i = 1; i <= wordCount; i++) {
            words[i] = bufferedReader.readLine();
        }

        Link[] links = new Link[wordCount - 1];

        for (int i = 0; i < wordCount - 1; i++) {
            int[] linkInfo = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            links[i] = new Link(linkInfo[0], linkInfo[1]);
        }

        System.out.print(solution(words, links, wordCount));
    }

    private static String solution(String[] words, Link[] links, int wordCount) {
        int[] children = new int[wordCount + 1];
        int[] tails = new int[wordCount + 1];
        for (int i = 1; i <= wordCount; i++) {
            children[i] = i;
            tails[i] = i;
        }

        int head = -1;

        for (Link link : links) {
            int tailIndex = tails[link.head];
            children[tailIndex] = link.tail;
            tails[link.head] = tails[link.tail];
            head = link.head;
        }

        return concatenateWords(words, head, children, wordCount);
    }

    private static String concatenateWords(
            String[] words,
            int head,
            int[] children,
            int wordCount
    ) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < wordCount; i++) {
            stringBuilder.append(words[head]);
            head = children[head];
        }

        return stringBuilder.toString().trim();
    }


    static class Link {

        private final int head;
        private final int tail;

        public Link(int head, int tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}

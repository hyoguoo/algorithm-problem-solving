/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 30700
 * Cheat Level: 0
 * Algorithm: Greedy / String
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KOREAStringCreation {

    private static final char[] KOREA = {'K', 'O', 'R', 'E', 'A'};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(solution(bufferedReader.readLine()));
    }

    private static int solution(String s) {
        Counter counter = new Counter();

        s.chars()
                .mapToObj(c -> (char) c)
                .forEach(counter::countIfMatch);

        return counter.index;
    }

    static class Counter {

        private int index = 0;

        public void countIfMatch(char c) {
            if (c == KOREA[index % KOREA.length]) {
                index++;
            }
        }
    }
}

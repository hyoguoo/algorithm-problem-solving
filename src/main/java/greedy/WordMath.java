/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1339
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordMath {

    final static int MAX_VALUE = 9;
    final static Map<Character, Integer> alphabetMap = new HashMap<>();
    static int N;
    static long max = Long.MIN_VALUE;
    static String[] words;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solution());
    }

    private static long solution() {
        backtracking(MAX_VALUE);

        return max;
    }

    private static void backtracking(int size) {
        if (size == MAX_VALUE - alphabetMap.size()) {
            max = Math.max(max, getWordsSum());
            return;
        }

        for (char alphabet : alphabetMap.keySet()) {
            if (alphabetMap.get(alphabet) == 0) {
                alphabetMap.put(alphabet, size);
                backtracking(size - 1);
                alphabetMap.put(alphabet, 0);
            }
        }
    }

    private static long getWordsSum() {
        return Arrays.stream(words).mapToLong(WordMath::wordToNumber).sum();
    }

    private static long wordToNumber(String word) {
        long value = 0;

        for (int i = 0; i < word.length(); i++) {
            value *= 10;
            value += alphabetMap.get(word.charAt(i));
        }

        return value;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        words = new String[N];
        for (int n = 0; n < N; n++) {
            String input = bufferedReader.readLine();
            for (int i = 0; i < input.length(); i++) {
                char alphabet = input.charAt(i);
                if (!alphabetMap.containsKey(alphabet)) {
                    alphabetMap.put(alphabet, 0);
                }
            }
            words[n] = input;
        }
    }
}

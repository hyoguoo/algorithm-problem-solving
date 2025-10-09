/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15312
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NameCompatibility {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = bufferedReader.readLine();
        String name2 = bufferedReader.readLine();

        System.out.printf("%02d", solution(name1, name2));
    }

    private static int solution(String name1, String name2) {
        int[] scores = convertToScores(name1, name2);

        while (scores.length > 2) {
            scores = reduceScores(scores);
        }

        return scores[0] * 10 + scores[1];
    }

    private static int[] reduceScores(int[] scores) {
        int[] newScores = new int[scores.length - 1];

        for (int i = 0; i < scores.length - 1; i++) {
            newScores[i] = (scores[i] + scores[i + 1]) % 10;
        }

        return newScores;
    }

    private static int[] convertToScores(String name1, String name2) {
        Alphabet[] alphabets1 = convertToAlphabets(name1);
        Alphabet[] alphabets2 = convertToAlphabets(name2);
        int[] scores = new int[alphabets1.length + alphabets2.length];

        for (int i = 0; i < alphabets1.length + alphabets2.length; i++) {
            if (i % 2 == 0) {
                scores[i] = alphabets1[i / 2].score;
            } else {
                scores[i] = alphabets2[i / 2].score;
            }
        }

        return scores;
    }

    private static Alphabet[] convertToAlphabets(String name) {
        return name.chars()
                .mapToObj(c -> Alphabet.of((char) c))
                .toArray(Alphabet[]::new);
    }

    enum Alphabet {
        A('A', 3), B('B', 2), C('C', 1), D('D', 2), E('E', 3), F('F', 3),
        G('G', 2), H('H', 3), I('I', 3), J('J', 2), K('K', 2), L('L', 1),
        M('M', 2), N('N', 2), O('O', 1), P('P', 2), Q('Q', 2), R('R', 2),
        S('S', 1), T('T', 2), U('U', 1), V('V', 1), W('W', 1), X('X', 2), Y('Y', 2), Z('Z', 1);

        private final char character;
        private final int score;

        Alphabet(char character, int score) {
            this.character = character;
            this.score = score;
        }

        public static Alphabet of(char character) {
            return Arrays.stream(values())
                    .filter(alphabet -> alphabet.character == character)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}

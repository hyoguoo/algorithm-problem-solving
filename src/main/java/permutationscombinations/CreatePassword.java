/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1759
 * Cheat Level: 0
 * Algorithm: Combinations
 */

package permutationscombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CreatePassword {

    final static StringBuilder stringBuilder = new StringBuilder();
    final static char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = info[0];
        char[] chars = bufferedReader.readLine().replaceAll(" ", "").toCharArray();
        solution(chars, length);
        System.out.print(stringBuilder);
    }

    private static void solution(char[] chars, int length) {
        Arrays.sort(chars);
        recursion(chars, 0, new char[length], 0, length);
        stringBuilder.append("\n");
    }

    private static void recursion(char[] chars, int index, char[] result, int depth, int length) {
        if (depth == length) {
            if (!isAvailable(result)) return;
            for (int i = 0; i < length; i++) stringBuilder.append(result[i]);
            stringBuilder.append("\n");
            return;
        }

        for (int i = index; i < chars.length; i++) {
            result[depth] = chars[i];
            recursion(chars, i + 1, result, depth + 1, length);
        }
    }

    private static boolean isAvailable(char[] result) {
        int vowelCount = 0;
        for (char c : result) {
            for (char vowel : VOWELS) {
                if (c == vowel) {
                    vowelCount++;
                    break;
                }
            }
        }
        return vowelCount >= 1 && result.length - vowelCount >= 2;
    }
}

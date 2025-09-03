/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17294
 * Cheat Level: 0
 * Algorithm: Mathematics
 */

package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CuteNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(
                solution(numbers)
                        ? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!"
                        : "흥칫뿡!! <(￣ ﹌ ￣)>"
        );
    }

    private static boolean solution(int[] numbers) {
        if (numbers.length < 2) {
            return true;
        }

        int diff = numbers[1] - numbers[0];

        return IntStream.range(1, numbers.length)
                .allMatch(i -> numbers[i] - numbers[i - 1] == diff);
    }
}

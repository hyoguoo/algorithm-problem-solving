/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1356
 * Cheat Level: 0
 * Algorithm: Bruteforce / Mathematics
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class YujinNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(solution(bufferedReader.readLine()) ? "YES" : "NO");
    }

    private static boolean solution(String n) {
        return IntStream.range(1, n.length())
                .anyMatch(i -> calculateProduct(n.substring(0, i)) == calculateProduct(n.substring(i)));
    }

    private static int calculateProduct(String numberString) {
        return numberString.chars()
                .map(character -> character - '0')
                .reduce(1, (a, b) -> a * b);
    }
}

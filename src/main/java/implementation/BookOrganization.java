/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1434
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BookOrganization {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] boxSizes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bookSizes = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solution(bookSizes, boxSizes));
    }

    private static int solution(int[] bookSizes, int[] boxRemainSpaces) {
        int bookIndex = 0;
        int boxIndex = 0;

        while (bookIndex < bookSizes.length && boxIndex < boxRemainSpaces.length) {
            if (bookSizes[bookIndex] <= boxRemainSpaces[boxIndex]) {
                boxRemainSpaces[boxIndex] -= bookSizes[bookIndex];
                bookIndex++;
            } else {
                boxIndex++;
            }
        }

        return Arrays.stream(boxRemainSpaces).sum();
    }
}

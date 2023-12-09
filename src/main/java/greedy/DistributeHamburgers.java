/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19941
 * Cheat Level: 0
 * Algorithm: Greedy
 */

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DistributeHamburgers {

    static final char HAMBURGER = 'H';
    static final char PERSON = 'P';
    static final char EMPTY = 'X';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int distanceLimit = info[1];
        char[] input = bufferedReader.readLine().toCharArray();

        System.out.println(solution(input, distanceLimit));
    }

    private static int solution(char[] input, int distanceLimit) {
        int count = 0;

        for (int currentIndex = 0; currentIndex < input.length; currentIndex++) {
            if (input[currentIndex] == HAMBURGER &&
                eatBurger(input, distanceLimit, currentIndex)) count++;
        }

        return count;
    }

    private static boolean eatBurger(char[] input, int distanceLimit, int currentIndex) {
        for (int distance = -distanceLimit; distance <= distanceLimit; distance++) {
            int nextIndex = currentIndex + distance;
            if (!isValidIndex(input, nextIndex)) continue;
            if (input[nextIndex] == PERSON) {
                input[nextIndex] = EMPTY;
                return true;
            }
        }

        return false;
    }

    private static boolean isValidIndex(char[] input, int index) {
        return 0 <= index && index < input.length;
    }
}

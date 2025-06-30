/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 19637
 * Cheat Level: 0
 * Algorithm: Binary Search
 */

package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WriteIFStatement {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int titleCount = info[0];
        int characterCount = info[1];

        Title[] titles = new Title[titleCount];

        for (int i = 0; i < titleCount; i++) {
            String[] titleInfo = bufferedReader.readLine().split(" ");
            titles[i] = new Title(titleInfo[0], Integer.parseInt(titleInfo[1]));
        }

        int[] characterPowers = new int[characterCount];
        for (int i = 0; i < characterCount; i++) {
            characterPowers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print(solution(titles, characterPowers));
    }

    private static String solution(Title[] titles, int[] characterPowers) {
        return Arrays.stream(characterPowers)
                .mapToObj(power -> findTitle(titles, power))
                .collect(Collectors.joining("\n"));
    }

    private static String findTitle(Title[] titles, int power) {
        int left = 0;
        int right = titles.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (titles[mid].isEligible(power)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return titles[left].name;
    }

    static class Title {

        private final String name;
        private final int requiredPower;

        public Title(String name, int requiredPower) {
            this.name = name;
            this.requiredPower = requiredPower;
        }

        public boolean isEligible(int characterPower) {
            return characterPower > this.requiredPower;
        }
    }
}

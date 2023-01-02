/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1431
 * Cheat Level: 0
 * Algorithm: Sort
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SerialNumber {

    static final List<String> serialNumbrList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) serialNumbrList.add(bufferedReader.readLine());

        serialNumbrList.sort(customComparator());
        for (String serialNumber : serialNumbrList) System.out.println(serialNumber);
    }

    private static Comparator<String> customComparator() {
        return (o1, o2) -> {
            if (o1.length() != o2.length()) return o1.length() - o2.length();
            int sumDigits1 = getSumDigits(o1);
            int sumDigits2 = getSumDigits(o2);
            if (sumDigits1 != sumDigits2) return sumDigits1 - sumDigits2;
            return compareEachCharacter(o1, o2);
        };
    }

    private static int compareEachCharacter(String o1, String o2) {
        for (int i = 0; i < o1.length(); i++) {
            char c1 = o1.charAt(i);
            char c2 = o2.charAt(i);
            if (c1 != c2) return c1 - c2;
        }
        return 0;
    }

    private static int getSumDigits(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) sum += c - '0';
        }

        return sum;
    }
}

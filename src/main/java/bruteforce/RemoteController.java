/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1107
 * Cheat Level: 2
 * Algorithm: Brute Force
 */

package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoteController {

    static int currentChannel = 100;
    static int target;

    static List<Integer> unableNumberList;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(bufferedReader.readLine());
        int length = Integer.parseInt(bufferedReader.readLine());
        unableNumberList = length != 0 ? getIntegers(bufferedReader) : new ArrayList<>();

        if (unableNumberList.size() == 10) {
            System.out.println(Math.abs(currentChannel - target));
        } else {
            int nearestNumber = getNearestNumber();
            System.out.println(Math.min(getMinCount(nearestNumber), Math.abs(target - currentChannel)));
        }
    }

    private static List<Integer> getIntegers(BufferedReader bufferedReader) throws IOException {
        int[] unableNumbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> unableNumberList = new ArrayList<>();
        for (int unableNumber : unableNumbers) unableNumberList.add(unableNumber);
        return unableNumberList;
    }

    private static int getMinCount(int number) {
        int numberLength = String.valueOf(number).length();
        return Math.abs(target - number) + numberLength;
    }

    private static int getNearestNumber() {
        int belowNumber = target;
        int topNumber = target;
        while (true) {
            if (belowNumber >= 0 && isAbleAllNumbers(belowNumber)) return belowNumber;
            if (isAbleAllNumbers(topNumber)) return topNumber;
            belowNumber--;
            topNumber++;
        }
    }

    private static boolean isAbleAllNumbers(int number) {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            int numberChar = numberString.charAt(i) - '0';
            if (unableNumberList.contains(numberChar)) return false;
        }
        return true;
    }
}

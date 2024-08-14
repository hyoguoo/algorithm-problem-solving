/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16960
 * Cheat Level: 0
 * Algorithm: Implementation
 */

package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwitchAndLamp {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int switchCount = info[0];
        int lampCount = info[1];

        List<List<Integer>> switchInfoList = new ArrayList<>();

        for (int s = 0; s < switchCount; s++) {
            int[] switchInfoArray = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            switchInfoList.add(Arrays.stream(switchInfoArray)
                    .skip(1)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
        }

        System.out.print(solution(switchInfoList, lampCount) ? "1" : "0");
    }

    private static boolean solution(List<List<Integer>> switchInfoList, int lampCount) {
        int[] lampSwitchCount = new int[lampCount + 1];

        for (List<Integer> switchInfo : switchInfoList) {
            for (int lamp : switchInfo) {
                lampSwitchCount[lamp]++;
            }
        }

        for (List<Integer> switchInfo : switchInfoList) {
            boolean isOn = true;
            for (int lamp : switchInfo) {
                lampSwitchCount[lamp]--;
                if (lampSwitchCount[lamp] < 1) {
                    isOn = false;
                    break;
                }
                lampSwitchCount[lamp]++;

            }
            if (isOn) {
                return true;
            }
        }

        return false;
    }
}

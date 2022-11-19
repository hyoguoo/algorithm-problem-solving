/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2748
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SevenDwarfs {

    static final int DWARF_LENGTH = 9;
    static List<Integer> dwarfList = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < DWARF_LENGTH; i++) {
            int dwarf = Integer.parseInt(bufferedReader.readLine());
            dwarfList.add(dwarf);
            sum += dwarf;
        }

        for (int i = 0; i < DWARF_LENGTH; i++) {
            for (int j = i + 1; j < DWARF_LENGTH; j++) {
                if (sum - dwarfList.get(i) - dwarfList.get(j) == 100) {
                    dwarfList.remove(j);
                    dwarfList.remove(i);
                    printDwarfList();
                    return;
                }
            }
        }
    }

    private static void printDwarfList() {
        dwarfList.stream().sorted().forEach(System.out::println);
    }
}

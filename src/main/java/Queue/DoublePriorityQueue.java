/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7662
 */

package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class DoublePriorityQueue {

    static final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static final int MAX = 1;
    private static final int MIN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int round = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < round; i++) {
            int length = Integer.parseInt(bufferedReader.readLine());
            runPriorityQueue(bufferedReader, length);
            if (treeMap.isEmpty()) System.out.println("EMPTY");
            else System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }

    private static void runPriorityQueue(BufferedReader bufferedReader, int length) throws IOException {
        treeMap.clear();

        for (int j = 0; j < length; j++) {
            String[] input = bufferedReader.readLine().split(" ");
            String command = input[0];
            int value = Integer.parseInt(input[1]);
            runCommand(command, value);
        }
    }

    private static void runCommand(String command, int value) {
        switch (command) {
            case INSERT:
                treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
                break;
            case DELETE:
                if (!treeMap.isEmpty()) deleteKey(value);
                break;
        }
    }

    private static void deleteKey(int value) {
        switch (value) {
            case MIN:
                removeKey(treeMap.firstKey());
                break;
            case MAX:
                removeKey(treeMap.lastKey());
                break;
        }
    }

    private static void removeKey(Integer key) {
        if (treeMap.get(key) == 1) treeMap.remove(key);
        else treeMap.put(key, treeMap.get(key) - 1);
    }
}
